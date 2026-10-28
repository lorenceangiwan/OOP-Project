import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int capacity = 10;
        Person[] users = new Person[capacity];
        int userCount = 0;
        Person loggedInUser = null;

        int choice = 0;

        while (choice != 3) {
            System.out.println("\n===== UNIVERSITY INFORMATION MANAGEMENT SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            
            while (!in.hasNextInt()) {
                System.out.print("Invalid input. Enter a number between 1 and 3: ");
                in.nextLine();
            }
            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1: { // REGISTER
                    if (userCount >= capacity) {
                        System.out.println("\n[Error] Registration failed. Maximum of " + capacity + " user capacity reached!");
                        break;
                    }

                    System.out.println("\n===== CHOOSE ACCOUNT TYPE =====");
                    System.out.println("1. Undergraduate Student");
                    System.out.println("2. Masteral Student");
                    System.out.println("3. Professor");
                    System.out.print("Enter choice: ");

                    while (!in.hasNextInt()) {
                        System.out.print("Invalid input. Enter 1, 2, or 3: ");
                        in.nextLine();
                    }
                    int registerChoice = in.nextInt();
                    in.nextLine();

                    Person newUser = null;

                    if (registerChoice == 1) {
                        UndergraduateStudent undergraduate = new UndergraduateStudent();
                        undergraduate.register();
                        newUser = undergraduate;
                    } else if (registerChoice == 2) {
                        MasteralStudent masteral = new MasteralStudent();
                        masteral.register();
                        newUser = masteral;
                    } else if (registerChoice == 3) {
                        Professor professor = new Professor();
                        professor.register();
                        newUser = professor;
                    } else {
                        System.out.println("Invalid account type. Please select between 1 and 3.");
                        break;
                    }

                    // --- DUPLICATE ID VALIDATOR ---
                    boolean idExists = false;
                    for (int i = 0; i < userCount; i++) {
                        if (users[i].idNumber != null && users[i].idNumber.equals(newUser.idNumber)) {
                            idExists = true;
                            break;
                        }
                    }

                    if (idExists) {
                        System.out.println("\n[Error] An account with ID Number '" + newUser.idNumber + "' already exists!");
                        System.out.println("Registration cancelled. Please try registering again with a unique ID.");
                    } else {
                        users[userCount] = newUser;
                        userCount++;

                        System.out.println("Registration Complete! " + newUser.name + " has been added.");
                        System.out.println("Account successfully registered in slot " + userCount);
                    }
                    break;
                }

                case 2: { // UNIFIED LOGIN (Handles both Students and Professors)
                    if (userCount == 0) {
                        System.out.println("\nNo accounts registered yet. Please register first.");
                        break;
                    }

                    System.out.println("\n----- LOGIN -----");
                    System.out.print("Enter ID Number: ");
                    String inputID = in.nextLine();
                    System.out.print("Enter Password: ");
                    String inputPassword = in.nextLine();

                    boolean found = false;
                    
                    for (int i = 0; i < userCount; i++) {
                        // Checks ID and password across all registered users regardless of role
                        if (users[i].idNumber != null && users[i].idNumber.equals(inputID)
                                && users[i].password != null && users[i].password.equals(inputPassword)) {
                            loggedInUser = users[i];
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        System.out.println("\nLogin Successful!");
                        loggedInUser.displayInfo();
                        loggedInUser = null;
                    } else {
                        System.out.println("Wrong ID Number or Password. Please try again.");
                    }
                    break;
                }

                case 3: // EXIT
                    System.out.println("\nExiting program. Goodbye!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please select between 1 and 3.");
            }
        }

        in.close();
    }
}