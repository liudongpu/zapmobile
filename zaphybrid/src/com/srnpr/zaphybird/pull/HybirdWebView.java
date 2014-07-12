/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.srnpr.zaphybird.pull;

import java.util.concurrent.atomic.AtomicBoolean;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshWebView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

/**
 * An advanced version of {@link PullToRefreshWebView} which delegates the
 * triggering of the PullToRefresh gesture to the Javascript running within the
 * WebView. This means that you should only use this class if:
 * <p/>
 * <ul>
 * <li>{@link PullToRefreshWebView} doesn't work correctly because you're using
 * <code>overflow:scroll</code> or something else which means
 * {@link WebView#getScrollY()} doesn't return correct values.</li>
 * <li>You control the web content being displayed, as you need to write some
 * Javascript callbacks.</li>
 * </ul>
 * <p/>
 * <p/>
 * The way this call works is that when a PullToRefresh gesture is in action,
 * the following Javascript methods will be called:
 * <code>isReadyForPullDown()</code> and <code>isReadyForPullUp()</code>, it is
 * your job to calculate whether the view is in a state where a PullToRefresh
 * can happen, and return the result via the callback mechanism. An example can
 * be seen below:
 * <p/>
 * 
 * <pre>
 * function isReadyForPullDown() {
 *   var result = ...  // Probably using the .scrollTop DOM attribute
 *   ptr.isReadyForPullDownResponse(result);
 * }
 * 
 * function isReadyForPullUp() {
 *   var result = ...  // Probably using the .scrollBottom DOM attribute
 *   ptr.isReadyForPullUpResponse(result);
 * }
 * </pre>
 * 
 * @author Chris Banes
 */
public class HybirdWebView extends PullToRefreshWebView {
	private static final OnRefreshListener2<WebView> defaultOnRefreshListener = new OnRefreshListener2<WebView>() {

		@Override
		public void onPullDownToRefresh(PullToRefreshBase<WebView> refreshView) {
			refreshView.getRefreshableView().reload();
			
			//refreshView.getRefreshableView().loadUrl("javascript:alert('up');");
			//refreshView.onRefreshComplete();
			
		}

		@Override
		public void onPullUpToRefresh(PullToRefreshBase<WebView> refreshView) {
			//refreshView.getRefreshableView().reload();
			refreshView.getRefreshableView().loadUrl("javascript:alert('down');");
			refreshView.onRefreshComplete();
		}

		
	};
	
	public HybirdWebView(Context context) {
		super(context);
		setOnRefreshListener(defaultOnRefreshListener);
	}

	public HybirdWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOnRefreshListener(defaultOnRefreshListener);
	}

	public HybirdWebView(Context context, Mode mode) {
		super(context, mode);
		setOnRefreshListener(defaultOnRefreshListener);
	}

}
