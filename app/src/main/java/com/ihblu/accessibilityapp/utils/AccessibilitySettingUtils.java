package com.ihblu.accessibilityapp.utils;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

/**
 * @Description:
 * @Author: wy1in
 * @Date: 2022/11/8
 */
public class AccessibilitySettingUtils {
    public static void jumpToAccessibilitySetting(Context context) {
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        context.startActivity(intent);
    }
}
