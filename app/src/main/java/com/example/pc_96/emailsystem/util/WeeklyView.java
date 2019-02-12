package com.example.pc_96.emailsystem.util;

import com.example.pc_96.emailsystem.data.WeeklyBean;

import java.util.ArrayList;

public interface WeeklyView {
    void onServerResponse(ArrayList<WeeklyBean> weeklyBeanArrayList);
    void bindType(int type);
}
