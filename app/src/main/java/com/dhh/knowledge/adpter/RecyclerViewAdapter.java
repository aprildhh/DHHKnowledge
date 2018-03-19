package com.dhh.knowledge.adpter;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhh.knowledge.MainActivity;
import com.dhh.knowledge.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by DHH on 2018/3/19.
 * 页面：RecyclerView的适配器
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Map<String,String >> datas;
    private LayoutInflater mInflater;

    public RecyclerViewAdapter(Context context, ArrayList<Map<String,String >> datas) {
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
        String title = datas.get ( position ).get ( "title" );
        String content = datas.get ( position ).get ( "content" );
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
        private ImageView itemImage;
        private TextView itemTvTitle;
        private TextView itemTvContent;

        public ViewHolder(View convertView) {
            super ( convertView );

            itemImage = (ImageView) convertView.findViewById(R.id.item_image);
            itemTvTitle = (TextView) convertView.findViewById(R.id.item_tv_title);
            itemTvContent = (TextView) convertView.findViewById(R.id.item_tv_content);

        }
    }
}
