package com.srnpr.zaphybird.libs.top;

import java.util.concurrent.ConcurrentHashMap;


import com.srnpr.zaphybird.libs.BaseClass;
import com.srnpr.zaphybird.libs.hybirdenumer.CurrentModelEnumer;

public class TopInit extends BaseClass {

	private ConcurrentHashMap<CurrentModelEnumer, String> configUrlMap = new ConcurrentHashMap<CurrentModelEnumer, String>();

	public void inConfigUrl(CurrentModelEnumer cEnumer, String sUrl) {
		configUrlMap.put(cEnumer, sUrl);
	}

	/**
	 * @param currentModelEnumer
	 * @param context
	 */
	public void initConfig(CurrentModelEnumer currentModelEnumer,
			String sVersion) {

		CurrentModelEnumer nowModelEnumer = getModelByVersion(sVersion);

		String sTargetUrl = configUrlMap.get(nowModelEnumer);

		// if(sTargetUrl.e)

	}

	public CurrentModelEnumer getModelByVersion(String sVersion) {

		CurrentModelEnumer nowModel = CurrentModelEnumer.RELEASE;

		if (sVersion.split("\\.")[1].equals("0")) {
			nowModel = CurrentModelEnumer.DEBUG;
		}

		return nowModel;
	}

}
