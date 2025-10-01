package prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books = new ArrayList<>();

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation cloned = (Recommendation) super.clone();
            cloned.books = new ArrayList<>();
            for (Book book : this.books) {
                cloned.books.add(book.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Audience: " + targetAudience + "\nBooks:\n");
        for (Book book : books) {
            result.append(book).append("\n");
        }
        return result.toString();
    }

}
