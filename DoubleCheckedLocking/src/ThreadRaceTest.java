import java.util.Random;

public class ThreadRaceTest {
	
	public static void main(String[] args) {
		// Create object with double checked locking
		Once once = new Once();
		
		// Create some threads
		int threads = 30;
		do {
			creatTestThread(once);
		} while(--threads>0);
	}

	
	public static void creatTestThread(Once once) {
		// Create test thread
		new Thread(
			new Runnable() {
				@Override
				public void run() {
					// Get random delay time from 0-1 second
					long delay = (long)new Random().nextInt(Integer.MAX_VALUE)%1000;
					try {
						Thread.sleep(delay);
					} catch(InterruptedException IE) {
						IE.printStackTrace();
					}
					// Try to win!
					once.win();
				}
			}
		).start();
	}
}
