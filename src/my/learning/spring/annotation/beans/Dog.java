package my.learning.spring.annotation.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Dog implements Animal {

	@Override
	public void move() {
		System.out.println("Dog is moving...");

	}

}
