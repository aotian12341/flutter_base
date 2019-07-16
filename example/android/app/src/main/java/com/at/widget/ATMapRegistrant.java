package com.at.widget;

import android.util.Log;

import com.at.flutter_base.FlutterBasePlugin;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.StandardMessageCodec;

public class ATMapRegistrant implements MethodChannel.MethodCallHandler {

    private static final String TAG = ATMapRegistrant.class.getName();

    public static void registerWith(PluginRegistry registry) {
        final String key = ATMapRegistrant.class.getCanonicalName();
        Log.i(TAG,"registerKey="+key);
        if (registry.hasPlugin(key)) {
            return;
        }
        PluginRegistry.Registrar registrar = registry.registrarFor(key);



        final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_base");
        FlutterBasePlugin plugin = new FlutterBasePlugin();
//        plugin.mContext = registrar.context();
//        plugin.registrar = registrar;
        channel.setMethodCallHandler(plugin);
        registrar.platformViewRegistry().registerViewFactory("widget.name", new ATMapFactory(new StandardMessageCodec(),channel));
    }

    @Override
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {

    }
}
