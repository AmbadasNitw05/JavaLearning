package my.learning.spring.xml.aop;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logging {

	/**
	 * This is the method which I would like to execute before a selected method
	 * execution.
	 */
	public void beforeAdvice() {
		System.out.println("Going to setup student profile.");
	}

	/**
	 * This is the method which I would like to execute after a selected method
	 * execution.
	 */
	public void afterAdvice() {
		System.out.println("Student profile has been setup.");
	}
	
	/**
	 * It's also responsible for choosing whether to proceed to 
	 * the join point or to shortcut the advised method execution by providing its own return value or throwing an exception.
	 * @throws Throwable 
	 */
	public Object aroundAdvice(ProceedingJoinPoint prj) throws Throwable {
		long start = System.nanoTime();
		Object retVal = prj.proceed();
		long end = System.nanoTime();
		String methodName = prj.getSignature().getName();
		System.out.println("Execution of method " + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end-start) + " ms");
		return retVal;
	}

	/**
	 * This is the method which I would like to execute when any method returns.
	 */
	public void afterReturningAdvice(Object retVal) {
		System.out.println("Returning: " + retVal.toString());
	}

	/**
	 * This is the method which I would like to execute if there is an exception
	 * raised.
	 */
	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception: " + ex.toString());
	}
}
