import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Chess extends Application {

    private static final int DIMENSION=460;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chess");
        primaryStage.setResizable(false);
        Group root = new Group();
        Board board=new Board(DIMENSION);
        root.getChildren().add(board);
        root.getChildren().addAll(board.getTiles());
        Scene scene = new Scene(root, DIMENSION, DIMENSION);
        primaryStage.setScene(scene);
        primaryStage.show();
    }




}
