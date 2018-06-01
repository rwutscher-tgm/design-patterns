package javaObservable;

import java.util.Observable;
import java.util.Observer;

public class javaCurrentConditionDisplay implements Observer, DisplayElement {

    Observable observable;
    private float temperature;
    private float humidity;
    private float pressure;

    public javaCurrentConditionDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof javaWeatherData){
            javaWeatherData javaweatherdata = (javaWeatherData) o;
            this.temperature = javaweatherdata.getTemperature();
            this.humidity = javaweatherdata.getHumidity();
            this.pressure = javaweatherdata.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current condition: " + this.temperature + "C degrees, "
                + this.humidity + "% humidity and " + this.pressure + " mbar pressure");
    }
}
