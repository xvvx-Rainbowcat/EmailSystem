package com.example.pc_96.emailsystem.presenter.constract;

public interface WeeklyDetilConstract {
    interface View {
        void onServerResponse(String content);
    }

    interface Presenter {
        void getServerResponse();
    }
}
