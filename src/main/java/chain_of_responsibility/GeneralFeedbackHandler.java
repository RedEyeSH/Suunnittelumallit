package chain_of_responsibility;

public class GeneralFeedbackHandler extends FeedbackHandler {
    @Override
    protected boolean canHandle(MessageType type) {
        return type == MessageType.GENERAL_FEEDBACK;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("[General Feedback Handler] from " + message.getSenderEmail() + ": " + message.getContent());
    }
}
