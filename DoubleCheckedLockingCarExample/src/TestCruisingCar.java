public class TestCruisingCar {

	public static void main(String[] args) {
		Car car = new Car();
		
		// Create car foot control test thread
		new Thread(
			new Runnable() {
				@Override
				public void run() {
					// This should start the car and accelerate
					System.out.println("Event 1 in thread 1:");
					car.start();
					car.accelerate();
					car.accelerate();
					try {
						Thread.sleep(1500);
					} catch(InterruptedException IE) {
						IE.printStackTrace();
					}
					// This should slow the car
					System.out.println("Event 2 in thread 1:");
					car.brake();
					try {
						Thread.sleep(5000);
					} catch(InterruptedException IE) {
						IE.printStackTrace();
					}
					// This should cancel cruise control and slow the car
					System.out.println("Event 3 in thread 2:");
					car.brake();
				}
			}
		).start();
				
		// Create car steering wheel control test thread
		new Thread(
			new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(2500);
					} catch(InterruptedException IE) {
						IE.printStackTrace();
					}
					// This set cruise control to the current speed
					System.out.println("Event 1 in thread 1:");
					car.cruise();
					// This should accelerate a few times
					int accelerateLoop = 5;
					do {
						try {
							Thread.sleep(500);
						} catch(InterruptedException IE) {
							IE.printStackTrace();
						}
						System.out.println("Event " + Integer.toString(7-accelerateLoop) + " in thread 1:");
						CruiseController.getInstance().accel();
					} while(--accelerateLoop>0);
				}
			}
		).start();
	}

}
