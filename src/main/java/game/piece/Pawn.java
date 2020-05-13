package game.piece;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Pawn extends Piece {

    private static final String BLACK_PAWN = "/images/blackPawn.png";
    private static final String WHITE_PAWN = "/images/whitePawn.png";

    private boolean isFirstMove = true;

    private Pawn(Image image, Color color, Position position) {
        super(image, color, position);
    }

    public static Pawn spawnBlackPawn(int row, int col) {
        return new Pawn(new Image(Pawn.class.getResourceAsStream(BLACK_PAWN)), Color.BLACK, new Position(row, col));
    }

    public static Pawn spawnWhitePawn(int row, int col) {
        return new Pawn(new Image(Pawn.class.getResourceAsStream(WHITE_PAWN)), Color.WHITE, new Position(row, col));
    }

    @Override
    public ArrayList<Position> validMove() {
        ArrayList<Position> positions = new ArrayList<>();
        if (getColor().equals(Color.BLACK)) {

        } else if (getColor().equals(Color.WHITE)) {

        }

        return null;
    }

    public void firstMove() {
        isFirstMove = true;
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }


}
