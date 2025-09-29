package bridge;

public class SmartTv extends Tv {
    private int brightness = 80;

    public void adjustBrightness(int level) {
        brightness = Math.max(0, Math.min(level, 100));
        System.out.println("SmartTV brightness set to " + brightness + "%");
    }

    public int getBrightness() {
        return brightness;
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm Smart TV set.");
        System.out.println("| I'm " + (isEnabled() ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + getVolume() + "%");
        System.out.println("| Current channel is " + getChannel());
        System.out.println("| Current brightness is " + brightness + "%");
        System.out.println("------------------------------------\n");
    }
}
