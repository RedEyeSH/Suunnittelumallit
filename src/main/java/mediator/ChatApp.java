package mediator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class ChatApp extends Application {
    private final List<String> usernames = Arrays.asList("Flame", "Aris", "Tom");

    @Override
    public void start(Stage primaryStage) {
        ChatMediator mediator = new ChatRoom();

        for (String user : usernames) {
            createClientWindow(user, mediator);
        }
    }

    private void createClientWindow(String username, ChatMediator mediator) {
        Stage stage = new Stage();
        stage.setTitle("Chat - " + username);

        TextArea messageArea = new TextArea();
        messageArea.setEditable(false);

        TextField messageField = new TextField();
        messageField.setPromptText("Type your message here...");

        ComboBox<String> recipientBox = new ComboBox<>();
        recipientBox.getItems().add("All");
        recipientBox.getItems().addAll(usernames);
        recipientBox.getItems().remove(username);
        recipientBox.setValue("All");

        Button sendButton = new Button("Send");
        sendButton.setStyle("-fx-background-color: #1E3A8A; -fx-text-fill: white; -fx-font-weight: bold;");

        ChatClient client = new ChatClient(username, mediator, messageArea, messageField, recipientBox);
        sendButton.setOnAction(e -> client.sendMessage());

        VBox vbox = new VBox(8, messageArea, messageField, recipientBox, sendButton);
        vbox.setPadding(new Insets(10));
        vbox.setStyle("-fx-background-color: #d1e0ff;");

        sendButton.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(messageArea, javafx.scene.layout.Priority.ALWAYS);

        Scene scene = new Scene(vbox, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
