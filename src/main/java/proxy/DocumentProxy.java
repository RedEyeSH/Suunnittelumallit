package proxy;

import java.time.LocalDate;
import java.util.List;

public class DocumentProxy implements DocumentInterface {
    private Document document;
    private List<String> allowedUsers;

    public DocumentProxy(Document document, List<String> allowedUsers) {
        this.document = document;
        this.allowedUsers = allowedUsers;
    }

    @Override
    public int getId() {
        return document.getId();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (allowedUsers.contains(user.getUsername())) {
            return document.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user (" + user.getUsername() + ") to document " + getId());
        }
    }

    @Override
    public LocalDate getCreationDate() {
        return document.getCreationDate();
    }
}
