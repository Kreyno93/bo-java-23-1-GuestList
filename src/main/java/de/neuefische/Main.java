package de.neuefische;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuestList guestList = new GuestList();
        List<Guest> listOfGuests = new ArrayList<>(
                List.of(
                        new Guest("Hans"),
                        new Guest("Peter"),
                        new Guest("Klaus")
                )
        );

        guestList.setGuestList(listOfGuests);

        System.out.println(guestList.getGuestList());
    }
}