package xyz.nahidwin.lot5.model;

public class InvalidMailFormatException extends InvalidFormatException {
    public InvalidMailFormatException() {
        super("Mail format must be : johndoe@example.com");
    }
}
