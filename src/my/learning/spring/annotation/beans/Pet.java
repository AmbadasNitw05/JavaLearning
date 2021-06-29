package my.learning.spring.annotation.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Pet {

	@Autowired
	@Qualifier("cat")
	private Animal animal;
	
	public void move() {
		animal.move();
	}
}
