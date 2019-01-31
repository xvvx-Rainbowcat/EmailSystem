package com.example.pc_96.emailsystem.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pc_96.emailsystem.R;
import com.example.pc_96.emailsystem.data.WeeklyMessage;

import java.util.List;

public class WeeklyAdapter extends RecyclerView.Adapter<WeeklyAdapter.WeeklyHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<WeeklyMessage> mData;
    private int mLayoutId;
    private OnItemClickListener mItemClickListener;

    public WeeklyAdapter(Context context, int layoutId, List<WeeklyMessage> data, OnItemClickListener clickListener) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mData = data;
        mLayoutId = layoutId;
        mItemClickListener = clickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public WeeklyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(mLayoutId, viewGroup, false);
        return new WeeklyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeeklyHolder weeklyHolder, int i) {
        weeklyHolder.itemView.setTag(i);
        weeklyHolder.itemView.setOnClickListener((view)->{
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(i);
            }
        });
        // weeklyHolder.onBindView(weeklyHolder, mData.get(i), mContext);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class WeeklyHolder extends RecyclerView.ViewHolder {

        public ImageView mUserAvatar;
        public TextView mUserName;
        public TextView mTime;
        public TextView mViewingCount;

        public WeeklyHolder(View itemView) {
            super(itemView);
            mUserAvatar = itemView.findViewById(R.id.avater);
            mUserName = itemView.findViewById(R.id.name);
            mTime = itemView.findViewById(R.id.time);
            mViewingCount = itemView.findViewById(R.id.viewing_count);
        }

        public void onBindView(WeeklyHolder holder, WeeklyMessage data, Context context) {
            Glide.with(context).load(data.avatar).into(holder.mUserAvatar);
            holder.mUserName.setText(data.name);
            holder.mTime.setText(data.time);
            holder.mViewingCount.setText(String.valueOf(data.viewingCount));
        }

    }
}
