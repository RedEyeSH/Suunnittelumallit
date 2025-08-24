package factory_method;

public abstract class Map {
    public abstract Tile createTile();

    public void display(int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Tile tile = createTile();
                System.out.print(tile.GetCharacter() + " ");
            }
            System.out.println();
        }
    }
}
