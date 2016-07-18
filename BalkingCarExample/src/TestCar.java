
public class TestCar {

	public static void main(String[] args) {
		Car car = new Car();
		
		// Create test thread 1
		new Thread(
			new Runnable() {
				@Override
				public void run() {
					// This should fail
					System.out.println("Attempting fail case in thread 1:");
					car.accelerate();
					try {
						Thread.sleep(1000);
					} catch(InterruptedException IE) {
						IE.printStackTrace();
					}
					// This should succeed
					System.out.println("Attempting success case in thread 1:");
					car.accelerate();
				}
			}
		).start();
				
		// Create test thread 2
		new Thread(
			new Runnable() {
				@Override
				public void run() {
					// This should pass
					System.out.println("Attempting success case 1 in thread 2:");
					car.start();
					car.accelerate();
					try {
						Thread.sleep(1500);
					} catch(InterruptedException IE) {
						IE.printStackTrace();
					}
					// This should also pass
					System.out.println("Attempting success case 2 in thread 2:");
					car.brake();
				}
			}
		).start();
	}

}
