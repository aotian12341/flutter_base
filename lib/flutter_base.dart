import 'dart:async';

import 'package:flutter/services.dart';

class FlutterBase {
  static MethodChannel _channel = const MethodChannel('flutter_base')..setMethodCallHandler(_handler);
//  static MethodChannel _channel = const MethodChannel('flutter_base')
//    ..setMethodCallHandler(_handler);

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<dynamic> _handler(MethodCall methodCall) {
    if ("callBack" == methodCall.method) {
      Map obj = methodCall.arguments;
      String a = obj["haha"];
      print("hahaha" + obj["xixi"]);
    }
    return Future.value(true);
  }

  static void showMsg(String msg){
    _channel.invokeMethod("showMsg",{"msg":msg});
  }

}
