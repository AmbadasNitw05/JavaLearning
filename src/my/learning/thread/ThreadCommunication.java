package my.learning.thread;

public class ThreadCommunication {
	
	private ProducerConsumer pc;
	
	public ThreadCommunication() {
		this.pc = new ProducerConsumer();
	}
	
	public void start() throws InterruptedException {
		
		Thread t1 = new Thread() {

			@Override
			public void run() {
				for(int i=97; i<123; i++) {
					try {
						pc.produce(String.valueOf((char)i));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		};
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		
		
		
		
	}

	public static void main(String[] args) {
		ThreadCommunication tc = new ThreadCommunication();
		try {
			tc.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
