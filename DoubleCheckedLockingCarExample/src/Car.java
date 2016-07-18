public class Car {
	private enum State { notRunning, running, accelerating, braking, cruising }
	
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
	    // Cancel cruise control
	    CruiseController.getInstance().cancel();
        // Accelerate the car
        speed += 10;
        System.out.println("Car accelerating to " + speed);
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
		// Cancel cruise control
		int tempSpeed = CruiseController.getInstance().getSpeed();
	    CruiseController.getInstance().cancel();
	    if(tempSpeed>0)
	    	speed = tempSpeed;
		// Brake the car
		if(speed<10)
			speed = 0;
		else
			speed -= 10;
		System.out.println("Car braking to " + speed);
		actionComplete();
	}
	
	public void cruise() {
		synchronized(this) {
			if(state == State.notRunning) {
	        	System.out.println("ERROR: Cannot cruise if car is not running!");
	            return;
	        }
			state = State.cruising;
		}
		// Set the cruise control to current speed
	    CruiseController.getInstance().setSpeed(speed);
		// Brake the car
		System.out.println("Car cruising at " + speed);
	}
	
	public void actionComplete() {
		synchronized(this) {
	        state = State.running;
	    }
	}
}
