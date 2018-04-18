package com.dhh.knowledge.adpter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhh.knowledge.R;

import java.util.List;
import java.util.Map;

/**
 * Created by DHH on 2018/4/18.
 * 页面：RecyclerView列表Adapter
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Map<String,Object>> dataList;
    private Handler mHandler;

    private OnItemClickListener onItemClickListener;

    public MyRecyclerViewAdapter(Context context, List<Map<String, Object>> dataList, Handler mHandler) {
        this.context = context;
        this.dataList = dataList;
        this.mHandler = mHandler;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate ( context, R.layout.item_recyclerview_my,null );
        return new ViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Map<String,Object> map = dataList.get ( position );
        String title = (String) map.get ( "title" );
        int imgId = (int) map.get ( "imgId" );

        holder.itemImg.setImageResource ( imgId );
        holder.itemTv.setText ( title );
    }

    @Override
    public int getItemCount() {
        return dataList.size ();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView itemImg;
        private TextView itemTv;

        public ViewHolder(View convertView) {
            super (convertView);
            itemImg = (ImageView) convertView.findViewById(R.id.item_img);
            itemTv = (TextView) convertView.findViewById(R.id.item_tv);
            convertView.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener !=null){
                        onItemClickListener.onItemClick ( v,getLayoutPosition (),dataList.get ( getLayoutPosition () ) );
                    }
                }
            } );
        }
    }

    public interface OnItemClickListener{
        public void onItemClick(View view,int position,Map<String,Object> data);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}
