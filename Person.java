import java.util.*;

public class Person {
    protected String name, address, idNumber, password;
    protected boolean isLoggedIn;
    Scanner in = new Scanner(System.in);

    public Person() {}

    public void register(){
        System.out.println("-----REGISTRATION-----");
        System.out.print("Enter Full Name: ");
        name = in.nextLine();
        System.out.print("Enter address: ");
        address = in.nextLine();

        do {
            System.out.print("Enter ID Number: ");
            idNumber = in.nextLine();

            if (idNumber.isEmpty()) {
                System.out.println("Input failed. ID Number must not be empty.");
            }
        } while (idNumber.isEmpty());

        do {
            System.out.print("Enter password: ");
            password = in.nextLine();

            if (password.isEmpty())
                System.out.println("Input failed. Password must not be empty.");
            else if (password.length() <= 5) {
                System.out.println("Input failed. Password must be at least 6 characters long.");
            }
        } while (password.isEmpty() || password.length() <= 5);

        System.out.println("Registration Complete! " + name + " has been added.");
    }

    public void login(String inputIDNumber, String inputPassword) {
        System.out.println("-----LOGIN-----");

        if (this.idNumber == null || this.password == null) {
            System.out.println("Error: Account not registered. Please register first.");
        }

        System.out.print("Enter ID Number: ");
        String inputIdNumber = in.nextLine();
        System.out.print("Enter Password: ");
        inputPassword = in.nextLine();

        if (idNumber.equals(inputIdNumber) && password.equals(inputPassword)) {
            isLoggedIn = true;
            System.out.println("Login Successful!");
        } else {
            System.out.println("Wrong ID Number or Password. Please try again.");
        }
    }

    public void logout(){
        if (isLoggedIn) {
            isLoggedIn = false;
            System.out.println("You logged out.");
        } else {
            System.out.println("You are not logged in.");
        }
    }

    public void displayInfo() {
        if (isLoggedIn) {
            System.out.println("\n===== WELCOME =====");
            System.out.println("Name: " + name);
            System.out.println("Address: " + address);
            System.out.println("ID Number: " + idNumber);
            System.out.println("===================\n");
        } else {
            System.out.println("Please log in to view your information.\n");
        }
    }

    public void changeInfo() {
    if (!isLoggedIn) {
        System.out.println("Please log in to change your information.");
        return;
    }

    boolean done = false;
    while (!done) {
        System.out.println("\n-----CHANGE INFORMATION-----");
        System.out.println("1. Name (" + name + ")");
        System.out.println("2. Address (" + address + ")");
        System.out.println("3. ID Number (" + idNumber + ")");
        System.out.println("4. Password");
        System.out.println("5. Done");
        System.out.print("What do you want to change? ");
        String choice = in.nextLine().trim();

        switch (choice) {
            case "1":
                System.out.print("Enter new full name: ");
                String newName = in.nextLine().trim();
                if (newName.isEmpty()) {
                    System.out.println("Input failed. Name must not be empty.");
                } else {
                    name = newName;
                    System.out.println("Name updated.");
                }
                break;

            case "2":
                System.out.print("Enter new address: ");
                String newAddress = in.nextLine().trim();
                if (newAddress.isEmpty()) {
                    System.out.println("Input failed. Address must not be empty.");
                } else {
                    address = newAddress;
                    System.out.println("Address updated.");
                }
                break;

            case "3":
                if (!confirmPassword()) break;
                System.out.print("Enter new ID Number: ");
                String newID = in.nextLine().trim();
                if (newID.isEmpty()) {
                    System.out.println("Input failed. ID Number must not be empty.");
                } else {
                    idNumber = newID;
                    System.out.println("ID Number updated.");
                }
                break;

            case "4":
                if (!confirmPassword()) break;
                System.out.print("Enter new password: ");
                String newPass = in.nextLine();
                if (newPass.length() <= 5) {
                    System.out.println("Input failed. Password must be at least 6 characters long.");
                } else {
                    password = newPass;
                    System.out.println("Password updated.");
                }
                break;

            case "5":
                done = true;
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }
}

// Helper: asks for the current password before changing sensitive info
private boolean confirmPassword() {
    System.out.print("Enter your current password to continue: ");
    String entered = in.nextLine();
    if (password.equals(entered)) {
        return true;
    }
    System.out.println("Incorrect password. Change cancelled.");
    return false;
}
}