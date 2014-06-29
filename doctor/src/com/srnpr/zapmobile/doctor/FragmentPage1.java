package com.srnpr.zapmobile.doctor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class FragmentPage1 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// WebView wv=(WebView) container.findViewById(R.id.wv);

		// wv.loadUrl("http://www.baidu.com");

		return inflater.inflate(R.layout.fragment_1, null);
	}

	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		
		super.onActivityCreated(savedInstanceState);
	
			

			
			WebView webview = (WebView) this.getView().findViewById(R.id.wv);
			
			webview.getSettings().setJavaScriptEnabled(true);
			
			webview.loadUrl("http://www.baidu.com/");
			

		

	}

}
