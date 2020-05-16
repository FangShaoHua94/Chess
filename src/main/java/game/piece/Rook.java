package game.piece;

import game.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static game.Board.SIZE;
import static game.Position.withinBoundary;

public class Rook extends Piece {

    private static final String BLACK_ROOK = "/images/blackRook.png";
    private static final String WHITE_ROOK = "/images/whiteRook.png";

    private Rook(Image image, Color color, Position position) {
        super(image, color, position);
    }

    public static Rook spawnRook(Position position, Color color) {
        if (color.equals(Color.BLACK)) {
            return new Rook(new Image(Rook.class.getResourceAsStream(BLACK_ROOK)), color, position);
        } else {
            return new Rook(new Image(Rook.class.getResourceAsStream(WHITE_ROOK)), color, position);
        }
    }

    @Override
    public ArrayList<ArrayList<Position>> validMove() {
        ArrayList<ArrayList<Position>> positions = new ArrayList<>();

        // up
        ArrayList<Position> position = new ArrayList<>();
        Position targetPosition = getPosition().up();
        while (withinBoundary(targetPosition)) {
            position.add(targetPosition.duplicate());
            targetPosition = targetPosition.up();
        }
        positions.add(position);

        // down
        position = new ArrayList<>();
        targetPosition = getPosition().down();
        while (withinBoundary(targetPosition)) {
            position.add(targetPosition.duplicate());
            targetPosition = targetPosition.down();
        }
        positions.add(position);

        // left
        position = new ArrayList<>();
        targetPosition = getPosition().left();
        while (withinBoundary(targetPosition)) {
            position.add(targetPosition.duplicate());
            targetPosition = targetPosition.left();
        }
        positions.add(position);

        // right
        position = new ArrayList<>();
        targetPosition = getPosition().right();
        while (withinBoundary(targetPosition)) {
            position.add(targetPosition.duplicate());
            targetPosition = targetPosition.right();
        }
        positions.add(position);

        return positions;
    }

    @Override
    public String toString() {
        return "R";
    }
}
