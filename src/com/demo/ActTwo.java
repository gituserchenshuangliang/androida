package com.demo;

import com.demo.andrioda.R;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
public class ActTwo extends BaseActivity {
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
	
	/*
	 * 活动B调用此方法，传入上一层活动及其参数，启动自己。
	 */
	public static void actionStart(Context context,String paramA,Integer paramB){
		Intent ints = new Intent(context,ActTwo.class);
		ints.putExtra("a", paramA);
		ints.putExtra("b", paramB);
		context.startActivity(ints);
	}
}
