package chapter.android.aweme.ss.com.homework;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Message> mdataset;


    public MyAdapter(List<Message> dataset) {
        mdataset = dataset;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.im_list_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
        Message message = mdataset.get(i);
        System.out.println(message.toString());
        myViewHolder.mTitleView.setText(message.getTitle());
        myViewHolder.mContentView.setText(message.getDescription());
        myViewHolder.mTimeView.setText(message.getTime());
        //myViewHolder.mImageView.setImageIcon(message.getIcon());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(i);
                }
            }
        });

    }


    //第一步 定义接口
    public interface OnItemClickListener {
        void onClick(int position);
    }

    private OnItemClickListener listener;

    //第二步， 写一个公共的方法
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public interface OnItemLongClickListener {
        void onClick(int position);
    }


    @Override
    public int getItemCount() {
        return mdataset.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTitleView;
        TextView mContentView;
        TextView mTimeView;
        ImageView mImageView;

        MyViewHolder(View itemRecyclerView) {
            super(itemRecyclerView);
            mTitleView = itemRecyclerView.findViewById(R.id.tv_title);
            mContentView = itemRecyclerView.findViewById(R.id.tv_description);
            mTimeView = itemRecyclerView.findViewById(R.id.tv_time);
            mImageView = itemRecyclerView.findViewById(R.id.robot_notice);
        }
    }
}
