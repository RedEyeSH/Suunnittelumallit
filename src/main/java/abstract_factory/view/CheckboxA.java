package abstract_factory.view;

public class CheckboxA extends Checkbox {
    public CheckboxA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[ Checkbox : " + text + " ]");
    }
}
