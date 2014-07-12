package com.srnpr.zaphybird.libs;

import com.srnpr.zaphybird.libs.init.HybirdUp;
import com.srnpr.zaphybird.libs.init.InitInfo;

public class BaseClass {

	public String bInfo(long lInfoCode, Object... oParams) {
		return HybirdUp.upInfo(lInfoCode, oParams);
	}

}
