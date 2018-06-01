package observer_pattern_example;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherdata;

    public CurrentConditionsDisplay(Subject weatherdata){
        this.weatherdata = weatherdata;
        weatherdata.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees, " + humidity + "% humidity and " + pressure + " mbar pressure");
    }
}
