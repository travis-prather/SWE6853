public class Balk {

	public enum Status { notReady, ready, busy }
	
	private Status status = Status.notReady;
	
	public void makeReady() {
	    status = Status.ready;
	}
	
	public void performAction() {
	    synchronized(this) {
	        if(status != Status.ready) {
	        	System.out.println("ERROR: Balking object not ready!");
	            return;
	        }
	        status = Status.busy;
	    }
        // Do something
        System.out.println("not balking...");
        actionComplete();
	}
	
	public void actionComplete() {
		synchronized(this) {
	        status = Status.ready;
	    }
	}
}
