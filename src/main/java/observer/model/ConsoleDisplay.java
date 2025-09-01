package observer.model;

import observer.view.Observer;

public class ConsoleDisplay implements Observer {
    private String name;

    public ConsoleDisplay(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " ConsoleDisplay: Current temperature: " + temperature + "°C");
    }
}
