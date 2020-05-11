package piece;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.InputStream;

import static java.util.Objects.requireNonNull;

public class Pawn extends Piece{

    public static final String BLACK_PAWN="/images/blackPawn.png";
    private static final String WHITE_PAWN="/images/whitePawn.png";

    private Pawn(Image image,Color color,int row,int col) {
        super(image,color,row,col);
    }

    public static Pawn spawnBlackPawn(int row, int col, InputStream inputStream){
        return new Pawn(new Image(inputStream),Color.BLACK,row,col);
    }

//    public static Pawn spawnWhitePawn(int row,int col){
//        return new Pawn(new Image(getClass().getResourceAsStream(WHITE_PAWN)),Color.WHITE,row,col);
//    }
}
