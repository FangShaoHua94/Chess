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

    public static Pawn spawnPawn(Position position, Color color){
        if(color.equals(Color.BLACK)){
            return new Pawn(new Image(Pawn.class.getResourceAsStream(BLACK_PAWN)), color, position);
        }else{
            return new Pawn(new Image(Pawn.class.getResourceAsStream(WHITE_PAWN)), color, position);
        }
    }

    @Override
    public ArrayList<ArrayList<Position>> validMove() {
        ArrayList<ArrayList<Position>> positions = new ArrayList<>();
        ArrayList<Position> position = new ArrayList<>();

        if(withinBoundary(getPosition().by(getColor()))){
            position.add(getPosition().by(getColor()));
        }

        if(isFirstMove && withinBoundary(getPosition().by(getColor()).by(getColor()))){
            position.add(getPosition().by(getColor()).by(getColor()));
        }
        positions.add(position);
        return positions;
    }

    @Override
    public ArrayList<ArrayList<Position>> validKillMove() {
        ArrayList<ArrayList<Position>> positions = new ArrayList<>();
        ArrayList<Position> position = new ArrayList<>();

        if(withinBoundary(getPosition().by(getColor()).left())){
            position.add(getPosition().by(getColor()).left());
        }

        if(withinBoundary(getPosition().by(getColor()).right())){
            position.add(getPosition().by(getColor()).right());
        }
        positions.add(position);
        return positions;
    }

    @Override
    public void move(Position position) {
        isFirstMove=false;
        super.move(position);
    }

    @Override
    public String toString(){
        return "P";
    }
}
