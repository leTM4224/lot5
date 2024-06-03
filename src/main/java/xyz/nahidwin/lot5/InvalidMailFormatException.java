package xyz.nahidwin.lot5;

public class InvalidMailFormatException extends InvalidFormatException {
    public InvalidMailFormatException() {
        super("Mail format must be : johndoe@example.com");
    }
}
