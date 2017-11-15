package com.zls;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class JavaExecutor {

	private static Integer pages = 1;
	private static boolean exeFlag = true;
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);//创建线程池默认连接10个
		
		while(exeFlag){
			if (pages<=1000) {
				executorService.execute(new Runnable() {
					
					@Override
					public void run() {
						// TODO 自动生成的方法存根
						System.out.println("正在爬取第"+pages+"网页");
						pages++;
					}
				});
			}else{
				//线程活动数为0时
				if(((ThreadPoolExecutor)executorService).getActiveCount()==0){
					executorService.shutdown();
					exeFlag=false;
					System.out.println("任务完成");//结束所欲线程
				}
			}
			try {
				Thread.sleep(100); //线程休息0.1秒
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		
	}
}
