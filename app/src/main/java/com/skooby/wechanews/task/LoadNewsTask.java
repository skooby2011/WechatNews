package com.skooby.wechanews.task;

import android.os.AsyncTask;
import android.util.Log;

import com.skooby.wechanews.adapter.NewsAdapter;
import com.skooby.wechanews.entity.News;
import com.skooby.wechanews.http.HttpRequest;
import com.skooby.wechanews.http.JsonHelper;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by lenovo on 2016/8/23.
 */
public class LoadNewsTask extends AsyncTask<Void, Void, List<News>> {

    private NewsAdapter adapter;
    private onFinishListener listener;

    public LoadNewsTask(NewsAdapter adapter) {
        super();
        this.adapter = adapter;
    }

    public LoadNewsTask(NewsAdapter adapter, onFinishListener listener) {
        super();
        this.adapter = adapter;
        this.listener = listener;
    }

    @Override
    protected List<News> doInBackground(Void... params) {
        List<News> newsList = null;
        try {
            newsList = JsonHelper.parseJsonToList(HttpRequest.get("1"));
            Log.d("LoadNewsTask", "JasonHelper.parseJsonToList pass");
        } catch (IOException | JSONException e) {
            Log.d("LoadNewsTask", "JasonHelper.parseJsonToList fail");

        } finally {
            return newsList;
        }
    }

    @Override
    protected void onPostExecute(List<News> newsList) {
        adapter.clear();
        adapter.addAll(newsList);
        adapter.notifyDataSetChanged();
        if (listener != null) {
            listener.afterTaskFinish();
        }

    }

    public interface onFinishListener {
        public void afterTaskFinish();
    }
}


