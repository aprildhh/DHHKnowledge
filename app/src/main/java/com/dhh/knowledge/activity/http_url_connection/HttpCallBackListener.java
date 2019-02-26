package com.dhh.knowledge.activity.http_url_connection;

/**
 * Created by DHH on 2019/2/19.
 * 页面：
 */
public interface HttpCallBackListener {

    void onFinish(String respose);

    void onError(Exception e);

    void getImage(Object obj);
}
