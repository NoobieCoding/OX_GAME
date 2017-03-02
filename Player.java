/**
 * Created by tuterdust on 23/2/2560.
 */
public class Player {

    private String name;
    private int turn;
    private String symbol;
    private Board board;

    public Player(String name, int turn, Board board) {
        this.name = name;
        this.turn = turn;
        this.board = board;
        determineSymbol();

    }

    private void determineSymbol() {
        if (turn == 1)
            symbol = "X";
        else if (turn == 2)
            symbol = "O";
    }

    public boolean placeSymbol(int row, int column) {
        boolean flag = board.isSquareFree(row-1, column-1);
        if(flag)
            board.setSymbol(row-1, column-1, symbol);
        return flag;
    }

    public int getTurn() {
        return turn;
    }

    public String getName() { return name;}
}
