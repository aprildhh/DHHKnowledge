package com.dhh.knowledge.adpter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhh.knowledge.R;

import java.util.List;
import java.util.Map;

/**
 * Created by DHH on 2018/4/20.
 * 页面：
 */

public class MyListAdapter extends BaseAdapter {

    private Context context ;
    private  List<Map<String, Object>> dataList;
    private Handler mHandler;
    private LayoutInflater mInflater;
    private ViewHolder viewHolder;

    public MyListAdapter(Context context, List<Map<String, Object>> dataList, Handler mHandler) {
        this.context = context;
        this.dataList = dataList;
        this.mHandler = mHandler;
        mInflater = LayoutInflater.from ( context );
    }

    @Override
    public int getCount() {
        return dataList.size ();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get ( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = mInflater.inflate ( R.layout.item_list_three,null );
            viewHolder = new ViewHolder ();
            viewHolder.imgFace = (ImageView) convertView.findViewById(R.id.img_face);
            viewHolder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
            viewHolder.imgDelete = (ImageView) convertView.findViewById(R.id.img_delete);
            convertView.setTag ( viewHolder );
        }else {
            viewHolder = (ViewHolder) convertView.getTag ();
        }

        Map<String,Object > map = dataList.get ( position );
        String title = (String) map.get ( "title" );
        viewHolder.tvContent.setText ( title );
        return convertView;
    }

    class ViewHolder{
        ImageView imgFace;
        TextView tvContent;
        ImageView imgDelete;
    }
}
