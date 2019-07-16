package com.at.widget;

import android.content.Context;

import java.util.Map;

import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class ATMapFactory extends PlatformViewFactory {

    MethodChannel channel;
    public ATMapFactory(MessageCodec<Object> createArgsCodec, MethodChannel channel) {
        super(createArgsCodec);
        this.channel = channel;
    }

    @Override
    public PlatformView create(Context context, int i, Object o) {

        Map<String,Object> param = (Map<String,Object>)o;
        String text = (String)param.get("text");
        int width = (int) param.get("width");
        int height = (int) param.get("height");

        return new ATMap(context,text,width,height,channel);
    }
}
