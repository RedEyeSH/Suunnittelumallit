package proxy;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Library {
    private Map<Integer, DocumentInterface> documents = new HashMap<>();

    public void addDocument(int id, String content, LocalDate date) {
        Document document = new Document(id, content, date);
        documents.put(id, document);
    }

    public void addProtectedDocument(int id, String content, LocalDate date, List<String> allowedUsers) {
        Document document = new Document(id, content, date);
        DocumentProxy proxy = new DocumentProxy(document, allowedUsers);
        documents.put(id, proxy);
    }

    public DocumentInterface getDocument(int id) {
        return documents.get(id);
    }
}