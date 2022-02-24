package my.learning.thread;

public class ThreadJoinExample extends Thread{
	
	

	@Override
	public void run() {
		for(int i=1; i<4; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}

	public static void main(String[] args) {
		ThreadJoinExample tje1 = new ThreadJoinExample();
		tje1.setName("T1");
		
		ThreadJoinExample tje2 = new ThreadJoinExample();
		tje2.setName("T2");
		
		ThreadJoinExample tje3 = new ThreadJoinExample();
		tje3.setName("T3");
		
		tje1.start();
		try {
			tje1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tje2.start();
		tje3.start();

	}

}
