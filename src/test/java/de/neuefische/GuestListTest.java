package de.neuefische;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GuestListTest {
    GuestList guestList = new GuestList();

    @Test
    void guestListShouldBeEmptyInitially() {
        //GIVEN
        List<Guest> testGuestList = new ArrayList<>();
        //WHEN
        guestList.setGuestList(testGuestList);
        //THEN
        assertTrue(guestList.getGuestList().isEmpty());
    }

    @Test
    void shouldReadSameGuestsAsWrittenBefore() {
        List<Guest> setGuests = new ArrayList<>(List.of(
                new Guest("Karl"),
                new Guest("Ute")
        ));
        guestList.setGuestList(setGuests);
        List<Guest> expected = new ArrayList<>(List.of(
                new Guest("Karl"),
                new Guest("Ute")
        ));
        assertEquals(expected, guestList.getGuestList());
    }

    @Test
    void whenGetGuestByName_withValidName_thenReturnCorrectGuest() throws GuestNotFoundException {

        Guest testGuest1 = new Guest("Karl");
        Guest testGuest2 = new Guest("Ute");
        List<Guest> testGuestList = new ArrayList<>(List.of(
                testGuest1,
                testGuest2
        ));
        guestList.setGuestList(testGuestList);

        assertThrows(GuestNotFoundException.class, () -> guestList.getGuestByName("Stephan"));

        try {
            guestList.getGuestByName("Stephan");
            fail();
        } catch (GuestNotFoundException e) {
            assertEquals("Guest not found with name: Stephan", e.getMessage());
        }
    }

    @Test
    void whenAddingGuest_thenCheckGuestIsInList() {
        //GIVEN
        Guest guestToAdd = new Guest("Karl");
        //WHEN
        guestList.addGuest(guestToAdd);
        //THEN
        assertTrue(guestList.getGuestList().contains(guestToAdd));
    }
}