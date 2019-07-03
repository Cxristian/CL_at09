package org.gradle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * PersonTest class.
 */
public class PersonTest {
    @Test
    public void canConstructAPersonWithAName() {
        Person person = new Person("Larry");
        assertEquals("Larry", person.getName());
    }
}
