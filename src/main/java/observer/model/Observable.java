package observer.model;

import observer.view.Observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    public List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(int temperature) {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}
