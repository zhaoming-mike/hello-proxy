package io.mike.proxy.service.support;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.mike.proxy.service.Subject;

/**
 * @author zhaoming
 *
 * 2017年11月10日 上午10:54:15
 */
public class PairRealSubject implements Subject, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PairRealSubject.class);
	
	@Override
	public void sayHello() {
		log.info("Hello!");
	}

	
}
