import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {
@Test
    public void creationFailsWithAllBlankValues() {

    assertThrows(IllegalArgumentException.class, () -> {
        ContactItem contact = new ContactItem("", "", "","" );
    });
}

@Test
    public void creationSucceedsWithBlankEmail() {
    assertDoesNotThrow(() -> new ContactItem("john", "doe", "321-795-8709", ""));
}

@Test
    public void creationSucceedsWithBlankFirstName() {
    assertDoesNotThrow(() -> new ContactItem("", "doe", "321-795-8709", "someone@gmail.com"));
}

@Test
    public void creationSucceedsWithBlankLastName() {
    assertDoesNotThrow(() -> new ContactItem("John", "", "321-795-8709", "someone@gmail.com"));
}

@Test
    public void creationSucceedsWithBlankPhone() {
    assertDoesNotThrow(() -> new ContactItem("John", "doe", "", "someone@gmail.com"));
}

@Test
    public void creationSucceedsWithNonBlankValues() {
    assertDoesNotThrow(() -> new ContactItem("John", "doe", "321-795-8709", "someone@gmail.com"));
}

@Test
    public void editingFailsWithAllBlankValues() {
    ContactItem contact = new ContactItem("John", "doe", "321-795-8709", "someone@gmail.com");
    assertThrows(IllegalArgumentException.class, () -> {
        contact.EditItems("", "", "", "");
    });
}

@Test
    public void editingSucceedsWithBlankEmail() {
    ContactItem contact = new ContactItem("John", "doe", "321-795-8709", "someone@gmail.com");
    assertDoesNotThrow(() -> contact.EditItems("Joe", "johnson", "321-795-3487", ""));
}

@Test
    public void editingSucceedsWithBlankFirstName() {
    ContactItem contact = new ContactItem("John", "doe", "321-795-8709", "someone@gmail.com");
    assertDoesNotThrow(() -> contact.EditItems("", "johnson", "321-795-3487", "someoneelse@gmail.com"));
}

@Test
    public void editingSucceedsWithBlankLastName() {
    ContactItem contact = new ContactItem("John", "doe", "321-795-8709", "someone@gmail.com");
    assertDoesNotThrow(() -> contact.EditItems("Joe", "", "321-795-3487", "someoneelse@gmail.com"));
}

@Test
    public void editingSucceedsWithBlankPhone() {
    ContactItem contact = new ContactItem("John", "doe", "321-795-8709", "someone@gmail.com");
    assertDoesNotThrow(() -> contact.EditItems("Joe", "johnson", "", "someoneelse@gmail.com"));
}

@Test
    public void editingSucceedsWithNonBlankValues() {
    ContactItem contact = new ContactItem("John", "doe", "321-795-8709", "someone@gmail.com");
    assertDoesNotThrow(() -> contact.EditItems("Joe", "johnson", "321-987-0394", "someoneelse@gmail.com"));
}

@Test
    public void testToString(){
    ContactItem contact = new ContactItem("John", "doe", "321-795-8709", "someone@gmail.com");
    assertEquals("Name: John doe\nPhone: 321-795-8709\nEmail: someone@gmail.com", contact.toString());
}

}