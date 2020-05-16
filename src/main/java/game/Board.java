package game;

import game.piece.Piece;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

import static game.piece.Bishop.spawnBishop;
import static game.piece.King.spawnKing;
import static game.piece.Knight.spawnKnight;
import static game.piece.Pawn.spawnPawn;
import static game.piece.Queen.spawnQueen;
import static game.piece.Rook.spawnRook;

public class Board extends AnchorPane {

    public static final int SIZE = 8;
    private Tile[][] board;
    private Position selectedPosition;
    private ArrayList<Tile> highlightedTiles;

    private static final int DIMENSION = 50;
    private static final Color PALE_BASE = Color.web("#e6ccab");
    private static final Color DARK_BASE = Color.web("#9d571b");
    private static final Color SELECTED_BASE = Color.SKYBLUE;
    private static final Color VALID_KILL_BASE = Color.RED;
    private static final Color VALID_MOVE_PALE_BASE = Color.LIGHTGREEN;
    private static final Color VALID_MOVE_DARK_BASE = Color.LIME;
    private static final double LOW_OPACITY = 0.35;
    private static final double FULL_OPACITY = 1;

    @FXML
    private GridPane grid;

    @FXML
    public void initialize() {
        board = new Tile[SIZE][SIZE];
        highlightedTiles = new ArrayList<>();
        selectedPosition = null;
        setUpBoard();
    }

    private void setUpBoard() {
        for (int i = 0; i < SIZE; i++) {
            switch (i) {
            case 0:
                spawnPiece(i, Color.BLACK);
                break;
            case 7:
                spawnPiece(i, Color.WHITE);
                break;
            default:
                for (int j = 0; j < SIZE; j++) {
                    switch (i) {
                    case 1:
                        board[i][j] = new Tile(spawnPawn(new Position(i, j), Color.BLACK));
                        break;
                    case 6:
                        board[i][j] = new Tile(spawnPawn(new Position(i, j), Color.WHITE));
                        break;
                    default:
                        board[i][j] = new Tile(new Position(i, j));
                    }
                }
            }
        }
        print();
    }

    private void spawnPiece(int i, Color color) {
        for (int j = 0; j < SIZE; j++) {
            switch (j) {
            case 0:
            case 7:
                board[i][j] = new Tile(spawnRook(new Position(i, j), color));
                break;
            case 1:
            case 6:
                board[i][j] = new Tile(spawnKnight(new Position(i, j), color));
                break;
            case 2:
            case 5:
                board[i][j] = new Tile(spawnBishop(new Position(i, j), color));
                break;
            case 3:
                board[i][j] = new Tile(spawnQueen(new Position(i, j), color));
                break;
            case 4:
                board[i][j] = new Tile(spawnKing(new Position(i, j), color));
                break;
            }
        }
    }


    public void select(Position position) {
        selectedPosition = position;
        getTile(position).setSelectedBase();
    }

    public void unselect(Position position) {
        selectedPosition = null;
        getTile(position).setOriginalColor();
        highlightedTiles.forEach(Tile::setOriginalColor);
        highlightedTiles.clear();
    }

    public boolean isSelected() {
        return selectedPosition != null;
    }

