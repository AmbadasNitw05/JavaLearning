package my.learning.spring.annotation.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext appContext = new ClassPathXmlApplicationContext("my/learning/spring/annotation/aop/spring-config-aop-annotations.xml");
		
		Student student = (Student) appContext.getBean("student");
		
		student.getName();
		student.getAge();
		
		student.printThrowException();
		
	}

}
