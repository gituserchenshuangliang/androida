package com.demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

/**
 * 活动管理器
 * 统一管理活动
 * @author Cherry
 * @date  2019年6月5日
 */
public class ActivityManager {
	private static List<Activity> activities = new ArrayList<Activity>();
	
	/*
	 * 添加活动到管理器
	 */
	public static void addActivity(Activity act){
		activities.add(act);
	}
	
	/*
	 * 从管理器移除活动
	 */
	public static void removeActivity(Activity act){
		activities.remove(act);
	}
	
	/*
	 * 退出所有活动
	 */
	public static void exitAllActivity(){
		for (Activity activity : activities) {
			if(null != activity){
				activity.finish();
			}
		}
	}
}
