package com.example.pc_96.emailsystem.presenter;

import com.example.pc_96.emailsystem.presenter.constract.UserDetilConstract;

public class UserDetilPresenter implements UserDetilConstract.Presenter {
    private UserDetilConstract.View mView;

    public UserDetilPresenter(UserDetilConstract.View view) {
        mView = view;
    }

    @Override
    public void getMessage() {

    }
}
