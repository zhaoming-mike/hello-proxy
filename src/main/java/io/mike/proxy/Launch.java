package io.mike.proxy;

import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.mike.proxy.jdk.ProxySubject;
import io.mike.proxy.jdk.Subject;
import io.mike.proxy.jdk.support.RealSubject;

/**
 * @author zhaoming
 *
 * 2017年11月10日 上午10:55:52
 */
public class Launch {

	private static final Logger log = LoggerFactory.getLogger(Launch.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//A、直接使用对象
		Subject subject = new RealSubject();		
		subject.sayHello();
		log.info(subject.getClass().getName());
		
		//B、通过JDK的动态代理使用对象
		Subject proxySubject = (Subject) Proxy.newProxyInstance(
				RealSubject.class.getClassLoader(), //1、ClassLoader
				RealSubject.class.getInterfaces(), 	//2、接口列表
				new ProxySubject(subject));			//3、InvocationHandler 实现切面逻辑
		
		proxySubject.sayHello();
		log.info(proxySubject.getClass().getName());
	}

}
