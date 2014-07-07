package com.srnpr.app.yinxlapp;

import org.apache.cordova.Config;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import com.srnpr.zaphybird.views.HybirdActivity;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends HybirdActivity  implements CordovaInterface{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//CordovaWebView cwv = (CordovaWebView) findViewById(R.id.text1);
		Config.init(this);
		
		
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
