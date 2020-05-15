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

    public static Queen spawnQueen(Position position,Color color){
        if(color.equals(Color.BLACK)){
            return new Queen(new Image(Queen.class.getResourceAsStream(BLACK_QUEEN)), color, position);
        }else{
            return new Queen(new Image(Queen.class.getResourceAsStream(WHITE_QUEEN)), color, position);
        }
    }

    @Override
    public ArrayList<Position> validMove() {
        return null;
    }


    @Override
    public String toString(){
        return "Q";
    }
}
