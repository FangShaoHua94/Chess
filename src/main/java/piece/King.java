package piece;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.InputStream;

public class King extends Piece {

    public static final String BLACK_KING = "/images/blackKing.png";
    public static final String WHITE_KING = "/images/whiteKing.png";

    private King(Image image, Color color, int row, int col) {
        super(image, color, row, col);
    }

    public static King spawnBlackKing(int row, int col, InputStream inputStream) {
        return new King(new Image(inputStream), Color.BLACK, row, col);
    }

    public static King spawnWhiteKing(int row, int col, InputStream inputStream) {
        return new King(new Image(inputStream), Color.WHITE, row, col);
    }

}
