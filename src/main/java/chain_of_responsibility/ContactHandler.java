package chain_of_responsibility;

public class ContactHandler extends FeedbackHandler {
    @Override
    protected boolean canHandle(MessageType type) {
        return type == MessageType.CONTACT_REQUEST;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("[Contact Handler] from " + message.getSenderEmail() + ": " + message.getContent());
    }
}
