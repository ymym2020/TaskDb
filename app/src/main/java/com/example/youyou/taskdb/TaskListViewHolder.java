package com.example.youyou.taskdb;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by youyou on 2020/03/29.
 */

public class TaskListViewHolder extends RecyclerView.ViewHolder {

    public TextView title_TextView;
    public TextView date_TextView;

    public TaskListViewHolder(View view){
        super(view);

        title_TextView = (TextView)view.findViewById(R.id.title_taskContent);
        date_TextView = (TextView)view.findViewById(R.id.date_taskContent);
    }

}
