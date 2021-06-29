package my.learning.spring.annotation.beans;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal{

	public void move() {
		System.out.println("Cat is moving...");
	}
}
