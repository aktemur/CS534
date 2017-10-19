package observer.weather;

public class CurrentConditionsDisplay implements DisplayElement {
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay() {

    }
	
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
	
    public void display() {
        System.out.println("Current conditions: " + temperature 
                           + "F degrees and " + humidity + "% humidity");
    }
}
