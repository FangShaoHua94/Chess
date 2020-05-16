package game.piece;

import game.Position;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static game.Position.withinBoundary;

public class King extends Piece {

    private static final String BLACK_KING = "/images/blackKing.png";
    private static final String WHITE_KING = "/images/whiteKing.png";

    private King(Image image, Color color, Position position) {
        super(image, color, position);
    }

    public static King spawnKing(Position position, Color color) {
        if (color.equals(Color.BLACK)) {
            return new King(new Image(King.class.getResourceAsStream(BLACK_KING)), color, position);
        } else {
            return new King(new Image(King.class.getResourceAsStream(WHITE_KING)), color, position);
        }
    }

    @Override
    public ArrayList<ArrayList<Position>> validMove() {
        ArrayList<ArrayList<Position>> positions = new ArrayList<>();
        ArrayList<Position> position = new ArrayList<>();
        int row=getPosition().getRow();
        int col=getPosition().getCol();
        for(int i=row-1;i<=row+1;i++){
            for(int j=col-1;j<=col+1;j++){
                if(!(i==row && j==col) && withinBoundary(i,j)){
                    position.add(new Position(i,j));
                }
            }
        }
        positions.add(position);
        return positions;
    }

    @Override
    public String toString() {
        return "K";
    }
}
