package com.example.youyou.taskdb;

import android.content.Context;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.Date;
import java.util.List;

/**
 * Created by youyou on 2020/03/29.
 */

public class TaskListAdapter extends RecyclerView.Adapter<TaskListViewHolder> {

    private List<TaskClass> list;

    public TaskListAdapter(List<TaskClass> list) {
        this.list = list;
    }

    @Override
    public TaskListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_content, parent,false);
        TaskListViewHolder vh = new TaskListViewHolder(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(TaskListViewHolder holder, int position) {
        holder.title_TextView.setText(list.get(position).getStrTitle());       // タイトル設定
        holder.date_TextView.setText(list.get(position).getPlanDateString());  // 日付設定
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
