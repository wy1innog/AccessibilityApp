package com.ihblu.accessibilityapp.utils;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;


/**
 * @Description:
 * @Author: wy1in
 * @Date: 2022/11/8
 */
public class ClickUtils {
    private static final String TAG = "ClickUtils";

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void click(AccessibilityService accessibilityService, float x, float y) {
        Log.d(TAG, "click: x: " + x + " y: " + y);
        GestureDescription.Builder builder = new GestureDescription.Builder();
        Path path = new Path();
        path.moveTo(x, y);
        path.lineTo(x, y);
        builder.addStroke(new GestureDescription.StrokeDescription(path, 0, 1));
        GestureDescription gesture = builder.build();
        accessibilityService.dispatchGesture(gesture, new AccessibilityService.GestureResultCallback() {
            @Override
            public void onCancelled(GestureDescription gestureDescription) {
                super.onCancelled(gestureDescription);
            }

            @Override
            public void onCompleted(GestureDescription gestureDescription) {
                super.onCompleted(gestureDescription);
            }
        }, null);
    }
}