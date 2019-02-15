package com.example.pc_96.emailsystem.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc_96.emailsystem.R;
import com.example.pc_96.emailsystem.data.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    
    private List<Comment> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    public CommentAdapter(List<Comment> data, Context context) {
        mData = data;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.comment_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.onBindView();
    }

    @Override
    public int getItemCount() {
        return 10;
    }
    
    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView avater;
        private TextView author;
        private TextView content;
        private TextView time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avater = itemView.findViewById(R.id.commenter_avatar);
            author = itemView.findViewById(R.id.commenter_name);
            content = itemView.findViewById(R.id.comment_content);
            time = itemView.findViewById(R.id.publish_time);
        }

        public void onBindView() {
        }
    }
}
