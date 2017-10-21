package observer.weatherObserver;

import java.util.LinkedList;
import java.util.List;

// This implementation is independent of the number and concrete
// type of displays. We can attach as many displays
// ass we want as long as the display conforms
// to the Observer interface.
public class WeatherData {
    private float temperature;
    private float humidity;
    private float pressure;

    List<Observer> observers;

    public WeatherData() {
        observers = new LinkedList<Observer>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void measurementsChanged() {
        for (Observer observer: observers) {
            observer.update(this);
        }
    }
    
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    
    public float getTemperature() {
        return temperature;
    }
    
    public float getHumidity() {
        return humidity;
    }
    
    public float getPressure() {
        return pressure;
    }   
}
