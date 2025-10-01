package mediator;

public interface ChatMediator {
    void addClient(ChatClient client);
    void sendMessage(String message, ChatClient sender, String recipient);
}
