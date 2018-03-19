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
    private ArrayList<Map<String,String >> datas;
    private String[] contents = {"ListView","占位"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        initdata ();
        init ();

        recyclerView.setHasFixedSize(true);
        //设置recyclerView的适配器
        adapter = new RecyclerViewAdapter (this,datas);
        recyclerView.setAdapter ( adapter );

        /**
         * LayoutManager
         * new LinearLayoutManager ( 上下文，方向，是否倒序 ) ListView效果
         * new GridLayoutManager (  ) GridView效果
         * new StaggeredGridLayoutManager (  ) 瀑布流效果
         */
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this,LinearLayoutManager.VERTICAL,false ) );

    }

    private void init() {
        datas = new ArrayList<> (  );
        for (int i= 0;i<contents.length;i++){
            Map<String,String>map = new HashMap<> (  );
            map.put ( "title",contents[i] );
            map.put ( "content","点击查看"+contents[i]+"的内容" );
            datas.add ( map);
        }
    }

    private void initdata() {
        // Example of a call to a native method
        tv = (TextView) findViewById ( R.id.sample_text );
        tv.setText ( new JNI ().stringFromJNI ());


        recyclerView = (RecyclerView) findViewById(R.id.rv_main);
    }


}
