package com.at.flutter_base;

import android.content.Context;
import android.widget.Toast;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterBasePlugin */
public class FlutterBasePlugin implements MethodCallHandler {

  Context mContext;
  Registrar registrar;

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_base");
    FlutterBasePlugin plugin = new FlutterBasePlugin();
    plugin.mContext = registrar.context();
    plugin.registrar = registrar;
    channel.setMethodCallHandler(plugin);
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    }else if(call.method.equals("showMsg")){
      showMsg((String) call.argument("msg"));
    }
    else {
      result.notImplemented();
    }
  }

  public void showMsg(String msg){
    Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
  }

  public void show(){

  }
}
