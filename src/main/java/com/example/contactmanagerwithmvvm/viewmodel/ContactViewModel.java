package com.example.contactmanagerwithmvvm.viewmodel;

import com.example.contactmanagerwithmvvm.model.Contact;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.regex.Pattern;





public class ContactViewModel {


    //hold up a list of contact in an array
    private final ObservableList<Contact> contactList = FXCollections.observableArrayList();



    //for binding data with UI like textField
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty phone = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();





    //Getter Methods for Observable List
    public ObservableList<Contact> getContactList(){
        return contactList;
    }
    public StringProperty getName(){
        return name;
    }
    public StringProperty getPhone(){
        return phone;
    }
    public StringProperty getEmail(){
        return email;
    }




    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._+=-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");


    public boolean isNameValid(){
        return !name.get().trim().isEmpty();
    }
    public boolean isPhoneValid(){
        return phone.get().matches("\\d+");
    }
    public boolean isEmailValid(){
        return EMAIL_PATTERN.matcher(email.get()).matches();
    }

    public boolean isContactValid(){
        return isEmailValid() && isPhoneValid() && isNameValid();
    }



    //setter for observable list (from text input of user)
    public void addContact(){

        if(!name.get().isEmpty() && !email.get().isEmpty() && !phone.get().isEmpty()) {
            Contact newContact = new Contact(name.get(), phone.get(), email.get());
            contactList.add(newContact);
            clearFields();
        }
    }




    //function for clearing textfield
    private void clearFields(){
        name.set("");
        phone.set("");
        email.set("");
    }







}
