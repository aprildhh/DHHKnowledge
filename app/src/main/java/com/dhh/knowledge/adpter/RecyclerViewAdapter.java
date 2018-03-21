package com.dhh.knowledge.adpter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhh.knowledge.R;

import java.util.List;

/**
 * Created by DHH on 2018/3/21.
 * 页面：
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<String> datas;

    public RecyclerViewAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate ( context, R.layout.item_recyclerview,null );
        return new ViewHolder ( itemView );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_item_recyler_view.setText ( datas.get ( position ) );
    }

    @Override
    public int getItemCount() {
        return datas.size ();
    }

    /**
     * 在指定位置插入一条新数据
     * @param position
     * @param data
     */
    public void addData(int position, String data) {
        datas.add ( position,data );
        notifyItemInserted ( position );
    }

    public void removed(int position) {
        datas.remove (position  );
        notifyItemRemoved ( position );
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_item_recyler_view;

        public ViewHolder(View itemView) {
            super ( itemView );
            tv_item_recyler_view = itemView.findViewById ( R.id.tv_item_recyler_view );

            itemView.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null){
                        onItemClickListener.onItemClick ( v,getLayoutPosition (),datas.get ( getLayoutPosition () ) );
                    }
                }
            } );
        }
    }

    public interface OnItemClickListener{
        public void onItemClick(View view,int position,String data);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
