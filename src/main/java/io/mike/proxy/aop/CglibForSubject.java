package io.mike.proxy.aop;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author zhaoming
 *
 * 2017年11月10日 下午2:50:28
 */
public class CglibForSubject implements MethodInterceptor {

	private static final Logger log = LoggerFactory.getLogger(CglibForSubject.class);
	
	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class<?> clazz) {
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		log.info("cglib before call method:{}", method);
		Object object = proxy.invokeSuper(obj, args);
		return object;
	}
	

}
