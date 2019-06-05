package com.demo;

import com.demo.andrioda.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * 安卓学习
 * 活动A，主活动。
 * @author Cherry
 * @date  2019年6月4日
 */
public class ActOne extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		 * 隐藏标题，在设置视图之前
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		/*
		 * 加载one_layout.xml图层
		 */
		setContentView(R.layout.one_layout);
		Log.d("ActOne", "图层one_layout.xml加载....");
		
		/*
		 * 访问网页
		 */
		Button btn = (Button)findViewById(R.id.A);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Toast.makeText(ActOne.this, "Hi ,Action A!", Toast.LENGTH_SHORT).show();
				Intent ints = new Intent(Intent.ACTION_VIEW,Uri.parse("http://cn.bing.com"));
				//ints.setData(Uri.parse("http://cn.bing.com"));
				startActivity(ints);
			}
		});
		
		/*
		 * 打电话
		 */
		Button btn4 = (Button) findViewById(R.id.G);
		btn4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent ints = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:10086"));
				startActivity(ints);
			}
		});
		
		/*
		 * 传递参数
		 */
		Button btn5 = (Button) findViewById(R.id.H);
		btn5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent ints = new Intent(ActOne.this,ActTwo.class);
				ints.putExtra("key", "活动One传递过来的参数！");
				//startActivity(ints);
				
				/*
				 * ActTow直接调用actionStart，进入活动，同时传入参数。
				 */
				//ActTwo.actionStart(ActOne.this, "参数1", 110);
				
				/*
				 * 获取活动B的返回值的启动方式,通过onActivityResult方法获取返回值。
				 */
				startActivityForResult(ints, 2);
			}
		});
		
		/*
		 * 进入活动B
		 */
		Button btn1 = (Button) findViewById(R.id.E);
		Button btn3 = (Button) findViewById(R.id.F);
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				 * Intent构造活动，显式Intent意图。
				 */
				Intent ints = new Intent(ActOne.this, ActTwo.class);
				startActivity(ints);
			}
		});
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				 * 隐式Intent意图。
				 */
				Intent ints = new Intent("com.demo.ACTION_START");
				startActivity(ints);
			}
		});
		
		/*
		 * 退出按钮
		 */
		Button btn2 = (Button)findViewById(R.id.B);
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				 * 退出程序
				 */
				finish();
			}
		});
	}
	
	/*
	 * 创建菜单
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		/*
		 * 加载菜单图层
		 */
		getMenuInflater().inflate(R.menu.one_menu, menu);
		Log.d("ActOne", "图层one_menu.xml加载....");
		
		return true;
	}
	
	/*
	 * 创建菜单响应事件
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add_item:
			Toast.makeText(ActOne.this, "添加成功！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(ActOne.this, "删除成功！", Toast.LENGTH_SHORT).show();
			break;
		default:
		}
		Log.d("one", "事件处理完毕..........");
		return true;
	}
	
	/*
	 * 获取活动B的返回值
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1:
			if(RESULT_OK == resultCode){
				Log.d("one", "请求代码1！");
			}
			break;
		case 2:
			if(RESULT_OK == resultCode){
				String msg = data.getStringExtra("back");
				Toast.makeText(ActOne.this,msg, Toast.LENGTH_SHORT).show();
				Log.d("one", msg);
			}
			break;
		default:
			break;
		}
	}
}
