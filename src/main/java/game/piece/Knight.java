package game.piece;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Knight extends Piece {

    private static final String BLACK_KNIGHT = "/images/blackKnight.png";
    private static final String WHITE_KNIGHT = "/images/whiteKnight.png";

    private Knight(Image image, Color color, Position position) {
        super(image, color, position);
    }

    public static Knight spawnBlackKnight(int row, int col) {
        return new Knight(new Image(Knight.class.getResourceAsStream(BLACK_KNIGHT)), Color.BLACK, new Position(row, col));
    }

    public static Knight spawnWhiteKnight(int row, int col) {
        return new Knight(new Image(Knight.class.getResourceAsStream(WHITE_KNIGHT)), Color.WHITE, new Position(row, col));
    }

    @Override
    public ArrayList<Position> validMove() {
        return null;
    }

}
