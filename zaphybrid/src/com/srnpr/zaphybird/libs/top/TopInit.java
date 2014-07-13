package com.srnpr.zaphybird.libs.top;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;


import com.srnpr.zaphybird.libs.BaseClass;
import com.srnpr.zaphybird.libs.hybirdenumer.CurrentModelEnumer;
import com.srnpr.zaphybird.libs.model.MDataMap;
import com.srnpr.zaphybird.libs.model.ResultHttp;
import com.srnpr.zaphybird.libs.support.HttpSupport;

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
		
		//判断如果加载的是空  则自动加载
		if(StringUtils.isEmpty(sTargetUrl))
		{
			sTargetUrl=configUrlMap.get(CurrentModelEnumer.RELEASE);
		}
		
		
		
		HttpSupport httpSupport=new HttpSupport();
		
		
		ResultHttp resultHttp= httpSupport.httpGet(sTargetUrl);
		
		
		
		
		
		
		
		
		

		// if(sTargetUrl.e)

	}

	public CurrentModelEnumer getModelByVersion(String sVersion) {

		CurrentModelEnumer nowModel = CurrentModelEnumer.RELEASE;

		/*
		if (sVersion.split("\\.")[1].equals("0")) {
			nowModel = CurrentModelEnumer.DEBUG;
		}*/
		
		if(StringUtils.split(sVersion,".")[1].equals("0"))
		{
			nowModel = CurrentModelEnumer.DEBUG;
		}
		

		return nowModel;
	}

}
