package com.example.pc_96.emailsystem.data;

public class WeeklyBean {   //修改WeeklyMessage为WeeklyBean,由于之后可能还会有更多的数据类所以总称为Bean最好(最少我是这样觉得的)
    public String mTitle;
    public String mTime;
    public String mUserName;
    public String mAvatarUrl;
    public int mViewerCount;
    public int mCommentCount;
    public String mContentUrl;
    public int mType;



    public WeeklyBean (String mTitle, String mTime, String mUserName, String mAvatarUrl
            , int mViewerCount, int mCommentCount, String mContentUrl, int mType) {
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

    public int getmViewerCount () {
        return mViewerCount;
    }

    public int getmCommentCount () {
        return mCommentCount;
    }

    public String getmContentUrl () {
        return mContentUrl;
    }
}
