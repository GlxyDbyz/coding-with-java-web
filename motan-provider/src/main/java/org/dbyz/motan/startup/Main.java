package org.dbyz.motan.startup;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MOTAN 启动方法
 *
 * @ClassName: Main
 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a>
 * @version: V1.0
 */
public class Main {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");
		System.out.println("motan server start...");
	}
}
