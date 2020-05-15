package game;

import game.piece.Piece;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
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
    private PieceUi[][] board;
    private Tile[][] tiles;
    private Position selectedPosition;
    private ArrayList<Tile> highlightedTiles;

    @FXML
    private StackPane base;

    @FXML
    private GridPane grid;

    @FXML
    public void initialize() {
        board = new PieceUi[DIMENSION][DIMENSION];
        tiles = new Tile[DIMENSION][DIMENSION];
        highlightedTiles= new ArrayList<>();
        selectedPosition=null;
        setUpTile();
        setUpPiece();
    }

    private void setUpTile() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if ((i + j) % 2 == 0) {
                    tiles[i][j] = spawnPaleTile(this,new Position(i,j));
                } else {
                    tiles[i][j] = spawnDarkTile(this,new Position(i,j));
                }
                grid.add(tiles[i][j], j, i);
            }
        }
    }

    private void setUpPiece() {
        for (int i = 0; i < DIMENSION; i++) {
            board[1][i] = new PieceUi(this,spawnBlackPawn(1, i));
            board[6][i] = new PieceUi(this,spawnWhitePawn(6, i));
            switch (i) {
            case 0:
            case 7:
                board[0][i] = new PieceUi(this,spawnBlackRook(0, i));
                board[7][i] = new PieceUi(this,spawnWhiteRook(7, i));
                break;
            case 1:
            case 6:
                board[0][i] = new PieceUi(this,spawnBlackKnight(0, i));
                board[7][i] = new PieceUi(this,spawnWhiteKnight(7, i));
                break;
            case 2:
            case 5:
                board[0][i] = new PieceUi(this,spawnBlackBishop(0, i));
                board[7][i] = new PieceUi(this,spawnWhiteBishop(7, i));
                break;
            case 3:
                board[0][i] = new PieceUi(this,spawnBlackQueen(0, i));
                board[7][i] =new PieceUi(this, spawnWhiteKing(7, i));
                break;
            case 4:
                board[0][i] = new PieceUi(this,spawnBlackKing(0, i));
                board[7][i] = new PieceUi(this,spawnWhiteQueen(7, i));
                break;
            default:
                break;
            }
        }
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (i < 2 || i > 5) {
                    grid.add(board[i][j], j, i);
                }
            }
        }
    }

    public void select(Position position) {
        selectedPosition= position;

        System.out.println("selected from board");
        System.out.println(position.getCol());
        System.out.println(position.getRow());
        getTile(position).setSelectedBase();
    }

    public void unselect(Position position) {
        selectedPosition=null;
        getTile(position).setOriginalColor();
        highlightedTiles.forEach(Tile::setOriginalColor);
        highlightedTiles.clear();
    }

    public boolean isSelected() {
        return selectedPosition!=null;
    }

    public void showValidMove(ArrayList<Position> validMove,Color color) {
        for(Position position:validMove){
            // invalid move on friendly piece
            if(getPiece(position)!=null && getPiece(position).sameColor(color)){
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

    public boolean isValidMove(Position position){
        return highlightedTiles.stream().anyMatch(tile -> tile.equals(getTile(position)));
    }

    private PieceUi getPiece(Position position){
        return board[position.getRow()][position.getCol()];
    }

    private Tile getTile(Position position){
        return tiles[position.getRow()][position.getCol()];
    }

    private void moveTo(Position originalPosition, Position newPosition){
        board[newPosition.getRow()][newPosition.getCol()]=board[originalPosition.getRow()][originalPosition.getCol()];
        board[originalPosition.getRow()][originalPosition.getCol()]=null;
    }

    public void move(Position position){
        PieceUi piece= getPiece(selectedPosition);
        grid.getChildren().remove(piece);
        piece.move(position);
        grid.add(piece,position.getCol(),position.getRow());
        moveTo(selectedPosition,position);
        getTile(selectedPosition).setOriginalColor();
        selectedPosition=null;
        highlightedTiles.forEach(Tile::setOriginalColor);
        highlightedTiles.clear();
    }


}
