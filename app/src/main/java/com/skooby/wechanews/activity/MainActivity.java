package com.skooby.wechanews.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.skooby.wechanews.R;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String APPKEY = "f509ab81014550537321ba98fee578e1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url ="http://v.juhe.cn/weixin/query";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("pno","");//当前页数，默认1
        params.put("ps","");//每页返回条数，最大100，默认20
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml或json，默认json

    }

    /*
    AppKey：f509ab81014550537321ba98fee578e1
     */
}
