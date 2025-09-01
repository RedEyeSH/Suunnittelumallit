package observer.model;

import java.util.Random;

public class WeatherStation extends Observable implements Runnable {
    private int temperature;
    private Random random;
    private final int MIN_TEMP = -20;
    private final int MAX_TEMP = 30;

    public WeatherStation() {
        this.random = new Random();
        temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;

    }

    public void updateTemperature() {
        int change = random.nextBoolean() ? 1 : -1;
        temperature += change;

        if (temperature > MAX_TEMP) temperature = MAX_TEMP;
        if (temperature < MIN_TEMP) temperature = MIN_TEMP;

        System.out.println("WeatherStation: Temperature updated: " + temperature + "°C");
        notifyObservers(temperature);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((random.nextInt(5) + 1) * 1000);
                updateTemperature();
            }
        } catch (InterruptedException e) {
            System.out.println("WeatherStation stopped.");
        }
    }
}
