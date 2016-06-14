package patternless;

import alertData.*;

public class CampusThreatInstructions {
	private CampusThreatAlertData campusAlertData;
	
	public void update(AlertData alertData) {
		try {
			CampusThreatAlertData mCampusAlertData = (CampusThreatAlertData) alertData;
		this.campusAlertData = mCampusAlertData;
		display();
		} catch (ClassCastException CCE) {
			CCE.printStackTrace();
		}
	}
	
	public void display() {
		System.out.println("there is a campus alert: " + this.campusAlertData.toString());
	}

}
