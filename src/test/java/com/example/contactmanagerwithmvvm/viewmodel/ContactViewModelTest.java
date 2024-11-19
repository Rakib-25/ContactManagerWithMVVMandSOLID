package com.example.contactmanagerwithmvvm.viewmodel;



import com.example.contactmanagerwithmvvm.model.Contact;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




import static org.junit.jupiter.api.Assertions.*;




public class ContactViewModelTest {

    private ContactViewModel contactViewModel;


    @BeforeEach
    void setUp(){
        contactViewModel = new ContactViewModel();

    }


    @Test
    void testAddContactValid() {
        //setting data for a valid contact
        contactViewModel.nameProperty().set("John Doe");
        contactViewModel.phoneProperty().set("01775773875");
        contactViewModel.emailProperty().set("mdrakibul303@gmail.com");




        contactViewModel.addContact();


        ObservableList<Contact> contactList = contactViewModel.getContactList();
        assertEquals(1,contactList.size(), "Contact list should hold at least one contact");
        Contact addedContact = contactList.get(0);
        assertEquals("John Doe", addedContact.getName());
        assertEquals("01775773875",addedContact.getPhone());
        assertEquals("mdrakibul303@gmail.com", addedContact.getEmail());
    }
    
    
}
