package composite;

public class Employee extends Component {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void printData(String indent) {
        System.out.println(indent + "<Employee name=\"" + name + "\" salary=\"" + salary + "\"/>");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Cannot add to an Employee.");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Cannot remove from an Employee.");
    }
}