package com.ihblu.accessibilityapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ihblu.accessibilityapp.databinding.ActivityMainBinding;
import com.ihblu.accessibilityapp.utils.AccessibilitySettingUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnJumpToSettings.setOnClickListener(
                view -> {
                    AccessibilitySettingUtils.jumpToAccessibilitySetting(this);
                }
        );

        binding.btnTest.setOnClickListener(
                view -> {
                    Toast.makeText(this, "I'm clicked", Toast.LENGTH_SHORT).show();
                }
        );
    }
}