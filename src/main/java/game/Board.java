package game;

import game.piece.Piece;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;

import static game.piece.Bishop.spawnBlackBishop;
import static game.piece.Bishop.spawnWhiteBishop;
import static game.piece.King.spawnBlackKing;
import static game.piece.King.spawnWhiteKing;
import static game.piece.Knight.spawnBlackKnight;
import static game.piece.Knight.spawnWhiteKnight;
import static game.piece.Pawn.spawnBlackPawn;
import static game.piece.Pawn.spawnWhitePawn;
import static game.piece.Queen.spawnBlackQueen;
import static game.piece.Queen.spawnWhiteQueen;
import static game.piece.Rook.spawnBlackRook;
import static game.piece.Rook.spawnWhiteRook;

public class Board extends AnchorPane {

    public static final int DIMENSION = 8;
    private static final Color PALE_BASE = Color.web("#e6ccab");
    private static final Color DARK_BASE = Color.web("#9d571b");
    private static final Color SELECTED_BASE = Color.SKYBLUE;
    private static final Color VALID_KILL_BASE = Color.RED;
    private static final Color VALID_MOVE_BASE = Color.GREEN;
    private static final int BORDER_WIDTH = 30;
    private Piece[][] board;
    private Rectangle[][] tiles;
    private boolean selected = false;

    @FXML
    private StackPane base;

    @FXML
    private GridPane grid;

    @FXML
    public void initialize() {
        board = new Piece[DIMENSION][DIMENSION];
        tiles = new Rectangle[DIMENSION][DIMENSION];
        setUpTile();
        setUpPiece();
    }

    private void setUpTile() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                tiles[i][j] = new Rectangle(50, 50);
                if ((i + j) % 2 == 0) {
                    tiles[i][j].setFill(PALE_BASE);
                } else {
                    tiles[i][j].setFill(DARK_BASE);
                }
                grid.add(tiles[i][j], j, i);
            }
        }
    }

    private void setUpPiece() {
        for (int i = 0; i < DIMENSION; i++) {
            board[1][i] = spawnBlackPawn(1, i);
            board[6][i] = spawnWhitePawn(6, i);
            switch (i) {
            case 0:
            case 7:
                board[0][i] = spawnBlackRook(1, i);
                board[7][i] = spawnWhiteRook(1, i);
                break;
            case 1:
            case 6:
                board[0][i] = spawnBlackKnight(1, i);
                board[7][i] = spawnWhiteKnight(1, i);
                break;
            case 2:
            case 5:
                board[0][i] = spawnBlackBishop(1, i);
                board[7][i] = spawnWhiteBishop(1, i);
                break;
            case 3:
                board[0][i] = spawnBlackQueen(1, i);
                board[7][i] = spawnWhiteKing(1, i);
                break;
            case 4:
                board[0][i] = spawnBlackKing(1, i);
                board[7][i] = spawnWhiteQueen(1, i);
                break;
            default:
                break;
            }
        }
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (i < 2 || i > 5) {
                    grid.add(new PieceUi(i, j, this, board[i][j]), j, i);
                }
            }
        }
    }

    public void select(int row, int col) {
        selected = true;
        tiles[row][col].setFill(SELECTED_BASE);
    }

    public void unselect(int row, int col) {
        selected = false;
        if ((row + col) % 2 == 0) {
            tiles[row][col].setFill(PALE_BASE);
        } else {
            tiles[row][col].setFill(DARK_BASE);
        }
    }

    public boolean isSelected() {
        return selected;
    }

    public void showValidMove(ArrayList<Position> validMove,Color color) {
        for(Position position:validMove){
            // valid move on empty tile
            if(getPiece(position)==null){
                getRectangle(position).setFill(VALID_MOVE_BASE);
            }

            // valid move on opposite color tile
            if (getPiece(position)!=null && !getPiece(position).sameColor(color)){
                getRectangle(position).setFill(VALID_KILL_BASE);
            }
        }
    }

    private Piece getPiece(Position position){
        return board[position.getRow()][position.getCol()];
    }

    private Rectangle getRectangle(Position position){
        return tiles[position.getRow()][position.getCol()];
    }


}
