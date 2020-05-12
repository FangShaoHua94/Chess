package piece;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.InputStream;

public class Bishop extends Piece {

    public static final String BLACK_BISHOP = "/images/blackBishop.png";
    public static final String WHITE_BISHOP = "/images/whiteBishop.png";

    private Bishop(Image image, Color color, int row, int col) {
        super(image, color, row, col);
    }

    public static Bishop spawnBlackBishop(int row, int col, InputStream inputStream) {
        return new Bishop(new Image(inputStream), Color.BLACK, row, col);
    }

    public static Bishop spawnWhiteBishop(int row, int col, InputStream inputStream) {
        return new Bishop(new Image(inputStream), Color.WHITE, row, col);
    }

}
