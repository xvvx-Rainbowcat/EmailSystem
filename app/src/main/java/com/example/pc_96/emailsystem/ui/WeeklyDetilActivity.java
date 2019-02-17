package com.example.pc_96.emailsystem.ui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebView;

import com.example.pc_96.emailsystem.R;
import com.example.pc_96.emailsystem.adapter.CommentAdapter;
import com.example.pc_96.emailsystem.data.CommentBean;
import com.example.pc_96.emailsystem.presenter.WeeklyDetilPresenter;
import com.example.pc_96.emailsystem.presenter.constract.WeeklyDetilConstract;

import java.util.ArrayList;

public class WeeklyDetilActivity extends AppCompatActivity implements WeeklyDetilConstract.View {
    //2.14 1:28 你之前把接口塞到Constract里面去的时候忘记给View加接口了

    private WeeklyDetilPresenter mPresenter;
    private RecyclerView mCommentRecyclerView;
    private CommentAdapter mCommentAdapter;
    private ArrayList<CommentBean> mCommentBeanList;   //2.14 3:42 从List改为ArrayList
    private WebView webView;
    private String contentUrl;

    // 2.14  1:23   我不晓得你为啥要把界面初始化又改到这,我记得我已经放到Presenter里面去了啊
//    private String content = "# 1.21-1.27周报\n" +
//            "\n" +
//            "## 本周学习内容\n" +
//            "*\t复习通知并进行总结\n" +
//            "*\t学习动画并进行总结\n" +
//            "*\tleetcode用java做了几道算法题\n" +
//            "*\t又看了下mvp模式\n" +
//            "*\t复习rxjava和retrofit的基本使用\n" +
//            "\n" +
//            "## 遇到问题\n" +
//            "*\t算法太差...\n" +
//            "\n" +
//            "## 下周学习计划\n" +
//            "*\t开始写项目\n" +
//            "\n" +
//            "## 本周分享\n" +
//            "*\t[通知总结](http://note.youdao.com/noteshare?id=29270193f50b33b784359516066a8163&sub=181F5D9CBF3E44D492DA00D8E3A4616D)\n" +
//            "*\t[动画总结](http://note.youdao.com/noteshare?id=84aa4ed47e4fb817e4717bd80a32b33b&sub=50387829C1CE42E3B161115114BCB5E1)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_detil);
        initData();
        initView();
    }

    private void initData() {
        Intent intent = getIntent();
        contentUrl = intent.getStringExtra("contentUrl");
        webView = findViewById(R.id.weekly_content);
        mCommentBeanList = new ArrayList<>();
        mPresenter = new WeeklyDetilPresenter(this);
    }

    private void initView() {
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener((view) -> {
        });
        mCommentRecyclerView = findViewById(R.id.comment_recycler);
        mCommentAdapter = new CommentAdapter(mCommentBeanList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mCommentRecyclerView.setLayoutManager(layoutManager);
        mCommentRecyclerView.setAdapter(mCommentAdapter);
        mPresenter.getServerResponse(contentUrl);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onServerResponse (String content, ArrayList<CommentBean> commentBeanList) {
        //2.14 3:30 调用webView直接显示爬取到的文档转化为的html格式
        //存在问题:
        //1.图片适配和文字适配
        //2.文章的标题想要显示在哪(a.状态栏,b.直接显示到webView中)
        //两种方法皆可,不过第一种需要先将状态栏改回来
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true); //2.14 3:40 允许使用缩放,但是缩放存在严重的滑动冲突,操作十分反人类
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.loadDataWithBaseURL(null,content,"text/html","UTF-8",null);
        this.mCommentBeanList = commentBeanList;
        mCommentAdapter.onDataChange(commentBeanList);
        mCommentAdapter.notifyDataSetChanged();
    }

}
