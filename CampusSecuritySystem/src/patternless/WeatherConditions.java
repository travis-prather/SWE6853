package patternless;

import alertData.*;

public class WeatherConditions {
	
	private WeatherAlertData weatherAlertData;
	
	public void update(AlertData alertData) {
		try {
		WeatherAlertData mWeatherAlertData = (WeatherAlertData) alertData;
		this.weatherAlertData = mWeatherAlertData;
		display();
		} catch (ClassCastException CCE) {
			CCE.printStackTrace();
		}
	}
	
	public void display() {
		System.out.println("there is a weather alert: " + this.weatherAlertData.toString());
	}
}
