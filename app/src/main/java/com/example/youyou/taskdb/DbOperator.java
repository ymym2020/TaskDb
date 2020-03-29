package com.example.youyou.taskdb;

import java.util.List;

import io.realm.Realm;

/**
 * Created by youyou on 2020/03/29.
 */

public class DbOperator {

    private Realm realm;
    private TaskClass weightData;

    public DbOperator(){
        realm = Realm.getDefaultInstance();
    }

    public void insert(TaskClass weightData){
        final TaskClass target = weightData;
        try {
            realm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealmOrUpdate(target);
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            //realm.close();
        }
    }

    public void delete(TaskClass memo){
        final TaskClass target = memo;
        try{
            realm.beginTransaction();
            target.deleteFromRealm();
            realm.commitTransaction();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            //realm.close();
        }
    }

    public List<TaskClass> findAll(){
        List<TaskClass> ret = null;
        try{
            ret = realm.where(TaskClass.class).findAll();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            //realm.close();
        }
        return ret;
    }

    public TaskClass find(int id){
        final int targetId = id;
        TaskClass ret = null;
        try{
            ret = realm.where(TaskClass.class).equalTo("id", targetId).findFirst();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            //realm.close();
        }

        return ret;
    }

}
