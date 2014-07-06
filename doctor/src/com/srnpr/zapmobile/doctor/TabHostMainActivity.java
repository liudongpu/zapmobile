package com.srnpr.zapmobile.doctor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.cordova.Config;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class TabHostMainActivity extends Activity implements CordovaInterface {

	CordovaWebView cwv;

	private final ExecutorService threadPool = Executors.newCachedThreadPool();

	private TabHost tabs;
	private ImageButton footer_tab_btn1;
	private ImageButton footer_tab_btn2;
	private ImageButton footer_tab_btn3;
	private ImageButton footer_tab_btn4;
	private ImageButton footer_tab_btn5;
	private ImageButton footer_tab_btn6;
	private ImageButton footer_tab_btn7;
	
	
	
	


	/* Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_host_main);

		/*
		 * cwv = (CordovaWebView) findViewById(R.id.tutorialView);
		 * 
		 * Config.init(this); cwv.loadUrl(Config.getStartUrl());
		 */

		// cwv.loadUrl("file:///android_asset/www/index.html");
		// cwv.loadUrl("http://www.baidu.com");

		tabs = null;
		tabs = (TabHost) findViewById(R.id.tabhost);
		tabs.setup();
		//tabs.setOnTabChangedListener(TabChangeListener);
		
		
		
		// 定义数组来存放Fragment界面
				int[] fragmentArray = { R.id.text1,R.id.text2,R.id.text3,R.id.text4 };

		// 得到fragment的个数
		int count = fragmentArray.length;
		layoutInflater = LayoutInflater.from(this);
		
		
		
		for (int i = 0; i < count; i++) {
			// 为每一个Tab按钮设置图标、文字和内容
			TabSpec tabSpec = tabs.newTabSpec(mTextviewArray[i])
					.setIndicator(getTabItemView(i));
			// 将Tab按钮添加进Tab选项卡中
			tabSpec.setContent(fragmentArray[i]);
			
			tabs.addTab(tabSpec);
			// 设置Tab按钮的背景
			tabs.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
		}
		
		
		
		/*
		
		// 设置Tab1
		footer_tab_btn1 = new ImageButton(this);
		footer_tab_btn1.setBackgroundResource(R.drawable.home_btn_bg);
		TabSpec tab1 = tabs.newTabSpec("home");
		tab1.setIndicator(footer_tab_btn1); // 设置tab1的名称
		tab1.setContent(R.id.text1); // 关联控件
		tabs.addTab(tab1); // 添加tab1

		// 设置Tab2
		footer_tab_btn2 = new ImageButton(this);
		footer_tab_btn2.setBackgroundResource(R.drawable.home_btn_bg);
		TabSpec tab2 = tabs.newTabSpec("book");
		tab2.setIndicator(footer_tab_btn2);
		tab2.setContent(R.id.text2);
		tabs.addTab(tab2);

		// 设置Tab3
		footer_tab_btn3 = new ImageButton(this);
		footer_tab_btn3.setBackgroundResource(R.drawable.home_btn_bg);
		TabSpec tab3 = tabs.newTabSpec("video");
		tab3.setIndicator(footer_tab_btn3);
		tab3.setContent(R.id.text3);
		tabs.addTab(tab3);

		// 设置Tab4
		footer_tab_btn4 = new ImageButton(this);
		footer_tab_btn4.setBackgroundResource(R.drawable.home_btn_bg);
		TabSpec tab4 = tabs.newTabSpec("magazine");
		tab4.setIndicator(footer_tab_btn4);
		tab4.setContent(R.id.text4);
		tabs.addTab(tab4);
		*/
		
		
		/*
		// 设置Tab5
		footer_tab_btn5 = new ImageButton(this);
		footer_tab_btn5.setBackgroundResource(R.drawable.home_btn_bg);
		TabSpec tab5 = tabs.newTabSpec("paper");
		tab5.setIndicator(footer_tab_btn5);
		tab5.setContent(R.id.text5);
		tabs.addTab(tab5);

		// 设置Tab6
		footer_tab_btn6 = new ImageButton(this);
		footer_tab_btn6.setBackgroundResource(R.drawable.home_btn_bg);
		TabSpec tab6 = tabs.newTabSpec("thesis");
		tab6.setIndicator(footer_tab_btn6);
		tab6.setContent(R.id.text6);
		tabs.addTab(tab6);

		// 设置Tab7
		footer_tab_btn7 = new ImageButton(this);
		footer_tab_btn7.setBackgroundResource(R.drawable.home_btn_bg);
		TabSpec tab7 = tabs.newTabSpec("library");
		tab7.setIndicator(footer_tab_btn7);
		tab7.setContent(R.id.text7);
		tabs.addTab(tab7);
		*/
		
		
		cwv = (CordovaWebView) findViewById(R.id.text1);
		Config.init(this);
		cwv.loadUrl("http://www.baidu.com");
		
		CordovaWebView cvwv2=(CordovaWebView) findViewById(R.id.text2);
		cvwv2.loadUrl("http://www.yinxl.com/mobile/index");
		
		
		
	}
	// 定义一个布局
		private LayoutInflater layoutInflater;
		
		// 定义数组来存放按钮图片
		private int mImageViewArray[] = { R.drawable.tab_home_btn,
				R.drawable.tab_message_btn, R.drawable.tab_selfinfo_btn,
				R.drawable.tab_square_btn, R.drawable.tab_more_btn };

		// Tab选项卡的文字
		private String mTextviewArray[] = { "首页", "消息", "好友", "广场", "更多" };
	
	/**
	 * 给Tab按钮设置图标和文字
	 */
	private View getTabItemView(int index) {
		View view = layoutInflater.inflate(R.layout.tab_item_view, null);

		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageViewArray[index]);

		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(mTextviewArray[index]);

		return view;
	}
	
	

	private OnTabChangeListener TabChangeListener = new OnTabChangeListener() {

		@Override
		public void onTabChanged(String tabId) {
			int j = tabs.getTabWidget().getTabCount();
			ImageButton currentView = (ImageButton) tabs.getCurrentTabView();
			for (int i = 0; i < j; i++) {
				if (tabs.getCurrentTab() == i) {
					currentView.setEnabled(false);
				} else {
					if (tabs.getTabWidget().getChildTabViewAt(i) != null) {
						((ImageButton) tabs.getTabWidget().getChildTabViewAt(i))
								.setEnabled(true);
					}
				}
			}
		}
	};

	public Context getContext() {
		return this;
	}

	@Override
	public Activity getActivity() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ExecutorService getThreadPool() {
		// TODO Auto-generated method stub
		return threadPool;
	}

	@Override
	public Object onMessage(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
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
