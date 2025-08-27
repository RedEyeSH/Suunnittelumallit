package composite;

import java.util.*;

public class Department extends Component {
    private List<Component> components = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void printData(String indent) {
        System.out.println(indent + "<Department name=\"" + name + "\">");
        for (Component component : components) {
            component.printData(indent + "  ");
        }
        System.out.println(indent + "</Department>");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        double total = 0;
        for (Component component : components) {
            total += component.getSalary();
        }
        return total;
    }

    @Override
    public void add(Component component) {
        this.components.add(component);
    }

    @Override
    public void remove(Component component) {
       this.components.remove(component);
    }
}
