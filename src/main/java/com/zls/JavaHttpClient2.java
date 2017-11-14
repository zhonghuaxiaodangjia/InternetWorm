package com.zls;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class JavaHttpClient2 {

	public static void main(String[] args) {
		//创建一个默认的httpClient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建请求
		HttpGet httpGet = new HttpGet("https://aimg0.tuicool.com");
		//设置消息请求头
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
		CloseableHttpResponse response = null;
		try {
			//获取响应
			response = httpClient.execute(httpGet);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//得到响应的实体内容
		HttpEntity entity = response.getEntity();
		//得到响应的状态码
		response.getStatusLine().getStatusCode();
		try {
			//把实体内容通过指定编码输出
			System.out.println(EntityUtils.toString(entity, "utf-8"));
			//获得响应的内容类型
			System.out.println(entity.getContentType().getValue());
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			response.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			try {
				httpGet.clone();
			} catch (CloneNotSupportedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
}
