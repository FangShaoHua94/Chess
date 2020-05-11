import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import piece.Piece;

import static piece.Pawn.BLACK_PAWN;
import static piece.Pawn.spawnBlackPawn;

public class Board extends AnchorPane {

    private static final int DIMENSION=8;
    private Piece[][] pieces;

    @FXML
    private GridPane board;

    @FXML
    public void initialize(){
        pieces=new Piece[DIMENSION][DIMENSION];
        setUpPiece();
    }

    private void setUpPiece(){
        for(int i=0;i<DIMENSION;i++){
            for(int j=0;j<DIMENSION;j++){
                pieces[i][j] = spawnBlackPawn(i, j,this.getClass().getResourceAsStream(BLACK_PAWN));
                board.add(pieces[i][j], j, i);
            }
        }
    }


}
