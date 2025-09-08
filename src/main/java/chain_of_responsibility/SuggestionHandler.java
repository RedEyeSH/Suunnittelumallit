package chain_of_responsibility;

public class SuggestionHandler extends FeedbackHandler {
    @Override
    protected boolean canHandle(MessageType type) {
        return type == MessageType.DEVELOPMENT_SUGGESTION;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("[Suggestion Handler] from " + message.getSenderEmail() + ": " + message.getContent());
    }
}
