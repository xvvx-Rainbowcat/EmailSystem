package com.example.pc_96.emailsystem.presenter;

import android.os.Handler;
import android.os.Message;
import android.text.Html;

import com.example.pc_96.emailsystem.data.CommentBean;
import com.example.pc_96.emailsystem.presenter.constract.WeeklyDetilConstract;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class WeeklyDetilPresenter implements WeeklyDetilConstract.Presenter { //修改WeeklyDetilActivity为MVP模式,新增WeeklyDetilPresenter
    public static final int RESPONSE_OK = 0;
    public static final int RESPONSE_FAIL = 1;

    private WeeklyDetilConstract.View mView;
    private ArrayList<CommentBean> mCommentBeanList;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage (Message message) {
            switch (message.what) {
                case RESPONSE_OK: {
                    mView.onServerResponse(content, mCommentBeanList);
                    break;
                }
            }
            return true;
        }
    });
    private String content;

    public WeeklyDetilPresenter (WeeklyDetilConstract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getServerResponse (String contentUrl) {
        mCommentBeanList = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run () {
                try {
                    //2.14 4:36 评论的列表获取不到,首先排除加密和混淆的原因,直接无法获取到评论模块
                    Document document = Jsoup.connect(contentUrl).get();
                    Element element = document.select("div.blogpost-body").get(0);
                    Element commentList = document.getElementById("blog-comments-placeholder");
                    Elements comments = commentList.select("div.feedbackItem");
                    String ttt = commentList.html();
                    if (comments.size() > 0) {
                        for (Element comment : comments) {
                            String content = comment.select("div.blog_comment_body").text();
                            String avatarUrl = comment.select("img.comment-avatar").attr("src");
                            String author = comment.select("a").get(3).text();
                            String time = comment.select("span.comment_date").text();
                            String temp = comment.select("div.comment_vote").select("a.comment_digg").text();
                            String likecount = temp.substring(3, temp.length() - 1);
                            temp = comment.select("div.comment_vote").select("a.comment_bury").text();
                            String dislikecount = temp.substring(3, temp.length() - 1);
                            CommentBean commentBean = new CommentBean(content, avatarUrl, author, time, likecount, dislikecount);
                            mCommentBeanList.add(commentBean);
                        }
                    }
                    content = element.html();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mHandler.sendEmptyMessage(RESPONSE_OK);
            }
        }).start();
    }


}
