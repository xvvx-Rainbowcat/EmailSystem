package com.example.pc_96.emailsystem.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.pc_96.emailsystem.R;
import com.example.pc_96.emailsystem.adapter.CommentAdapter;
import com.example.pc_96.emailsystem.data.Comment;
import com.example.pc_96.emailsystem.presenter.WeeklyDetilPresenter;
import com.example.pc_96.emailsystem.util.WeeklyDetilView;
import com.zzhoujay.richtext.RichText;

import java.util.ArrayList;
import java.util.List;

public class WeeklyDetilActivity extends AppCompatActivity implements WeeklyDetilView {

    private WeeklyDetilPresenter mPresenter;
    private RecyclerView mCommentRecyclerView;
    private CommentAdapter mCommentAdapter;
    private List<Comment> mData;
    private TextView mTextView;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_detil);
        initView();
    }


    private void initView () {
        mTextView = findViewById(R.id.weekly_content);
        mData = new ArrayList<>();
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener((view) -> {
        });
        mCommentRecyclerView = findViewById(R.id.comment_recycler);
        mCommentAdapter = new CommentAdapter(mData, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mCommentRecyclerView.setLayoutManager(layoutManager);
        mCommentRecyclerView.setAdapter(mCommentAdapter);
        mPresenter = new WeeklyDetilPresenter(this);
        mPresenter.getServerResponse();
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        RichText.recycle();
    }

    @Override
    public void onServerResponse (String content) {
        //具体调用放到WeeklyDetilPresenter中,现在可以用于显示html格式的字符,代码块的显示还需要处理
        RichText.initCacheDir(this);
        RichText.fromHtml(content).bind(this)
                .into(mTextView);
    }

}
