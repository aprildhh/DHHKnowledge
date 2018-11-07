package com.dhh.knowledge.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.dhh.knowledge.R;

/**
 * Created by DHH on 2018/6/1.
 * 页面：自定义弹框
 */

public class CustomDialog extends Dialog {
    private Listener mListener;

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, String content, Listener listener){
        super(context, R.style.custom_dialog_style);
        mListener = listener;
        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_have_been_sign_section_show, null);
        TextView contentTextView = (TextView) contentView.findViewById(R.id.dialog_content_text);
        contentTextView.setText(content);
        TextView sureButton  = (TextView) contentView.findViewById(R.id.tv_sure);

        //消失监听
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mListener.onDialogDismissListener();
            }
        });

        //确认
        sureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                mListener.onSureListerner();
            }
        });
        setContentView(contentView);
    }

    @Override
    public void show() {
        super.show ();
        /**
         * 设置宽度全屏，要设置在show的后面
         */
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.width= ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height= ViewGroup.LayoutParams.WRAP_CONTENT;
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setAttributes(layoutParams);
    }

    public interface Listener {
        void onDialogDismissListener();
        void onSureListerner();
    }
}
