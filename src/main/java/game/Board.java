package game;

import game.piece.Piece;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static game.Tile.spawnDarkTile;
import static game.Tile.spawnPaleTile;
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
    private Piece[][] board;
    private Tile[][] tiles;
    private boolean selected = false;
    private ArrayList<Tile> highlightedTiles;

    @FXML
    private StackPane base;

    @FXML
    private GridPane grid;

    @FXML
    public void initialize() {
        board = new Piece[DIMENSION][DIMENSION];
        tiles = new Tile[DIMENSION][DIMENSION];
        highlightedTiles= new ArrayList<>();
        setUpTile();
        setUpPiece();
    }

    private void setUpTile() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if ((i + j) % 2 == 0) {
                    tiles[i][j] = spawnPaleTile();
                } else {
                    tiles[i][j] = spawnDarkTile();
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
        tiles[row][col].setSelectedBase();
    }

    public void unselect(int row, int col) {
        selected = false;
        tiles[row][col].setOriginalColor();
        highlightedTiles.forEach(Tile::setOriginalColor);
        highlightedTiles.clear();
    }

    public boolean isSelected() {
        return selected;
    }

    public void showValidMove(ArrayList<Position> validMove,Color color) {
        for(Position position:validMove){
            // invalid move on friendly piece
            if(getPiece(position)!=null && getPiece(position)!=null && getPiece(position).sameColor(color)){
                continue;
            }

            highlightedTiles.add(getTile(position));
            // valid move on empty tile
            if(getPiece(position)==null){
                getTile(position).setValidMoveBase();
            }

            // valid move on opposite color tile
            if (getPiece(position)!=null && !getPiece(position).sameColor(color)){
                getTile(position).setValidKillBase();
            }
        }
    }

    private Piece getPiece(Position position){
        return board[position.getRow()][position.getCol()];
    }

    private Tile getTile(Position position){
        return tiles[position.getRow()][position.getCol()];
    }


}
