import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:flutter_base/flutter_base.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    String platformVersion;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      platformVersion = await FlutterBase.platformVersion;
    } on PlatformException {
      platformVersion = 'Failed to get platform version.';
    }

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _platformVersion = platformVersion;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Column(
          children: <Widget>[
//            GestureDetector(
//              child: Center(
//                child: Text('Running on: $_platformVersion\n'),
//              ),
//              onTap: (){
//                FlutterBase.showMsg("aaaa");
//              },
//            ),
            Container(
              width: 300,
              height: 200,
              color: Colors.red,
              child: AndroidView(
                viewType: 'widget.name',
                creationParams: {'text': 'Flutter传给Android的参数',"width":400,"height":400},
                creationParamsCodec: StandardMessageCodec(),
              ),
            )
          ],
        ),
      ),
    );
  }
}
