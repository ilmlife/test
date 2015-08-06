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
	
//	public final static String COMTEXT = "^[\u3000-\u301e\ufe10-\ufe19\ufe30-\ufe44\ufe50-\ufe6b\uff01-\uffee]$"; // 中文及全角标点符号(字符)
	
	/** 中国大陆固定电话号码 **/
	public final static String ZH_LANDLINE = "^(\\d{4}-|\\d{3}-)?(\\d{8}|\\d{7})$";
	/** 中国大陆手机号码 **/
	public final static String ZH_CELLPHONE = "^1\\d{10}$";
	/** 中国大陆邮政编码 **/
	public final static String ZH_ZIPCODE = "^[1-9]\\d{5}$";
	/** 中国大陆身份证号(15位或18位) **/
	public final static String ZH_CARDID = "^\\d{15}(\\d\\d[0-9xX])?$";
}
