package xyz.nahidwin.lot5.model;

public class InvalidPhoneFormatException extends InvalidFormatException {
    public InvalidPhoneFormatException() {
        super("Phone number must contain 10 digits");
    }
}
