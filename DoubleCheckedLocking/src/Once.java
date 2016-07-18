public class Once {
	boolean completed = false;
	
	public void win() {
		if(!completed) {
			synchronized(this) {
				if(!completed) {
					System.out.println("Winning thread is " + Long.toString(Thread.currentThread().getId()));
					completed = true;
				}
			}
		}
	}
}
