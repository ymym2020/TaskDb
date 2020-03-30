package com.example.youyou.taskdb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by youyou on 2020/03/29.
 */

public class TaskListView extends RelativeLayout implements Button.OnClickListener {

    private RecyclerView mTaskListView;
    private TaskListAdapter mTaskListAdapter;
    private TextView mDateTextView;
    private getTaskDateInterface mGetTaskDateinterface;
    private getTaskListInterface mGetTaskListinterface;
    private clickFunctionInterface mClickFunctionInterface;
    private Button mButtonNewTask;

    private Date taskDate;
    public TaskListView(Context context, AttributeSet attr){
        super(context, attr);
        if( context instanceof getTaskDateInterface ){
            mGetTaskDateinterface = (getTaskDateInterface)context;
        } else {
            throw new RuntimeException(context.toString() + "getTaskDateInterfaceを実装してください");
        }
        if( context instanceof getTaskListInterface ){
            mGetTaskListinterface = (getTaskListInterface)context;
        } else {
            throw new RuntimeException(context.toString() + "getTaskDateInterfaceを実装してください");
        }
        if( context instanceof getTaskListInterface ){
            mClickFunctionInterface = (clickFunctionInterface) context;
        } else {
            throw new RuntimeException(context.toString() + "clickFunctionInterfaceを実装してください");
        }

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
        mDateTextView.setText(CommonFunction.date2Str(mGetTaskDateinterface.getTaskDate()));

        mTaskListView = (RecyclerView)findViewById(R.id.recyclerView_TaskListActivity); // タスク表示リスト
        List<TaskClass> mTaskClassList = mGetTaskListinterface.getTaskList();    // タスククラスをすべて取ってくる
        mTaskListAdapter = new TaskListAdapter(mTaskClassList);
        mTaskListView.setAdapter(mTaskListAdapter);

        mButtonNewTask = (Button)findViewById(R.id.button_newTask_TaskListActivity);    // 新タスク作成ボタン
        mButtonNewTask.setOnClickListener(this);
    }

    public interface getTaskDateInterface{
        Date getTaskDate();   // 日付をセットする
    }

    public interface getTaskListInterface{
        List<TaskClass> getTaskList();  // タスクリストをセットする
    }

    public interface clickFunctionInterface{
        void clickFunction();
    }

    @Override
    public void onClick(View view){
        if( view.getId() == R.id.button_newTask_TaskListActivity ){
            // ボタンタッチ時の挙動
            mClickFunctionInterface.clickFunction();
        }
    }
}
