package com.netease.activeandroidtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.netease.activeandroid.ActiveAndroidHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int mCount=0;
    TextView textView;
    TextView query;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=((TextView)findViewById(R.id.textview));
        query=((TextView)findViewById(R.id.query));
        textView.setText("单条插入");
        //1.单条  张三 1,1
        //2.多条  张三 1,2  李四3，3  王五4.4

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (mCount){
                    case 0:
                        textView.setText("多条插入");
                        item=new Item();
                        item.name="张三";item.age=1;item.userId=1;
                        ActiveAndroidHelper.insertSingleItem(item);
                        break;
                    case 1:
                        List <Item> list=new ArrayList<Item>();
                        item=new Item();
                        item.name="张三";item.age=2;item.userId=1;
                        list.add(item);
                        item=new Item();
                        item.name="李四";item.age=3;item.userId=3;
                        list.add(item);
                        item=new Item();
                        item.name="王五";item.age=4;item.userId=4;
                        list.add(item);
                        ActiveAndroidHelper.bulkInsert(list);
                        textView.setText("删除李四");
                        break;
                    case 2:
                        ActiveAndroidHelper.delete(Item.class,"Name = ?","李四");
                        textView.setText("更新张三");
                        break;
                    case 3:
                        ActiveAndroidHelper.updateSingleItem(Item.class,"age = ?","100","Name = ?","张三");
                        break;
                }
                mCount++;
            }
        });

        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             ArrayList<Item> list= (ArrayList<Item>) ActiveAndroidHelper.selectMultiItem(Item.class,"UserId ASC",null,null);

                String info="";
                for (Item modle:list) {
                        info=info+modle;
                    }
                query.setText( info);
            }
        });



    }



}
