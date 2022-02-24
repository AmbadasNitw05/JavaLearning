package my.learning.thread;

import java.time.Duration;
import java.time.Instant;

public class Sum1to100WithThreads {
	
	private int sum1;
	private int sum2;
	
	public int getSumWithoutThreads() {
		int sum = 0;
		for(int i=1; i<=100; i++) {
			sum += i;
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}
	
	public int getSumWithThreads() {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1; i<=50; i++) {
					sum1 += i;
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread t2 = new Thread() {
			
			@Override
			public void run() {
				for(int i=51; i<=100; i++) {
					sum2 += i;
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		return sum1 + sum2;
	}

	public static void main(String[] args) {
		Sum1to100WithThreads sumFirstHundred = new Sum1to100WithThreads();
		
		Instant start = Instant.now();
		int result = sumFirstHundred.getSumWithoutThreads();
		System.out.println("without threads(" 
				+ Duration.between(start, Instant.now()).getSeconds()
				+ "): " + result);
		
		start = Instant.now();
		result = sumFirstHundred.getSumWithThreads();
		System.out.println("with threads(" 
				+ Duration.between(start, Instant.now()).getSeconds()
				+ "): " + result);

	}

}
