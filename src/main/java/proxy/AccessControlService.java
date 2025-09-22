package proxy;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance = new AccessControlService();
    private Set<String> accessSet = new HashSet<>();

    private AccessControlService() {}

    public static AccessControlService getInstance() {
        return instance;
    }

    public void grantAccess(int documentId, String username) {
        accessSet.add(documentId + ":" + username);
    }

    public boolean isAllowed(int documentId, String username) {
        return accessSet.contains(documentId + ":" + username);
    }
}
