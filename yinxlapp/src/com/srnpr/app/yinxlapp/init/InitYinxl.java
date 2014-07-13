package com.srnpr.app.yinxlapp.init;

import android.content.Context;

import com.srnpr.zaphybird.libs.hybirdenumer.*;
import com.srnpr.zaphybird.libs.top.TopInit;

public class InitYinxl extends TopInit {

	/*
	 * 定义当前加载的版本类型
	 */
	private final static CurrentModelEnumer MODEL = CurrentModelEnumer.DEBUG;

	private final static String DECIVAL = "android";

	public InitYinxl(String sVersion) {
		// 设置测试版本地址
		inConfigUrl(CurrentModelEnumer.DEBUG,
				"http://192.168.0.215:8080/mobile/index");
		// 设置正式版本地址
		inConfigUrl(CurrentModelEnumer.RELEASE,
				"http://web.yinxl.com/mobile/index");

		initConfig(MODEL, sVersion);

	}

}
