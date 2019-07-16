package com.at.flutter_base_example;

import android.os.Bundle;

import com.at.widget.ATMapRegistrant;

import io.flutter.app.FlutterActivity;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    GeneratedPluginRegistrant.registerWith(this);

    ATMapRegistrant.registerWith(this);
  }
}
