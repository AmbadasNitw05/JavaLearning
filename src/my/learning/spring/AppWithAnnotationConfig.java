package my.learning.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import my.learning.spring.annotation.beans.Animal;
import my.learning.spring.annotation.beans.Cat;
import my.learning.spring.annotation.beans.Pet;

public class AppWithAnnotationConfig {
	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppWithAnnotationsConfigConfig.class);		
		Pet pet = appContext.getBean(Pet.class); pet.move();
	}
}
