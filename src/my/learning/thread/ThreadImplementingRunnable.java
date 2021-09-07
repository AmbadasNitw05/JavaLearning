package my.learning.thread;

public class ThreadImplementingRunnable implements Runnable {

	public static void main(String[] args) {
		Thread obj = new Thread(new ThreadImplementingRunnable());
		obj.start();
	}

	@Override
	public void run() {
		System.out.println("Thread runs...");
	}

}
