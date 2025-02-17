/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        while (true) {
            try {
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
                    int age = getValidAge(scanner);
                    newContact.setAge(age);

                    // Get valid phone number
                    String phoneNumber = getValidPhoneNumber(scanner);
                    newContact.setPhoneNumber(phoneNumber);

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
            } catch (InputMismatchException e) {
                // Handle invalid input type (non-integer input for choice and age)
                System.out.println("Invalid input. Please enter a valid number.\n");
                scanner.nextLine(); // Clear the buffer
            } catch (IllegalArgumentException e) {
                // Handle invalid arguments (name, age, phone number)
                System.out.println("Error: " + e.getMessage() + "\n");
            } catch (Exception e) {
                // Catch any other unexpected errors
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }

        scanner.close();
    }

    // Method to handle age input validation
    private static int getValidAge(Scanner scanner) {
        while (true) {
            try {
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                if (age <= 0) {
                    System.out.println("Age must be a positive integer. Please try again:");
                } else {
                    return age;
                }
            } catch (InputMismatchException e) {
                // Handle invalid input for age (non-integer input)
                System.out.println("Invalid age input. Please enter a valid number:");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }

    // Method to handle phone number input validation
    private static String getValidPhoneNumber(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter Phone Number (11 digits): ");
                String phoneNumber = scanner.nextLine();
                
                // Validate and set the phone number
                if (phoneNumber.length() != 11) {
                    throw new IllegalArgumentException("Phone number must be exactly 11 digits.");
                }

                // Check if the phone number contains only digits
                if (!phoneNumber.matches("\\d{11}")) {
                    throw new IllegalArgumentException("Phone number must contain only digits.");
                }

                // If phone number is valid, return it
                return phoneNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid phone number: " + e.getMessage() + " Please try again.");
            }
        }
    }
}
