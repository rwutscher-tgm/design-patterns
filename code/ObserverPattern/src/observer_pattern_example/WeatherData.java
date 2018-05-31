package observer_pattern_example;

import java.util.ArrayList;

public class WeatherData implements Subject {

    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(observers.indexOf(o) >= 0) observers.remove(o);
    }

    @Override
    public void notifyObserver() { // es wird von jedem Observer die update-Methode aufgerufen
        for(Observer observer: observers){
            observer.update(this.temperature, this.humidity, this.pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged(); // eine Methode wie stateChanged könnte das aufrufen von notifyObserver übernehmen. ka wie effektiv das hier wäre, aber overall vllt nützlich
    }

    private void measurementsChanged() {
        notifyObserver();
    }
}
