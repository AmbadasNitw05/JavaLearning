package my.learning.spring.xml.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-config-cpr.xml");
		
		Student student = (Student) appContext.getBean("student");
		
		student.getName();
		student.getAge();
		
		student.printThrowException();
		
	}

}
