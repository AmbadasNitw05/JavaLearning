package my.learning.spring.annotation.beans;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AspectHelper {

	@Before("execution(public void move())")
	public void log() {
		System.out.println("before : Aspect log called ");
	}
}
