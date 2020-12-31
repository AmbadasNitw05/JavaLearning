package my.learning.test;

import java.util.PriorityQueue;

public class TestPriorityQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();		
		for(int i=10;i>0;i--){
			queue.add(i);
		}		
		// Queue: (front) 10 9 8 7 6 5 4 3 2 1 (rear)
		// PriorityQueue sorts the data
		// Queue: (front) 1 2 3 4 5 6 7 8 9 10 (rear) | sorted queue		
		System.out.println("Queue size: " + queue.size()); // 10
		System.out.println("Queue head: " + queue.peek()); // 1		
		queue.poll();
		System.out.println("Queue size after poll:" + queue.size()); // 9
		System.out.println("Queue head after poll: " + queue.peek()); // 2

	}

}
