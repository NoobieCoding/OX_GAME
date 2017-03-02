/**
 * Created by tuterdust on 23/2/2560.
 */

import java.util.*;

public class OXGame {

    static Scanner input = new Scanner(System.in);

    static Player player1, player2;

    static Board board;

    static int winner = 0;

    static String checkString1 = "XXXXX", checkString2 = "OOOOO";

    public static void main(String[] args) {
        start();

    }

    public static  void start() {
        setBoard();
        setPlayers();
        while (winner == 0 && board.getNumSymbol() != board.getSize() * board.getSize()) {
            takeTurn(player1);
            if (winner != 0 || board.getNumSymbol() == board.getSize() * board.getSize())
                break;
            takeTurn(player2);
        }
        String playername = "";

        switch(winner) {
            case 1:
                playername = player1.getName();
                break;
            case 2:
                playername = player2.getName();
                break;
        }

        if (winner != 0)
            System.out.println(playername +" wins");
        else
            System.out.println("Game draw");
    }

    public static void setPlayers() {
        System.out.print("Insert player1's name");
        player1 = new Player(input.nextLine(), 1, board);
        System.out.print("Insert player2's sname");
        player2 = new Player(input.nextLine(), 2, board);
    }

    public static void setBoard() {
        int size = 0;
        while (size < 5) {
            System.out.print("Boardsize: ");
            size = Integer.parseInt(input.nextLine());
        }

        board = new Board(size);
    }

    public static void takeTurn(Player player) {
        System.out.println("Player"+player.getTurn() + "'s turn");
        int row, column;
        boolean canPlace = false;
        while(!canPlace) {
            System.out.print("Target row");
            row = Integer.parseInt(input.nextLine());
            System.out.print("Target column");
            column = Integer.parseInt(input.nextLine());
            if (row < 1 || row > board.getSize() || column < 1 || column > board.getSize()) {
                System.out.println("Invalid number, please try agian");
                continue;
            }
            canPlace = player.placeSymbol(row, column);
            if (!canPlace)
                System.out.println("This square is occupied !");
        }

        System.out.println(board);
        boolean hasWinner = checkFinish();
        if (hasWinner)
            winner = player.getTurn();
    }

    public static boolean checkFinish() {
        boolean hasWinner = false;
        for (int i = 0; i < board.getSize(); i++) {
            String horizontalLine = board.getHorizontalLine(i);
            if (horizontalLine.contains(checkString1) || horizontalLine.contains(checkString2))
                hasWinner = true;

            String verticalLine = board.getVerticalLine(i);
            if (verticalLine.contains(checkString1) || verticalLine.contains(checkString2))
                hasWinner = true;

            for (int j = 0; j < board.getSize(); j++) {
                String diagonalLine1 = board.getDiagonalLine1(i, j);
                String diagonalLine2 = board.getDiagonalLine2(i, j);
                if (diagonalLine1.contains(checkString1) || diagonalLine1.contains(checkString2)
                        || diagonalLine2.contains(checkString1)||diagonalLine2.contains(checkString2))
                    hasWinner = true;
            }
        }
        return hasWinner;
    }
}
