package chain_of_responsibility;

public class CompensationHandler extends FeedbackHandler {
    @Override
    protected boolean canHandle(MessageType type) {
        return type == MessageType.COMPENSATION_CLAIM;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("[Compensation Handler] from " + message.getSenderEmail() + ": " + message.getContent());
    }
}
