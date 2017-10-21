package observer.weatherObserver;

public class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay() {

    }
	
    public void update(WeatherData data) {
        this.temperature = data.getTemperature();
        this.humidity = data.getHumidity();
        display();
    }
	
    public void display() {
        System.out.println("Current conditions: " + temperature 
                           + "F degrees and " + humidity + "% humidity");
    }
}
