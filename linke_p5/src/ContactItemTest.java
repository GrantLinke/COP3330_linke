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
        {ContactItem c = new ContactItem("try", "this", "I", "guess");});
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        assertDoesNotThrow(() -> {ContactItem c = new
                ContactItem("Good", "Name", "justForTest", "yeah");});
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){

    }

    @Test
    public void editingSucceedsWithBlankLastName(){

    }

    @Test
    public void editingSucceedsWithBlankPhone(){

    }

    @Test
    public void editingSucceedsWithNonBlankValues(){

    }

    @Test
    public void testToString(){

    }

}