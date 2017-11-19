package com.zls;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlFont;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class JavaHtmlUnit {

	public static void main(String[] args) {
		//浏览器ip代理
		// WebClient webClient=new WebClient(BrowserVersion.FIREFOX_52,"60.255.186.169",8888);
		 WebClient webClient=new WebClient(BrowserVersion.FIREFOX_52);
		 //取消对css支持
		 webClient.getOptions().setCssEnabled(false);
		 //取消对javascript支持
		 webClient.getOptions().setJavaScriptEnabled(false);
		 HtmlPage page;
		try {
			page = webClient.getPage("http://www.java1234.com/");
			HtmlDivision div=page.getHtmlElementById("bdcs");  // 查找指定id的html dom元素
			System.out.println(div.asXml());
			System.out.println("======================");
			DomNodeList<DomElement> aList=page.getElementsByTagName("title"); // 根据标签名称查询
			for(int i=0;i<aList.getLength();i++){
				DomElement a=aList.get(i);
				System.out.println(a.asText());
			}
			System.out.println("======================");
			//根据xPath获取
			List<HtmlFont> fonts = page.getByXPath("//div[@class='latestnews']/dl/dd/ul/li[1]/a/font");
			System.out.println(fonts.get(0).asText());
			System.out.println("======================");
			//模拟提交表单
			HtmlForm form = page.getFormByName("");
			HtmlTextInput textInput = form.getInputByName("q");
			HtmlSubmitInput button = form.getInputByValue("搜索");
			textInput.setValueAttribute("java");
			HtmlPage resultPage = button.click();
			System.out.println(resultPage.asXml());
			System.out.println("======================");
		} catch (FailingHttpStatusCodeException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		webClient.close();
	}
}
