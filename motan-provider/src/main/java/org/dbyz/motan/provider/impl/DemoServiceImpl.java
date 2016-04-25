package org.dbyz.motan.provider.impl;

import java.util.concurrent.atomic.AtomicInteger;

import org.dbyz.motan.provider.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
	private AtomicInteger count = new AtomicInteger(0);

	@Override
	public String reply() {
		return "motan reply:" + count.incrementAndGet();
	}

}
