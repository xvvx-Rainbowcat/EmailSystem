package com.example.pc_96.emailsystem.data.source.remote;

import com.example.pc_96.emailsystem.data.WeeklyBean;
import com.example.pc_96.emailsystem.data.source.DataSource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.example.pc_96.emailsystem.presenter.WeeklyItemPresenter.TYPE_IOS;
import static com.example.pc_96.emailsystem.presenter.WeeklyItemPresenter.TYPE_SERVICE;
import static com.example.pc_96.emailsystem.presenter.WeeklyItemPresenter.TYPE_WEB;
import static com.example.pc_96.emailsystem.ui.WeeklyActivity.TYPE_ANDROID;

public class RemoteDataSource implements DataSource {

    private static RemoteDataSource INSTANCE;

    private RemoteDataSource() {

    }

    public static RemoteDataSource getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public Observable getWeeklyList(int type) {
        return Observable.create((ObservableEmitter<ArrayList> emitter) -> {
            ArrayList<WeeklyBean> mWeeklyBeanList = new ArrayList<>();
            String url = null;
            switch (type) {
                case TYPE_ANDROID:
                    url = "https://www.cnblogs.com/cate/android/";
                    break;
                case TYPE_IOS:
                    url = "https://www.cnblogs.com/cate/ios/";
                    break;
                case TYPE_SERVICE:
                    url = "https://www.cnblogs.com/cate/mysql/";
                    break;
                case TYPE_WEB:
                    url = "https://www.cnblogs.com/cate/web/";
                    break;
                default:
                    break;
            }
            try {
                Document document = Jsoup.connect(url).get();
                Elements elements = document.select("div.post_item");
                for (int i = 0; i < elements.size(); i++) {
                    Element element = elements.get(i);
                    String title = element.select("a.titlelnk").text();
                    String contentUrl = element.select("a.titlelnk").attr("href");
                    String time = element.select("div.post_item_foot").get(0).ownText();
                    String username = element.select("a.lightblue").text();
                    Elements avatarElement = element.select("p.post_item_summary").select("img");
                    String avatarurl = null;
                    if (avatarElement.size() > 0) {
                        avatarurl = avatarElement.attr("src");
                    }
                    String tempcount = element.select("span.article_view").select("a.gray").text();
                    String viewercount = tempcount.substring(3, tempcount.length() - 1);
                    tempcount = element.select("span.article_comment").select("a.gray").text();
                    String commentcount = tempcount.substring(3, tempcount.length() - 1);
                    WeeklyBean weeklyBean = new WeeklyBean(title, time, username, avatarurl, viewercount, commentcount, contentUrl, type);
                    mWeeklyBeanList.add(weeklyBean);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            emitter.onNext(mWeeklyBeanList);
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable getWeeklyDetil() {
        return null;
    }

    @Override
    public void getNewWeekly() {

    }
}
