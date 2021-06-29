package my.learning.spring.annotation.aop;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppProxy {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("my/learning/spring/annotation/aop/spring-config-proxy.xml");
		
		Student student = (Student) appContext.getBean("student");
		Logging logging = (Logging) appContext.getBean("logging");
		
		AspectJProxyFactory proxyFactory = new AspectJProxyFactory(student);
		
		proxyFactory.addAspect(logging);
		
		Student proxyStudent = proxyFactory.getProxy();
		
		proxyStudent.getName();
		proxyStudent.getAge();
		
		proxyStudent.printThrowException();
		
	}

}