    public void showValidMove(ArrayList<ArrayList<Position>> validMove) {
        if (validMove.size() == 1) {
            for (Position position : validMove.get(0)) {
                if (getPiece(position) == null) {
                    // valid move on empty tile
                    getTile(position).setValidMoveBase();
                    highlightedTiles.add(getTile(position));
                }
            }
        } else {
            for (ArrayList<Position> positions : validMove) {
                for (Position position : positions) {
                    if (getPiece(position) == null) {
                        // valid move on empty tile
                        getTile(position).setValidMoveBase();
                        highlightedTiles.add(getTile(position));
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public void showValidKillMove(ArrayList<ArrayList<Position>> validMove, Color color) {
        if (validMove.size() == 1) {
            for (Position position : validMove.get(0)) {
                if (getPiece(position) != null) {
                    if (getPiece(position).sameColor(color)) {
                        // invalid move on friendly piece
                        continue;
                    } else {
                        // valid move on opposite color tile
                        getTile(position).setValidKillBase();
                        highlightedTiles.add(getTile(position));
                    }
                }
            }
        } else {
            for (ArrayList<Position> positions : validMove) {
                for (Position position : positions) {
                    if (getPiece(position) != null) {
                        if (!getPiece(position).sameColor(color)) {
                            // valid move on opposite color tile
                            getTile(position).setValidKillBase();
                            highlightedTiles.add(getTile(position));
                        }
                        break;
                    }
                }
            }
        }
    }

    public boolean isValidMove(Position position) {
        return highlightedTiles.stream().anyMatch(tile -> tile.equals(getTile(position)));
    }

    private Tile getTile(Position position) {
        return board[position.getRow()][position.getCol()];
    }

    private Piece getPiece(Position position) {
        return board[position.getRow()][position.getCol()].getPiece();
    }

    public void move(Position position) {
        getTile(selectedPosition).removePieceTo(getTile(position));
        getTile(selectedPosition).setOriginalColor();
        selectedPosition = null;
        highlightedTiles.forEach(Tile::setOriginalColor);
        highlightedTiles.clear();
    }

    private void print() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getPiece());
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    class Tile extends StackPane {

        private Rectangle base;
        private Piece piece;
        private Position position;
        private Color originalColor;
        private ImageView pieceImage;
        private boolean isSelect;

        public Tile(Position position, Piece piece) {
            this.setPrefSize(DIMENSION, DIMENSION);
            base = new Rectangle(DIMENSION, DIMENSION);
            this.position = position;
            isSelect = false;
            this.getChildren().add(base);
            setUpBaseColour();
            setUpImage(piece);
            setUpBaseControl();
        }

        public Tile(Position position) {
            this(position, null);
        }

        public Tile(Piece piece) {
            this(piece.getPosition(), piece);
        }

        private void setUpBaseColour() {
            if ((position.getCol() + position.getRow()) % 2 == 0) {
                originalColor = PALE_BASE;
            } else {
                originalColor = DARK_BASE;
            }
            setOriginalColor();
        }

        private void setUpImage(Piece piece) {
            pieceImage = new ImageView();
            pieceImage.setFitHeight(DIMENSION);
            pieceImage.setFitWidth(DIMENSION);
            pieceImage.setPreserveRatio(true);
            setUpPieceControl();
            if (piece == null) {
                pieceImage.setImage(null);
            } else {
                this.piece = piece;
                pieceImage.setImage(piece.getImage());
            }
            this.getChildren().add(pieceImage);
            grid.add(this, position.getCol(), position.getRow());
        }

        private void setUpBaseControl() {
            setOnMouseClicked(e -> {
                if (isSelected() && isValidMove(position)) {
                    move(position);
                }
            });
        }

        private void setUpPieceControl() {
            pieceImage.setOnMouseClicked(e -> {
                if (isSelected() && !isSelect) {
                    return;
                }
                if (isSelected()) {
                    System.out.println("UnSelect");
                    unselect(piece.getPosition());
                    isSelect = false;
                } else {
                    System.out.println("Select");
                    select(piece.getPosition());
                    isSelect = true;
                    showValidMove(piece.validMove());
                    showValidKillMove(piece.validKillMove(), piece.getColor());
                }
            });
        }

        public ImageView getPieceImage() {
            return pieceImage;
        }

        public Rectangle getBase() {
            return base;
        }

        public Piece getPiece() {
            return piece;
        }

        public void removePieceTo(Tile tile) {
            tile.addPiece(piece);
            piece = null;
            pieceImage.setImage(null);
        }

        private void addPiece(Piece piece) {
            this.piece = piece;
            piece.move(position);
            pieceImage.setImage(piece.getImage());
            setUpPieceControl();
        }


        public void setSelectedBase() {
            base.setFill(SELECTED_BASE);
        }

        public void setValidKillBase() {
            base.setFill(VALID_KILL_BASE);
            base.setOpacity(LOW_OPACITY);
        }

        public void setValidMoveBase() {
            if (originalColor.equals(PALE_BASE)) {
                base.setFill(VALID_MOVE_PALE_BASE);
            } else {
                base.setFill(VALID_MOVE_DARK_BASE);
            }
            base.setOpacity(LOW_OPACITY);
        }

        public void setOriginalColor() {
            base.setFill(originalColor);
            base.setOpacity(FULL_OPACITY);
        }
    }


}
