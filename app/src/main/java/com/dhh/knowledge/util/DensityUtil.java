package com.dhh.knowledge.util;

import android.content.Context;

/**
 * Created by DHH on 2018/4/20.
 * 页面：像素转换dp
 */

public class DensityUtil {
    /**
     * 根据手机的分辨率从dip的单位 转成为px（像素）
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources ().getDisplayMetrics ().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从px（像素）的单位转成dp
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources ().getDisplayMetrics ().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
