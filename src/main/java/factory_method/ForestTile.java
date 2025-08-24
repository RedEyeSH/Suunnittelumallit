package factory_method;

public class ForestTile implements Tile {
    @Override
    public char GetCharacter() {
        return 'F';
    }

    @Override
    public String GetType() {
        return "forest";
    }
}
