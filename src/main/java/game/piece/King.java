package game.piece;

import game.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class King extends Piece {

    private static final String BLACK_KING = "/images/blackKing.png";
    private static final String WHITE_KING = "/images/whiteKing.png";

    private King(Image image, Color color, Position position) {
        super(image, color, position);
    }

    public static King spawnKing(Position position,Color color){
        if(color.equals(Color.BLACK)){
            return new King(new Image(King.class.getResourceAsStream(BLACK_KING)), color, position);
        }else{
            return new King(new Image(King.class.getResourceAsStream(WHITE_KING)), color, position);
        }
    }

    @Override
    public ArrayList<Position> validMove() {
        return null;
    }

    @Override
    public String toString(){
        return "K";
    }
}
