package game.piece;

import game.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static game.Position.withinBoundary;

public class Queen extends Piece {

    private static final String BLACK_QUEEN = "/images/blackQueen.png";
    private static final String WHITE_QUEEN = "/images/whiteQueen.png";

    private Queen(Image image, Color color, Position position) {
        super(image, color, position);
    }

    public static Queen spawnQueen(Position position, Color color) {
        if (color.equals(Color.BLACK)) {
            return new Queen(new Image(Queen.class.getResourceAsStream(BLACK_QUEEN)), color, position);
        } else {
            return new Queen(new Image(Queen.class.getResourceAsStream(WHITE_QUEEN)), color, position);
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


        position = new ArrayList<>();
        targetPosition = getPosition().up().left();
        while (withinBoundary(targetPosition)) {
            position.add(targetPosition.duplicate());
            targetPosition = targetPosition.up().left();
        }
        positions.add(position);

        position = new ArrayList<>();
        targetPosition = getPosition().up().right();
        while (withinBoundary(targetPosition)) {
            position.add(targetPosition.duplicate());
            targetPosition = targetPosition.up().right();
        }
        positions.add(position);

        position = new ArrayList<>();
        targetPosition = getPosition().down().left();
        while (withinBoundary(targetPosition)) {
            position.add(targetPosition.duplicate());
            targetPosition = targetPosition.down().left();
        }
        positions.add(position);

        position = new ArrayList<>();
        targetPosition = getPosition().down().right();
        while (withinBoundary(targetPosition)) {
            position.add(targetPosition.duplicate());
            targetPosition = targetPosition.down().right();
        }
        positions.add(position);

        return positions;
    }

    @Override
    public String toString() {
        return "Q";
    }
}
