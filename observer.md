[back](README.md)

# Observer Pattern

### Problem

Bei dem Observer Pattern gibt es ein Objekt(Subjekt), dessen Daten sich ändern. Dazu gibt es auch Objekte, welche das Subjekt beobachten, die Observer. Diese wollen informiert werden, wenn sich die Daten des Subjektes ändern. Darauf hin erhalten die Observer auch die geänderten Daten. Es können mehrere Observer ein Subjekt beobachten. <small> Des Weiteren können die Beobachter sich anmelden(um die Daten zu erhalten, anmelden zum beobachten), abmelden(falls man die Daten nicht mehr haben will) und müssen natürlich informiert werden. Dies ist ähnlich wie bei einem Abonnement. </small>
Hier kommt außerdem ein neues OO Principle ins Spiel: *strive for loosely coupled designs between objects that interact*. Wenn sich ein Observer abmeldet, sollen die anderen weiterhin ihre Daten erhalten. Der Betrieb geht weiter, da das Subjekt nicht von den Observern abhängig ist und auch umgekehrt.

### Lösung

Auch beim Observer Pattern gibt es wieder mehr als nur eine Möglichkeit das Problem zu lösen.

1. *Java Observable*
![Observable](https://github.com/TGM-HIT/sew4-design-patterns-ntesanovic-tgm/blob/master/images/java_observable.png)
<small>[Head First Design Patterns](http://shop.oreilly.com/product/9780596007126.do) Seite 64</small>

Bei dieser Lösung wird die in Java eingebaute Version des Observer Patterns verwendet. Das Problem bei dieser Variante des Observer Patterns ist, dass java.util.Observable eine Klasse ist. Das heißt, dass einige OO Principles wieder missachtet werden, da wir Vererbung statt Interfaces benutzen müssen.
2. ***Observer Pattern*** <small>(aus dem Buch)</small>  
![Observer_Pattern](https://github.com/TGM-HIT/sew4-design-patterns-ntesanovic-tgm/blob/master/images/observer.png)
<small>[Head First Design Patterns](http://shop.oreilly.com/product/9780596007126.do) Seite 52</small>

Hier haben wir nun die vom Buch vorgeschlagene Variante. Wir haben ein Interface für das Subjekt und wir haben ein Interface für die Observer. Es wird gezeigt, dass *Subject* eine HAS-A-Beziehung zu *Observer* hat. Das heißt, dass das Subjekt Beobachter hat. Allerdings gibt es hier auch noch eine HAS-A-Beziehung zwischen den konkreten Implementierungen. Dies ist etwas, was wir schon vorher als eher unerwünscht betrachtet haben. Allerdings kann man dadurch eine notify-Methode erstellen ohne Attribute. <small> Wieso dies so wichtig ist, weiß ich gerade auch nicht. </small>

### Beispiel

![Observer_Pattern_Beispiel](https://github.com/TGM-HIT/sew4-design-patterns-ntesanovic-tgm/blob/master/images/observer_example.png)
<small>[Head First Design Patterns](http://shop.oreilly.com/product/9780596007126.do) Seite 56</small>

In diesem Beispiel wollen wir die Daten einer Wetterstation erhalten und diese dann an alle Observer weitergeben. Wenn sich also das Wetter ändert, werden alle registrierten Beobachter, benachrichtigt und, da jedes der Displays schon ein WeatherData-Objekt besitzt, muss für *update* auch kein Parameter übergeben werden, um zu wissen, bei welchem Objekt sich die Daten geändert haben. Daraufhin können die Daten dann ausgegeben werden.  
Das Observer Pattern wird außerdem bei z.B. Java Swing verwendet -> Listeners.

### Beispielcode

*java.util.Observable*:
Die Klasse WeatherData erweitert das von *java* bereitgestellte Observable.
~~~ java
import java.util.Observable;

public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){} // here you would create a structure (e.g. ArrayList) to hold all Observers

    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public void createNewZeitung(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
   //getter-Methoden
}
~~~

~~~ java
public interface DisplayElement {
    void display();
}
~~~

Der Observer implementiert Observer von java.util und wird zu den Observern des Observables hizugefügt.

~~~ java
import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {

    Observable observable;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current condition: " + this.temperature + "C degrees, "
                + this.humidity + "% humidity and " + this.pressure + " mbar pressure");
    }
}
~~~

*eigene Implementierung*

Das Interface definiert die Methoden, welche für die Interaktionen mit den Observern genutzt werden.

~~~ java
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
~~~

Im Gegensatz zu der javainternen Implementierung, brauchen wir hier nun eine ArrayList, welche alle Observer beinhaltet, um ihnen auch die Daten senden zu können. Des Weiteren implementiert die Klasse das Subject-Interface und muss somit die Observer verwalten.

~~~ java
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
        measurementsChanged();
    }

    private void measurementsChanged() {
        notifyObserver();
    }
}

~~~

Das Interface, welche alle Klassen implementieren müssen, falls sie die Daten des Observable, hier die Wetterdaten, erhalten wollen.

~~~ java
public interface Observer {
    void update(float temperature, float humidity, float pressure);
}
~~~

Diese Klasse implementiert das Observer-Interface und wird somit benachrichtigt, wenn sich die Wetterdaten geändert haben.

~~~ java
public class CurrentConditionsDisplay implements Observer {
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
    }
    // code für weiteres
}
~~~