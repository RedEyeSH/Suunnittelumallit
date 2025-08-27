package composite;

public class Main {
    public static void main(String[] args) {
        Component organization = new Department("Organization");

        Department it = new Department("IT Department");
        Department dev = new Department("Development");

        Employee emp1 = new Employee("Alice", 44000);
        Employee emp2 = new Employee("Henry", 53000);
        Employee emp3 = new Employee("Kevin", 54000);
        Employee emp4 = new Employee("William", 580000);

        it.add(emp1);
        it.add(emp2);

        dev.add(emp3);
        dev.add(emp4);

        organization.add(it);
        organization.add(dev);

        organization.printData("");

        System.out.println("\nTotal Salary: " + organization.getSalary());
    }
}