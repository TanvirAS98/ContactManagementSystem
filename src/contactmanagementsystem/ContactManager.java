package contactmanagementsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.util.ArrayList;

class ContactManager {
    private ArrayList<Contact> contacts;

    // Constructor to initialize the contacts list
    public ContactManager() {
        contacts = new ArrayList<>();
    }

    // Method to add a contact
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Method to display all contacts
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contacts) {
                contact.displayContactInfo();
                System.out.println("--------------------");
            }
        }
    }

    // Method to find a contact by name
    public Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null; // Return null if not found
    }
}
