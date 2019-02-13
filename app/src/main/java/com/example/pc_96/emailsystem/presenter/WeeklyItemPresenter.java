package com.example.pc_96.emailsystem.presenter;

import android.os.Handler;
import android.os.Message;

import com.example.pc_96.emailsystem.data.WeeklyBean;
import com.example.pc_96.emailsystem.presenter.constract.WeeklyConstract;

import java.util.ArrayList;

public class WeeklyItemPresenter implements WeeklyConstract.Presenter{  //修改PagerItemFragment为MVP模式,新增WeeklyItemPresenter
    public static final int RESPONSE_OK = 0;
    public static final int RESPONSE_FAIL = 1;
    public static final int TYPE_ANDROID = 0;
    public static final int TYPE_IOS = 1;
    public static final int TYPE_SERVICE = 2;
    public static final int TYPE_WEB = 3;

    private int mType;
    private ArrayList<WeeklyBean> mWeeklyBeanList;
    private WeeklyConstract.View mView;
    private Handler dataHandle = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage (Message message) {
            switch (message.what){
                case RESPONSE_OK:{
                    mView.onServerResponse(mWeeklyBeanList);
                }
                case RESPONSE_FAIL:{

                }
            }
            return true;
        }
    });

    public WeeklyItemPresenter (WeeklyConstract.View mView, int mType){
        this.mView = mView;
        this.mType = mType;
        mWeeklyBeanList = new ArrayList<>();
    }


    @Override
    public void getServerResponse() {   //网络请求多线程,之后如果有需要可以改成rxJava
        new Thread(new Runnable() {
            @Override
            public void run () {
                String title = null;
                switch (mType){
                    case TYPE_ANDROID:
                        title = "安卓测试";break;
                    case TYPE_IOS:
                        title = "苹果测试";break;
                    case TYPE_SERVICE:
                        title = "后台测试";break;
                    case TYPE_WEB:
                        title = "网页测试";break;
                }
                for(int i = 0;i<15;i++){    //加载15条测试数据,后改网络请求判断
                    WeeklyBean weeklyBean = new WeeklyBean(title,"2月13日"
                            ,"用户测试","...png",299,399,"http://....",mType);
                    //后改网络请求获取该信息
                    mWeeklyBeanList.add(weeklyBean);
                }
                dataHandle.sendEmptyMessage(RESPONSE_OK);
            }
        }).start();

    }
}
