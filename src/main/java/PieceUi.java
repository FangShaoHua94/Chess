import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import piece.Piece;

import java.awt.*;
import java.io.IOException;

public class PieceUi extends StackPane {

    private boolean isSelect=false;
    private Board board;
    private Piece piece;
    private int row;
    private int col;

    @FXML
    private ImageView pieceHolder;

    public PieceUi(int row,int col,Board board, Piece piece) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PieceUi.class.getResource("/view/Piece.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.board=board;
        this.piece = piece;
        this.row=row;
        this.col=col;
        pieceHolder.setImage(piece.getImage());
    }

    @FXML
    public void select(){
        if(board.isSelected()&&!isSelect){
            return;
        }

        if(board.isSelected()){
            System.out.println(board.isSelected()+"   UnSelect");
            board.unselect(row,col);
            isSelect=false;
        }else{
            System.out.println(board.isSelected()+" Select  ");
            board.select(row,col);
            isSelect=true;
        }
    }

}
