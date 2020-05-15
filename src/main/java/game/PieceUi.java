package game;

import game.piece.Piece;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class PieceUi extends StackPane {

    private boolean isSelect = false;
    private Board board;
    private Piece piece;

    @FXML
    private ImageView pieceHolder;

    public PieceUi(Board board, Piece piece) {
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
        pieceHolder.setImage(piece.getImage());
    }

    public void move(Position position){
        piece.move(position);
        isSelect = false;
    }

    @FXML
    public void select() {
        if (board.isSelected() && !isSelect) {
            return;
        }

        if (board.isSelected()) {
            System.out.println(board.isSelected() + "   UnSelect");
            board.unselect(piece.getPosition());
            isSelect = false;
        } else {
            System.out.println(board.isSelected() + " Select  ");
            board.select(piece.getPosition());
            isSelect = true;
            board.showValidMove(piece.validMove(),piece.getColor());
        }
    }

    public boolean sameColor(Color color){
        return piece.sameColor(color);
    }

}
