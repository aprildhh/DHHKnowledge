package com.dhh.knowledge.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhh.knowledge.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by DHH on 2018/3/19.
 * 页面：RecyclerView的适配器
 */

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Map<String,Object >> datas;
    private LayoutInflater mInflater;

    public MainRecyclerViewAdapter(Context context, ArrayList<Map<String,Object >> datas) {
        this.context = context;
        this.datas = datas;
    }

    /**
     * 相当于ListView中的getView（）方法中创建View和ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = View.inflate (context, R.layout.item_main_recyclerview,null );
        return new ViewHolder ( itemView );
    }

    /**
     * 相当于ListView中的getView（）方法中绑定数据部门的代码
     * 数据和View绑定
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //根据位置得到对应的数据
        String leftTitle = (String) datas.get ( position ).get ( "leftTitle" );
        String title = (String) datas.get ( position ).get ( "title" );
        String content = (String) datas.get ( position ).get ( "content" );
        int color = (int) datas.get ( position ).get ( "color" );
        holder.itemLeftTitle.setBackground ( context.getResources ().getDrawable ( color ) );
        holder.itemLeftTitle.setText ( leftTitle );
        holder.itemTvTitle.setText ( title );
        holder.itemTvContent.setText ( content );
    }

    /**
     * 得到总条数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return datas.size ();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView itemLeftTitle;
        private TextView itemTvTitle;
        private TextView itemTvContent;

        public ViewHolder(View convertView) {
            super ( convertView );
            itemLeftTitle = (TextView) convertView.findViewById(R.id.item_left_title);
            itemTvTitle = (TextView) convertView.findViewById(R.id.item_tv_title);
            itemTvContent = (TextView) convertView.findViewById(R.id.item_tv_content);

            convertView.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null){
                        onItemClickListener.onItemClick ( v,getLayoutPosition (),datas.get ( getLayoutPosition () ) );
                    }
//                    int position = getLayoutPosition ();
//                    if (position == 0){
//                        context.startActivity ( new Intent (  ) );
//                    }
                }
            } );
        }
    }

    /**
     * 点击RecyclerView某条的监听
     */
    public interface OnItemClickListener{

        /**
         * 当RecyclerView某条被点击的时候回调
         * @param view 点击item的视图
         * @param position 点击item的position
         * @param data 点击得到的数据
         */
        public void onItemClick(View view, int position, Map<String, Object> data);
    }

    private OnItemClickListener onItemClickListener;

    /**
     * 设置RecyclerView某条的监听事件
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
