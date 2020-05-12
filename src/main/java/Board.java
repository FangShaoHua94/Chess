import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import piece.Piece;

import static piece.Bishop.BLACK_BISHOP;
import static piece.Bishop.WHITE_BISHOP;
import static piece.Bishop.spawnBlackBishop;
import static piece.Bishop.spawnWhiteBishop;
import static piece.King.BLACK_KING;
import static piece.King.WHITE_KING;
import static piece.King.spawnBlackKing;
import static piece.King.spawnWhiteKing;
import static piece.Knight.BLACK_KNIGHT;
import static piece.Knight.WHITE_KNIGHT;
import static piece.Knight.spawnBlackKnight;
import static piece.Knight.spawnWhiteKnight;
import static piece.Pawn.BLACK_PAWN;
import static piece.Pawn.WHITE_PAWN;
import static piece.Pawn.spawnBlackPawn;
import static piece.Pawn.spawnWhitePawn;
import static piece.Queen.BLACK_QUEEN;
import static piece.Queen.WHITE_QUEEN;
import static piece.Queen.spawnBlackQueen;
import static piece.Queen.spawnWhiteQueen;
import static piece.Rook.BLACK_ROOK;
import static piece.Rook.WHITE_ROOK;
import static piece.Rook.spawnBlackRook;
import static piece.Rook.spawnWhiteRook;

public class Board extends AnchorPane {

    private static final int DIMENSION = 8;
    private Piece[][] board;

    @FXML
    private StackPane base;

    @FXML
    private GridPane grid;

    @FXML
    public void initialize() {
        board = new Piece[DIMENSION][DIMENSION];
        setUpPiece();
    }

    private void setUpPiece() {
        for(int i=0;i<DIMENSION;i++){
            board[1][i]=spawnBlackPawn(1, i, getClass().getResourceAsStream(BLACK_PAWN));
            board[6][i]=spawnWhitePawn(6, i, getClass().getResourceAsStream(WHITE_PAWN));
            switch (i){
            case 0:
            case 7:
                board[0][i]=spawnBlackRook(1, i, getClass().getResourceAsStream(BLACK_ROOK));
                board[7][i]=spawnWhiteRook(1, i, getClass().getResourceAsStream(WHITE_ROOK));
                break;
            case 1:
            case 6:
                board[0][i]=spawnBlackKnight(1, i, getClass().getResourceAsStream(BLACK_KNIGHT));
                board[7][i]=spawnWhiteKnight(1, i, getClass().getResourceAsStream(WHITE_KNIGHT));
                break;
            case 2:
            case 5:
                board[0][i]=spawnBlackBishop(1, i, getClass().getResourceAsStream(BLACK_BISHOP));
                board[7][i]=spawnWhiteBishop(1, i, getClass().getResourceAsStream(WHITE_BISHOP));
                break;
            case 3:
                board[0][i]=spawnBlackQueen(1, i, getClass().getResourceAsStream(BLACK_QUEEN));
                board[7][i]=spawnWhiteKing(1, i, getClass().getResourceAsStream(WHITE_KING));
                break;
            case 4:
                board[0][i]=spawnBlackKing(1, i, getClass().getResourceAsStream(BLACK_KING));
                board[7][i]=spawnWhiteQueen(1, i, getClass().getResourceAsStream(WHITE_QUEEN));
                break;
            default:
                break;
            }
        }
        for(int i=0;i<DIMENSION;i++){
            for(int j=0;j<DIMENSION;j++){
               if(i<2||i>5) {
                   grid.add(new PieceUi(board[i][j]), j, i);
               }
            }
        }
    }


}
