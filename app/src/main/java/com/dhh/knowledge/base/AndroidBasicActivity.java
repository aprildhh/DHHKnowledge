package com.dhh.knowledge.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dhh.knowledge.R;
import com.dhh.knowledge.common.Util;

/**
 * Created by DHH on 2018/12/19.
 * 页面：Android复习页面
 */
public class AndroidBasicActivity extends MBaseActivity {

    private ImageButton imgBtnBack;
    private TextView tvTitle;
    private ImageButton imgBtnConfrom;

    private Handler mHandler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_basic );

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


    }

    @Override
    protected void initData() {
        tvTitle.setText ( "Android复习" );
    }

    @Override
    protected void setListeners() {

    }

    public void back(View view) {
        finish ();
    }

    //注释
    public void getAndroidBasicNotes(View view) {
        Util.showDialog(activity,"");
    }
}
