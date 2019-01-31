package com.example.pc_96.emailsystem.data;

import android.os.Parcelable;

import java.io.Serializable;

public class WeeklyMessage implements Serializable {
    public int avatar;
    public String name;
    public String time;
    public int viewingCount;
    public String title;

    public WeeklyMessage(int avatar, String name, String time, int viewingCount, String title) {
        this.avatar = avatar;
        this.name = name;
        this.time = time;
        this.viewingCount = viewingCount;
        this.title = title;
    }
}
