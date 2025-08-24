package factory_method;

public class CityMap extends Map {
    public Tile createTile() {
        int randomVal = (int) (Math.random() * 3);

        if (randomVal == 0) {
            return new RoadTile();
        } else if (randomVal == 1) {
            return new ForestTile();
        } else if (randomVal == 2) {
            return new BuildingTile();
        }
        return null;
    }
}
