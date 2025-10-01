package mediator;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class ChatClient {
    private String username;
    private ChatMediator mediator;

    private TextArea messageArea;
    private TextField messageField;
    private ComboBox<String> recipientBox;

    public ChatClient(String username, ChatMediator mediator, TextArea messageArea, TextField messageField, ComboBox<String> recipientBox) {
        this.username = username;
        this.mediator = mediator;
        this.messageArea = messageArea;
        this.messageField = messageField;
        this.recipientBox = recipientBox;
        mediator.addClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage() {
        String recipient = recipientBox.getValue();
        String message = messageField.getText();
        if (message != null && !message.isEmpty()) {
            mediator.sendMessage(message, this, recipient);
            messageField.clear();
            messageArea.appendText("Me to " + recipient + ": " + message + "\n");
        }
    }

    public void receiveMessage(String message) {
        messageArea.appendText(message + "\n");
    }
}
