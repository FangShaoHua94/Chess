package game;

import static game.Board.DIMENSION;

public class Position {

    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Position up(){
        return new Position(row-1,col);
    }

    public Position down(){
        return new Position(row+1,col);
    }

    public Position left(){
        return new Position(row,col-1);
    }

    public Position right(){
        return new Position(row,col+1);
    }

    public static boolean withinBoundary(int row, int col) {
        return row >= 0 && row < DIMENSION && col >= 0 && col < DIMENSION;
    }

    public static boolean withinBoundary(Position position) {
        return withinBoundary(position.getRow(),position.getCol());
    }


}
