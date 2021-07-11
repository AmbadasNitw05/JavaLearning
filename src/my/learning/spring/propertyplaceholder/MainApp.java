package my.learning.spring.propertyplaceholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.PropertyPlaceholderHelper;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("my/learning/spring/propertyplaceholder/spring-propertyplaceholder.xml");
		
		MyBean myBean = (MyBean) appContext.getBean("myBean");
		
		myBean.greetMessage();
		

	}

}
