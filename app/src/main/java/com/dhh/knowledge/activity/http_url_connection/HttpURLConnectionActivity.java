package com.dhh.knowledge.activity.http_url_connection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dhh.knowledge.R;
import com.dhh.knowledge.activity.gson.entity.JsonToGson;
import com.dhh.knowledge.activity.gson.entity.Person;
import com.dhh.knowledge.activity.gson.entity.Result;
import com.dhh.knowledge.activity.gson.entity.SchoolInfo;
import com.dhh.knowledge.adpter.MyViewPagerAdapter;
import com.dhh.knowledge.base.MBaseActivity;
import com.dhh.knowledge.common.Constants;
import com.dhh.knowledge.util.HttpUtil;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DHH on 2018/11/7.
 * 页面：HttpURLConnection
 * 耗时操作：要在子线程中进行，如果耗时操作在主线程中进行，会阻塞主线程，造成ANR（应用程序无响应）
 * <p>
 * 需要在manifest文件中添加网络权限
 */
public class HttpURLConnectionActivity extends MBaseActivity {

    private ImageButton imgBtnBack;
    private TextView tvTitle;
    private ImageButton imgBtnConfrom;
    private TextView mTvHttpRequestContent;
    private ImageView mImgHttpRequestContent;

    private Handler mHandler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_http );

        initUI ();

        initHandler ();

        init ();

        initData ();

        setListeners ();
    }

    @Override
    protected void initUI() {

        imgBtnBack = (ImageButton) findViewById ( R.id.img_btn_back );
        tvTitle = (TextView) findViewById ( R.id.tv_title );
        imgBtnConfrom = (ImageButton) findViewById ( R.id.img_btn_confrom );
        mTvHttpRequestContent = (TextView) findViewById ( R.id.tv_http_request_content );
        mImgHttpRequestContent = (ImageView) findViewById(R.id.img_http_request_content);

    }

    @Override
    protected void initHandler() {
        mHandler = new Handler () {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {

                    case Constants.GET_SUCCESS:
                        String content = (String) msg.obj;
                        Gson gson = new Gson ();
//                        gson.fromJson ( content,GsonBean.class );

                        mTvHttpRequestContent.setText ( content );
                        break;

                    case Constants.GET_FAIL:
                        break;

                    case 2:
                        Bitmap bitmap = (Bitmap) msg.obj;
                        mImgHttpRequestContent.setImageBitmap ( bitmap );
                        break;
                    default:
                        break;
                }
            }
        };
    }

    @Override
    protected void init() {

        // get   post

    }

    private void httpGet() {
        new Thread ( new Runnable () {
            @Override
            public void run() {
                String urlStr = "http://v.juhe.cn/historyWeather/province?key=26eb24bf9f2f85eb4793260cc7867b1f";
                BufferedReader reader = null;
                try {
                    URL url = new URL ( urlStr );
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection ();
                    // 设置请求方式（默认get）
                    httpURLConnection.setRequestMethod ( "GET" );
                    // 设置字符集
                    httpURLConnection.setRequestProperty ( "Charset", "UTF-8" );
                    // 设置允许输入和输出
                    httpURLConnection.setDoInput ( true );
                    httpURLConnection.setDoOutput ( true );
                    // 设置链接超时
                    httpURLConnection.setConnectTimeout ( 500 );
                    // 设置读取超时
                    httpURLConnection.setReadTimeout ( 500 );
                    // 提交
                    httpURLConnection.connect ();
                    // 返回码  返回码==200就是数据请求成功
                    if (httpURLConnection.getResponseCode () == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream ();
                        InputStreamReader streamReader = new InputStreamReader ( inputStream );
                        reader = new BufferedReader ( streamReader );
                        String str = reader.readLine ();
                        Log.e ( "数据", "httpGET：" + str );

                        Message message = new Message ();
                        message.what = Constants.GET_SUCCESS;
                        message.obj = str;
                        mHandler.sendMessage ( message );

                    } else {
                        new Exception ( "数据请求失败。。。请检查代码后重试" );
                    }

                } catch (Exception e) {
                    e.printStackTrace ();
                }finally {
                    if (reader != null){
                        try {
                            reader.close ();
                        } catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                }
            }
        } ).start ();

    }

    @Override
    protected void initData() {
        tvTitle.setText ( "HttpURLConnection" );
    }

    @Override
    protected void setListeners() {

    }

    public void httpGET(View view) {

//        httpGet ();
        HttpUtil.requestData ( "http://v.juhe.cn/historyWeather/province?key=26eb24bf9f2f85eb4793260cc7867b1f", new HttpCallBackListener () {
            @Override
            public void onFinish(String respose) {
                Message message = new Message ();
                message.what = Constants.GET_SUCCESS;
                message.obj = respose;
                mHandler.sendMessage ( message );
            }

            @Override
            public void onError(Exception e) {
                Message message = new Message ();
                message.what = 1;
                message.obj = "请求错误" + e;
                mHandler.sendMessage ( message );
            }
        } );
    }

    public void httpPOST(View view) {
        new Thread ( new Runnable () {
            @Override
            public void run() {
                httpPost();
            }
        } ).start ();
    }

    private void httpPost() {
        String urlStr = "http://v.juhe.cn/historyWeather/citys";
        BufferedReader reader = null;
        try {
            URL url = new URL ( urlStr );
            HttpURLConnection post = (HttpURLConnection) url.openConnection ();
            //设置请求方式
            post.setRequestMethod ( "POST" );
            //设置字符集
            post.setRequestProperty ( "Charset","UTF-8" );
            //设置链接超时
            post.setConnectTimeout ( 5000 );
            //设置读取超时
            post.setReadTimeout ( 5000 );

            String key = "key=26eb24bf9f2f85eb4793260cc7867b1f" + "&province_id=3";
            PrintWriter writer = new PrintWriter ( post.getOutputStream () );
            writer.write ( key );
            writer.flush ();
            writer.close ();
            if (post.getResponseCode () == 200){
                reader = new BufferedReader (
                        new InputStreamReader ( post.getInputStream () )
                );
                String readerText = "";
                StringBuffer buffer = new StringBuffer (  );
                while ((readerText= reader.readLine ()) != null){
                    buffer.append ( readerText );
                }

                Message message = new Message ();
                message.what = Constants.GET_SUCCESS;
                message.obj = buffer.toString ();
                mHandler.sendMessage ( message );

            }

        } catch (Exception e) {
            e.printStackTrace ();
        }finally {
            if (reader != null){
                try {
                    reader.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
    }


    public void httpGETImage(View view) {
        String strUrl = "http://pic2.16pic.com/00/04/33/16pic_433435_b.jpg";
        try {
            //1、使用路径包装类URL，包装我们的路径
            URL url = new URL ( strUrl );
            //2、调用openConnection（），建立连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
            //3、设置请求方式
            connection.setRequestMethod ( "GET" );
            //4、设置请求超时时间（单位毫秒）
            connection.setConnectTimeout ( 5000 );
            connection.setReadTimeout ( 50000 );
            //5、设置字符集
//                    connection.set
            //6、设置返回码
            int code = connection.getResponseCode ();
            if (code == 200) {
                //7(流)、请求成功后，接受服务器返回的数据
                InputStream inputStream = connection.getInputStream ();
                //8（画工厂）、由于请求的是图片，BitmapFactory工具了
                Bitmap bitmap = BitmapFactory.decodeStream ( inputStream );
                Message message = new Message ();
                message.what = 2;
                message.obj= bitmap;
                mHandler.sendMessage ( message );
            } else {
                Message message = new Message ();
                message.what = 1;
                message.obj= "请求错误";
                mHandler.sendMessage ( message );
            }

        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public void back(View view) {
        finish ();
    }
}


