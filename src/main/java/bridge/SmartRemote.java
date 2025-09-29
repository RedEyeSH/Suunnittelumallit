package bridge;

public class SmartRemote extends BasicRemote {
    public SmartRemote(Device device) {
        super(device);
    }

    public void brightnessUp() {
        if (device instanceof SmartTv tv) {
            tv.adjustBrightness(tv.getBrightness() + 10);
        } else {
            System.out.println("This device does not support brightness control.");
        }
    }

    public void brightnessDown() {
        if (device instanceof SmartTv tv) {
            tv.adjustBrightness(tv.getBrightness() - 10);
        } else {
            System.out.println("This device does not support brightness control.");
        }
    }
}
