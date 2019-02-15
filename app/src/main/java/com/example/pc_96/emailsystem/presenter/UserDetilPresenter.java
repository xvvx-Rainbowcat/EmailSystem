package com.example.pc_96.emailsystem.presenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.pc_96.emailsystem.data.UserBean;
import com.example.pc_96.emailsystem.data.source.Respository;
import com.example.pc_96.emailsystem.presenter.constract.UserDetilConstract;
import com.example.pc_96.emailsystem.ui.EditUserActivity;

public class UserDetilPresenter implements UserDetilConstract.Presenter {

    private UserDetilConstract.View mView;
    private Context mContext;
    private Respository mRespository;

    public UserDetilPresenter(Context context, UserDetilConstract.View view, Respository respository) {
        mView = view;
        mContext = context;
        mRespository = respository;
    }

    @Override
    public UserBean getMessage() {
        return null;
    }

    @Override
    public void showMessage(UserBean userBean) {
        mView.showMessage(userBean);
    }

    @Override
    public void call(String telephone) {
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:" + telephone));
        mContext.startActivity(call);
    }

    @Override
    public void sendEmail(String emailAddress) {
        Intent sendEmail = new Intent(Intent.ACTION_SENDTO);
        sendEmail.setData(Uri.parse("mailto:" + emailAddress));
        mContext.startActivity(sendEmail);
    }

    @Override
    public void editUser() {
        Intent editUser = new Intent(mContext, EditUserActivity.class);
        mContext.startActivity(editUser);
    }
}
