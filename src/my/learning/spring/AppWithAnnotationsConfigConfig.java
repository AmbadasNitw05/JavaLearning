package my.learning.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import my.learning.spring.annotation.beans.Cat;

@Configuration
@ComponentScan("my.learning.spring.annotation.beans")
public class AppWithAnnotationsConfigConfig {

	/*
	 * @Bean public Cat getCat() { return new Cat(); }
	 */
}
