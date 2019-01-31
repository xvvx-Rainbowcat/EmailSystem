package com.example.pc_96.emailsystem.util;

import com.example.pc_96.emailsystem.data.source.Respository;
import com.example.pc_96.emailsystem.data.source.local.LocalDataSource;
import com.example.pc_96.emailsystem.data.source.remote.RemoteDataSource;

public class Injection {
    public static Respository provideRepository() {
        return Respository.getInstance(LocalDataSource.getInstance(),
                RemoteDataSource.getInstance());
    }
}
