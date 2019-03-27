package pl.sda.intermediate16;

public class NegativeNumberFoundException extends RuntimeException{ // musi,powinien byc checke exception, inaczej mamy duuuzo zabawy

    public NegativeNumberFoundException(String message) {
        super(message);
    }
}
