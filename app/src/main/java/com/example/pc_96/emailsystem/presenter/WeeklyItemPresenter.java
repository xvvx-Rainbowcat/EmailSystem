package com.example.pc_96.emailsystem.presenter;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import com.example.pc_96.emailsystem.data.WeeklyBean;
import com.example.pc_96.emailsystem.data.source.Respository;
import com.example.pc_96.emailsystem.presenter.constract.WeeklyConstract;
import com.example.pc_96.emailsystem.util.Injection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class WeeklyItemPresenter implements WeeklyConstract.Presenter {  //修改PagerItemFragment为MVP模式,新增WeeklyItemPresenter
    public static final int RESPONSE_OK = 0;
    public static final int RESPONSE_FAIL = 1;
    public static final int TYPE_ANDROID = 0;
    public static final int TYPE_IOS = 1;
    public static final int TYPE_SERVICE = 2;
    public static final int TYPE_WEB = 3;

    private int mType;
    private ArrayList<WeeklyBean> mWeeklyBeanList;
    private WeeklyConstract.View mView;
    /*private Handler dataHandle = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case RESPONSE_OK:
                    mView.onServerResponse(mWeeklyBeanList);
                    break;
                case RESPONSE_FAIL:
                    break;
                default:
                    break;
            }
            return true;
        }
    });*/
    private Respository mRespository = Injection.provideRepository();

    public WeeklyItemPresenter(WeeklyConstract.View mView, int mType) {
        this.mView = mView;
        this.mType = mType;
        mWeeklyBeanList = new ArrayList<>();
    }

    @Override
    public void getServerResponse() {   //网络请求多线程,之后如果有需要可以改成rxJava
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                String url = null;
                switch (mType) {
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
                        WeeklyBean weeklyBean = new WeeklyBean(title, time, username, avatarurl, viewercount, commentcount, contentUrl, mType);
                        mWeeklyBeanList.add(weeklyBean);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                dataHandle.sendEmptyMessage(RESPONSE_OK);
            }
        }).start();*/
        mRespository.getWeeklyList(mType)
                .subscribe((o)->{
                    if(o instanceof ArrayList) {
                        mView.onServerResponse((ArrayList<WeeklyBean>) o);
                    }
                });
    }

    private void requestFromServer(String url) {

    }
}
