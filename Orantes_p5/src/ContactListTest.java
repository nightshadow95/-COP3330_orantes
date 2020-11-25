import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    @Test
    public void addingItemsIncreasesSize() {
        ContactItem contact = new ContactItem("joe", "hammond", "320-234-7685", "someone@gmail.com");
        ContactList list = new ContactList();
        list.SetContactList(contact);
        assertEquals(1, list.contacts.size());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactItem contact = new ContactItem("joe", "", "", "");
        ContactList list = new ContactList();
        list.SetContactList(contact);
        contact.setFirstName("");
        assertThrows(IllegalArgumentException.class, () -> {
            list.EditItems(contact, 0);
        });
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {
        ContactItem contact = new ContactItem("joe", "wild", "", "");
        ContactList list = new ContactList();
        list.SetContactList(contact);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            list.EditItems(contact, 5);
        });
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem contact = new ContactItem("joe", "wild", "321-098-0909", "someone@gmail.com");
        ContactList list = new ContactList();
        list.SetContactList(contact);
        contact.setFirstName("");
        list.EditItems(contact, 0);
        assertEquals("", list.contacts.get(0).getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem contact = new ContactItem("joe", "wild", "321-098-0909", "someone@gmail.com");
        ContactList list = new ContactList();
        list.SetContactList(contact);
        contact.setPhoneNumber("");
        list.EditItems(contact, 0);
        assertEquals("", list.contacts.get(0).getPhoneNumber());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem contact = new ContactItem("joe", "wild", "321-098-0909", "someone@gmail.com");
        ContactList list = new ContactList();
        list.SetContactList(contact);
        contact.setPhoneNumber("345-333-4444");
        contact.setEmailAddress("email@email.com");
        contact.setFirstName("Winner");
        contact.setLastName("Winner");
        list.EditItems(contact, 0);
        assertEquals("Name: Winner Winner\nPhone: 345-333-4444\nEmail: email@email.com", contact.toString());
    }

    @Test
    public void newListIsEmpty() {
        ContactList list = new ContactList();
        assertThrows(IllegalArgumentException.class, () -> {
            list.LoadContactList("pain.txt");
        });
    }

    @Test
    public void removingItemsDecreasesSize() {
        ContactItem contact = new ContactItem("joe", "wild", "321-098-0909", "someone@gmail.com");
        ContactList list = new ContactList();
        list.SetContactList(contact);
        list.contacts.remove(0);
        assertEquals(0, list.contacts.size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactItem contact = new ContactItem("joe", "wild", "321-098-0909", "someone@gmail.com");
        ContactList list = new ContactList();
        list.SetContactList(contact);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.contacts.remove(10);
        });
    }


}