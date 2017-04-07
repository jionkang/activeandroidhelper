package com.netease.activeandroidtest;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by xiejiantao on 2017/4/5.
 */
@Table(name = "Categories")
public class Item extends Model {
    @Column(name = "Name")
    public String name;

    @Column(name = "UserId",index=true,unique = true, onUniqueConflict = Column.ConflictAction.REPLACE )
    public int userId;

    @Column
    public int age;

    @Override
    public String toString() {
        return "name "+name+" userId "+userId+" age "+age;
    }
}