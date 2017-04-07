package com.netease.activeandroid;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.activeandroid.Model;
import com.activeandroid.query.Delete;
import com.activeandroid.query.From;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.util.List;

/**
 * Created by xiejiantao on 2017/4/6.
 */

public class ActiveAndroidHelper {

    public static void  init(Context app){
        ActiveAndroid.initialize(app);
    }

    public static void dispose(){
        ActiveAndroid.dispose();
    }

    public  static void  delete(Class<? extends Model> clazz,String where,String ...args){
        new Delete().from(clazz).where(where,args).execute();
    }

    public static  void  updateSingleItem(Class<? extends Model> clazz,String set,String arg,String where,String ...args){
        new Update(clazz).set(set,arg).where(where,args).execute();
    }

    public static  void  updateMultiItem(Class<? extends Model> clazz,String set,String where,String ...args){
        new Update(clazz).set(set).where(where,args).execute();
    }
    public static <T extends Model>  void  insertSingleItem(T model){
        model.save();
    }

    public static   void  bulkInsert(List<? extends Model> list){
        ActiveAndroid.beginTransaction();
        try {
            for (Model modle:list) {
                modle.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        }finally {
            ActiveAndroid.endTransaction();
        }
    }

    public  static  <T extends Model> T selectRandomSingleItem(Class<T> clazz,String where,String ...args){
        return new Select().from(clazz).where(where,args).orderBy("RANDOM()").executeSingle();
    }

    public  static  <T extends Model> List<T> selectMultiItem(Class<T> clazz,@Nullable String orderBy,@Nullable  String where,@Nullable  String ...args){
        From from=new Select().from(clazz);
        if (TextUtils.isEmpty(where)){
        }else if (args==null){
            from.where(where);
        }else{
            from.where(where,args);
        }
        if (orderBy!=null){
            from.orderBy(orderBy);
        }
       return   from.execute();
    }

}
