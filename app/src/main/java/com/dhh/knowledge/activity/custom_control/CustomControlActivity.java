package com.dhh.knowledge.activity.custom_control;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dhh.knowledge.R;
import com.dhh.knowledge.adpter.MyRecyclerViewAdapter;
import com.dhh.knowledge.base.MBaseActivity;
import com.dhh.knowledge.common.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DHH on 2018/3/27.
 * 页面：自定义控件页面
 */

public class CustomControlActivity extends MBaseActivity{

    private TextView tv;
    private RecyclerView recyclerView;

    private Handler mHandler;

    private MyRecyclerViewAdapter mAdapter;
    private List<Map<String,Object>> dataList;

    private String[] titles = {"01优酷菜单","02广告效果-ViewPager","03下拉框","04自定义开关","05自定义弹框"};
    private String[] types = {"YK","GGVP","XLK","KG","TK"};
    private int[] imgs = {R.mipmap.bg_list_1,R.mipmap.bg_list_2,R.mipmap.bg_list_3,R.mipmap.bg_list_4,R.mipmap.bg_list_5};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

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

        dataList = new ArrayList<> (  );

        for (int i =0; i< titles.length;i++){
            Map<String,Object> map = new HashMap<> (  );
            map.put ( "title",titles[i] );
            map.put ( "imgId",imgs[i] );
            map.put ( "type",types[i] );
            dataList.add ( map );
        }
    }

    @Override
    protected void initData() {
        tv.setText ( "自定义控件" );

        recyclerView.setHasFixedSize ( true );
        mAdapter = new MyRecyclerViewAdapter (activity,dataList,mHandler);
        recyclerView.setAdapter ( mAdapter );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this, LinearLayoutManager.VERTICAL, false ) );
//        recyclerView.addItemDecoration(new RecycleViewDivider(activity, LinearLayoutManager.VERTICAL, 10, getResources().getColor(R.color.black)));
    }

    @Override
    protected void setListeners() {
        mAdapter.setOnItemClickListener ( new MyRecyclerViewAdapter.OnItemClickListener () {
            @Override
            public void onItemClick(View view, int position, Map<String, Object> data) {
                String type = data.get ( "type" ) + "";
                if ("YK".equals ( type )){
                    Util.showShortToast ( activity,"暂未开发" );
                }else if ("GGVP".equals ( type )){
                    Util.showActivity ( activity,CVViewPagerActivity.class );
                }else if ("XLK".equals ( type )){
                    Util.showActivity ( activity,XLKActivity.class );
                }else if ("KG".equals ( type )){
                    Util.showActivity ( activity,KGActivity.class );
                }else if ("TK".equals ( type )){
                    Util.showActivity ( activity,TKActivity.class );
                }
            }
        } );
    }
}
