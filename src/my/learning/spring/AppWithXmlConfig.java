package my.learning.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import my.learning.spring.scan.beans.Baleno;
import my.learning.spring.xml.beans.Car;

public class AppWithXmlConfig {

	public static void main(String[] args) {

		// Resource res = new FileSystemResource("spring-config.xml"); // relative Path starts from project folder.
		// ClassPathResource res = new ClassPathResource("spring-config-cpr.xml"); // File should be on class path
		// BeanFactory factory = new XmlBeanFactory(res);

		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-config-cpr.xml"); // File should be on classpath
		// Of course ApplicationContext is just a BeanFactory
		BeanFactory factory = appContext;

		// Car car = (Car) factory.getBean("car");
		Car car = (Car) appContext.getBean("car");		car.move();
		Baleno baleno = (Baleno) factory.getBean("baleno"); baleno.move();
	}

}
