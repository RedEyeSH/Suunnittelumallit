package composite;

public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void printData(String indent);
    public abstract String getName();
    public abstract double getSalary();
    public abstract void add(Component component);
    public abstract void remove(Component component);
}
