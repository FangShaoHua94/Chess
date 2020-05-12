package piece;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.InputStream;

public class Knight extends Piece {

    public static final String BLACK_KNIGHT = "/images/blackKnight.png";
    public static final String WHITE_KNIGHT = "/images/whiteKnight.png";

    private Knight(Image image, Color color, int row, int col) {
        super(image, color, row, col);
    }

    public static Knight spawnBlackKnight(int row, int col, InputStream inputStream) {
        return new Knight(new Image(inputStream), Color.BLACK, row, col);
    }

    public static Knight spawnWhiteKnight(int row, int col, InputStream inputStream) {
        return new Knight(new Image(inputStream), Color.WHITE, row, col);
    }

}
