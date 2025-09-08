package chain_of_responsibility;

public abstract class FeedbackHandler {
    protected FeedbackHandler nextHandler;

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(Message message) {
        if (canHandle(message.getType())) {
            processMessage(message);
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        } else {
            System.out.println("No handler available for this message: " + message.getContent());
        }
    }

    protected abstract boolean canHandle(MessageType type);
    protected abstract void processMessage(Message message);
}
