package observer.weatherObservable;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay() {

    }

    @Override
    public void update(Observable o, Object arg) {
        WeatherData data = (WeatherData)o;
        this.temperature = data.getTemperature();
        this.humidity = data.getHumidity();
        display();
    }
	
    public void display() {
        System.out.println("Current conditions: " + temperature 
                           + "F degrees and " + humidity + "% humidity");
    }
}
