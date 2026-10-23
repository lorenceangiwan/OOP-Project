import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        Person[] users = new Person[5];
        int userCount = 0; // Tracks the number of registered users
        
        do {
            System.out.println("\n===== SYSTEM MENU =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Info");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = in.nextInt();
            
            switch (choice) {
                case 1: // REGISTER
                    if (userCount >= 5) {
                        System.out.println("\n[Error] Registration failed. Maximum user capacity reached!");
                    } else {

                        System.out.println("=====CHOOSE=====");
                        System.out.print("1. Student \n2. Professor");
                        int registerChoice = in.nextInt();

                        if (registerChoice == 1){
                            Person newPerson = new Person();
                            newPerson.register();
                            users[userCount] = newPerson;
                            userCount++;
                        }
                        // Create a new Person object and store it in the array
                        
                    }
                    break;

                case 2: // LOGIN
                    if (userCount == 0) {
                        System.out.println("\nNo accounts registered yet. Please register first.");
                        break;
                    }

                    System.out.println("\n----- LOGIN -----");
                    System.out.print("Enter ID Number: ");
                    String inputID = in.nextLine();
                    System.out.print("Enter Password: ");
                    String inputPass = in.nextLine();

                    boolean found = false;
                    // Loop through the fixed array to find a matching user
                    for (int i = 0; i < userCount; i++) {
                        // Checking against fields (assuming package-private/protected access)
                        if (users[i].idNumber != null && users[i].idNumber.equals(inputID) && 
                            users[i].password != null && users[i].password.equals(inputPass)) {
                            
                            loggedInUser = users[i];
                            loggedInUser.isLoggedIn = true;
                            System.out.println("Login Successful! Welcome back, " + loggedInUser.name + ".");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Wrong ID Number or Password. Please try again.");
                    }
                    break;

                case 3: // VIEW INFO
                    if (loggedInUser != null) {
                        loggedInUser.displayInfo();
                    } else {
                        System.out.println("\nPlease log in first to view your information.");
                    }
                    break;

                case 4: // LOGOUT
                    if (loggedInUser != null) {
                        loggedInUser.logout();
                        loggedInUser = null; // Clear active session reference
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
        } while (choice != 5);

        scanner.close();
    }
}