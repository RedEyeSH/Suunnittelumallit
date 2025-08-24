package factory_method;

public class SwampTile implements Tile {
    @Override
    public char GetCharacter() {
        return 'S';
    }

    @Override
    public String GetType() {
        return "swamp";
    }
}
