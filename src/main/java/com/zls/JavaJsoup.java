package com.zls;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JavaJsoup {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://geek.csdn.net/cloud");
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
		CloseableHttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		response.close();
		Document document = Jsoup.parse(content);
//		Element e1 = document.getElementsByTag("title").first(); //通过标签
		//Element e2 = document.getElementById("searchbar"); //通过id
		//System.out.println(e2.html()); 
//		Elements e3 = document.getElementsByClass("container-fluid"); //通过样式
//		for (Element element : e3) {
//			System.out.println(element.html());
//			System.out.println("+++++++++++++++++++++");
//		}
//		Elements e4 = document.getElementsByAttribute("src"); //通过属性名称
//		e4 = document.getElementsByAttributeValue("src", 
//				"//v2static.epub360.com/static20160620/files/bd58ce7f9ae848c8cddf025f00e894a2.png"); //通过属性名称和值
//		for (Element element : e4) {
//			System.out.println(element.toString());
//			System.out.println("+++++++++++++++++++++");
//		}
		
		//通过选择器查找dom
//		Elements e5 = document.select(".body_lSpd6j .section_head .container_mFFe5Q .row_wdmfuy");
//		for (Element element : e5) {
//			System.out.println(element.toString());
//			System.out.println("+++++++++++++++++++++");
//		}
		
//		Elements e5 = document.select("a[href]");
//		for (Element element : e5) {
//			System.out.println(element.toString());
//			System.out.println("+++++++++++++++++++++");
//		}
		
//		Elements e5 = document.select("img[src$=.png]");
//		for (Element element : e5) {
//			System.out.println(element.toString());
//			System.out.println("+++++++++++++++++++++");
//		}
		
		Elements e5 = document.select("img[src$=.png]");
		List<String> imageUrl = new ArrayList<String>();
		String src = null;
		for (Element element : e5) {
			//获取字节流
			src = element.attr("src");
			imageUrl.add(src);
		}
	}
}