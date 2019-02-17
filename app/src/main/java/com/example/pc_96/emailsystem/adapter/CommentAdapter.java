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
import com.example.pc_96.emailsystem.data.CommentBean;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    
    private ArrayList<CommentBean> mCommentBeanList;
    private Context mContext;
    private LayoutInflater mInflater;

    public CommentAdapter(ArrayList<CommentBean> mCommentBeanList, Context context) {
        mCommentBeanList = mCommentBeanList;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    public void onDataChange(ArrayList mCommentBeanList){   //2.14 3:46 新增方法用于获取从网络获取的内容
        this.mCommentBeanList = mCommentBeanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.comment_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.onBindView(mContext,mCommentBeanList.get(i));
    }

    @Override
    public int getItemCount() {
        if(mCommentBeanList == null){
            return 0;
        }else {
            return mCommentBeanList.size();
        }
    }
    
    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView avater;
        private TextView author;
        private TextView content;
        private TextView time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avater = itemView.findViewById(R.id.commenter_avatar);
            author = itemView.findViewById(R.id.comment_author);
            content = itemView.findViewById(R.id.comment_content);
            time = itemView.findViewById(R.id.comment_time);
        }

        public void onBindView(Context context,CommentBean commentBean) {
            Glide.with(context).load(commentBean.mAvatarUrl).into(avater);
            author.setText(commentBean.mAuthorName);
            content.setText(commentBean.mContent);
            time.setText(commentBean.mTime);
        }
    }
}
