package abstract_factory;

import abstract_factory.view.*;

public class Main {
    public static void main(String[] args) {
        UIFactory factory = new AFactory();

        Button button = factory.createButton("Ok");
        TextField textField = factory.createTextField("Some text");
        Checkbox checkbox = factory.createCheckbox("[X]");

        button.display();
        textField.display();
        checkbox.display();

        textField.setText("Updated text");
        textField.display();
    }
}
