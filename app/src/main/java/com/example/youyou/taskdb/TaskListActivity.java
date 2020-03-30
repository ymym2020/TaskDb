package com.example.youyou.taskdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskListActivity extends AppCompatActivity implements TaskListView.getTaskDateInterface , TaskListView.getTaskListInterface , TaskListView.clickFunctionInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklist_activity);
    }

    @Override
    public Date getTaskDate(){
        Date ret = new Date();

        return ret;
    }

    @Override
    public List<TaskClass> getTaskList(){
        List<TaskClass> list = new ArrayList<TaskClass>();

        return list;
    }

    @Override
    public void clickFunction(){
        Intent intent = new Intent( this, TaskRegisterActivity.class);
        startActivity(intent);
        return  ;
    }
}
