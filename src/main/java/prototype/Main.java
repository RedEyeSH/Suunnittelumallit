package prototype;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Head First Java", "Kathy Sierra & Bert Bates", "Programming", 2005);
        Book book2 = new Book("Python Crash Course", "Eric Matthes", "Programming", 2015);

        Recommendation rec1 = new Recommendation("Beginner Programmers");
        rec1.addBook(book1);

        Recommendation rec2 = rec1.clone();
        rec2.setTargetAudience("Advanced Programmers");
        rec2.addBook(book2);

        System.out.println("Original:");
        System.out.println(rec1);

        System.out.println("Cloned and modified:");
        System.out.println(rec2);
    }
}
