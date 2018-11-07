package com.dhh.knowledge.activity.gson;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dhh.knowledge.R;
import com.dhh.knowledge.activity.gson.entity.JsonToGson;
import com.dhh.knowledge.activity.gson.entity.Person;
import com.dhh.knowledge.activity.gson.entity.Result;
import com.dhh.knowledge.activity.gson.entity.SchoolInfo;
import com.dhh.knowledge.adpter.MyViewPagerAdapter;
import com.dhh.knowledge.base.MBaseActivity;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DHH on 2018/11/7.
 * 页面：
 */
public class GsonActivity extends MBaseActivity {

    private ImageButton imgBtnBack;
    private TextView tvTitle;
    private ImageButton imgBtnConfrom;

    private Handler mHandler;

    private MyViewPagerAdapter mAdapter;
    private List<ImageView> dataList;

    private int prePositon = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_gson );

        initUI ();

        initHandler ();

        init ();

        initData ();

        setListeners ();
    }

    @Override
    protected void initUI() {

        imgBtnBack = (ImageButton) findViewById(R.id.img_btn_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imgBtnConfrom = (ImageButton) findViewById(R.id.img_btn_confrom);

    }

    @Override
    protected void initHandler() {
        mHandler = new Handler (  ){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    default:
                        break;
                }
            }
        };
    }

    @Override
    protected void init() {

        dataList = new ArrayList<> (  );

    }

    @Override
    protected void initData() {
        tvTitle.setText ( "GSON" );
    }

    @Override
    protected void setListeners() {

    }

    //使用Gson生成Json串
    public void gsonToJson(View view) {
        Result result = new Result ();
        result.setResult ( 1 );
        List<Person> personData = new ArrayList<> (  );

        //Person1====================================================
        Person person1 = new Person ();
        person1.setName ( "张三" );
        person1.setAge ( 20 );
        person1.setUrl ( "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1541566994452&di=6d830d2da54036f8e592e647975583cc&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F04821455daae58000001106d11b58e.jpg" );
        List<SchoolInfo> schoolInfos = new ArrayList<> (  );

        SchoolInfo school1 = new SchoolInfo ();
        school1.setSchoolName ( "Cambridge" );

        SchoolInfo school2 = new SchoolInfo ();
        school2.setSchoolName ( "Oxford" );

        schoolInfos.add ( school1 );
        schoolInfos.add ( school2 );

        person1.setSchoolInfo ( schoolInfos );

        //Person2====================================================
        Person person2 = new Person ();
        person2.setName ( "李四" );
        person2.setAge ( 21 );
        person2.setUrl ( "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1541567772499&di=77b69b4f1a47de5dac3a2b6f22fe5228&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%253D580%2Fsign%3Db5de60dc8126cffc692abfba89004a7d%2Fea8dbe315c6034a85c44aec4c81349540823767c.jpg" );
        List<SchoolInfo> schoolInfos2 = new ArrayList<> (  );

        SchoolInfo school3 = new SchoolInfo ();
        school3.setSchoolName ( "清华大学" );

        SchoolInfo school4 = new SchoolInfo ();
        school3.setSchoolName ( "北京大学" );

        schoolInfos2.add ( school3 );
        schoolInfos2.add ( school4 );

        person2.setSchoolInfo ( schoolInfos2 );

        //=========================================
        personData.add ( person1 );
        personData.add ( person2 );

        result.setPersonData ( personData );

        Gson gson = new Gson ();
        String strGson = gson.toJson ( result );
        Toast.makeText ( activity,strGson,Toast.LENGTH_LONG ).show ();

    }


    //使用Gson解析Json串
    public void jsonToGson(View view) {
        try {
            //读取文件获取json字符串
            InputStream inputStream = getAssets ().open ( "gson.txt" );
            BufferedReader reader = new BufferedReader ( new InputStreamReader ( inputStream ) );
            String str = "";
            StringBuffer sbStr = new StringBuffer (  );
            while ((str = reader.readLine ()) != null){
                sbStr.append ( str );
            }

            //解析
            Gson gson = new Gson ();
            JsonToGson jsonToGson = gson.fromJson ( sbStr.toString (), JsonToGson.class);
            int rst = jsonToGson.getRst ();
            String msg = jsonToGson.getMsg ();
            String cookie = jsonToGson.getData ().getCookie ();

            Toast.makeText ( activity,"rst：" + rst + "\n" +
                    "msg：" + msg + "\n" +
                    "cookie：" + cookie,Toast.LENGTH_LONG).show ();

        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public void back(View view) {
        finish ();
    }
}

