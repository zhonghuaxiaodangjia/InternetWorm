package com.zls;


import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class JavaHtmlUnit {

	public static void main(String[] args) throws InterruptedException {
		WebClient webClient=new WebClient(BrowserVersion.FIREFOX_52); // 实例化Web客户端
		try {
			HtmlPage page=webClient.getPage("http://www.shaoit.com/html/wallpaper/"); // 解析获取页面
			Thread.sleep(10000); // 休息10秒 等待htmlunit执行Js
			System.out.println("网页html:"+page.asXml());
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			webClient.close(); // 关闭客户端，释放内存
		}
	}
}
