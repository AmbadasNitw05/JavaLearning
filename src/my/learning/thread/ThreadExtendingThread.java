package my.learning.thread;

public class ThreadExtendingThread extends Thread {

	@Override
	public void run() {
		System.out.println("Thread runs...");
	}
	
	public static void main(String[] args) {
		ThreadExtendingThread obj = new ThreadExtendingThread();
		obj.start();
	}

}
