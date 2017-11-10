package io.mike.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhaoming
 *
 * 2017年11月10日 上午10:57:45
 */
public class JdkLogicForSubject implements InvocationHandler {

	private static final Logger log = LoggerFactory.getLogger(JdkLogicForSubject.class);
	
	private Object target;
	
	public JdkLogicForSubject(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		log.info("Proxy:{}", this.getClass().getSimpleName());
		Object object = method.invoke(target, args);
		return object;
	}

}
