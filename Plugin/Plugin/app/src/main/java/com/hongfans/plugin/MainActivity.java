package com.hongfans.plugin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hongfans.usage.Andy;
import com.litesuits.orm.LiteOrm;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LiteOrm mLiteOrm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogUtil.i("onCreate ");

        setTitle("Plugin");

        LogUtil.w("插件 调用公用库 " + Andy.getName());

        findViewById(R.id.btn_insert).setOnClickListener(this);
        findViewById(R.id.btn_insert_person).setOnClickListener(this);
        findViewById(R.id.btn_query_person).setOnClickListener(this);

        mLiteOrm = LiteOrm.newSingleInstance(this, "host.db");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_insert:
                Human human = new Human();
                human.setCategory("黄种人");
                human.setNo(200);
                long insert = mLiteOrm.insert(human);
                LogUtil.w("添加人类 " + insert);
                break;
            case R.id.btn_insert_person:
                Person p = new Person();
                p.setName("plugin name");
                p.setAge(2);
                p.setMale(false);
                long insert1 = mLiteOrm.insert(p);
                LogUtil.w("添加人 " + insert1);

                break;
            case R.id.btn_query_person:
                ArrayList<Person> query = mLiteOrm.query(Person.class);
                LogUtil.w("查询人 " + query);
                break;
            default:

                break;
        }
    }
}
