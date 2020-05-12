package piece;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Piece {

    private Color color;
    private int row;
    private int col;
    private Image image;

    public Piece(Image image, Color color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
        this.image = image;
    }

    public Color getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName();
    }

}
