package com.ilmlife.regex.constant;


/**
 * 常用正则表达式常量
 *
 * @author silly E-Mail：silly@intoms.cn
 * @version 1.0 创建时间：2015年7月30日 上午10:35:52
 */
public final class RegexConstant {
	/** email正则表达式 **/
	public final static String EMAIL = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
	/** IP地址正则表达式 **/
	public final static String IP = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})($|(?!\\.$)\\.)){4}+$";// (?!\\.$) 表示点后面不能是结束
}
