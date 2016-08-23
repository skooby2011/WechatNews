package com.skooby.wechanews.http;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2016/8/23.
 */
public class HttpRequest {

    public static final String APPKEY = "f509ab81014550537321ba98fee578e1";
    public  static final String url ="http://v.juhe.cn/weixin/query"; //请求接口地址

    public static String get(String pno) throws IOException{
        Map params = new HashMap();//请求参数
        params.put("pno",pno); //当前页数，默认1
        params.put("ps",""); //每页返回条数，最大100，默认20
        params.put("dtype","");//返回数据的格式,xml或json，默认json
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)

        HttpURLConnection con = null;
        try {
            URL url = new URL(urlencode(params));
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            Log.d("HttpRequest","get pass");
            return response.toString();

        }
        finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }

    public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
