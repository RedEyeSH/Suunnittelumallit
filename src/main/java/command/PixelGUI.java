package command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PixelGUI extends Application {

    private static final int CELL_SIZE = 40;
    private PixelGrid pixelGrid = new PixelGrid();
    private Rectangle[][] cells = new Rectangle[8][8];

    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();

        for (int i = 0; i < pixelGrid.getRows(); i++) {
            for (int j = 0; j < pixelGrid.getCols(); j++) {
                Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setStroke(Color.GRAY);
                rect.setFill(Color.WHITE);
                cells[i][j] = rect;
                gridPane.add(rect, j, i);
            }
        }

        Button generateButton = new Button("Create Code");
        generateButton.setFocusTraversable(false);
        generateButton.setOnAction(e -> new GenerateCodeCommand(pixelGrid).execute());

        VBox root = new VBox(10, gridPane, generateButton);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor");

        scene.setOnKeyPressed(e -> {
            Command command = null;
            switch (e.getCode()) {
                case UP -> command = new MoveCursorUpCommand(pixelGrid);
                case DOWN -> command = new MoveCursorDownCommand(pixelGrid);
                case LEFT -> command = new MoveCursorLeftCommand(pixelGrid);
                case RIGHT -> command = new MoveCursorRightCommand(pixelGrid);
                case SPACE -> command = new TogglePixelCommand(pixelGrid);
            }

            if (command != null) {
                command.execute();
                updateGrid();
            }
        });

        stage.show();
        gridPane.requestFocus();
        updateGrid();
    }

    private void updateGrid() {
        for (int i = 0; i < pixelGrid.getRows(); i++) {
            for (int j = 0; j < pixelGrid.getCols(); j++) {
                int value = pixelGrid.getGrid()[i][j];
                cells[i][j].setFill(value == 1 ? Color.BLACK : Color.WHITE);
            }
        }

        int cr = pixelGrid.getCursorRow();
        int cc = pixelGrid.getCursorCol();
        cells[cr][cc].setFill(Color.RED);
    }

    public static void main(String[] args) {
        launch();
    }
}
