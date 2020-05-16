package game.piece;

import game.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static game.Position.withinBoundary;

public class Knight extends Piece {

    private static final String BLACK_KNIGHT = "/images/blackKnight.png";
    private static final String WHITE_KNIGHT = "/images/whiteKnight.png";

    private Knight(Image image, Color color, Position position) {
        super(image, color, position);
    }

    public static Knight spawnKnight(Position position, Color color) {
        if (color.equals(Color.BLACK)) {
            return new Knight(new Image(Knight.class.getResourceAsStream(BLACK_KNIGHT)), color, position);
        } else {
            return new Knight(new Image(Knight.class.getResourceAsStream(WHITE_KNIGHT)), color, position);
        }
    }

    @Override
    public ArrayList<ArrayList<Position>> validMove() {
        ArrayList<ArrayList<Position>> positions = new ArrayList<>();
        ArrayList<Position> position = new ArrayList<>();

        // up
        if (withinBoundary(getPosition().up().up().left())) {
            position.add(getPosition().up().up().left());
        }
        if (withinBoundary(getPosition().up().up().right())) {
            position.add(getPosition().up().up().right());
        }
        // down
        if (withinBoundary(getPosition().down().down().left())) {
            position.add(getPosition().down().down().left());
        }
        if (withinBoundary(getPosition().down().down().right())) {
            position.add(getPosition().down().down().right());
        }
        // right
        if (withinBoundary(getPosition().right().right().down())) {
            position.add(getPosition().right().right().down());
        }
        if (withinBoundary(getPosition().right().right().up())) {
            position.add(getPosition().right().right().up());
        }
        // left
        if (withinBoundary(getPosition().left().left().up())) {
            position.add(getPosition().left().left().up());
        }
        if (withinBoundary(getPosition().left().left().down())) {
            position.add(getPosition().left().left().down());
        }

        positions.add(position);
        return positions;
    }

    @Override
    public ArrayList<ArrayList<Position>> validKillMove() {
        return validMove();
    }

    @Override
    public String toString() {
        return "H";
    }
}
