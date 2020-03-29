package com.example.youyou.taskdb;

import java.io.StringBufferInputStream;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by youyou on 2020/03/29.
 */

public class TaskClass extends RealmObject {

    @PrimaryKey
    private int id = 0; // ID

    private String strTitle = "";    // タイトル
    private String strMemo  = "";    // メモ
    private boolean bFinishFlg = false;     // 完了フラグ(true:完了, false:未完了）
    private Date planDate   = new Date();   // 予定日付
    private Date finishDate = new Date();   // 終了日付

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getStrTitle(){
        return this.strTitle;
    }
    public void setStrTitle(String title){
        this.strTitle = title;
    }

    public String getStrMemo(){
        return this.strMemo;
    }
    public void setStrMemo(String memo){
        this.strMemo = memo;
    }

    public boolean getFinishFlg(){
        return this.bFinishFlg;
    }
    public void setFinishFlg(Boolean flg){
        this.bFinishFlg = flg;
    }

    public Date getPlanDate(){
        return this.planDate;
    }
    public void setPlanDate(Date date){
        this.planDate = date;
    }
    public String getPlanDateString(){
        return CommonFunction.date2Str(getPlanDate());
    }

    public Date getFinishDate(){
        return this.finishDate;
    }
    public void setFinishDate(Date date){
        this.finishDate = date;
    }
    public String getFinishDateString(){
        return CommonFunction.date2Str(getFinishDate());
    }



}
