import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int capacity = 10;
        Person[] users = new Person[capacity];
        int userCount = 0;
        Person loggedInUser = null;

        int choice = 0;

        while (choice != 5) {
            System.out.println("\n===== UNIVERSITY INFORMATION MANAGEMENT SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Professor (To be made)");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
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

                    if (registerChoice == 1) {
                        UndergraduateStudent undergraduate = new UndergraduateStudent();
                        undergraduate.register();

                        users[userCount] = undergraduate;
                        userCount++;
                        System.out.println("Student successfully registered in slot " + userCount);

                    } else if (registerChoice == 2) {
                        MasteralStudent masteral = new MasteralStudent();
                        masteral.in = in;
                        masteral.register();

                        users[userCount] = masteral;
                        userCount++;
                        System.out.println("Masteral student successfully registered in slot " + userCount);
                    } else if (registerChoice == 3) {
                        System.out.println("Professor registration coming soon.");
                    } else {
                        System.out.println("Invalid account type. Please select between 1 and 3.");
                    }
                    break;
                }

                case 2: { // LOGIN
                    if (userCount == 0) {
                        System.out.println("\nNo accounts registered yet. Please register first.");
                        break;
                    }

                    System.out.println("\n-----LOGIN-----");
                    System.out.print("Enter ID Number: ");
                    String inputID = in.nextLine();
                    System.out.print("Enter Password: ");
                    String inputPassword = in.nextLine();

                    boolean found = false;
                    for (int i = 0; i < userCount; i++) {
                        if (users[i].idNumber != null && users[i].idNumber.equals(inputID)
                                && users[i].password != null && users[i].password.equals(inputPassword)) {
                            loggedInUser = users[i];
                            loggedInUser.isLoggedIn = true;
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        System.out.println("\nLogin Successful!");
                        loggedInUser.displayInfo();
                    } else {
                        System.out.println("Wrong ID Number or Password. Please try again.");
                    }
                    break;
                }

                case 3: // PROFESSOR
                    System.out.println("\n[Feature under development]");
                    break;

                case 4: // LOGOUT
                    if (loggedInUser != null) {
                        loggedInUser.isLoggedIn = false;
                        loggedInUser = null;
                        System.out.println("\nYou logged out.");
                    } else {
                        System.out.println("\nYou are not logged in.");
                    }
                    break;

                case 5: // EXIT
                    System.out.println("\nExiting program. Goodbye!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please select between 1 and 5.");
            }
        }

        in.close();
    }
}