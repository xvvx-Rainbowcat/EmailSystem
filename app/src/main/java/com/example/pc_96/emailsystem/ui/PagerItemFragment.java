package com.example.pc_96.emailsystem.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pc_96.emailsystem.R;
import com.example.pc_96.emailsystem.adapter.WeeklyAdapter;
import com.example.pc_96.emailsystem.data.WeeklyBean;
import com.example.pc_96.emailsystem.presenter.WeeklyItemPresenter;
import com.example.pc_96.emailsystem.presenter.constract.WeeklyConstract;

import java.util.ArrayList;

public class PagerItemFragment extends Fragment implements WeeklyConstract.View {

    private WeeklyItemPresenter mPresenter;
    private ArrayList<WeeklyBean> mWeeklyBeanList = new ArrayList<>();
    private WeeklyAdapter mAdapter;
    private int mType;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weekly_item, container, false);
        initView(view);
        return view;
    }

    private void initView (View view) {
        RecyclerView recyclerView = view.findViewById(R.id.group_weekly_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        WeeklyAdapter.OnItemClickListener clickListener = (position) -> {
            WeeklyBean bean = mWeeklyBeanList.get(position);
            Intent intent = new Intent(getContext(), WeeklyDetilActivity.class);
            intent.putExtra("data", bean.mContentUrl);  //将文章真实地址传递给详细界面
            startActivity(intent);
        };
        mAdapter = new WeeklyAdapter(getContext(), R.layout.weekly_recycler_item, mWeeklyBeanList, clickListener);
        recyclerView.setAdapter(mAdapter);
        mPresenter = new WeeklyItemPresenter(this, mType);
        mPresenter.getServerResponse();
    }

    @Override
    public void onServerResponse (ArrayList<WeeklyBean> weeklyBeanArrayList) {
        mWeeklyBeanList = weeklyBeanArrayList;
        mAdapter.onDataChange(weeklyBeanArrayList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void bindType (int type) {
        mType = type;
    }   //用于获取Fragment显示的类别,调用于WeeklyActivity(后可改为调用于WeeklyActivty的Presenter)

}
