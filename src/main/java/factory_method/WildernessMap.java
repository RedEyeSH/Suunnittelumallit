package factory_method;

public class WildernessMap extends Map {
    public Tile createTile() {
        int randomVal = (int) (Math.random() * 3);

        if (randomVal == 0) {
            return new SwampTile();
        } else if (randomVal == 1) {
            return new WaterTile();
        } else if (randomVal == 2) {
            return new ForestTile();
        }
        return null;
    }
}
