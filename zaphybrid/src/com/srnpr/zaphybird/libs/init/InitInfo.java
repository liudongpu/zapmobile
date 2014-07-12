package com.srnpr.zaphybird.libs.init;

import com.srnpr.zaphybird.libs.helper.FormatHelper;
import com.srnpr.zaphybird.libs.model.MDataMap;

public class InitInfo {

	private MDataMap mInfoMap = new MDataMap();

	public InitInfo() {

		mInfoMap.put("968412001", "网络连接失败");
		mInfoMap.put("968412002", "网络连接出现错误");

	}

	public String upInfo(long lInfoCode, Object... oParams) {

		String sReturn = String.valueOf(lInfoCode);

		if (mInfoMap.containsKey(sReturn)) {
			sReturn = FormatHelper.formatString(mInfoMap.get(sReturn), oParams);
		} else {
			sReturn = FormatHelper.formatString("", oParams);
		}

		return sReturn;
	}

}
