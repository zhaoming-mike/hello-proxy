package io.mike.proxy.service.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.mike.proxy.service.Subject;

/**
 * @author zhaoming
 *
 * 2017年11月10日 上午10:54:15
 */
public class SingleRealSubject implements Subject {

	private static final Logger log = LoggerFactory.getLogger(SingleRealSubject.class);
	
	@Override
	public void sayHello() {
		log.info("Hello!");
	}

	
}
