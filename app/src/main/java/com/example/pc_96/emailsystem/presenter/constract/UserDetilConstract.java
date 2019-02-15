package com.example.pc_96.emailsystem.presenter.constract;

import com.example.pc_96.emailsystem.data.UserBean;

public interface UserDetilConstract {
    interface View {
        void showMessage(UserBean userBean);
    }

    interface Presenter {
        UserBean getMessage();
        void showMessage(UserBean userBean);
        void call(String telephone);
        void sendEmail(String emailAddress);
        void editUser();
    }
}
