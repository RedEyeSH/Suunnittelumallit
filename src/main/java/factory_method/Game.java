package factory_method;

public class Game {
    private static Map createMap() {
        int randomVal = (int) (Math.random() * 2);

        if (randomVal == 0) {
            return new CityMap();
        } else if (randomVal == 1) {
            return new WildernessMap();
        }
        return null;
    }

    public static void main(String[] args) {
        Map map = createMap();
        if (map != null) {
            map.display(5, 5);
        }
    }
}
