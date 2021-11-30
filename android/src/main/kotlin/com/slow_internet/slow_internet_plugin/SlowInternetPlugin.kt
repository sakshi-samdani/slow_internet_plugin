package com.slow_internet.slow_internet_plugin

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding

/** SlowInternetPlugin */
class SlowInternetPlugin : FlutterPlugin, MethodCallHandler, ActivityAware {
    /// The MethodChannel that will the communication between Flutter and native Android
    ///
    /// This local reference serves to register the plugin with the Flutter Engine and unregister it
    /// when the Flutter Engine is detached from the Activity
    private lateinit var channel: MethodChannel
    private lateinit var context: Context
    private lateinit var activity: Activity

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "slow_internet_plugin")
        channel.setMethodCallHandler(this)
        context = flutterPluginBinding.applicationContext
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        if (call.method == "isSlowInternet") {
            val cm: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo: NetworkInfo = cm.getActiveNetworkInfo()!!
            //should check null because in airplane mode it will be null
            //should check null because in airplane mode it will be null
            val nc: NetworkCapabilities = cm.getNetworkCapabilities(cm.getActiveNetwork())!!
            val downSpeed: Int = nc.getLinkDownstreamBandwidthKbps()
            val upSpeed: Int = nc.getLinkUpstreamBandwidthKbps()
            result.success("${downSpeed}, ${upSpeed}")
        } else if (call.method == "getPlatformVersion") {
            result.success("Android ${android.os.Build.VERSION.RELEASE}")
        } else {
            result.notImplemented()
        }
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }

    override fun onDetachedFromActivity() {
        TODO("Not yet implemented")
    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
        TODO("Not yet implemented")
    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        activity = binding.activity;
    }

    override fun onDetachedFromActivityForConfigChanges() {
        TODO("Not yet implemented")
    }
}
