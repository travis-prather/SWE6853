public class CruiseController {

	private volatile static CruiseController cruiseController;
	private int cruisingSpeed = 0;
	
	private CruiseController() {}
	
	public static CruiseController getInstance() {
		if(cruiseController == null) {
			synchronized(CruiseController.class) {
				if(cruiseController == null) {
					cruiseController = new CruiseController();
				}
			}
		}
		return cruiseController;
	}
	
	public void setSpeed(int speed) {
		cruisingSpeed = speed;
		System.out.println("Cruise control set to " + cruisingSpeed);
	}
	
	public int getSpeed() {
		return cruisingSpeed;
	}
	
	public void accel() {
		cruisingSpeed++;
		System.out.println("Cruise control set to " + cruisingSpeed);
	}
	
	public void decel() {
		if(cruisingSpeed<1)
			cruisingSpeed = 0;
		else
			cruisingSpeed--;
		System.out.println("Cruise control set to " + cruisingSpeed);
	}
	
	public void cancel() {
		cruisingSpeed = 0;
		System.out.println("Cruise cancelled");
	}
}
