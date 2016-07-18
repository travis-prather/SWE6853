
public class AirConditioning {

	private volatile static AirConditioning airConditioning;
	private int temperature = 0;
	private boolean acRunning = false;
	
	private AirConditioning() {}
	
	public static AirConditioning getInstance() {
		if(airConditioning == null) {
			synchronized(AirConditioning.class) {
				if(airConditioning == null) {
					airConditioning = new AirConditioning();
				}
			}
		}
		return airConditioning;
	}
	
	public synchronized void startAC() {
		// Start AC
		System.out.println("Starting AC");
		acRunning = true;
		notifyAll();
	}
	
	public synchronized void setTemp(int temp) {
		while(!acRunning) {
			try {
				wait();
			} catch(InterruptedException IE) {
				IE.printStackTrace();
			}
		}
		// Set AC temp
		temperature = temp;
		System.out.println("Setting AC temp to " + temperature);
	}
}
