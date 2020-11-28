import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest
{
    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(IllegalArgumentException.class, ()->
    {ContactItem c = new ContactItem("", "", "", "");});
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        assertDoesNotThrow(() -> {ContactItem c = new
                ContactItem("Good", "Name", "justForTest", "");});
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        assertDoesNotThrow(() -> {ContactItem c = new
                ContactItem("", "Name", "justForTest", "test");});
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        assertDoesNotThrow(() -> {ContactItem c = new
                ContactItem("Good", "", "justForTest", "test");});
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        assertDoesNotThrow(() -> {ContactItem c = new
                ContactItem("Good", "Name", "", "test");});
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        assertDoesNotThrow(() -> {ContactItem c = new
                ContactItem("Good", "Name", "justForTest", "FULLY@LOADED.COM");});
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        assertThrows(IllegalArgumentException.class, ()->
        {   ContactItem c = new ContactItem("try", "this", "I", "guess");
            ContactItem c2 = new ContactItem("", "", "", "");
            ContactList contactList = new ContactList();
            contactList.contactList.add(c);
            c.editItem(c, c2);
        });
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem c = new ContactItem("try", "this", "I", "guess");
        ContactItem c2 = new ContactItem("test", "test", "test", "");
        assertDoesNotThrow(()-> { c.editItem(c, c2); });
        assertEquals(c.getEmail(), c2.getEmail());
        assertEquals(c.getFName(), c2.getFName());
        assertEquals(c.getLName(), c2.getLName());
        assertEquals(c.getPhoneNum(), c2.getPhoneNum());
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem c = new ContactItem("try", "this", "I", "guess");
        ContactItem c2 = new ContactItem("", "test", "test", "test");
        assertDoesNotThrow(()-> { c.editItem(c, c2); });
        assertEquals(c.getEmail(), c2.getEmail());
        assertEquals(c.getFName(), c2.getFName());
        assertEquals(c.getLName(), c2.getLName());
        assertEquals(c.getPhoneNum(), c2.getPhoneNum());
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem c = new ContactItem("try", "this", "I", "guess");
        ContactItem c2 = new ContactItem("test", "", "test", "test");
        assertDoesNotThrow(()-> { c.editItem(c, c2); });
        assertEquals(c.getEmail(), c2.getEmail());
        assertEquals(c.getFName(), c2.getFName());
        assertEquals(c.getLName(), c2.getLName());
        assertEquals(c.getPhoneNum(), c2.getPhoneNum());
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem c = new ContactItem("try", "this", "I", "guess");
        ContactItem c2 = new ContactItem("test", "test", "", "test");
        assertDoesNotThrow(()-> { c.editItem(c, c2); });
        assertEquals(c.getEmail(), c2.getEmail());
        assertEquals(c.getFName(), c2.getFName());
        assertEquals(c.getLName(), c2.getLName());
        assertEquals(c.getPhoneNum(), c2.getPhoneNum());
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem c = new ContactItem("try", "this", "I", "guess");
        ContactItem c2 = new ContactItem("test", "test", "test", "test");
        assertDoesNotThrow(()-> { c.editItem(c, c2); });
        assertEquals(c.getEmail(), c2.getEmail());
        assertEquals(c.getFName(), c2.getFName());
        assertEquals(c.getLName(), c2.getLName());
        assertEquals(c.getPhoneNum(), c2.getPhoneNum());
    }

    @Test
    public void testToString(){
        ContactItem c = new ContactItem("First", "Last", "Phone Number", "Email");
        assertEquals(c.toString(), "Name: First Last\nPhone: Phone Number\nEmail: Email");
    }

}