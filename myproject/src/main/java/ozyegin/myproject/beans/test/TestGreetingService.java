package ozyegin.myproject.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ozyegin.myproject.AppConfig;
import ozyegin.myproject.beans.GreetingService;
import ozyegin.myproject.beans.GreetingServiceImpl;
import ozyegin.myproject.beans.MessageBeanTrImpl;

public class TestGreetingService {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		GreetingService srv= context.getBean("greetingService", GreetingService.class);
		System.out.println(srv.getARandomNumber());
		System.out.println(srv.sayHello());
		
		
//		GreetingService srv1= context.getBean("greetingService", GreetingService.class);
//		System.out.println(srv1.getARandomNumber());
//		System.out.println(srv1.sayHello());
//		
//		System.out.println(srv==srv1);
		
		
		
//		GreetingService srv3=new GreetingServiceImpl();
//		MessageBeanTrImpl mb= new MessageBeanTrImpl();
//		srv3.setMessageBean(mb);
//		System.out.println(srv3.sayHello());
		
		
		
		

	}

}