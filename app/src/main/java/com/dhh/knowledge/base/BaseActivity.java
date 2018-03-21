package com.dhh.knowledge.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by DHH on 2018/3/21.
 * 页面：
 */

public abstract class BaseActivity extends Activity{

    protected Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        activity = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
    }

    /**
     * 初始化控件
     */
    protected void initUI() {
    }

    /**
     * 初始化方法
     */
    protected void init() {
    }

    /**
     * 初始化Handler
     */
    protected void initHandler(){
    }

    /**
     * 给控件赋值
     */
    protected void initData() {
    }
}
