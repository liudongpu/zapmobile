package com.srnpr.zaphybird.libs.init;

public class HybirdUp {

	private static final InitInfo initInfo = new InitInfo();

	public static String upInfo(long lInfoCode, Object... oParams) {
		return initInfo.upInfo(lInfoCode, oParams);
	}

}
