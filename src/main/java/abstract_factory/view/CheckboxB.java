package abstract_factory.view;

public class CheckboxB extends Checkbox {
    public CheckboxB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("{ Checkbox : " + text + " }");
    }
}
