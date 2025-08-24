package factory_method;

public class RoadTile implements Tile {
    @Override
    public char GetCharacter() {
        return 'R';
    }

    @Override
    public String GetType() {
        return "road";
    }
}
