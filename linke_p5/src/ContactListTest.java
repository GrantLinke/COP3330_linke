import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    @Test
    public void addingItemsIncreasesSize(){
        ContactList contactList = new ContactList();
        assertEquals(contactList.contactList.size(), 0);

        contactList.addItem("T", "T", "T", "T");
        assertEquals(contactList.contactList.size(), 1);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactList contactList = new ContactList();
        contactList.addItem("T","T","T","T");
        contactList.addItem("T2", "T2", "T2", "T2");
        assertThrows(IllegalArgumentException.class, ()-> {contactList.contactList.get(0).editItem
                (contactList.contactList.get(0), contactList.contactList.get(1));});
    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){

    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList contactList = new ContactList();
        contactList.addItem("T","T","T","T");
        contactList.addItem("", "T2", "T2", "T2");
        assertDoesNotThrow( ()-> {contactList.contactList.get(0).editItem
                (contactList.contactList.get(0), contactList.contactList.get(1));});
        ContactItem c1 = contactList.contactList.get(0);
        ContactItem c2 = contactList.contactList.get(1);

        assertEquals(c1.getEmail(), c2.getEmail());
        assertEquals(c1.getFName(), c2.getFName());
        assertEquals(c1.getLName(), c2.getLName());
        assertEquals(c1.getPhoneNum(), c2.getPhoneNum());
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList contactList = new ContactList();
        contactList.addItem("T","T","T","T");
        contactList.addItem("T2", "", "T2", "T2");
        assertDoesNotThrow( ()-> {contactList.contactList.get(0).editItem
                (contactList.contactList.get(0), contactList.contactList.get(1));});
        ContactItem c1 = contactList.contactList.get(0);
        ContactItem c2 = contactList.contactList.get(1);

        assertEquals(c1.getEmail(), c2.getEmail());
        assertEquals(c1.getFName(), c2.getFName());
        assertEquals(c1.getLName(), c2.getLName());
        assertEquals(c1.getPhoneNum(), c2.getPhoneNum());
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList contactList = new ContactList();
        contactList.addItem("T","T","T","T");
        contactList.addItem("T2", "T2", "", "T2");
        assertDoesNotThrow( ()-> {contactList.contactList.get(0).editItem
                (contactList.contactList.get(0), contactList.contactList.get(1));});
        ContactItem c1 = contactList.contactList.get(0);
        ContactItem c2 = contactList.contactList.get(1);

        assertEquals(c1.getEmail(), c2.getEmail());
        assertEquals(c1.getFName(), c2.getFName());
        assertEquals(c1.getLName(), c2.getLName());
        assertEquals(c1.getPhoneNum(), c2.getPhoneNum());
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactList contactList = new ContactList();
        contactList.addItem("T","T","T","T");
        contactList.addItem("T2", "T2", "T2", "T2");
        assertDoesNotThrow( ()-> {contactList.contactList.get(0).editItem
                (contactList.contactList.get(0), contactList.contactList.get(1));});
        ContactItem c1 = contactList.contactList.get(0);
        ContactItem c2 = contactList.contactList.get(1);

        assertEquals(c1.getEmail(), c2.getEmail());
        assertEquals(c1.getFName(), c2.getFName());
        assertEquals(c1.getLName(), c2.getLName());
        assertEquals(c1.getPhoneNum(), c2.getPhoneNum());
    }

    @Test
    public void newListIsEmpty(){
        ContactList contactList = new ContactList();
        assertTrue(contactList.contactList.isEmpty());
    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactList contactList = new ContactList();
        contactList.addItem("T","T","T","T");
        assertEquals(contactList.contactList.size(), 1);

        contactList.removeItem(0);
        assertEquals(contactList.contactList.size(), 0);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList contactList = new ContactList();
        contactList.addItem("T","T","T","T");
        assertEquals(contactList.contactList.size(), 1);

        assertThrows(IndexOutOfBoundsException.class, ()-> {contactList.removeItem(2);});
    }

    @Test
    public void savedContactListCanBeLoaded(){
        ContactList contactList = new ContactList();
        contactList.addItem("T","T","T","T");
        contactList.save("testCase.txt");

        ContactList contactList1 = new ContactList();
        assertDoesNotThrow(()->{contactList1.loadFile("testCase.txt");});
        ContactItem c1 = contactList.contactList.get(0);
        ContactItem c2 = contactList1.contactList.get(0);

        assertEquals(c1.getFName(), c2.getFName());
        assertEquals(c1.getPhoneNum(), c2.getPhoneNum());
        assertEquals(c1.getLName(), c2.getLName());
        assertEquals(c1.getEmail(), c2.getEmail());
    }

}