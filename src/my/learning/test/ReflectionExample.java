package my.learning.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {

	public void reflectMethodNoArgs() {
		System.out.println("Printing from refelectingMethodNoArgs");
	}
	
	public void reflectMethodWithArgs(String name, Integer id) {
		System.out.println("Printing from refelectingMethodWithArgs " + name + " " + id);
	}
	
	public static void main(String[] args) {
		ReflectionExample reflectionExample = new ReflectionExample();
		try {
			// 3 times slower than direct call. Hard to find root cause if fails. 
			// if type safety fails at run time rather than compile time
			Method method1 = reflectionExample.getClass().getMethod("reflectMethodNoArgs", null);
			Method method2 = reflectionExample.getClass().getMethod("reflectMethodWithArgs", String.class, Integer.class);
			try {
				method1.invoke(reflectionExample, null);
				method2.invoke(reflectionExample, "Ambadas",257294);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
