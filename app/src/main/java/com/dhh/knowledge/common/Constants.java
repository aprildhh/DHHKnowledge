package com.dhh.knowledge.common;

import com.dhh.knowledge.R;

/**
 * Created by DHH on 2018/3/21.
 * 页面：
 */

public class Constants {
    public static String[] types = {"RecyclerView", "CustomControl", "FAB", "MySQL", "Gson", "HttpURLConnection", "AndroidBasic","OkHttp",  "占位"};

    public static String[] leftTitles = {"RecyclerView", "Android\n自定义控件", "Floating\nAction\nButton", "MySQL", "Gson", "HttpURLConnection", "Android复习", "OkHttp","占位"};

    public static String[] titles = {"Android《RecyclerView》", "Android《自定义控件》", "悬浮按钮（FloatingActionButton）", "MySQL", "Gson",
            "HttpURLConnection", "Android复习", "OkHttp","占位"};

    public static String[] contents = {"RecyclerView 是Android L版本中新添加的一个用来取代ListView的SDK，它的灵活性、插拔性、高度解耦性与可替代性比listview" +
            "更好。本视频详细讲解了RecyclerView的基本使用、设置Listview& Gridview效果、瀑布流效果、分割线、自定义设置item的点击事件以及删除和增加数据等功" +
            "能。","Android自定义控件，是中高级程序员必须熟练掌握的技术之一。\n本套视频涵盖了安卓自定义开发过程中所有的技术问题，课程中讲授的例子全部来源于" +
            "企业。学习本套视频后，你会真正理解自定义控件在UI效果展示上的强大之处，并使你具备安卓自定义控件企业级开发的能力","浮动操作按钮，可以配合ListView" +
            "等滚动控件，实现当ListView 向上滑动的时候按钮就会显示出来，当向下滑动按钮会自动隐藏。请注意这个库的FloatingActionButton是和滚动控件没有耦合的，" +
            " 该库代码封装的比较好，使用起来比较简单。可以自定义动画效果。", "MySQL",
            "使用Gson生成Json串，使用Gson解析json串",
            "HttpURLConnection",
            "Android复习",
            "OkHttp学习",
            "占位"};

    public static int[] colors = {R.color.c_ef9dab, R.color.c_749f42, R.color.c_f79124,
            R.color.c_f2aebb, R.color.c_f2afa9, R.color.c_f4c6a2,
            R.color.c_fffbb1, R.color.c_d9ebb1, R.color.c_b9dcc8,
            R.color.c_99bce2, R.color.c_bbb3d8};


    public final static int GET_SUCCESS = 200;
    public final static int GET_FAIL = 201;
}
