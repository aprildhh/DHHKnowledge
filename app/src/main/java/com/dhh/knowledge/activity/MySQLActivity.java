package com.dhh.knowledge.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.dhh.knowledge.R;
import com.dhh.knowledge.base.MBaseActivity;
import com.dhh.knowledge.common.Util;
import com.dhh.knowledge.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by DHH on 2018/4/4.
 * 页面：android链接MySQL数据库
 */

public class MySQLActivity extends MBaseActivity {

    private TextView tvTitle;
//    private static final String REMOTE_IP = "192.168.1.102";
    private static final String REMOTE_IP = "http://192.168.8.31/";
    private static final String URL = "jdbc:mysql://" + REMOTE_IP + "/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private Connection conn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView( R.layout.activity_mysql);

        initUI();

        init ();

        initData ();

    }

    @Override
    protected void initUI() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initData() {
        tvTitle.setText ( "MySQL" );
    }

    public void onConn(View view) {
        conn = DBUtil.openConnection(URL, USER, PASSWORD);
    }

    public void onInsert(View view) {
        String sql = "insert into mytable (`user_num`, `user_name`) VALUES ('113', ASCII('lilei'))";
        DBUtil.execSQL(conn, sql);
    }

    public void onDelete(View view) {
        String sql = "delete from mytable where name='mark'";
        DBUtil.execSQL(conn, sql);
    }

    public void onUpdate(View view) {
        String sql = "update mytable set name='lilei' where name='hanmeimei'";
        DBUtil.execSQL(conn, sql);
    }

    public void onQuery(View view) {
        System.out.println("All users info:");
        DBUtil.query(conn, "select * from mytable");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                conn = null;
            } finally {
                conn = null;
            }
        }
    }

    public void onText(View view) {
        System.out.println("点击测试");
        Util.showShortToast ( activity,"点击测试" );
    }
}
