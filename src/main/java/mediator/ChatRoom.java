package mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatRoom implements ChatMediator {
    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void addClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String message, ChatClient sender, String recipient) {
        if (recipient.equalsIgnoreCase("All")) {
            for (ChatClient client : clients.values()) {
                if (!client.equals(sender)) {
                    client.receiveMessage(sender.getUsername() + ": " + message);
                }
            }
        } else {
            ChatClient client = clients.get(recipient);
            if (client != null) {
                client.receiveMessage(sender.getUsername() + " (private): " + message);
            }
        }
    }
}
