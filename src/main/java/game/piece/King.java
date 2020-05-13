package game.piece;

import game.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class King extends Piece {

    private static final String BLACK_KING = "/images/blackKing.png";
    private static final String WHITE_KING = "/images/whiteKing.png";

    private King(Image image, Color color, Position position) {
        super(image, color, position);
    }

    public static King spawnBlackKing(int row, int col) {
        return new King(new Image(King.class.getResourceAsStream(BLACK_KING)), Color.BLACK, new Position(row, col));
    }

    public static King spawnWhiteKing(int row, int col) {
        return new King(new Image(King.class.getResourceAsStream(WHITE_KING)), Color.WHITE, new Position(row, col));
    }

    @Override
    public ArrayList<Position> validMove() {
        return null;
    }


}
