package com.dhh.knowledge.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dhh.knowledge.R;
import com.dhh.knowledge.adpter.RecyclerViewAdapter;
import com.dhh.knowledge.base.MBaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DHH on 2018/3/21.
 * 页面：RecyclerView
 */

public class RecyclerViewActivity extends MBaseActivity {

    private TextView tvTitle;
    private RecyclerView rvRecyclerView;

    private RecyclerViewAdapter mAdapter;
    private List<String> datas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_recycler_view );

        initUI();

        init ();

        initData ();
    }

    @Override
    protected void initUI() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        rvRecyclerView = (RecyclerView) findViewById(R.id.rv_recycler_view);

    }

    @Override
    protected void init() {
        datas = new ArrayList<> (  );
        for (int i = 0; i<100;i++){
            datas.add ( "test_data_" + i );
        }
    }

    @Override
    protected void initData() {

        tvTitle.setText ( "RecyclerView" );

        rvRecyclerView.setHasFixedSize ( true );
        mAdapter = new RecyclerViewAdapter (activity,datas);
        rvRecyclerView.setAdapter ( mAdapter );
        //添加分割线
//        rvRecyclerView.addItemDecoration ( new DividerItemDecoration ( this,DividerItemDecoration.VERTICAL ) );
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        divider.setDrawable( ContextCompat.getDrawable(this,R.drawable.custom_divider));
        rvRecyclerView.addItemDecoration(divider);

        rvRecyclerView.setLayoutManager ( new LinearLayoutManager ( activity,LinearLayoutManager.VERTICAL,false ) );
        mAdapter.setOnItemClickListener ( new RecyclerViewAdapter.OnItemClickListener () {
            @Override
            public void onItemClick(View view, int position, String data) {
                Toast.makeText ( activity,data,Toast.LENGTH_SHORT ).show ();
            }
        } );
    }

    public void back(View view) {
        finish ();
    }

    public void add(View view) {
        mAdapter.addData(0,"new item");
        //移动到第0条
        rvRecyclerView.scrollToPosition ( 0 );
    }

    public void delete(View view) {
        mAdapter.removed(0);
    }

    public void list(View view) {
        rvRecyclerView.setLayoutManager ( new LinearLayoutManager ( activity,LinearLayoutManager.VERTICAL,false ) );
    }

    public void grid(View view) {
        rvRecyclerView.setLayoutManager ( new GridLayoutManager ( activity,2,GridLayoutManager.VERTICAL,false ));
    }

    public void flow(View view) {
        rvRecyclerView.setLayoutManager ( new StaggeredGridLayoutManager ( 3,StaggeredGridLayoutManager.VERTICAL ) );
    }
}
