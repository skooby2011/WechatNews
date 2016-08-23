package com.skooby.wechanews.http;

import com.skooby.wechanews.entity.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/8/23.
 */
public class JsonHelper {

    public static List<News> parseJsonToList(String json) throws JSONException {
        JSONObject newsContent = new JSONObject(json);
        JSONArray newsArray = newsContent.getJSONArray("list");
        List<News> newsList = new ArrayList<News>();
        for (int i = 0; i < newsArray.length(); i++) {
            JSONObject newsInJson = newsArray.getJSONObject(i);
            String id = newsInJson.optString("id");
            String title = newsInJson.optString("title");
            String source = newsInJson.optString("source");
            String firstImage = "";
            if (newsInJson.has("firstImg")) {
                firstImage = (String) newsInJson.getJSONArray("images").get(0);

            }
            News news = new News(id, title,source, firstImage);
            newsList.add(news);
        }
        return newsList;
    }
}
