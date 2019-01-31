package com.example.pc_96.emailsystem.presenter.constract;

import com.example.pc_96.emailsystem.util.BasePresenter;
import com.example.pc_96.emailsystem.util.BaseView;

public interface WeeklyConstract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void getWeekly();
    }
}
