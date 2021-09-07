package my.learning.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

	private int count;	
	private AtomicInteger atomicCount = new AtomicInteger();
	
	// synchronized makes this method thread safe. 
	// This method allows one thread at a time. 
	public /* synchronized */ void increment() {
		count++;
		
		// This method is thread safe
		atomicCount.incrementAndGet();
	}
	
	public void print() {
		System.out.println("count = " + count);
		System.out.println("atomicCount = " + atomicCount.get());
	}
}
