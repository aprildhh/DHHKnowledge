package com.dhh.knowledge.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import android.widget.TextView;

import com.dhh.knowledge.R;
import com.dhh.knowledge.activity.custom_control.CustomControlActivity;
import com.dhh.knowledge.activity.gson.GsonActivity;
import com.dhh.knowledge.activity.http_url_connection.HttpURLConnectionActivity;
import com.dhh.knowledge.adpter.MainRecyclerViewAdapter;
import com.dhh.knowledge.base.AndroidBasicActivity;
import com.dhh.knowledge.common.Constants;
import com.dhh.knowledge.common.Util;
import com.dhh.knowledge.jni.JNI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    private TextView tv;
    private RecyclerView recyclerView;

    private MainRecyclerViewAdapter adapter;
    private ArrayList<Map<String, Object>> datas;

    private GestureDetector mGestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        initdata ();
        init ();

        recyclerView.setHasFixedSize ( true );
        //设置recyclerView的适配器
        adapter = new MainRecyclerViewAdapter ( this, datas );
        recyclerView.setAdapter ( adapter );

        /**
         * LayoutManager
         * new LinearLayoutManager ( 上下文，方向，是否倒序 ) ListView效果
         * new GridLayoutManager (  ) GridView效果
         * new StaggeredGridLayoutManager (  ) 瀑布流效果
         */
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this, LinearLayoutManager.VERTICAL, false ) );
        adapter.setOnItemClickListener ( new MainRecyclerViewAdapter.OnItemClickListener () {
            @Override
            public void onItemClick(View view, int position, Map<String, Object> data) {
                String type = (String) data.get ( "type" );
                if ("RecyclerView".equals ( type )){
                    Util.showActivity(MainActivity.this,RecyclerViewActivity.class);
                }else if ("CustomControl".equals ( type )){
                    Util.showActivity(MainActivity.this,CustomControlActivity.class);
                }else if ("FAB".equals ( type )){
                    Util.showActivity(MainActivity.this,FloatingActionButtonActivity.class);
                }else if("MySQL".equals ( type )){
                    Util.showActivity(MainActivity.this,MySQLActivity.class);
                }else if("Gson".equals ( type )){
                    Util.showActivity(MainActivity.this,GsonActivity.class);
                }else if("HttpURLConnection".equals ( type )){
                    Util.showActivity(MainActivity.this,HttpURLConnectionActivity.class);
                }else if("AndroidBasic".equals ( type )){
                    Util.showActivity(MainActivity.this,AndroidBasicActivity.class);
                }
            }
        } );
    }

    private void init() {
        datas = new ArrayList<> ();
        for (int i = 0; i < Constants.contents.length; i++) {
            Map<String, Object> map = new HashMap<> ();
            map.put ( "leftTitle", Constants.leftTitles[i] );
            map.put ( "title", Constants.titles[i] );
            map.put ( "content", Constants.contents[i] );
            map.put ( "color", Constants.colors[i] );
            map.put ( "type", Constants.types[i] );
            datas.add ( map );
        }
    }

    private void initdata() {
        // Example of a call to a native method
        tv = (TextView) findViewById ( R.id.sample_text );
//        tv.setText ( new JNI ().stringFromJNI () );


        recyclerView = (RecyclerView) findViewById ( R.id.rv_main );

         mGestureDetector = new GestureDetector ( this );
        //解决长按屏幕后无法拖动的现象
        mGestureDetector.setIsLongpressEnabled ( false );


        Context mContext = this;
        Scroller scroller = new Scroller ( mContext );

        int destX = 5;
        int destY = 10;
        smoothScrollTo(destX,destY);

        tv.scrollTo ( 5,10 );
    }

    private void smoothScrollTo(int destX, int destY) {
//        int scrollX = getScrll
    }


    @Override
    public boolean onDown(MotionEvent event) {
        boolean consume = mGestureDetector.onTouchEvent ( event );
        return consume;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

}
