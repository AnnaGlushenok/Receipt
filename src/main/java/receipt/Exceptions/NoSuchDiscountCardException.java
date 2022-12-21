package receipt.Exceptions;

public class NoSuchDiscountCardException extends Exception {
    public NoSuchDiscountCardException() {
        super("No such discount card");
    }
}
