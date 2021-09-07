package my.learning.thread;

public class ThreadSafeExample {

	public static void main(String[] args) {
		final Counter counter = new Counter();
		
		Thread t1 = new Thread(new Runnable() {			
			@Override
			public void run() {
				for(int i=1;i<=2000;i++) {
					counter.increment();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {			
			@Override
			public void run() {
				for(int i=1;i<=2000;i++) {
					counter.increment();
				}
				
			}
		});

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		counter.print();
	}
}
