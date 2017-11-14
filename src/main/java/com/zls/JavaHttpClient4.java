package com.zls;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class JavaHttpClient4 {

	public static void main(String[] args) {
		//创建一个默认的httpClient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建请求
		long start = System.currentTimeMillis();
		HttpGet httpGet = new HttpGet("http://www.zhimaruanjian.com/?148");
		HttpHost proxy = new HttpHost("113.123.50.78", 808);
		RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
		httpGet.setConfig(config );
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
		try {
			System.out.println(EntityUtils.toString(entity, "utf-8"));
			System.out.println(System.currentTimeMillis()-start);
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
