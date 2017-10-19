package observer.weather;

import java.util.ArrayList;

public class WeatherData {
    private float temperature;
    private float humidity;
    private float pressure;

    CurrentConditionsDisplay currentDisplay;
    StatisticsDisplay statisticsDisplay;
    ForecastDisplay forecastDisplay;

    public WeatherData() {

    }

    public void setCurrentDisplay(CurrentConditionsDisplay currentDisplay) {
        this.currentDisplay = currentDisplay;
    }

    public void setStatisticsDisplay(StatisticsDisplay statisticsDisplay) {
        this.statisticsDisplay = statisticsDisplay;
    }

    public void setForecastDisplay(ForecastDisplay forecastDisplay) {
        this.forecastDisplay = forecastDisplay;
    }

    public void measurementsChanged() {
        currentDisplay.update(temperature, humidity, pressure);
        statisticsDisplay.update(temperature, humidity, pressure);
        forecastDisplay.update(temperature, humidity, pressure);
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
