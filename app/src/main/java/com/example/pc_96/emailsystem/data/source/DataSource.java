package com.example.pc_96.emailsystem.data.source;

import java.util.List;

import io.reactivex.Observable;

public interface DataSource {
    Observable getWeeklyList(int type);
    Observable getWeeklyDetil();
    void getNewWeekly();
}
