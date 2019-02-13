package com.example.pc_96.emailsystem.presenter.constract;

import com.example.pc_96.emailsystem.data.WeeklyBean;

import java.util.ArrayList;

public interface WeeklyConstract {
    interface View {
        void onServerResponse(ArrayList<WeeklyBean> weeklyBeanArrayList);

        void bindType(int type);
    }

    interface Presenter {
        void getServerResponse();
    }
}
