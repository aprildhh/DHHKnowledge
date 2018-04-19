package com.dhh.knowledge.adpter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by DHH on 2018/4/19.
 * 页面：ViewPagerAdapter
 */

public class MyViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<ImageView> dataList;
    private Handler mHandler;

    public MyViewPagerAdapter(Context context, List<ImageView> dataList, Handler mHandler) {
        this.context = context;
        this.dataList = dataList;
        this.mHandler = mHandler;
    }

    @Override
    public int getCount() {
        return dataList.size ();
    }

    /**
     * 比较view和object是否是同一个页面
     *
     * @param view   页面
     * @param object 这个方法instantiateItem返回的结果
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
//        if (view == object){
//            return true;
//        }else {
//            return false;
//        }
        return view == object;
    }

    /**
     * 相当于getView方法
     *
     * @param container viewpager自身
     * @param position  当前页面所在的位置
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = dataList.get ( position );
        container.addView ( imageView );    //添加到Viewpager中
        return imageView;
    }

    /**
     * 释放资源
     * @param container viewpager
     * @param position  要释放的位置
     * @param object  要释放的页面
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.e ( context.getClass ().getSimpleName (),"destroyItem==" + position+"---,object==" + object);
        container.removeView ( (View) object );
    }

}
