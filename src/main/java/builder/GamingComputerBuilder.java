package builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("AMD Ryzen 7 6800H");
    }

    @Override
    public void buildRAM() {
        computer.setRam(16);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("1 TB NVMe SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA GeForce RTX 3060 6GB");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Home");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
