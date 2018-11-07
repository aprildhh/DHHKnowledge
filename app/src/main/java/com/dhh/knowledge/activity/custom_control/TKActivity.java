package com.dhh.knowledge.activity.custom_control;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dhh.knowledge.R;
import com.dhh.knowledge.adpter.MyRecyclerViewAdapter;
import com.dhh.knowledge.base.CustomDialog;
import com.dhh.knowledge.base.MBaseActivity;
import com.dhh.knowledge.common.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DHH on 2018/6/1.
 * 页面：自定义弹框页面
 */

public class TKActivity extends MBaseActivity {

    private TextView tv;
    private RecyclerView recyclerView;

    private Handler mHandler;

    private MyRecyclerViewAdapter mAdapter;
    private List<Map<String, Object>> dataList;

    private String[] titles = {"01优酷菜单", "02广告效果-ViewPager"};
    private int[] imgs = {R.mipmap.bg_list_1, R.mipmap.bg_list_2};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        CustomDialog customDialog = new CustomDialog(activity);
//        customDialog.setTitle("提示");
//        customDialog.setMessage("是否保存退出？");
//        customDialog.setButtonThree("是", new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (Util.isFastDoubleClick()) {
//                    return;
//                }
//                customDialog.dismiss();
//                save();
//            }
//        });
//        customDialog.setButtonTwo("否", new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (Util.isFastDoubleClick()) {
//                    return;
//                }
//                finish();
//            }
//        });
//        customDialog.setButtonOne("取消", null);
        customDialog.setTitle ( "提示" );
//        customDialog.setOnDismissListener ( "取消" ,new View.OnClickListener (););
        customDialog.show();

//        initUI ();
//
//        initHandler ();
//
//        init ();
//
//        initData ();
//
//        setListeners ();
    }

    @Override
    protected void initUI() {

        tv = (TextView) findViewById ( R.id.sample_text );
        recyclerView = (RecyclerView) findViewById ( R.id.rv_main );


    }

    @Override
    protected void initHandler() {
        mHandler = new Handler () {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    default:
                        break;
                }
            }
        };
    }

    @Override
    protected void init() {
        for (int i = 0; i < titles.length; i++) {
            Map<String, Object> map = new HashMap<> ();
            map.put ( "title", titles[i] );
            map.put ( "imgId", imgs[i] );
            dataList.add ( map );
        }
    }

    @Override
    protected void initData() {
        tv.setText ( "" );

        recyclerView.setHasFixedSize ( true );
        mAdapter = new MyRecyclerViewAdapter ( activity, dataList, mHandler );
        recyclerView.setAdapter ( mAdapter );

    }

    @Override
    protected void setListeners() {

    }
}
