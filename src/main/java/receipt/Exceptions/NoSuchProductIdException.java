package receipt.Exceptions;

public class NoSuchProductIdException extends Exception {
    public NoSuchProductIdException(String msg) {
        super(msg);
    }

    public NoSuchProductIdException(int id) {
        super("No such product id = " + id);
    }
}
