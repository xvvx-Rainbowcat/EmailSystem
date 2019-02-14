package com.example.pc_96.emailsystem.presenter.constract;

import com.example.pc_96.emailsystem.data.CommentBean;

import java.util.ArrayList;

public interface WeeklyDetilConstract {
    interface View {
        void onServerResponse(String content, ArrayList<CommentBean> commentBeanList);
    }

    interface Presenter {
        void getServerResponse(String contentUrl);
    }
}
