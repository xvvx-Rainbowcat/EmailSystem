package com.example.pc_96.emailsystem.ui;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import com.example.pc_96.emailsystem.R;
import com.example.pc_96.emailsystem.adapter.CommentAdapter;
import com.example.pc_96.emailsystem.data.Comment;
import com.zzhoujay.richtext.RichText;

import java.util.ArrayList;
import java.util.List;

public class WeeklyDetilActivity extends AppCompatActivity {

    private RecyclerView mCommentRecyclerView;
    private CommentAdapter mCommentAdapter;
    private List<Comment> mData;
    private String content = "# 1.21-1.27周报\n" +
            "\n" +
            "## 本周学习内容\n" +
            "*\t复习通知并进行总结\n" +
            "*\t学习动画并进行总结\n" +
            "*\tleetcode用java做了几道算法题\n" +
            "*\t又看了下mvp模式\n" +
            "*\t复习rxjava和retrofit的基本使用\n" +
            "\n" +
            "## 遇到问题\n" +
            "*\t算法太差...\n" +
            "\n" +
            "## 下周学习计划\n" +
            "*\t开始写项目\n" +
            "\n" +
            "## 本周分享\n" +
            "*\t[通知总结](http://note.youdao.com/noteshare?id=29270193f50b33b784359516066a8163&sub=181F5D9CBF3E44D492DA00D8E3A4616D)\n" +
            "*\t[动画总结](http://note.youdao.com/noteshare?id=84aa4ed47e4fb817e4717bd80a32b33b&sub=50387829C1CE42E3B161115114BCB5E1)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_detil);
        initData();
        initView();
    }

    private void initData() {
        TextView textView = findViewById(R.id.weekly_content);
        mData = new ArrayList<>();
        RichText.initCacheDir(this);
        RichText.fromMarkdown(content).into(textView);
    }

    private void initView() {
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener((view) -> {
        });
        mCommentRecyclerView = findViewById(R.id.comment_recycler);
        mCommentAdapter = new CommentAdapter(mData, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mCommentRecyclerView.setLayoutManager(layoutManager);
        mCommentRecyclerView.setAdapter(mCommentAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RichText.recycle();
    }
}
