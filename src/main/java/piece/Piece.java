package piece;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Piece extends Rectangle {

    public static final int DIMENSION=50;

    private int row;
    private int col;
    private final Color color;
    private Image image;

    public Piece(int row,int col,Color color,Image image){
        this.color=color;
        this.row=row;
        this.col=col;
        this.image=image;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public Color getColor(){
        return color;
    }

}
