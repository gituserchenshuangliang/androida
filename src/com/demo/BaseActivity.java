package com.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends Activity {
	private static final String TAG = "BaseActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		 * 输出当前活动名称
		 */
		Log.d(TAG,getClass().getSimpleName());
		/*
		 * 活动的添加到管理器
		 */
		ActivityManager.addActivity(this);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		/*
		 * 从管理器移除活动
		 */
		ActivityManager.removeActivity(this);
	}
}
