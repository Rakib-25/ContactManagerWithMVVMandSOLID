package com.example.contactmanagerwithmvvm.view;
import com.example.contactmanagerwithmvvm.model.Contact;
import com.example.contactmanagerwithmvvm.viewmodel.ContactViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;








public class ContactController {

    @FXML
    private TextField nameInput;
    @FXML
    private TextField phoneInput;
    @FXML
    private TextField emailInput;
    @FXML
    private Label nameErrorLabel;
    @FXML
    private Label phoneErrorLabel;
    @FXML
    private Label emailErrorLabel;

    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;

    @FXML
    private ListView<Contact> contactListView;

    private ContactViewModel contactViewModel;

    @FXML
    public void initialize(){
        contactViewModel = new ContactViewModel();


        nameInput.textProperty().bindBidirectional(contactViewModel.getName());
        phoneInput.textProperty().bindBidirectional(contactViewModel.getPhone());
        emailInput.textProperty().bindBidirectional(contactViewModel.getEmail());


        contactListView.setItems(contactViewModel.getContactList());


        addButton.setOnAction(event -> {
            if (contactViewModel.isContactValid()){
                contactViewModel.addContact();

                clearErrorLabel();
            }
            else {
                showErrorLabel();

            }
        });


        deleteButton.setOnAction(event -> {
            Contact selectedContact = contactListView.getSelectionModel().getSelectedItem();
            if (selectedContact != null){
                contactViewModel.getContactList().remove(selectedContact);
            }
        });






    }
    public void showErrorLabel(){

        if (!contactViewModel.isNameValid()){
            nameErrorLabel.setText("Name cannot be empty");
        }
        else {
            nameErrorLabel.setText("");
        }
        if (!contactViewModel.isPhoneValid()){
            phoneErrorLabel.setText("Phone number can only be digit");
        }
        else {
            phoneErrorLabel.setText("");
        }
        if (!contactViewModel.isEmailValid()){
            emailErrorLabel.setText("Please give a valid email");
        }
        else {
            emailErrorLabel.setText("");
        }


    }

    public void clearErrorLabel(){
        nameErrorLabel.setText("");
        phoneErrorLabel.setText("");
        emailErrorLabel.setText("");
    }



}