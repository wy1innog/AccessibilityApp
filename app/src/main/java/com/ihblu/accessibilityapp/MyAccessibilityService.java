package com.ihblu.accessibilityapp;

import android.accessibilityservice.AccessibilityService;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import com.ihblu.accessibilityapp.utils.ClickUtils;

import java.util.concurrent.BlockingDeque;

/**
 * @BelongsProject: AccessibilityApp
 * @BelongsPackage: com.ihblu.accessibilityapp
 * @Author: wyl
 * @CreateTime: 2022-11-08  10:09
 * @Description: TODO
 * @Version: 1.0
 */
public class MyAccessibilityService extends AccessibilityService {
    private static final String TAG = "MyAccessibilityService";
    private MediaProjectionManager mediaProjectionManager =
            (MediaProjectionManager) getSystemService(MEDIA_PROJECTION_SERVICE);

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.d(TAG, "onServiceConnected: ");
        new Thread(()-> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Click test button
            ClickUtils.click(this, 370, 460);
        }).start();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        // 界面发生改变时此方法会被调用
        Log.d(TAG, "onAccessibilityEvent: " + event.toString());
    }

    @Override
    public void onInterrupt() {

    }
}