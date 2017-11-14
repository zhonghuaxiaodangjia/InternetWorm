package com.zls;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class JavaHttpClient3 {

	public static void main(String[] args) {
		//创建一个默认的httpClient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建请求
		HttpGet httpGet = new HttpGet("http://blog.i20forever.cn/content/uploadfile/201711/37df1510662958.png");
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
			InputStream inputStream = entity.getContent();
			//利用Apache组件
			//FileUtils.copyToFile(inputStream, new File("F://2017.jpg"));
			FileOutputStream fout = new FileOutputStream("F://201702.jpg");
			byte[] buf = new byte[1024];
			int length =0;
			System.out.println("开始下载");
			while((length = inputStream.read(buf))!=-1){
				fout.write(buf,0,length);
			}
			inputStream.close();
			fout.close();
			System.out.println("下载完成");
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
