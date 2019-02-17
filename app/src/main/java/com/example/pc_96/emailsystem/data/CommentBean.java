package com.example.pc_96.emailsystem.data;

public class CommentBean {
    public String mContent;
    public String mAvatarUrl;
    public String mAuthorName;
    public String mTime;
    public String mLikeCount;
    public String mDislikeCount;

    public CommentBean (String mContent, String mAvatarUrl, String mAuthorName, String mTime, String mLikeCount, String mDislikeCount) {
        this.mContent = mContent;
        this.mAvatarUrl = mAvatarUrl;
        this.mAuthorName = mAuthorName;
        this.mTime = mTime;
        this.mLikeCount = mLikeCount;
        this.mDislikeCount = mDislikeCount;
    }

    public String getmContent () {
        return mContent;
    }

    public String getmAvatarUrl () {
        return mAvatarUrl;
    }

    public String getmTime () {
        return mTime;
    }

    public String getmLikeCount () {
        return mLikeCount;
    }

    public String getmDislikeCount () {
        return mDislikeCount;
    }

    public String getmAuthorName () {
        return mAuthorName;
    }
}
