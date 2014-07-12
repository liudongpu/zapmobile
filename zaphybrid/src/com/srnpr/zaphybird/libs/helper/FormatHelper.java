package com.srnpr.zaphybird.libs.helper;

public class FormatHelper {

	/**
	 * @param sBaseString
	 *            输入字符串
	 * @param sFromStrings
	 *            替换字符串组
	 * @return 返回替换后结果
	 */
	public static String formatString(String sBaseString,
			Object... sFromStrings) {

		if (sBaseString.equals(null) || sBaseString.equals("")) {
			for (int i = 0, j = sFromStrings.length; i < j; i++) {
				sBaseString = sBaseString + "{" + i + "}";
			}
		}

		for (int i = 0, j = sFromStrings.length; i < j; i++) {
			sBaseString = sBaseString.replace("{" + (i) + "}",
					sFromStrings[i].toString());
		}
		return sBaseString;

	}

}
