package com.dhh.knowledge.activity;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dhh.knowledge.R;
import com.dhh.knowledge.adpter.MyListAdapter;
import com.dhh.knowledge.adpter.MyRecyclerViewAdapter;
import com.dhh.knowledge.base.MBaseActivity;
import com.dhh.knowledge.util.DensityUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 下拉框
 */
public class XLKActivity extends MBaseActivity {

    private ImageButton imgBtnBack;
    private TextView tvTitle;
    private ImageButton imgBtnConfrom;
    private EditText etXlk;


    private Handler mHandler;

    private MyListAdapter mAdapter;
    private List<Map<String, Object>> dataList;

    private String[] titles = {"01优酷菜单", "02广告效果-ViewPager"};
    private int[] imgs = {R.mipmap.bg_list_1, R.mipmap.bg_list_2};

    private PopupWindow mpopupWindow;
    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_xlk );

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
        etXlk = (EditText) findViewById ( R.id.et_xlk );

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams ( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT );
        mListView = new ListView ( activity );
        mListView.setLayoutParams ( params );
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

        dataList = new ArrayList<> (  );

        for (int i = 0; i < 50; i++) {
            Map<String, Object> map = new HashMap<> ();
            map.put ( "title", "a------" + i );
            map.put ( "imgId", "b------" + i );
            dataList.add ( map );
        }
    }

    @Override
    protected void initData() {
        tvTitle.setText ( "03下拉框" );

        mpopupWindow = new PopupWindow ( activity );


        mAdapter = new MyListAdapter ( activity, dataList, mHandler );
        mListView.setAdapter ( mAdapter );

    }

    @Override
    protected void setListeners() {
        etXlk.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                mpopupWindow.setContentView ( mListView );
                int height = DensityUtil.dip2px (activity, 200 );
                mpopupWindow.setHeight ( height );
                mpopupWindow.setFocusable ( true );
                mpopupWindow.showAsDropDown ( etXlk, 0, 0 );
            }
        } );
    }
}
