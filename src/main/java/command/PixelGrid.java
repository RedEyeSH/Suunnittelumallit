package command;

public class PixelGrid {
    private final int rows = 8;
    private final int cols = 8;
    private int[][] grid = new int[rows][cols];
    private int cursorRow = 0;
    private int cursorCol = 0;

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getCursorRow() {
        return cursorRow;
    }

    public int getCursorCol() {
        return cursorCol;
    }

    public void moveUp() {
        if (cursorRow > 0) {
            cursorRow--;
        }
    }

    public void moveDown() {
        if (cursorRow < rows - 1) {
            cursorRow++;
        }
    }

    public void moveLeft() {
        if (cursorCol > 0) {
            cursorCol--;
        }
    }

    public void moveRight() {
        if (cursorCol < cols - 1) {
            cursorCol++;
        }
    }

    public void togglePixel() {
        grid[cursorRow][cursorCol] = (grid[cursorRow][cursorCol] == 0) ? 1 : 0;
    }

    public String generateJavaCode() {
        StringBuilder sb = new StringBuilder();
        sb.append("int[][] pixelArt = {\n");
        for (int i = 0; i < rows; i++) {
            sb.append("    {");
            for (int j = 0; j < cols; j++) {
                sb.append(grid[i][j]);
                if (j < cols - 1) {
                    sb.append(", ");
                }
            }
            sb.append("}");
            if (i < rows - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append("};");
        return sb.toString();
    }
}
