package io.mike.proxy.jdk.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.mike.proxy.jdk.Subject;

/**
 * @author zhaoming
 *
 * 2017年11月10日 上午10:54:15
 */
public class RealSubject implements Subject {

	private static final Logger log = LoggerFactory.getLogger(RealSubject.class);
	
	@Override
	public void sayHello() {
		log.info("Hello!");
	}

}
