package com.example.pc_96.emailsystem.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.pc_96.emailsystem.R;
import com.example.pc_96.emailsystem.adapter.WeeklyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class WeeklyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final int TYPE_ANDROID = 0;
    public static final int TYPE_IOS = 1;
    public static final int TYPE_SERVICE = 2;
    public static final int TYPE_WEB = 3;

    private DrawerLayout mDrawerLayout;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("android");

        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mPager = findViewById(R.id.weekly_viewpager);
        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = TYPE_ANDROID; i <= TYPE_WEB; i++) {
            PagerItemFragment tempFragment = new PagerItemFragment();
            fragmentList.add(tempFragment);
            tempFragment.bindType(i);
        }
        WeeklyPagerAdapter adapter = new WeeklyPagerAdapter(getSupportFragmentManager(), fragmentList);
        mPager.setAdapter(adapter);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case TYPE_ANDROID:
                        actionBar.setTitle("android");
                        break;
                    case TYPE_IOS:
                        actionBar.setTitle("ios");
                        break;
                    case TYPE_SERVICE:
                        actionBar.setTitle("service");
                        break;
                    case TYPE_WEB:
                        actionBar.setTitle("web");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}