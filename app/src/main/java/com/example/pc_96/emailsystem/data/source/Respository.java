package com.example.pc_96.emailsystem.data.source;

import com.example.pc_96.emailsystem.data.source.local.LocalDataSource;
import com.example.pc_96.emailsystem.data.source.remote.RemoteDataSource;

/**
 * 该类为mvp中的model
 * @author YJH
 */
public class Respository implements DataSource{
    private static Respository INSTANCE;
    private LocalDataSource mLocalDataSource;
    private RemoteDataSource mRemoteDataSource;

    private Respository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    public static Respository getInstance(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        if (null == INSTANCE) {
            INSTANCE = new Respository(localDataSource, remoteDataSource);
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
