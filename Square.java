/**
 * Created by tuterdust on 23/2/2560.
 */
public class Square {

    private String symbol;

    public Square() {
        symbol = "-";
    }


    public String getSymbol() {
        return  symbol;
    }

    public boolean isFree() {
        if (symbol.equals("-"))
            return true;
        return false;
    }

    public void setSquare(String newSymbol) {
        symbol = newSymbol;
    }

    public String toString() {
        return " " + symbol + " ";
    }
}
