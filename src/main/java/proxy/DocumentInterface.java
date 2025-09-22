package proxy;

import java.time.LocalDate;

public interface DocumentInterface {
    int getId();
    String getContent(User user) throws AccessDeniedException;
    LocalDate getCreationDate();
}
