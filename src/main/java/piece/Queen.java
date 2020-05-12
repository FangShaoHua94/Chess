package piece;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.InputStream;

public class Queen extends Piece {

    public static final String BLACK_QUEEN = "/images/blackQueen.png";
    public static final String WHITE_QUEEN = "/images/whiteQueen.png";

    private Queen(Image image, Color color, int row, int col) {
        super(image, color, row, col);
    }

    public static Queen spawnBlackQueen(int row, int col, InputStream inputStream) {
        return new Queen(new Image(inputStream), Color.BLACK, row, col);
    }

    public static Queen spawnWhiteQueen(int row, int col, InputStream inputStream) {
        return new Queen(new Image(inputStream), Color.WHITE, row, col);
    }

}
