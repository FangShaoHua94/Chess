package game.piece;

import game.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static game.Position.withinBoundary;

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
        if (getColor().equals(Color.BLACK)) {
            return blackMove();
        } else {
           return whiteMove();
        }
    }

    @Override
    public void move(Position position) {
        isFirstMove=false;
        super.move(position);
    }

    private ArrayList<Position> blackMove(){
        ArrayList<Position> positions = new ArrayList<>();
        if(withinBoundary(getPosition().down())){
            positions.add(getPosition().down());
        }
        if(isFirstMove && withinBoundary(getPosition().down().down())){
            positions.add(getPosition().down().down());
        }
        return positions;
    }

    private ArrayList<Position> whiteMove(){
        ArrayList<Position> positions = new ArrayList<>();
        if(withinBoundary(getPosition().up())){
            positions.add(getPosition().up());
        }
        if(isFirstMove && withinBoundary(getPosition().up().up())){
            positions.add(getPosition().up().up());
        }
        return positions;
    }

}
