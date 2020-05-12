package piece;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Pawn extends Piece {

    private Pawn(int row, int col, Color color,Image image ){
        super(row, col, color,image);
    }

    public static Pawn spawnBlackPawn(int row,int col) throws FileNotFoundException {
        return new Pawn(row,col,Color.BLACK,new Image(new FileInputStream("src\\main\\resources\\images\\blackPawn.png")));
    }
}
