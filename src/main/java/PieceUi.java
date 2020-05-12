import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import piece.Piece;

import java.io.IOException;

public class PieceUi extends StackPane {

    private Piece piece;

    @FXML
    private ImageView pieceHolder;

    public PieceUi(Piece piece){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PieceUi.class.getResource("/view/Piece.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.piece=piece;
//        pieceHolder.setPreserveRatio(true);
        pieceHolder.setImage(piece.getImage());

    }

}
