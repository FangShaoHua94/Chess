import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import piece.Piece;

import java.io.FileNotFoundException;

import static piece.Pawn.spawnBlackPawn;
import static piece.Piece.DIMENSION;

public class Chess extends Application {

    public static final int BASE_DIMENSION =460;
    public static final int SIZE=8;
    public static final Color BOARD_COLOR= Color.BURLYWOOD;
    public static final int BOARD_DIMENSION=400;
    public static final int BORDER_WIDTH=30;

    private GridPane grid;
    private Piece[][] board;
    private Group root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chess");
        primaryStage.setResizable(false);
        root = new Group();
        board=new Piece[DIMENSION][DIMENSION];
        grid=new GridPane();
        setBase();
        getTiles();
        setPieces();
        Scene scene = new Scene(root, BASE_DIMENSION, BASE_DIMENSION);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setBase(){
        Rectangle base = new Rectangle(BASE_DIMENSION, BASE_DIMENSION);
        base.setFill(BOARD_COLOR);
        root.getChildren().add(base);
    }

    private void getTiles(){
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                Rectangle tile = new Rectangle(BORDER_WIDTH+ DIMENSION *i,
                        BORDER_WIDTH+ DIMENSION *j, DIMENSION, DIMENSION);
                if((i+j)%2==0){
                    tile.setFill(Color.SADDLEBROWN);
                }else {
                    tile.setFill(Color.ANTIQUEWHITE);
                }
                root.getChildren().add(tile);
            }
        }
    }

    private void setPieces(){
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                try {
                    board[i][j] = spawnBlackPawn(i, j);
                    root.getChildren().add(board[i][j]);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }



}
