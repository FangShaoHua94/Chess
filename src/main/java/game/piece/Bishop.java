package game.piece;

import game.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Bishop extends Piece {

    private static final String BLACK_BISHOP = "/images/blackBishop.png";
    private static final String WHITE_BISHOP = "/images/whiteBishop.png";

    private Bishop(Image image, Color color, Position position) {
        super(image, color, position);
    }

    public static Bishop spawnBishop(Position position,Color color){
        if(color.equals(Color.BLACK)){
            return new Bishop(new Image(Bishop.class.getResourceAsStream(BLACK_BISHOP)), color, position);
        }else{
            return new Bishop(new Image(Bishop.class.getResourceAsStream(WHITE_BISHOP)), color, position);
        }
    }

    @Override
    public ArrayList<Position> validMove() {
        return null;
    }

    @Override
    public ArrayList<Position> validKillMove() {
        return null;
    }

    @Override
    public String toString(){
        return "B";
    }

}
