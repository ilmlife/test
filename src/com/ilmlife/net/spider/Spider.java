package com.ilmlife.net.spider;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ilmlife E-Mail：ilmlife@126.com
 * @version 1.0 创建时间：2015年7月24日 下午9:27:28
 */
public class Spider {
	private final String aUrlRegrex = "[a-zA-Z0-9]+/?[a-zA-Z0-9\\.]+\\.(html)";
	private final Map<String,String> spiderMap = new HashMap<String,String>();
//	private final String aUrlRegrex = "[a-zA-Z0-9\\-\\.]+\\.(com|org|net|mil|edu|COM|ORG|NET|MIL|EDU)";
//	private final String aUrlRegrex = "<a[\\s\\S]*?href=['\"]?([\\w\\.]*)['\"]?[\\s\\S]*?>(.*)</a>";
	
	
	public static void main(String[] args) throws Exception {
		String domain = "http://cn.cocos2d-x.org/doc/jsdoc/";
		String baseUrl = "http://cn.cocos2d-x.org/doc/jsdoc/index.html";
		String localPath = "C:/Users/SillyBoy/Desktop/testSpider/";
		
		Spider spider = new Spider();
		spider.spiderBegin(baseUrl, domain, localPath);
	}
	
	/**
	 * 从url获取数据并替换domain
	 * @param url
	 * @param domain
	 * @param localPath
	 * @throws Exception
	 */
	public void spiderBegin(String url,String domain,String localPath) {
		if(spiderMap.containsKey(url)) {
			return;
		}
		spiderMap.put(url, null);

		try{
			URL httpurl = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) httpurl.openConnection();
			httpConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");
			httpConn.setRequestMethod("GET");
			httpConn.setDoInput(true);
			
			BufferedWriter fileBw = new BufferedWriter(new FileWriter(buildFile(url, domain, localPath)));
			
			BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				Pattern p = Pattern.compile(aUrlRegrex);
				Matcher m = p.matcher(line);
				while(m.find()) {
					String tempUrl = domain + m.group();
					spiderBegin(tempUrl, domain, localPath);
				}
				fileBw.write(line.replaceAll(domain, localPath));
			}
			fileBw.flush();
			fileBw.close();
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 构建本地位置
	 * @param url
	 * @param domain
	 * @param localPath
	 * @return
	 * @throws Exception
	 */
	public File buildFile(String url, String domain, String localPath) throws Exception {
		String localFileStr = url.replaceAll(domain, localPath);
		
		File file = new File(localFileStr);
		String pathStr = file.getParent();
		File path = new File(pathStr);
		if(!path.exists()) {
			path.mkdirs();
		}
		if(!file.exists()) {
			file.createNewFile();
		}
		return file;
	}
}