package com.dhh.knowledge.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by DHH on 2018/4/24.
 * 页面：自定义开关
 *
 * 一个视图从创建到显示过程中的主要方法
 * 1、构造方法实例化 MyToggleButton(Context context, @Nullable AttributeSet attrs)
 * 2、测量-measure（int,int）--> onMeasure();
 *    如果当前view是一个ViewGroup，还有义务测量孩子
 *    孩子有建议权
 * 3、指定位置-layout()-->onLayout();
 *    指定控件的位置，一般view不用写这个方法，ViewGroup的时候才需要，一般View不需要重写该方法
 * 4、绘制视图--draw()-->onDraw(canvas);
 *
 *  根据上面两个方法参数，进入绘制
 */

public class MyToggleButton extends View {

    /**
     * 如果我们在布局文件使用该类，将会调用这个构造方法实例该类，如果没有就崩溃
     * @param context
     * @param attrs
     */
    public MyToggleButton(Context context, @Nullable AttributeSet attrs) {
        super ( context, attrs );
    }
}
