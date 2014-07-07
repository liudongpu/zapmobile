package com.srnpr.zaphybird.views;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Activity;
import android.content.Context;

public abstract class HybirdActivity extends Activity  {
	private final ExecutorService threadPool = Executors.newCachedThreadPool();
	public Context getContext() {
		return this;
	}
	
	public Activity getActivity() {
		// TODO Auto-generated method stub
		return this;
	}
	
	
	public Object onMessage(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ExecutorService getThreadPool() {
		// TODO Auto-generated method stub
		return threadPool;
	}
	
}
