package game;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    private static final int DIMENSION=50;
    private static final Color PALE_BASE = Color.web("#e6ccab");
    private static final Color DARK_BASE = Color.web("#9d571b");
    private static final Color SELECTED_BASE = Color.SKYBLUE;
    private static final Color VALID_KILL_BASE = Color.RED;
    private static final Color VALID_MOVE_PALE_BASE = Color.LIGHTGREEN;
    private static final Color VALID_MOVE_DARK_BASE = Color.LIME;
    private static final double LOW_OPACITY =0.35;
    private static final double FULL_OPACITY=1;

    private Color originalColor;
    private Position position;
    private Board board;

    public Tile (Board board,Position position, Color originalColor){
        super(DIMENSION,DIMENSION);
        this.position=position;
        this.originalColor=originalColor;
        setOnMouseClicked(e->{
            if(board.isSelected() && board.isValidMove(position)){
                System.out.println("aaa"+position.getCol());
                System.out.println(position.getRow());
                board.move(position);
            }
        });
        setOriginalColor();
    }

    public static Tile spawnPaleTile(Board board,Position position){
        return new Tile(board,position,PALE_BASE);
    }

    public static Tile spawnDarkTile(Board board,Position position){
        return new Tile(board,position,DARK_BASE);
    }

    public void setSelectedBase(){
        setFill(SELECTED_BASE);
    }

    public void setValidKillBase(){
        setFill(VALID_KILL_BASE);
        setOpacity(LOW_OPACITY);
    }

    public void setValidMoveBase(){
        if(originalColor.equals(PALE_BASE)){
            setFill(VALID_MOVE_PALE_BASE);
        }else{
            setFill(VALID_MOVE_DARK_BASE);
        }
        setOpacity(LOW_OPACITY);
    }

    public void setOriginalColor(){
        setFill(originalColor);
        setOpacity(FULL_OPACITY);
    }


}
