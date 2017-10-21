package observer.weather;

public class CurrentConditionsDisplay {
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay() {

    }
	
    public void update(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
	
    public void display() {
        System.out.println("Current conditions: " + temperature 
                           + "F degrees and " + humidity + "% humidity");
    }
}
