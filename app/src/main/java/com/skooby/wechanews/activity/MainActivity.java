package com.skooby.wechanews.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.skooby.wechanews.R;
import com.skooby.wechanews.adapter.NewsAdapter;
import com.skooby.wechanews.task.LoadNewsTask;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView newList;
    private NewsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newList = (ListView)findViewById(R.id.news_list);
        adapter = new NewsAdapter(this,R.layout.listview_item);

        newList.setAdapter(adapter);
        new LoadNewsTask(adapter).execute();

    }
}

