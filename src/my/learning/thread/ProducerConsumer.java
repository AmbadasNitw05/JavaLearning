package my.learning.thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	private Queue<String> queue;
	private static final int MAX_CAPACITY = 10;
	
	public ProducerConsumer() {
		queue = new LinkedList<String>();
	}
	
	public void produce(String msg) throws InterruptedException {
		synchronized(this) {	
			if(queue.size() == MAX_CAPACITY) {
				wait();				
			}
			
			System.out.println("produce message(" + Thread.currentThread().getName() + "): " + msg);
			queue.offer(msg);
			System.out.println("Queue: " + queue);
			Thread.sleep(2000);
			notify();
			
		}
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized(this) {
				while(queue.size() == 0) {
					wait();
				}
				
				System.out.println("Consuming msg(" + Thread.currentThread().getName() + "): " + this.queue.peek());
				
				queue.remove();
				
			}
		}
	}
}
