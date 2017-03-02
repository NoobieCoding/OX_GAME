/**
 * Created by tuterdust on 23/2/2560.
 */
public class Board {

    private int size, numSymbol = 0;

    private Square[][] grid;

    public Board(int size) {
        this.size = size;
        setGrid();
    }

    public int getSize() {
        return size;
    }

    private void setGrid() {
        grid = new Square[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                grid[i][j] = new Square();
            }
        }
    }

    public void setSymbol(int r, int c, String symbol) {
        grid[r][c].setSquare(symbol);
        numSymbol++;
    }

    public int getNumSymbol() {
        return numSymbol;
    }

    public boolean isSquareFree(int row, int column) {
        return grid[row][column].isFree();
    }

    public String getHorizontalLine(int r) {
        String output = "";
        for(int i = 0; i < size; i++) {
                output += grid[r][i].getSymbol();

        }
        return output;
    }

    public String getVerticalLine(int r) {
        String output = "";
        for(int i = 0; i < size; i++) {
            output += grid[i][r].getSymbol();

        }
        return output;
    }

    public String getDiagonalLine1(int r, int c) {
        String output = "";
        while (r < size && c < size) {
            output += grid[r][c].getSymbol();
            r++; c++;
        }
        return output;
    }

    public String getDiagonalLine2(int r, int c) {
        String output = "";
        while (r < size && c >= 0) {
            output += grid[r][c].getSymbol();
            r++; c--;
        }
        return output;
    }

    public String toString() {
        String output = "";
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                output += grid[i][j].toString();
            }
            output += "\n";
        }
        return output;
    }
}
