package org.dbyz.dubbo.test;

import org.dbyz.dubbo.consumer.Consumer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");
		Consumer consumer = context.getBean(Consumer.class);
		for (int i = 0; i < 10; i++) {
			consumer.run();			
		}
	}
}
