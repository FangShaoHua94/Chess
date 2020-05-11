package piece;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Piece extends StackPane {

    private Color color;
    private int row;
    private int col;

    @FXML
    private ImageView pieceHolder;

    public Piece(Image image,Color color,int row,int col){
        pieceHolder.setImage(image);
        this.color=color;
        this.row=row;
        this.col=col;
    }

    public Color getColor(){
        return color;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

}
