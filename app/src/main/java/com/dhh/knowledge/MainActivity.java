package com.dhh.knowledge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dhh.knowledge.adpter.MainRecyclerViewAdapter;
import com.dhh.knowledge.common.Constants;
import com.dhh.knowledge.jni.JNI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private RecyclerView recyclerView;

    private MainRecyclerViewAdapter adapter;
    private ArrayList<Map<String, Object>> datas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        initdata ();
        init ();

        recyclerView.setHasFixedSize ( true );
        //设置recyclerView的适配器
        adapter = new MainRecyclerViewAdapter ( this, datas );
        recyclerView.setAdapter ( adapter );

        /**
         * LayoutManager
         * new LinearLayoutManager ( 上下文，方向，是否倒序 ) ListView效果
         * new GridLayoutManager (  ) GridView效果
         * new StaggeredGridLayoutManager (  ) 瀑布流效果
         */
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this, LinearLayoutManager.VERTICAL, false ) );
        adapter.setOnItemClickListener ( new MainRecyclerViewAdapter.OnItemClickListener () {
            @Override
            public void onItemClick(View view, int position, Map<String, Object> data) {
                if (position == 0){
                    Intent intent= new Intent (  );
                    intent.setClass ( MainActivity.this,RecyclerViewActivity.class );
                    startActivity ( intent );
                }
            }
        } );
    }

    private void init() {
        datas = new ArrayList<> ();
        for (int i = 0; i < Constants.contents.length; i++) {
            Map<String, Object> map = new HashMap<> ();
            map.put ( "leftTitle", Constants.leftTitles[i] );
            map.put ( "title", Constants.titles[i] );
            map.put ( "content", Constants.contents[i] );
            map.put ( "color", Constants.colors[i] );
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
