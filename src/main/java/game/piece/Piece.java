package game.piece;

import game.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class Piece {

    private Color color;
    private Position position;
    private Image image;

    public Piece(Image image, Color color, Position position) {
        this.color = color;
        this.position = position;
        this.image = image;
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

    public abstract ArrayList<ArrayList<Position>> validMove();

    public ArrayList<ArrayList<Position>> validKillMove(){
        return validMove();
    };

    public void move(Position position) {
        this.position = position;
    }

    ;

    public boolean sameColor(Color color) {
        return this.color.equals(color);
    }

    @Override
    public String toString() {
        return "null";
    }
}
