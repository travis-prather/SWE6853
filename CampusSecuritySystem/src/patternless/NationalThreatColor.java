package patternless;

import alertData.*;

public class NationalThreatColor {
	private NationalThreatColorAlertData nationalThreatColorAlertData;
	
	public void update(AlertData alertData) {
		try {
		NationalThreatColorAlertData mNationalThreatColorAlertData = (NationalThreatColorAlertData) 
				alertData;
		this.nationalThreatColorAlertData = mNationalThreatColorAlertData;
		display();
		} catch (ClassCastException CCE) {
			CCE.printStackTrace();
		}
	}
	
	public void display() {
		System.out.println("there is a national threat color level alert: " + this.nationalThreatColorAlertData.toString());
	}
}
