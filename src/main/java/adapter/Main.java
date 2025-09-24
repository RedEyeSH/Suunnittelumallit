package adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setDay(10);
        date.setMonth(5);
        date.setYear(2026);
        System.out.println("Initial date: " + date.getDay() + "-" + date.getMonth() + "-" + date.getYear());

        date.advanceDays(15);
        System.out.println("After advance: " + date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
    }
}
