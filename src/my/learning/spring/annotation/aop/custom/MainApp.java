package my.learning.spring.annotation.aop.custom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext appContext = new ClassPathXmlApplicationContext("my/learning/spring/annotation/aop/custom/spring-config-aop-annotations-custom.xml");
		
		Student student = (Student) appContext.getBean("student");
		
		student.getName();
		student.getAge();
		
		student.printThrowException();
		
	}

}
