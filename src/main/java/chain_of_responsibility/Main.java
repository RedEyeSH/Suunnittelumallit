package chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        FeedbackHandler compensationHandler = new CompensationHandler();
        FeedbackHandler contactHandler = new ContactHandler();
        FeedbackHandler suggestionHandler = new SuggestionHandler();
        FeedbackHandler generalFeedbackHandler = new GeneralFeedbackHandler();

        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalFeedbackHandler);

        Message[] messages = {
                new Message(MessageType.COMPENSATION_CLAIM, "I received the wrong item in my order.", "Alice@gmail.com"),
                new Message(MessageType.CONTACT_REQUEST, "I need help setting up my account.", "Henry@gmail.com"),
                new Message(MessageType.DEVELOPMENT_SUGGESTION, "You should add dark mode to the app.", "Kevin@gmail.com"),
                new Message(MessageType.GENERAL_FEEDBACK, "Customer support was very helpful!", "William@gmail.com")
        };

        for (Message message : messages) {
            compensationHandler.handle(message);
        }
    }
}
