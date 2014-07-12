package com.srnpr.zaphybird.libs.model;

import com.srnpr.zaphybird.libs.hybirdif.IResult;
import com.srnpr.zaphybird.libs.init.HybirdUp;

/**
 * 返回执行结果
 * 
 * @author srnpr
 * 
 */
public class RootResult implements IResult {

	/**
	 * 返回标记 如果该标记为1则表明返回结果正确 否则都是错误消息
	 */

	private long resultCode = 1;

	/**
	 * 返回消息 一般用于返回错误描述或者操作提示
	 */

	private String resultMessage = "";

	public long getResultCode() {
		return resultCode;
	}

	public void setResultCode(long resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	/*
	 * 判断是否正确
	 */
	public boolean upFlagTrue() {
		return getResultCode() == 1;
	}

	public void inErrorMessage(long lInfoCode, Object... oParams) {
		setResultCode(lInfoCode);

		setResultMessage(HybirdUp.upInfo(lInfoCode, oParams));
	}

	public void inResult(IResult iResult) {
		if (iResult.getResultCode() != 1) {

			setResultCode(iResult.getResultCode());

			setResultMessage(iResult.getResultMessage());

		}
	}

}
