package de.neuefische;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuestList {

    private List<Guest> guestList = new ArrayList<>();

    public GuestList() {
    }

    public void addGuest(Guest guestToAdd) {
        guestList.add(guestToAdd);
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    @Override
    public String toString() {
        return "GuestList{" +
                "guestList=" + guestList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestList guestList1 = (GuestList) o;
        return Objects.equals(guestList, guestList1.guestList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestList);
    }

    public Guest getGuestByName(String name) throws GuestNotFoundException {
        for (Guest guest : guestList) {
            if (guest.getName().equals(name)) {
                return guest;
            }
        }
        throw new GuestNotFoundException("Guest not found with name: " + name);
    }
}
