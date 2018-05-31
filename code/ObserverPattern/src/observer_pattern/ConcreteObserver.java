package observer_pattern;

import javaObservable.CurrentConditionDisplay;

public class ConcreteObserver implements Observer {

    private Object state;
    private Subject concretesubject;

    public ConcreteObserver(Subject concretesubject){
        this.concretesubject = concretesubject;
        concretesubject.registerObserver(this);
    }

    @Override
    public void update(Object state) {
        this.state = state;
    }
}
