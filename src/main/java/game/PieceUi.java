package game;

import game.piece.Piece;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class PieceUi extends StackPane {

    private boolean isSelect = false;
    private Board board;
    private Piece piece;
    private Position position;

    @FXML
    private ImageView pieceHolder;

    public PieceUi(int row, int col, Board board, Piece piece) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PieceUi.class.getResource("/view/Piece.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.board = board;
        this.piece = piece;
        position = new Position(row, col);
        pieceHolder.setImage(piece.getImage());
    }

    @FXML
    public void select() {
        if (board.isSelected() && !isSelect) {
            return;
        }

        if (board.isSelected()) {
            System.out.println(board.isSelected() + "   UnSelect");
            board.unselect(position.getRow(), position.getCol());
            isSelect = false;
        } else {
            System.out.println(board.isSelected() + " Select  ");
            board.select(position.getRow(), position.getCol());
            isSelect = true;
            board.showValidMove(piece.validMove(),piece.getColor());
        }
    }

}
