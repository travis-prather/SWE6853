public class GuardedSuspension {

	private boolean ready = false;
	
	synchronized void guardedMethod() {
		// Wait for precondition to be satisfied
		while(!ready) {
			try {
				wait();
			} catch(InterruptedException IE) {
				IE.printStackTrace();
			}
		}
		// Perform action
		System.out.println("Action Performed!");
	}
	
	synchronized void makeReady() {
		// Change ready state
		ready = true;
		// notify blocked threads
		notifyAll();
	}
}
