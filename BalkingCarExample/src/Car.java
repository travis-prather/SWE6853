public class Car {
	public enum State { notRunning, running, accelerating, braking }
	
	private State state = State.notRunning;
	private int speed = 0;
	
	public void start() {
		// Start the car
		System.out.println("Ignition success");
	    state = State.running;
	}
	
	public void accelerate() {
	    synchronized(this) {
	        if(state == State.notRunning) {
	        	System.out.println("ERROR: Cannot accelerate if car is not running!");
	            return;
	        }
	        state = State.accelerating;
	    }
        // Accelerate the car
	    speed += 10;
        System.out.println("Accelerating to " + speed);
        actionComplete();
	}
	
	public void brake() {
		synchronized(this) {
			if(state == State.accelerating) {
				System.out.println("WARNING: Must stop accelerating before braking to prevent wear");
				return;
			}
			state = State.braking;
		}
		// Brake the car
		if(speed<10)
			speed = 0;
		else
			speed -= 10;
		System.out.println("Braking to " + speed);
		actionComplete();
	}
	
	public void actionComplete() {
		synchronized(this) {
	        state = State.running;
	    }
	}
}
