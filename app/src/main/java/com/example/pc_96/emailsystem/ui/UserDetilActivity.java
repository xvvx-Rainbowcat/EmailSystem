package com.example.pc_96.emailsystem.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pc_96.emailsystem.R;
import com.example.pc_96.emailsystem.presenter.constract.UserDetilConstract;

public class UserDetilActivity extends AppCompatActivity
        implements UserDetilConstract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detil);
        Toolbar toolbar = findViewById(R.id.user_detil_toolbar);
        setSupportActionBar(toolbar);
        ImageView imageView = findViewById(R.id.background);
        RequestOptions options = new RequestOptions().centerCrop();
        Glide.with(this).load(R.mipmap.background).apply(options).into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_detil_menu, menu);
        return true;
    }

    @Override
    public void showMessage() {

    }
}