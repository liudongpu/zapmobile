package com.srnpr.zaphybird.libs.support;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.srnpr.zaphybird.libs.model.ResultHttp;

public class HttpSupport {

	public ResultHttp httpGet(String sUrl) {
		ResultHttp resultHttp = new ResultHttp();

		if (resultHttp.upFlagTrue()) {
			try {
				// 封装访问服务器的地址
				URL url = new URL(sUrl);

				// 打开对服务器的连接
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				// 连接服务器
				conn.connect();
				/** 读入服务器数据的过程 **/
				// 得到输入流
				InputStream is = conn.getInputStream();
				// 创建包装流
				BufferedReader br = new BufferedReader(
						new InputStreamReader(is));
				// 定义String类型用于储存单行数据
				String line = null;
				// 创建StringBuffer对象用于存储所有数据
				StringBuffer sb = new StringBuffer();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				// 用TextView显示接收的服务器数据

				// System.out.println(sb.toString());

				resultHttp.setRespose(sb.toString());

			} catch (Exception e) {
				e.printStackTrace();
				resultHttp.inErrorMessage(968412002);
			}
		}

		return resultHttp;

	}

}
