package game.piece;

import game.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static game.Position.withinBoundary;

public class Bishop extends Piece {

    private static final String BLACK_BISHOP = "/images/blackBishop.png";
    private static final String WHITE_BISHOP = "/images/whiteBishop.png";

    private Bishop(Image image, Color color, Position position) {
        super(image, color, position);
    }

    public static Bishop spawnBishop(Position position, Color color) {
        if (color.equals(Color.BLACK)) {
            return new Bishop(new Image(Bishop.class.getResourceAsStream(BLACK_BISHOP)), color, position);
        } else {
            return new Bishop(new Image(Bishop.class.getResourceAsStream(WHITE_BISHOP)), color, position);
        }
    }

    @Override
    public ArrayList<ArrayList<Position>> validMove() {
        ArrayList<ArrayList<Position>> positions = new ArrayList<>();

        ArrayList<Position> position = new ArrayList<>();
        Position targetPosition = getPosition().up().left();
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
    public ArrayList<ArrayList<Position>> validKillMove() {
        return validMove();
    }

    @Override
    public String toString() {
        return "B";
    }

}
