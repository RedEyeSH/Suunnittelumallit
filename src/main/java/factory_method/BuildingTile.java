package factory_method;

public class BuildingTile implements Tile {
    @Override
    public char GetCharacter() {
        return 'B';
    }

    @Override
    public String GetType() {
        return "building";
    }
}
