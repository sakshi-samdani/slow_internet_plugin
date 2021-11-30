
import 'dart:async';

import 'package:flutter/services.dart';

class SlowInternetPlugin {
  static const MethodChannel _channel = MethodChannel('slow_internet_plugin');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<String?> get isSlowInternet async {
    final String? version = await _channel.invokeMethod('isSlowInternet');
    return version;
  }
}
