package com.example.pc_96.emailsystem.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pc_96.emailsystem.R;
import com.example.pc_96.emailsystem.data.UserBean;
import com.example.pc_96.emailsystem.data.source.Respository;
import com.example.pc_96.emailsystem.presenter.UserDetilPresenter;
import com.example.pc_96.emailsystem.presenter.constract.UserDetilConstract;
import com.example.pc_96.emailsystem.util.Injection;

public class UserDetilActivity extends AppCompatActivity
        implements UserDetilConstract.View, View.OnClickListener {

    private UserDetilConstract.Presenter mPresenter;
    private TextView mName;
    private ImageView mAvater;
    private TextView mGrade;
    private TextView mGroup;
    private TextView mTelephone;
    private TextView mEmail;
    private TextView mSpecialtyClass;
    private TextView mSignature;
    private ImageView mSex;
    // 用来标志是自己的名片还是别人的名片
    private int mType;

    public static final int MINE = 0;
    public static final int OTHER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detil);
        mType = getIntent().getIntExtra("type", OTHER);
        initView();
        initData();
    }

    private void initData() {
        mPresenter = new UserDetilPresenter(this, this, Injection.provideRepository());
        mPresenter.getMessage();
    }

    private void initView() {
        mName = findViewById(R.id.user_name);
        mSex = findViewById(R.id.sex);
        mGrade = findViewById(R.id.grade);
        mGroup = findViewById(R.id.group);
        mTelephone = findViewById(R.id.telephone);
        mEmail = findViewById(R.id.email);
        mSpecialtyClass = findViewById(R.id.specialty_class);
        mSignature = findViewById(R.id.signature);
        mAvater = findViewById(R.id.avater);

        mTelephone.setOnClickListener(this);
        mEmail.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.user_detil_toolbar);
        setSupportActionBar(toolbar);
        ImageView imageView = findViewById(R.id.background);
        RequestOptions options = new RequestOptions().centerCrop();
        Glide.with(this).load(R.mipmap.background).apply(options).into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (mType == MINE) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.user_detil_menu, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void showMessage(UserBean userBean) {
        mName.setText(userBean.getName());
        if ("man".equals(userBean.getSex())) {
            Glide.with(this).load(R.mipmap.sex_m).into(mSex);
        } else {
            Glide.with(this).load(R.mipmap.sex_w).into(mSex);
        }
        mGroup.setText(userBean.getGroup());
        mGrade.setText(userBean.getGrade());
        mTelephone.setText(userBean.getTelephone());
        mEmail.setText(userBean.getEmail());
        mSpecialtyClass.setText(userBean.getSpecialtyClass());
        mSignature.setText(userBean.getSignature());
        Glide.with(this).load(userBean.getAvaterUrl()).into(mAvater);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.telephone:
                String telephone = (String) ((TextView) findViewById(R.id.telephone)).getText();
                mPresenter.call(telephone);
                break;
            case R.id.email:
                String emailAddress = (String) ((TextView) findViewById(R.id.email)).getText();
                mPresenter.sendEmail(emailAddress);
                break;
            case R.id.edit:
                mPresenter.editUser();
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        mPresenter = null;
        super.onDestroy();
    }
}