package com.example.pc_96.emailsystem.data.source.remote;

import com.example.pc_96.emailsystem.data.source.DataSource;

public class RemoteDataSource implements DataSource {
    private static RemoteDataSource INSTANCE;

    private RemoteDataSource() {

    }

    public static RemoteDataSource getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new RemoteDataSource();
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
