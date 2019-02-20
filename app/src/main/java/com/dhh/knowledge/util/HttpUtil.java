package com.dhh.knowledge.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import com.dhh.knowledge.activity.http_url_connection.HttpCallBackListener;
import com.dhh.knowledge.common.Constants;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by DHH on 2019/2/19.
 * 页面：
 */
public class HttpUtil {

    private static Handler mHandler;
    private static HttpURLConnection connection;

    public static void requestData(final String strUrl, final HttpCallBackListener listener) {
        new Thread ( new Runnable () {
            @Override
            public void run() {

                try {
                    //1、使用路径包装类URL，包装我们的路径
                    URL url = new URL ( strUrl );
                    //2、调用openConnection（），建立连接
                    connection =(HttpURLConnection) url.openConnection ();
                    //3、设置请求方式
                    connection.setRequestMethod ( "GET" );
                    //4、设置请求超时时间（单位毫秒）
                    connection.setConnectTimeout ( 5000 );
                    connection.setReadTimeout ( 50000 );
                    connection.connect ();
                    //5、设置字符集
//                    connection.set
                    //6、设置返回码
                    int code = connection.getResponseCode ();
                    if (code == 200) {
                        //7(流)、请求成功后，接受服务器返回的数据
                        InputStream inputStream = connection.getInputStream ();
                        InputStreamReader streamReader = new InputStreamReader ( inputStream );
                        BufferedReader reader = new BufferedReader ( streamReader );
                        String str = reader.readLine ();

                        String readerText = "";
                        StringBuffer buffer = new StringBuffer ();
                        while ((readerText = reader.readLine ()) != null) {
                            buffer.append ( readerText );
                        }

                        if (listener != null) {
                            listener.onFinish ( buffer.toString () );
                        }
                        //8（画工厂）、由于请求的是图片，BitmapFactory工具了
//                        Bitmap bitmap = BitmapFactory.decodeStream ( inputStream );
                    }


                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError ( e );
                    }
                } finally {
                    if (connection !=null){
                        connection.disconnect ();
                    }
                }
            }
        } ).start ();
    }
}
