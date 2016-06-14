package patternless;

import alertData.*;

public class CampusSecurity {
	private WeatherConditions weatherConditions;
	private CampusThreatInstructions campusThreatInstructions;
	private NationalThreatColor nationalThreatColor;
	
	public CampusSecurity(){
		this.weatherConditions = new WeatherConditions();
		this.campusThreatInstructions = new CampusThreatInstructions();
		this.nationalThreatColor = new NationalThreatColor();
	}
	
	public void alertsChanged() {
		this.weatherConditions.update(new WeatherAlertData());
		this.campusThreatInstructions.update(new CampusThreatAlertData());
		this.nationalThreatColor.update(new NationalThreatColorAlertData());
	}
}
