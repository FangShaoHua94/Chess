package game.piece;

import game.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Queen extends Piece {

    private static final String BLACK_QUEEN = "/images/blackQueen.png";
    private static final String WHITE_QUEEN = "/images/whiteQueen.png";

    private Queen(Image image, Color color, Position position) {
        super(image, color, position);
    }

    public static Queen spawnBlackQueen(int row, int col) {
        return new Queen(new Image(Queen.class.getResourceAsStream(BLACK_QUEEN)), Color.BLACK, new Position(row, col));
    }

    public static Queen spawnWhiteQueen(int row, int col) {
        return new Queen(new Image(Queen.class.getResourceAsStream(WHITE_QUEEN)), Color.WHITE, new Position(row, col));
    }

    @Override
    public ArrayList<Position> validMove() {
        return null;
    }



}
