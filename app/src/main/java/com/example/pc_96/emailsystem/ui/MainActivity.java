package com.example.pc_96.emailsystem.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pc_96.emailsystem.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "使用测试", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, WeeklyActivity.class);
        startActivity(intent);
    }
}
