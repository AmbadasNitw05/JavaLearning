package my.learning.spring.annotation.aop;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logging {

	/**
	 * Following is the definition for a PointCut to select all the methods
	 * available. So advice will be called for all the methods.
	 */
	@Pointcut("execution(* my.learning.spring.annotation.aop.*.*(..))")
	public void selectAll() {}

	/**
	 * This is the method which I would like to execute before a selected method
	 * execution.
	 */
	@Before("selectAll()")
	public void beforeAdvice() {
		System.out.println("Going to setup student profile.");
	}

	/**
	 * This is the method which I would like to execute after a selected method
	 * execution.
	 */
	@After("selectAll()")
	public void afterAdvice() {
		System.out.println("Student profile has been setup.");
	}

	/**
	 * It's also responsible for choosing whether to proceed to the join point or to
	 * shortcut the advised method execution by providing its own return value or
	 * throwing an exception.
	 * 
	 * @throws Throwable
	 */
	@Around("selectAll()")
	public Object aroundAdvice(ProceedingJoinPoint prj) throws Throwable {
		long start = System.nanoTime();
		Object retVal = prj.proceed();
		long end = System.nanoTime();
		String methodName = prj.getSignature().getName();
		System.out.println(
				"Execution of method " + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
		return retVal;
	}

	/**
	 * This is the method which I would like to execute when any method returns.
	 */
	@AfterReturning(pointcut = "selectAll()", returning = "retVal")
	public void afterReturningAdvice(Object retVal) {
		System.out.println("Returning: " + retVal.toString());
	}

	/**
	 * This is the method which I would like to execute if there is an exception
	 * raised.
	 */
	@AfterThrowing(pointcut = "selectAll()", throwing = "ex")
	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception: " + ex.toString());
	}
}
