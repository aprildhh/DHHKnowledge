package com.dhh.knowledge.activity.custom_control;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dhh.knowledge.R;
import com.dhh.knowledge.adpter.MyRecyclerViewAdapter;
import com.dhh.knowledge.adpter.MyViewPagerAdapter;
import com.dhh.knowledge.base.MBaseActivity;
import com.dhh.knowledge.util.DensityUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CVViewPagerActivity extends MBaseActivity {

    private ImageButton imgBtnBack;
    private TextView tvTitle;
    private ImageButton imgBtnConfrom;
    private ViewPager vpCvViewPager;
    private LinearLayout llCvLineaLayout;
    private TextView tvCvTitle;
    private LinearLayout llPointGroup;

    private Handler mHandler;

    private MyViewPagerAdapter mAdapter;
    private List<ImageView> dataList;

    private String[] titles = {"VP第一页","滴耳液","第三夜","迪斯(＾－＾)V"};
    private int[] imgs = {R.mipmap.bg_list_1,R.mipmap.bg_list_2,R.mipmap.bg_list_3,R.mipmap.bg_list_4};

    private int prePositon = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_cv_view_pager );

        initUI ();

        initHandler ();

        init ();

        initData ();

        setListeners ();
    }

    @Override
    protected void initUI() {

        imgBtnBack = (ImageButton) findViewById(R.id.img_btn_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imgBtnConfrom = (ImageButton) findViewById(R.id.img_btn_confrom);
        vpCvViewPager = (ViewPager) findViewById(R.id.vp_cv_view_pager);
        llCvLineaLayout = (LinearLayout) findViewById(R.id.ll_cv_linea_layout);
        tvCvTitle = (TextView) findViewById(R.id.tv_cv_title);
        llPointGroup = (LinearLayout) findViewById(R.id.ll_point_group);

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

        for (int i =0; i< imgs.length;i++){
            ImageView imageView = new ImageView ( activity );
            imageView.setBackgroundResource ( imgs[i] );

            dataList.add ( imageView );

            //添加点
            ImageView point = new ImageView ( activity );
            point.setBackgroundResource ( R.drawable.point_select );
            int wh = DensityUtil.dip2px ( activity,8 );
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams ( wh,wh);

            if (i==0){
                point.setEnabled ( true );
            }else {
                point.setEnabled ( false );
                params.leftMargin = 8;
            }

            point.setLayoutParams ( params );

            llPointGroup.addView ( point );

        }
    }

    @Override
    protected void initData() {
        tvTitle.setText ( "02广告条效果--ViewPager" );
        tvCvTitle.setText ( titles[0] );

        mAdapter = new MyViewPagerAdapter (activity,dataList,mHandler);
        vpCvViewPager.setAdapter ( mAdapter );
    }

    @Override
    protected void setListeners() {
        vpCvViewPager.addOnPageChangeListener ( new MyOnPageChangeListener () );
    }

    public void getAndroidBasicNotes(View view) {
    }


    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /**
         * 当页面滚动的时候回调这个方法
         * @param position 当前页面的位置
         * @param positionOffset 滑动页面的百分比
         * @param positionOffsetPixels 在屏幕上滑动的像素
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        /**
         * 当某个页面被选中的时候回调
         * @param position 被选中页面的位置
         */
        @Override
        public void onPageSelected(int position) {
            //设置对应的文本信息
            tvCvTitle.setText ( titles[position] );
            //把上一个高亮位置设置为-灰色
            llPointGroup.getChildAt ( prePositon ).setEnabled ( false );
            //把当前位置设置为-红色
            llPointGroup.getChildAt ( position ).setEnabled ( true );

            prePositon = position;
        }

        /**
         * 当页面滚动状态变化的时候回调这个方法
         * 静止-》滑动
         * 滑动-》静止
         * 静止-》拖拽
         * @param state
         */
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    public void back(View view) {
        finish ();
    }
}
