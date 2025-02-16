/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsystem;

import java.util.Scanner;

/**
 *
 * @author User
 */

import java.util.Scanner;

public class ContactManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        while (true) {
            // Display menu to the user
            System.out.println("Contact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact by Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                // Add contact
                Contact newContact = new Contact();

                System.out.print("Enter Name: ");
                newContact.setName(scanner.nextLine());

                System.out.print("Enter Age: ");
                newContact.setAge(scanner.nextInt());
                scanner.nextLine();

                System.out.print("Enter Phone Number: ");
                newContact.setPhoneNumber(scanner.nextLine());

                manager.addContact(newContact);
                System.out.println("Contact added successfully!\n");

            } else if (choice == 2) {
                // View all contacts
                System.out.println("\nView All Contacts:");
                manager.displayContacts();
            } else if (choice == 3) {
                // Search contact by name
                System.out.print("Enter Name to search: ");
                String name = scanner.nextLine();
                Contact contact = manager.findContactByName(name);

                if (contact != null) {
                    System.out.println("\nContact Found:");
                    contact.displayContactInfo();
                } else {
                    System.out.println("Contact not found.\n");
                }
            } else if (choice == 4) {
                // Exit
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.\n");
            }
        }

        scanner.close();
    }
}

