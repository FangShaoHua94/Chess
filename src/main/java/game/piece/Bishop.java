package game.piece;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Bishop extends Piece {

    private static final String BLACK_BISHOP = "/images/blackBishop.png";
    private static final String WHITE_BISHOP = "/images/whiteBishop.png";

    private Bishop(Image image, Color color, Position position) {
        super(image, color, position);
    }

    public static Bishop spawnBlackBishop(int row, int col) {
        return new Bishop(new Image(Bishop.class.getResourceAsStream(BLACK_BISHOP)), Color.BLACK, new Position(row, col));
    }

    public static Bishop spawnWhiteBishop(int row, int col) {
        return new Bishop(new Image(Bishop.class.getResourceAsStream(WHITE_BISHOP)), Color.WHITE, new Position(row, col));
    }

    @Override
    public ArrayList<Position> validMove() {
        return null;
    }

}
