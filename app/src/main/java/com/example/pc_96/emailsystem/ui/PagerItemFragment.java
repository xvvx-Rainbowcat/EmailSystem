package com.example.pc_96.emailsystem.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.example.pc_96.emailsystem.data.WeeklyMessage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PagerItemFragment extends Fragment {

    private List<WeeklyMessage> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weekly_item, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        WeeklyMessage message = new WeeklyMessage(R.mipmap.aver, "yjh", "2019.1.29 11:06",
                12, "fasdfasdfasdfdsagfdsgsdgdfsg");
        for (int i = 0; i < 10; i++) {
            data.add(message);
        }
    }

    private void initView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.group_weekly_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        WeeklyAdapter.OnItemClickListener clickListener = (position) -> {
            WeeklyMessage message = data.get(position);
            Intent intent = new Intent(getContext(), WeeklyDetilActivity.class);
            intent.putExtra("data", message);
            startActivity(intent);
        };
        WeeklyAdapter adapter = new WeeklyAdapter(getContext(), R.layout.weekly_recycler_item, data, clickListener);
        recyclerView.setAdapter(adapter);
    }
}
