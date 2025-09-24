package builder;

public class Computer {
    private String processor;
    private int ram;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Processor: " + processor + "\n");
        sb.append("RAM: " + ram + "\n");
        sb.append("Hard Drive: " + hardDrive + "\n");
        sb.append("Graphics Card: " + graphicsCard + "\n");
        sb.append("Operating System: " + operatingSystem + "\n");

        return sb.toString();
    }
}
