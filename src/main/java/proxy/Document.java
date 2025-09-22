package proxy;

import java.time.LocalDate;

public class Document implements DocumentInterface {
    private int id;
    private String content;
    private LocalDate creationDate;

    public Document(int id, String content, LocalDate creationDate) {
        this.id = id;
        this.content = content;
        this.creationDate = creationDate;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        return content;
    }

    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }
}
