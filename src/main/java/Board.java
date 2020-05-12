
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import piece.Piece;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static piece.Pawn.spawnBlackPawn;
import static piece.Piece.DIMENSION;

public class Board extends Rectangle {

    public static final int SIZE=8;
    private static final Color BOARD_COLOR= Color.SIENNA;
    private static final int BOARD_DIMENSION=400;

    private final int dimension;
    private Piece[][] grid;

    public Board (int dimension){
        super(dimension,dimension);
        setFill(BOARD_COLOR);
        this.dimension=dimension;
        grid =new Piece[SIZE][SIZE];
        setPieces();
    }

    public ArrayList<Rectangle> getTiles(){
        ArrayList<Rectangle> tiles=new ArrayList<>();
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                Rectangle tile = new Rectangle(30+DIMENSION*i,30+DIMENSION*j,DIMENSION,DIMENSION);
                if((i+j)%2==0){
                    tile.setFill(Color.BROWN);
                }else {
                    tile.setFill(Color.ANTIQUEWHITE);
                }
                tiles.add(tile);
            }
        }
        return tiles;
    }

    private void setPieces(){
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                try {
                    grid[i][j] = spawnBlackPawn(i, j);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }



}
