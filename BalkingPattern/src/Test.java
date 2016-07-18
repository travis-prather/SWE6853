public class Test {

	public static void main(String[] args) {
		Balk balk = new Balk();
		
		// Create test thread 1
		new Thread(
			new Runnable() {
				@Override
				public void run() {
					// This should fail
					System.out.println("Attempting fail case in thread 1:");
					balk.performAction();
					try {
						Thread.sleep(1000);
					} catch(InterruptedException IE) {
						IE.printStackTrace();
					}
					// This should pass
					System.out.println("Attempting success case in thread 1:");
					balk.performAction();
				}
			}
		).start();
		
		// Create test thread 2
		new Thread(
			new Runnable() {
				@Override
				public void run() {
					// This should pass
					System.out.println("Attempting success case in thread 2:");
					balk.makeReady();
					balk.performAction();
				}
			}
		).start();
	}
}
