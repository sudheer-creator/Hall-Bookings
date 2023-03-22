package spring.boot.exceptionhandling;

public class InvalidBooking extends Exception {
    public InvalidBooking() {
        super();
    }
    public InvalidBooking(String message) {
        super(message);
    }
}
