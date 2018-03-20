package com.dhh.knowledge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import com.dhh.knowledge.adpter.RecyclerViewAdapter;
import com.dhh.knowledge.jni.JNI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private RecyclerView recyclerView;

    private RecyclerViewAdapter adapter;
    private ArrayList<Map<String, Object>> datas;
    private String[] leftTitles = {"Android\n自定义控件", "占位"};
    private String[] titles = {"Android《自定义控件》", "占位"};
    private String[] contents = {"Android自定义控件，是中高级程序员必须熟练掌握的技术之一。\n本套视频涵盖了安卓自定义开发过程中所有的技术问题，课程中讲授的例子全部来源于企业。学习本套视频后，你会真正理解自定义控件在UI效果展示上的强大之处，并使你具备安卓自定义控件企业级开发的能力", "占位"};
    private int[] colors = {R.color.c_ef9dab, R.color.c_749f42, R.color.c_f79124};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        initdata ();
        init ();

        recyclerView.setHasFixedSize ( true );
        //设置recyclerView的适配器
        adapter = new RecyclerViewAdapter ( this, datas );
        recyclerView.setAdapter ( adapter );

        /**
         * LayoutManager
         * new LinearLayoutManager ( 上下文，方向，是否倒序 ) ListView效果
         * new GridLayoutManager (  ) GridView效果
         * new StaggeredGridLayoutManager (  ) 瀑布流效果
         */
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this, LinearLayoutManager.VERTICAL, false ) );

    }

    private void init() {
        datas = new ArrayList<> ();
        for (int i = 0; i < contents.length; i++) {
            Map<String, Object> map = new HashMap<> ();
            map.put ( "leftTitle", leftTitles[i] );
            map.put ( "title", titles[i] );
            map.put ( "content", contents[i] );
            map.put ( "color", colors[i] );
            datas.add ( map );
        }
    }

    private void initdata() {
        // Example of a call to a native method
        tv = (TextView) findViewById ( R.id.sample_text );
        tv.setText ( new JNI ().stringFromJNI () );


        recyclerView = (RecyclerView) findViewById ( R.id.rv_main );
    }


}
