package game.piece;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static game.Board.DIMENSION;

public abstract class Piece {

    private Color color;
    private Position position;
    private Image image;

    public Piece(Image image, Color color, Position position) {
        this.color = color;
        this.position = position;
        this.image = image;
    }

    public static boolean withinBoundary(int row, int col) {
        return row >= 0 && row < DIMENSION && col >= 0 && col < DIMENSION;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public Image getImage() {
        return image;
    }

    public abstract ArrayList<Position> validMove();

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
