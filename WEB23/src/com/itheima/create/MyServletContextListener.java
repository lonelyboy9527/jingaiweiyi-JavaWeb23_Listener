package com.itheima.create;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	// 监听context域对象的创建
	public void contextInitialized(ServletContextEvent arg0) {
		//返回值 --- 就是被监听的对象 servletContext
		ServletContext servletContext = arg0.getServletContext();
		//返回值 --- 通用返回被监听的对象 
		Object source = arg0.getSource();
		System.out.println("context创建了...");
		
		
		//例如：开启一个计息的任务调度 --- 每天晚上12点计息一次
		Timer timer = new Timer();
		//task:任务 firstTime:第一次执行时间 period:间隔执行时间
		/*timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {	
				System.out.println("银行计息了...");
			}
		}, new Date(), 5000);*/
		
		//修改成银行真实的计息业务
		//1.起始时间：定义成晚上12点 
		//2.间隔时间：24小时
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime = "2017-07-15 00:45:00";
		Date parse = null;
		try {
			parse = format.parse(currentTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {	
				System.out.println("银行计息了...");
			}
		}, parse, 24 * 3600 * 1000);
	}
	@Override
	// 监听context域对象的销毁
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("context销毁了...");

	}
	
}
