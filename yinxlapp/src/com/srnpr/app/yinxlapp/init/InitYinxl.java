package com.srnpr.app.yinxlapp.init;

import com.srnpr.zaphybird.libs.hybirdenumer.*;

public class InitYinxl {

	/*
	 * 定义当前加载的类型
	 */
	private final static CurrentModelEnumer MODEL = CurrentModelEnumer.DEBUG;

	/**
	 * 定义测试版本的配置地址
	 */
	private final static String CONFIG_URL_DEBUG = "http://192.168.0.215:8080/mobile/index";

	/**
	 * 定义正式版本的配置地址
	 */
	private final static String CONFIG_URL_FORMAT = "http://web.yinxl.com/mobile/index";

}
