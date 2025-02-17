package contactmanagementsystem;

public class Contact {
    private String name;
    private int age;
    private String phoneNumber;

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive number.");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty or null.");
        }
        if (!phoneNumber.matches("\\d{11}")) { // Validate if phone number is exactly 11 digits
            throw new IllegalArgumentException("Phone number must be exactly 11 digits.");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void displayContactInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge() + " years old");
        System.out.println("Phone Number: " + getPhoneNumber());
    }
}
