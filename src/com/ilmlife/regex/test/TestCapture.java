package com.ilmlife.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 捕获组使用
 * 
 * @author silly E-Mail：silly@intoms.cn
 * @version 1.0 创建时间：2015年7月30日 下午3:22:26
 */
public class TestCapture {
	public static void main(String[] args) {
		String regex = "^((A)(BC))$";
		String s = "ABC";
		s = "250.2.3.4";
		regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})($|(?!\\.$)\\.)){4}$";;
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		while (m.find()) {
			for (int i = 1; i <= m.groupCount(); i++) {
				System.out.println(m.group(i));
			}
			System.out.println("============");
		}
	}
}
