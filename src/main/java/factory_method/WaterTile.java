package factory_method;

public class WaterTile implements Tile {
    @Override
    public char GetCharacter() {
        return 'W';
    }

    @Override
    public String GetType() {
        return "water";
    }
}
