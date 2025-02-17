package contactmanagementsystem;

import java.util.ArrayList;

class ContactManager {
    private ArrayList<Contact> contacts;

    // Constructor to initialize the contacts list
    public ContactManager() {
        contacts = new ArrayList<>();
    }

    // Method to add a contact
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Cannot add a null contact.");
        }
        contacts.add(contact);
    }

    // Method to display all contacts
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            try {
                for (Contact contact : contacts) {
                    if (contact == null) {
                        throw new NullPointerException("Contact is null.");
                    }
                    contact.displayContactInfo();
                    System.out.println("--------------------");
                }
            } catch (NullPointerException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Method to find a contact by name
    public Contact findContactByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Search name cannot be null or empty.");
        }
        for (Contact contact : contacts) {
            if (contact != null && contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null; // Return null if not found
    }
}
