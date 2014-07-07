package com.srnpr.zapmobile.doctor;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class FragmentPage2 extends Fragment{

	
	 private View rootView;//缓存Fragment view  
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	

		 if(rootView==null){  
	            rootView=inflater.inflate(R.layout.fragment_2, null);  
	            
	            
	            //HybirdWebView webview = (HybirdWebView) rootView.findViewById(R.id.hwv_2);
	    		
	    		
	    		
	    		//webview.loadUrl("http://www.baidu.com/");
	            
	            
	        }  
	 //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。  
	        ViewGroup parent = (ViewGroup) rootView.getParent();  
	        if (parent != null) {  
	            parent.removeView(rootView);  
	        }   
	        return rootView;  
	}	
}