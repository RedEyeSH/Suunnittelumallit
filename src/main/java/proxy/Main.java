package proxy;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        User user1 = new User("user1");
        User user2 = new User("user2");

        library.addDocument(1, "content", LocalDate.now());
        library.addProtectedDocument(2, "protected content", LocalDate.now(), List.of("user1"));

        try {
            System.out.println("(" + user1.getUsername() + ") reads document 1: " + library.getDocument(1).getContent(user1));
            System.out.println("(" + user2.getUsername() + ") reads document 1: " + library.getDocument(1).getContent(user2));

            System.out.println("(" + user1.getUsername() + ") reads document 2: " + library.getDocument(2).getContent(user1));
            System.out.println("(" + user2.getUsername() + ") reads document 2: " + library.getDocument(2).getContent(user2));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
