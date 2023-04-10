package com.zhou.updatetools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UpDataUtils.upData(this, "1", "1", "1", "1",
				"1", "1", "1", "https://candy-pro-bucket.s3.ap-southeast-1.amazonaws.com/test/Candy-Test-v1.5.4-154.apk");
	}
}