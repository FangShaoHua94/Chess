package game.piece;

import game.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Knight extends Piece {

    private static final String BLACK_KNIGHT = "/images/blackKnight.png";
    private static final String WHITE_KNIGHT = "/images/whiteKnight.png";

    private Knight(Image image, Color color, Position position) {
        super(image, color, position);
    }

    public static Knight spawnKnight(Position position,Color color){
        if(color.equals(Color.BLACK)){
            return new Knight(new Image(Knight.class.getResourceAsStream(BLACK_KNIGHT)), color, position);
        }else{
            return new Knight(new Image(Knight.class.getResourceAsStream(WHITE_KNIGHT)), color, position);
        }
    }

    @Override
    public ArrayList<Position> validMove() {
        return null;
    }

    @Override
    public String toString(){
        return "H";
    }
}
