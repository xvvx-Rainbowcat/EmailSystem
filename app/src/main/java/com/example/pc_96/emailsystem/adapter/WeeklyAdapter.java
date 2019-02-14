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
import com.bumptech.glide.request.RequestOptions;
import com.example.pc_96.emailsystem.R;
import com.example.pc_96.emailsystem.data.WeeklyBean;

import java.util.ArrayList;
import java.util.List;

public class WeeklyAdapter extends RecyclerView.Adapter<WeeklyAdapter.WeeklyHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<WeeklyBean> mData;
    private int mLayoutId;
    private OnItemClickListener mItemClickListener;

    public WeeklyAdapter (Context context, int layoutId, ArrayList<WeeklyBean> data, OnItemClickListener clickListener) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mData = data;
        mLayoutId = layoutId;
        mItemClickListener = clickListener;
    }

    public void onDataChange (ArrayList<WeeklyBean> Data) {
        this.mData = Data;
    }   //当网络请求返回时用于修改列表

    public interface OnItemClickListener {
        void onItemClick (int position);
    }

    @NonNull
    @Override
    public WeeklyHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(mLayoutId, viewGroup, false);
        return new WeeklyHolder(view);
    }

    @Override
    public void onBindViewHolder (@NonNull WeeklyHolder weeklyHolder, int i) {
        weeklyHolder.itemView.setTag(i);
        weeklyHolder.itemView.setOnClickListener((view) -> {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(i);
            }
        });
        weeklyHolder.onBindView(weeklyHolder, mData.get(i), mContext);
    }

    @Override
    public int getItemCount () {
        return mData.size();
    }


    public static class WeeklyHolder extends RecyclerView.ViewHolder {  //新增Title,CommentCount

        public ImageView mUserAvatar;
        public TextView mTitle;
        public TextView mUserName;
        public TextView mTime;
        public TextView mViewingCount;
        public TextView mCommentCount;

        public WeeklyHolder (View itemView) {
            super(itemView);
            mUserAvatar = itemView.findViewById(R.id.avater);
            mTitle = itemView.findViewById(R.id.title);
            mUserName = itemView.findViewById(R.id.name);
            mTime = itemView.findViewById(R.id.time);
            mViewingCount = itemView.findViewById(R.id.viewing_count);
            mCommentCount = itemView.findViewById(R.id.comment_count);
        }

        public void onBindView (WeeklyHolder holder, WeeklyBean data, Context context) {
            if (data.mAvatarUrl != null) {
//                Glide.with(context).load("html://pic.cnblogs.com/face/999921/20160728114510.png")
//                        .apply(RequestOptions.centerCropTransform())
//                        .into(holder.mUserAvatar);
                //2.14 3:11 网络加载图片有点问题,暂且搁置
            }
            holder.mTitle.setText(data.mTitle);
            holder.mUserName.setText(data.mUserName);
            holder.mTime.setText(data.mTime);
            holder.mViewingCount.setText(data.mViewerCount);
            holder.mCommentCount.setText(data.mCommentCount);
        }

    }
}
