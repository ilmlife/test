package com.ilmlife.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试Greedy、Reluctant、Possessive三种数量词之间的区别
 * 
 * @author silly E-Mail：silly@intoms.cn
 * @version 1.0 创建时间：2015年7月30日 上午11:00:13
 */
public class TestQuantifierDif {
	public static void main(String[] args) {
		testGreedy();
		testReluctant();
		testPossessive();
	}

	/**
	 * .{3,10}第一次就吞10个字符.检查不匹配,吐出字符继续检查
	 */
	public static void testGreedy() {
		Pattern p = Pattern.compile(".{3,10}[0-9]");
		String s = "abcd1efggg123hijk123";
		Matcher m = p.matcher(s);
		if (m.find()) {
			System.out.println(m.group()); // --->abcd1efggg1
		} else {
			System.out.println("not match!");
		}
		
		s = "abcd1efgggg123hijk123";
		m = p.matcher(s);
		if (m.find()) {
			System.out.println(m.group()); // --->abcd1
		} else {
			System.out.println("not match!");
		}
	}

	/**
	 * .{3,10}?第一次就吞3个字符.检查不匹配,继续吞入,匹配则结束进行下一轮
	 */
	public static void testReluctant() {
		Pattern p = Pattern.compile(".{3,10}?[0-9]");
		String s = "abcd1efggg123hijk123";
		Matcher m = p.matcher(s);
		if (m.find()) {
			System.out.println(m.group()); // --->abcd1
		} else {
			System.out.println("not match!");
		}
		
		s = "abcd1efgggg123hijk123";
		m = p.matcher(s);
		if (m.find()) {
			System.out.println(m.group()); // --->abcd1
		} else {
			System.out.println("not match!");
		}
	}

	/**
	 * .{3,10}第一次就吞10个字符.一次性检索若不匹配就结束本次匹配进行下一轮
	 */
	public static void testPossessive() {
		Pattern p = Pattern.compile(".{3,10}+[0-9]");
		String s = "abcd1efggg123hijk123";
		Matcher m = p.matcher(s);
		if (m.find()) {
			System.out.println(m.group());// --->abcd1efggg1
		} else {
			System.out.println("not match!");
		}
		
		s = "abcd1efgggg123hijk123";
		m = p.matcher(s);
		if (m.find()) {
			System.out.println(m.group()); // --->bcd1efgggg1
		} else {
			System.out.println("not match!");
		}
	}
}
