package org.dbyz.motan.consumer;

import javax.annotation.Resource;

import org.dbyz.motan.provider.DemoService;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @ClassName: Consumer
 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a>
 * @version: V1.0
 */
@Component
public class Consumer {
	
	@Resource
	private DemoService demoService;

	public void run() {
		System.out.println(demoService.reply());
	}
}
