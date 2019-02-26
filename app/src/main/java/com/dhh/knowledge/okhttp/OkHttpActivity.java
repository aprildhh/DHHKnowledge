package com.dhh.knowledge.okhttp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dhh.knowledge.R;
import com.dhh.knowledge.base.MBaseActivity;
import com.zhy.http.okhttp.OkHttpUtils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by DHH on 2019/2/20.
 * 页面：OKHTTP学习页面
 */
public class OkHttpActivity extends MBaseActivity {
    private ImageButton mImgBtnBack;
    private TextView mTvTitle;
    private ImageButton mImgBtnConfrom;
    private TextView mTvOkhttpContent;

    private static final int GET = 1;
    private static final int POST = 2;
    private OkHttpClient client = new OkHttpClient ();
    private String urlStr = "http://v.juhe.cn/historyWeather/province?key=26eb24bf9f2f85eb4793260cc7867b1f";
    private Handler mHandler;

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        setContentView ( R.layout.activity_ok_http );

        initUI ();

        initHandler ();

        init ();

        initData ();

        setListeners ();

    }

    @Override
    protected void initUI() {
        mImgBtnBack = (ImageButton) findViewById(R.id.img_btn_back);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mImgBtnConfrom = (ImageButton) findViewById(R.id.img_btn_confrom);
        mTvOkhttpContent = (TextView) findViewById(R.id.tv_okhttp_content);
    }

    @Override
    protected void initHandler() {
        mHandler = new Handler () {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage ( msg );
                switch (msg.what) {
                    case GET:
                        String result = (String) msg.obj;
                        mTvOkhttpContent.setText ( result );
                        break;

                    case POST:
                        mTvOkhttpContent.setText ( (String) msg.obj );
                        break;
                    default:
                        break;
                }
            }
        };
    }

    @Override
    protected void initData() {

    }

    /**
     * get请求：只能在子线程请求
     *
     * @param url 网络连接
     * @return
     * @throws IOException
     */
    private String get(String url) throws IOException {
        Request request = new Request.Builder ()
                .url ( url )
                .build ();

        try (Response response = client.newCall ( request ).execute ()) {
            return response.body ().string ();
        }
    }

    public void okHttpGet(View view) {

        getDataFromGet ();

    }

    public void okHttpPost(View view) {

        mTvOkhttpContent.setText ( "" );
        getDataFromPost ();

    }


    /**
     * okhttp3的post请求：也需要在子线程中请求
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private void getDataFromGet() {
        new Thread ( new Runnable () {
            @Override
            public void run() {
                try {
                    String result = get ( urlStr );
                    Log.e ( "Tag", result );
                    Message message = new Message ();
                    message.what = GET;
                    message.obj = result;
                    mHandler.sendMessage ( message );

                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        } ) {
        }.start ();
    }

    private void getDataFromPost() {
        new Thread ( new Runnable () {
            @Override
            public void run() {
                try {
                    String result = post ( urlStr ,"");
                    Log.e ( "Tag", result );
                    Message message = new Message ();
                    message.what = POST;
                    message.obj = result;
                    mHandler.sendMessage ( message );

                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        } ) {
        }.start ();
    }

    private void getDataByOkHttyUtils(){
        OkHttpUtils.get ().url ( urlStr ).id ( 100 ).build ().execute ();
    }

}
