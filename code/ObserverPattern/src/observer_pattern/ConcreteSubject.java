package observer_pattern;

import java.util.ArrayList;

public class ConcreteSubject implements Subject {

    private ArrayList<Observer> observers;
    private Object state; // Stellvertretend für alle möglichen Attribute

    public ConcreteSubject(){
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
            observer.update(this.state);
        }
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
        notifyObserver(); // eine Methode wie stateChanged könnte das aufrufen von notifyObserver übernehmen. ka wie effektiv das hier wäre, aber overall vllt nützlich
    }
}
