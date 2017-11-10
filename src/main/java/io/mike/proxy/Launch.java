package io.mike.proxy;

import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.mike.proxy.aop.CglibForSubject;
import io.mike.proxy.aop.JdkLogicForSubject;
import io.mike.proxy.service.Subject;
import io.mike.proxy.service.support.PairRealSubject;

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
		Subject subject = new PairRealSubject();		
		subject.sayHello();
		log.info(subject.getClass().getName());
		
		//B、通过JDK的动态代理使用对象
		ClassLoader classLoader = PairRealSubject.class.getClassLoader();
		Class<?>[] interfaces = PairRealSubject.class.getInterfaces();
		
		log.debug("classLoader:{}", classLoader);
		log.debug("interfaces length:{}", interfaces.length);
		
		Subject proxySubject = (Subject) Proxy.newProxyInstance(
				classLoader,						//1、classLoader
				interfaces, 						//2、接口列表
				new JdkLogicForSubject(subject));	//3、InvocationHandler 实现切面逻辑
		
		proxySubject.sayHello();
		
		/**
		 * java.lang.reflect.Proxy.class
		 * line:512 => String proxyName = proxyPkg + proxyClassNamePrefix + num;
		 */
		log.info(proxySubject.getClass().getName());
		
		//C、cglib 的动态代理方式
		PairRealSubject temp = (PairRealSubject) new CglibForSubject().getProxy(PairRealSubject.class);
		temp.sayHello();
		log.info(temp.getClass().getName());
	}

}
