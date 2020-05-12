package piece;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.InputStream;

public class Rook extends Piece {

    public static final String BLACK_ROOK = "/images/blackRook.png";
    public static final String WHITE_ROOK = "/images/whiteRook.png";

    private Rook(Image image, Color color, int row, int col) {
        super(image, color, row, col);
    }

    public static Rook spawnBlackRook(int row, int col, InputStream inputStream) {
        return new Rook(new Image(inputStream), Color.BLACK, row, col);
    }

    public static Rook spawnWhiteRook(int row, int col, InputStream inputStream) {
        return new Rook(new Image(inputStream), Color.WHITE, row, col);
    }

}
