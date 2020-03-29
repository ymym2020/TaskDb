package com.example.youyou.taskdb;

import android.app.Application;
import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by youyou on 2020/03/29.
 */

public class TaskDb extends Application {

    static int currentId = 1;

    @Override
    public void onCreate(){
        super.onCreate();;
        Log.d("DebugLog", "TaskDb Start");
        Realm.init(this);
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder().build());

        //deleteAll();
    }

    public static int getCurrentId(){
        int id = currentId;
        currentId++;

        if( currentId >= 1000000 ){
            currentId = 0;
        }
        return id;
    }

    private void deleteAll(){
        DbOperator dbOperator = new DbOperator();
        List<TaskClass> list = dbOperator.findAll();
        for(TaskClass data : list ){
            dbOperator.delete(data);
        }
    }

}
