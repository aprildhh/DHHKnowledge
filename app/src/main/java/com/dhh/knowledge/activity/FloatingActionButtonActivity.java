package com.dhh.knowledge.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import com.dhh.knowledge.R;
import com.dhh.knowledge.adpter.MainRecyclerViewAdapter;
import com.dhh.knowledge.adpter.RecyclerViewAdapter;
import com.dhh.knowledge.common.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DHH on 2018/3/27.
 * 页面：FloatingActionButton页面
 */

public class FloatingActionButtonActivity extends Activity {

    private RecyclerView rvFab;
    private FloatingActionButton fabFab;

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_fab );

        mContext = FloatingActionButtonActivity.this;

        rvFab = (RecyclerView) findViewById ( R.id.rv_fab );
        fabFab = (FloatingActionButton) findViewById ( R.id.fab_fab );

        rvFab.setHasFixedSize ( true );
        rvFab.setItemAnimator ( new DefaultItemAnimator () );

        //设置一个垂直方向的Layout manager
        int orientation = LinearLayoutManager.VERTICAL;
        rvFab.setLayoutManager ( new LinearLayoutManager ( mContext, orientation, false ) );

        List<String> mList = new ArrayList<> ();
        for (int i = 0; i < 20; i++) {
            mList.add ( "item--" + i );
        }

        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter ( mContext,mList );
        rvFab.setAdapter ( mAdapter );

        fabFab.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Snackbar.make ( v,"FAB",Snackbar.LENGTH_SHORT ).setAction ( "action", new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        Util.showShortToast(mContext,"float action bar");
                    }
                } ).show ();
            }
        } );

//        final FloatingActionButton fab = new FloatingActionButton(this);
//        fab.setType(FloatingActionButton.TYPE_NORMAL);
//        fab.setImageResource(icon);
//        fab.setColorPressedResId(R.color.colorPrimary);
//        fab.setColorNormalResId(R.color.fab);
//        fab.setColorRippleResId(R.color.text_color);
//        fab.setShadow(true);
//
//        new SpringFloatingActionMenu.Builder(this)
//                .fab(fab)
//                //添加菜单按钮参数依次是背景颜色,图标,标签,标签的颜色,点击事件
//                .addMenuItem(R.color.c_bbb3d8, R.mipmap.ic_messaging_posttype_photo, "Photo", R.color.text_color,this)
//                .addMenuItem(R.color.c_99bce2, R.mipmap.ic_messaging_posttype_chat, "Chat", R.color.text_color,this)
//                .addMenuItem(R.color.c_b9dcc8, R.mipmap.ic_messaging_posttype_quote, "Quote", R.color.text_color,this)
//                .addMenuItem(R.color.c_d9ebb1, R.mipmap.ic_messaging_posttype_link, "Link", R.color.text_color,this)
//                .addMenuItem(R.color.c_fffbb1, R.mipmap.ic_messaging_posttype_audio, "Audio", R.color.text_color,this)
//                .addMenuItem(R.color.c_f4c6a2, R.mipmap.ic_messaging_posttype_text, "Text", R.color.text_color,this)
//                .addMenuItem(R.color.c_f2afa9, R.mipmap.ic_messaging_posttype_video, "Video", R.color.text_color,this)
//                //设置动画类型
//                .animationType(SpringFloatingActionMenu.ANIMATION_TYPE_TUMBLR)
//                //设置reveal效果的颜色
//                .revealColor(R.color.colorPrimary)
//                //设置FAB的位置,只支持底部居中和右下角的位置
//                .gravity( Gravity.RIGHT | Gravity.BOTTOM)
//                .onMenuActionListner(new OnMenuActionListener() {
//                    @Override
//                    public void onMenuOpen() {
//                        //设置FAB的icon当菜单打开的时候
//                        fab.setImageResource(icon_closed);
//                    }
//
//                    @Override
//                    public void onMenuClose() {
//                        //设置回FAB的图标当菜单关闭的时候
//                        fab.setImageResource(icon_opend);
//                    }
//                })
//                .build();

    }
}
