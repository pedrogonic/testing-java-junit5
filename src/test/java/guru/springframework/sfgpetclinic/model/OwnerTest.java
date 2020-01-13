package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@Tag("models")
class OwnerTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1234567890");

        // JUnit
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

        // Hamcrest
        assertThat(owner.getCity(), is("Key West"));
    }
}