package com.example.pc_96.emailsystem.data.source.local;

import com.example.pc_96.emailsystem.data.source.DataSource;

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
    public void getWeeklyList() {

    }

    @Override
    public void getNewWeekly() {

    }
}
