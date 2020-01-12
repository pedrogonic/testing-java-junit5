package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1234567890");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                            () -> assertEquals("Joe", owner.getFirstName(), "First Name did not match"),
                            () -> assertEquals("Buck", owner.getLastName(), "Last Name did not match")
                        ),
                () -> assertAll("Owner Properties",
                            () -> assertEquals("Key West", owner.getCity(), "City did not match"),
                            () -> assertEquals("1234567890", owner.getTelephone(), "Telephone did not match")
                        )
                );

    }
}