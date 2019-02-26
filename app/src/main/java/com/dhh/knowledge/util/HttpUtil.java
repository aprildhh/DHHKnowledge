package com.dhh.knowledge.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Network;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.dhh.knowledge.activity.http_url_connection.HttpCallBackListener;
import com.dhh.knowledge.common.Constants;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
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
                    connection = (HttpURLConnection) url.openConnection ();
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

//                        String readerText = "";
//                        StringBuffer buffer = new StringBuffer ();
//                        while ((readerText = reader.readLine ()) != null) {
//                            buffer.append ( readerText );
//                        }

                        if (listener != null) {
//                            listener.onFinish ( buffer.toString () );
                            listener.onFinish ( str );
                        }
                        //8（画工厂）、由于请求的是图片，BitmapFactory工具了
//                        Bitmap bitmap = BitmapFactory.decodeStream ( inputStream );
                    }


                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError ( e );
                    }
                } finally {
                    if (connection != null) {
                        connection.disconnect ();
                    }
                }
            }
        } ).start ();
    }

    /**
     * 请求网络图片
     *
     * @param imgURL
     * @param listener
     */
    public static void RequestNetworkPictures(final String imgURL, final HttpCallBackListener listener) {
        new Thread ( new Runnable () {

            private Bitmap bitmap;

            @Override
            public void run() {
                try {
                    URL url = new URL ( imgURL );
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
                    connection.setRequestMethod ( "GET" );
                    connection.setConnectTimeout ( 50000 );
//                    connection.setRequestProperty ( "Charset","utf-8" );
                    connection.setDoInput ( true );
                    int code = connection.getResponseCode ();
                    if (code == 200) {
                        InputStream inputStream = connection.getInputStream ();

                        //请求一：无法正常解码为Bitmap对象的解决方法
//                        bitmap = BitmapFactory.decodeStream ( inputStream );
                        /**
                         * 解决办法：
                         * 请求二：将流转化为字节数组
                         *
                         */

                        byte[] data = null;
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream ();
                        byte[] buffer = new byte[1024];
                        int len = 0;
                        while ((len = inputStream.read ( buffer )) != -1) {
                            outputStream.write ( buffer, 0, len );
                        }
                        outputStream.close ();
                        inputStream.close ();

                        data = outputStream.toByteArray ();

                        if (data != null) {
                            bitmap = BitmapFactory.decodeByteArray ( data, 0, data.length );
                        }

                    }

                    if (listener != null) {
                        listener.getImage ( bitmap );
                    }


                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError ( e );
                    }
                } finally {
                    if (listener != null) {
                        connection.disconnect ();
                    }
                }
            }
        } ).start ();
    }

    public static void getImage(final String strUrl, final HttpCallBackListener listener) {
        new Thread ( new Runnable () {
            @Override
            public void run() {
                //1、使用路径包装类URL，包装我们的路径
                URL url = null;
                try {
                    url = new URL ( strUrl );

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

                        Log.e ( "bitmap","aaaaa" );

                        if (listener != null){
                            listener.getImage ( bitmap );
                        }

//                        Message message = new Message ();
//                        message.what = 2;
//                        message.obj = bitmap;
//                        mHandler.sendMessage ( message );
                    } else {
//                        Message message = new Message ();
//                        message.what = 1;
//                        message.obj = "请求错误";
//                        mHandler.sendMessage ( message );
                    }
                } catch (Exception e) {
                    e.printStackTrace ();
                }

            }
        } ).start ();
    }
}
