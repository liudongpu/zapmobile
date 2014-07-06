/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */
package com.srnpr.zapmobile.doctor;

import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.cordova.AuthenticationToken;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.IceCreamCordovaWebViewClient;
import org.apache.cordova.LOG;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.webkit.ValueCallback;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

/**
 * This class is the main Android activity that represents the Cordova
 * application. It should be extended by the user to load the specific html file
 * that contains the application.
 * 
 * As an example:
 * 
 * <pre>
 * package org.apache.cordova.examples;
 * 
 * import android.os.Bundle;
 * import org.apache.cordova.*;
 * 
 * public class Example extends CordovaActivity {
 * 	&#064;Override
 * 	public void onCreate(Bundle savedInstanceState) {
 * 		super.onCreate(savedInstanceState);
 * 		super.init();
 * 		// Load your application
 * 		super.loadUrl(Config.getStartUrl());
 * 	}
 * }
 * </pre>
 * 
 * Cordova xml configuration: Cordova uses a configuration file at
 * res/xml/config.xml to specify its settings. See "The config.xml File" guide
 * in cordova-docs at http://cordova.apache.org/docs for the documentation for
 * the configuration. The use of the set*Property() methods is deprecated in
 * favor of the config.xml file.
 * 
 */
public class DocCordovaActivity extends Activity implements CordovaInterface {
	CordovaWebView cwv;
	
	private final ExecutorService threadPool =Executors.newCachedThreadPool(); 

	/* Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		cwv = (CordovaWebView) findViewById(R.id.tutorialView);
		
		Config.init(this);
		cwv.loadUrl(Config.getStartUrl());
		//cwv.loadUrl("file:///android_asset/www/index.html");
		//cwv.loadUrl("http://www.baidu.com");
	}
	
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
