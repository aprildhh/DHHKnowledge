package com.dhh.knowledge.common;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by DHH on 2018/3/27.
 * 页面：工具类
 */

public class Util {
    public static void showActivity(Context context, Class<?> cls) {
        context.startActivity ( new Intent ( context,cls ) );
    }

    public static void showShortToast(Context mContext, String s) {
        Toast.makeText ( mContext,s,Toast.LENGTH_SHORT ).show ();
    }
}
