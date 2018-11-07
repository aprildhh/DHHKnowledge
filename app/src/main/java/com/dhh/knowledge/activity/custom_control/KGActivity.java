package com.dhh.knowledge.activity.custom_control;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.dhh.knowledge.R;
import com.dhh.knowledge.adpter.MyRecyclerViewAdapter;
import com.dhh.knowledge.base.MBaseActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义开关
 */
public class KGActivity  extends MBaseActivity {

    private TextView tv;
    private RecyclerView recyclerView;

    private Handler mHandler;

    private MyRecyclerViewAdapter mAdapter;
    private List<Map<String,Object>> dataList;

    private String[] titles = {"01优酷菜单","02广告效果-ViewPager"};
    private int[] imgs = {R.mipmap.bg_list_1,R.mipmap.bg_list_2};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_kg );

        initUI ();

        initHandler ();

        init ();

        initData ();

        setListeners ();
    }

    @Override
    protected void initUI() {

        tv = (TextView) findViewById ( R.id.sample_text );
        recyclerView = (RecyclerView) findViewById ( R.id.rv_main );



    }

    @Override
    protected void initHandler() {
        mHandler = new Handler (  ){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    default:
                        break;
                }
            }
        };
    }

    @Override
    protected void init() {
        for (int i =0; i< titles.length;i++){
            Map<String,Object> map = new HashMap<> (  );
            map.put ( "title",titles[i] );
            map.put ( "imgId",imgs[i] );
            dataList.add ( map );
        }
    }

    @Override
    protected void initData() {
        tv.setText ( "" );

        recyclerView.setHasFixedSize ( true );
        mAdapter = new MyRecyclerViewAdapter (activity,dataList,mHandler);
        recyclerView.setAdapter ( mAdapter );

    }

    @Override
    protected void setListeners() {

    }
}
