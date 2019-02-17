package com.example.pc_96.emailsystem.data.source.local;

import com.example.pc_96.emailsystem.data.source.DataSource;

import io.reactivex.Observable;

public class LocalDataSource implements DataSource {
    private static LocalDataSource INSTANCE;

    private LocalDataSource() {

    }

    public static LocalDataSource getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new LocalDataSource();
        }
        return INSTANCE;
    }

    @Override
    public Observable getWeeklyList(int type) {
        return null;
    }

    @Override
    public Observable getWeeklyDetil() {
        return null;
    }

    @Override
    public void getNewWeekly() {

    }
}
