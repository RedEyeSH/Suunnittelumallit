package observer;

import observer.model.*;
import observer.view.Observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        Observer user1 = new ConsoleDisplay("User 1");
        Observer user2 = new ConsoleDisplay("User 2");

        station.addObserver(user1);
        station.addObserver(user2);

        Thread thread = new Thread(station);
        thread.start();

        try {
            Thread.sleep(10000);

            System.out.println("Removing user 1 Display");
            station.removeObserver(user1);

            Thread.sleep(10000);

            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
