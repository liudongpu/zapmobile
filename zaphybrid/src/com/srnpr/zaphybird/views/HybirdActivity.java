package com.srnpr.zaphybird.views;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public abstract class HybirdActivity extends Activity {
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

	public String getVersion() {

		String sReturn = "";

		try {
			PackageManager manager = this.getPackageManager();
			PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
			sReturn = info.versionName;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return sReturn;
	}

}
