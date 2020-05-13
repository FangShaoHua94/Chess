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

    public Tile (Color originalColor){
        super(DIMENSION,DIMENSION);
        this.originalColor=originalColor;
        setOriginalColor();
    }

    public static Tile spawnPaleTile(){
        return new Tile(PALE_BASE);
    }

    public static Tile spawnDarkTile(){
        return new Tile(DARK_BASE);
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
