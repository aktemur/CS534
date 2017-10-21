package observer.weather;

// This implementation is highly coupled with concrete display types.
// Consider adding a second CurrentConditionsDisplay or a new HeatIndexDisplay
// to this WeatherData. You will need to make lots of changes.
// Also, if the displays' interfaces change, WeatherData class will be broken and
// will need to be fixed.
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
        currentDisplay.update(temperature, humidity);
        statisticsDisplay.update(temperature);
        forecastDisplay.update(pressure);
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
