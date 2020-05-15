package game.piece;

import game.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Rook extends Piece {

    private static final String BLACK_ROOK = "/images/blackRook.png";
    private static final String WHITE_ROOK = "/images/whiteRook.png";

    private Rook(Image image, Color color, Position position) {
        super(image, color, position);
    }

    public static Rook spawnRook(Position position,Color color){
        if(color.equals(Color.BLACK)){
            return new Rook(new Image(Rook.class.getResourceAsStream(BLACK_ROOK)), color, position);
        }else{
            return new Rook(new Image(Rook.class.getResourceAsStream(WHITE_ROOK)), color, position);
        }
    }

    @Override
    public ArrayList<Position> validMove() {
        return null;
    }

    @Override
    public String toString(){
        return "R";
    }
}
