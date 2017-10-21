package observer.weatherObservable;

import java.util.Observable;

// This implementation is independent of the number and concrete
// type of displays. We can attach as many displays
// ass we want as long as the display conforms
// to the Observer interface.
// In this implementation we use JDK's Observer/Observable
// mechanism.
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }

    public void measurementsChanged() {
        notifyObservers();
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
