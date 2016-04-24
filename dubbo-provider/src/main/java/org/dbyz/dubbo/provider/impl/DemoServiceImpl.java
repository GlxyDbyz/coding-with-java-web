package org.dbyz.dubbo.provider.impl;

import java.util.concurrent.atomic.AtomicInteger;

import org.dbyz.dubbo.provider.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
	private AtomicInteger count = new AtomicInteger(0);

	@Override
	public String reply() {
		return "reply:" + count.incrementAndGet();
	}

}
