package com.example.pc_96.emailsystem.data;

public class WeeklyBean {   //2.14 2:35 修改mViewerCount和mCommentCount为String类型
    public String mTitle;
    public String mTime;
    public String mUserName;
    public String mAvatarUrl;
    public String mViewerCount;
    public String mCommentCount;
    public String mContentUrl;
    public int mType;



    public WeeklyBean (String mTitle, String mTime, String mUserName, String mAvatarUrl
            , String mViewerCount, String mCommentCount, String mContentUrl, int mType) {
        this.mTitle = mTitle;
        this.mTime = mTime;
        this.mUserName = mUserName;
        this.mAvatarUrl = mAvatarUrl;
        this.mViewerCount = mViewerCount;
        this.mCommentCount = mCommentCount;
        this.mContentUrl = mContentUrl;
        this.mType = mType;
    }

    public String getmTitle () {
        return mTitle;
    }

    public String getmTime () {
        return mTime;
    }

    public String getmUserName () {
        return mUserName;
    }

    public String getmAvatarUrl () {
        return mAvatarUrl;
    }

    public String getmViewerCount () {
        return mViewerCount;
    }

    public String getmCommentCount () {
        return mCommentCount;
    }

    public String getmContentUrl () {
        return mContentUrl;
    }
}
