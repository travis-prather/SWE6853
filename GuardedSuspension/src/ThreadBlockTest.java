public class ThreadBlockTest {

	public static void main(String[] args) {
		GuardedSuspension guardedSuspension = new GuardedSuspension();
		
		// Create test thread 1
		new Thread(
			new Runnable() {
				@Override
				public void run() {
					// Invoke guarded method
					System.out.println("Requesting guarded action...");
					guardedSuspension.guardedMethod();
				}
			}
		).start();
		
		// Create test thread 2
		new Thread(
			new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1500);
					} catch(InterruptedException IE) {
						IE.printStackTrace();
					}
					// Alter precondition state
					System.out.println("making ready...");
					guardedSuspension.makeReady();
				}
			}
		).start();
	}
}
