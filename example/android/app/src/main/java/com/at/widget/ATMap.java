package com.at.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.at.flutter_base_example.R;

import java.util.HashMap;
import java.util.Map;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;

public class ATMap implements PlatformView {

    private TextView tv;

    private View view;

    MethodChannel channel;

    public ATMap(Context context, String msg, int width, int height, MethodChannel channel){
//        tv = new TextView(context);
//        tv.setText(msg);
//        tv.setLayoutParams(new ViewGroup.LayoutParams(dp2px(context,width), dp2px(context,height)));
//        tv.setGravity(Gravity.CENTER);
//        tv.setBackgroundResource(R.color.green);

        this.channel = channel;

        view = LayoutInflater.from(context).inflate(R.layout.view_atmap,null);

        TextView tv = view.findViewById(R.id.atmap_txt);
        tv.setText(msg);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> map  =new HashMap<>();
                map.put("xixi","xixi");
                map.put("haha","haha");
                channel.invokeMethod("callBack",map);
            }
        });

    }

    public int dp2px(Context context, double dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void dispose() {

    }
}
