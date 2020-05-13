import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import piece.Piece;

import java.io.IOException;

public class PieceUi extends StackPane {

    private Piece piece;

    @FXML
    private ToggleButton toggleButton;

    public PieceUi(Piece piece) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PieceUi.class.getResource("/view/Piece.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.piece = piece;
        ImageView imageView = new ImageView();
        imageView.setImage(piece.getImage());
        imageView.setPreserveRatio(true);
        imageView.setX(50);
        imageView.setY(50);
        toggleButton.setGraphic(imageView);
    }

}
