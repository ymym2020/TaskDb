package com.example.youyou.taskdb;

import java.util.Date;

/**
 * Created by youyou on 2020/03/29.
 */

// 多くのクラスで使用する関数群
// すべてstatic関数
public class CommonFunction {

    public static String date2Str(Date date){
        String str = null;
        if( date != null ){
            str = String.format("%04d/%02d/%02d", date.getYear()+2000, date.getMonth()+1, date.getMinutes());
        }
        return str;
    }

}
