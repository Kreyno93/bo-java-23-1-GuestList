package de.neuefische;

public class GuestNotFoundException extends Throwable {
    public GuestNotFoundException(String guestNotFound) {
        super(guestNotFound);
    }
}
