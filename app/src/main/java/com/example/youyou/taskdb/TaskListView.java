package com.example.youyou.taskdb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by youyou on 2020/03/29.
 */

public class TaskListView extends RelativeLayout {

    private RecyclerView mTaskListView;
    private TaskListAdapter mTaskListAdapter;
    private TextView mDateTextView;
    private setTaskDateInterface mSetTaskDateinterface;
    private Date mTaskDate; // 予定日付

    private Date taskDate;
    public TaskListView(Context context, AttributeSet attr){
        super(context, attr);
        if( context instanceof setTaskDateInterface ){
            mSetTaskDateinterface = (setTaskDateInterface)context;
        } else {
            throw new RuntimeException(context.toString() + "setTaskDateInterfaceを実装してください");
        }
        mTaskDate = mSetTaskDateinterface.setTaskDate();
    }

    /*
    * inflateが完了した時点での実行
    *  各コンポーネントの設定
     */
    @Override
    protected void onFinishInflate(){
        Log.d("DebugLog", "onFinishInflate");
        super.onFinishInflate();
        initTaskListView();
    }

    // 初期処理
    private void initTaskListView(){
        mDateTextView = (TextView)findViewById(R.id.textView_date_TaskListAcitivity);   // 日付表示
        mDateTextView.setText(CommonFunction.date2Str(mTaskDate));

        mTaskListView = (RecyclerView)findViewById(R.id.recyclerView_TaskListActivity); // タスク表示リスト
        List<TaskClass> mTaskClassList = new ArrayList<TaskClass>();    // タスククラスをすべて取ってくる
        mTaskListAdapter = new TaskListAdapter(mTaskClassList);
        mTaskListView.setAdapter(mTaskListAdapter);
    }

    public interface setTaskDateInterface{
        Date setTaskDate();   // 日付をセットする
    }
}
