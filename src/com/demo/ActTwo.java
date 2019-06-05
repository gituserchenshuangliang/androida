package com.demo;

import com.demo.andrioda.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
/**
 * 活动B
 * @author Cherry
 * @date  2019年6月4日
 */
public class ActTwo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.two_layout);
		
		Button btn = (Button)findViewById(R.id.C);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Toast.makeText(ActTwo.this, "Hi ,Action B!", Toast.LENGTH_SHORT).show();
				Intent ints = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com"));
				startActivity(ints);
			}
		});
		
		Button btn2 = (Button)findViewById(R.id.D);
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				 * 退出，返回数据给活动A
				 */
				Intent ints = new Intent();
				ints.putExtra("back", "活动结束返回的数据");
				setResult(RESULT_OK, ints);
				finish();
			}
		});
		
		Button btn3 = (Button)findViewById(R.id.J);
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent ints = getIntent();
				Toast.makeText(ActTwo.this, ints.getStringExtra("key"), Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		/*
		 * 没有返回按钮，返回数据给活动A
		 */
		Intent ints = new Intent();
		ints.putExtra("back", "活动结束返回的数据");
		setResult(RESULT_OK, ints);
	}
	
	@Override
	public boolean onCreatePanelMenu(int featureId, Menu menu) {
		return true;
	}
}
