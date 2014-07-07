package com.srnpr.app.yinxlapp;

import org.apache.cordova.Config;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import com.srnpr.zaphybird.views.HybirdActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;
import android.content.Intent;

public class MainActivity extends HybirdActivity implements CordovaInterface {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initTabs();
		

		// CordovaWebView cwv = (CordovaWebView) findViewById(R.id.text1);
		Config.init(this);

	}

	private TabHost tabs;
	private LayoutInflater layoutInflater;

	private void initTabs() {
		tabs = null;
		tabs = (TabHost) findViewById(R.id.tabhost);
		tabs.setup();

		int[] fragmentArray = { R.id.aw_webview_1, R.id.aw_webview_2,
				R.id.aw_webview_3, R.id.aw_webview_4,R.id.aw_webview_5 };

		int count = fragmentArray.length;
		layoutInflater = LayoutInflater.from(this);

		for (int i = 0; i < count; i++) {
			// 为每一个Tab按钮设置图标、文字和内容
			TabSpec tabSpec = tabs.newTabSpec(mTextviewArray[i]).setIndicator(
					getTabItemView(i));
			// 将Tab按钮添加进Tab选项卡中
			tabSpec.setContent(fragmentArray[i]);

			tabs.addTab(tabSpec);
			// 设置Tab按钮的背景
			tabs.getTabWidget().getChildAt(i)
					.setBackgroundResource(R.drawable.selector_tab_background);
		}

	}

	private String mTextviewArray[] = { "首页", "消息", "好友", "广场", "更多" };
	// 定义数组来存放按钮图片
	private int mImageViewArray[] = { R.drawable.tab_home_btn,
			R.drawable.tab_message_btn, R.drawable.tab_selfinfo_btn,
			R.drawable.tab_square_btn, R.drawable.tab_more_btn };

	private View getTabItemView(int index) {
		View view = layoutInflater.inflate(R.layout.tab_item_view, null);

		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageViewArray[index]);

		// imageView.setAlpha(0);

		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(mTextviewArray[index]);

		return view;
	}

	@Override
	public void setActivityResultCallback(CordovaPlugin arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void startActivityForResult(CordovaPlugin arg0, Intent arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
