package javaObservable;

import java.util.Date;
import java.util.Observable;

public class javaWeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public javaWeatherData(){} // here you would create a structure (e.g. ArrayList) to hold all Observers

    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
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
