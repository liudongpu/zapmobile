package com.srnpr.zaphybird.libs.support;

import com.srnpr.zaphybird.libs.BaseClass;
import com.srnpr.zaphybird.libs.model.MDataMap;
import com.srnpr.zaphybird.libs.model.ResultHttp;
import com.srnpr.zaphybird.libs.model.ResultInit;

public class InitSupport extends BaseClass {

	public ResultInit loadConfig(String sUrl) {

		ResultInit resultInit = new ResultInit();

		if (resultInit.upFlagTrue()) {
			ResultHttp resultHttp = new HttpSupport().httpGet(sUrl);

			resultInit.inResult(resultHttp);

			if (resultHttp.upFlagTrue()) {

				
				
				
				
				
			}

		}

		return resultInit;

	}

}
