import java.util.*;

public class Main extends Person{
    
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
    public static void main(String[] args) {
        Person loggedInUser = null;
        Scanner in = new Scanner(System.in);
        int capacity = 10;
        Person[] users = new Person[capacity];
        int userCount = 0; // Tracks the number of registered users
        int choice = in.nextInt();

        do {
            System.out.println("\n===== SYSTEM MENU =====");
            System.out.println("1. Register");
            System.out.println("2. Student");
            System.out.println("3. Professor");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            
            switch (choice) {
                case 1: // REGISTER
                    if (userCount >= capacity) {
                        System.out.println("\n[Error] Registration failed. Maximum of " + capacity + " user capacity reached!");
                    } else {

                        System.out.println("=====CHOOSE=====");
                        System.out.print("1. Undergraduate Student \n2. Professor");
                        int registerChoice = in.nextInt();

                        if (registerChoice == 1){
                            UndergraduateStudent undergraduate = new UndergraduateStudent();
                            undergraduate.register();
                            users[userCount] = undergraduate;
                            userCount++;
                        }
                        // Create a new Person object and store it in the array
                        
                    }
                    break;

                case 2: // STUDENT
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
                    // Loop through the fixed array to find a matching user
                    for (int i = 0; i < userCount; i++) {
                        // Checking against fields (assuming package-private/protected access)
                        if (users[i].idNumber != null && users[i].idNumber.equals(inputID) && 
                            users[i].password != null && users[i].password.equals(inputPassword)) {
                            
                            loggedInUser = users[i];
                            loggedInUser.isLoggedIn = true;
                            System.out.println("Login Successful! Welcome back, " + loggedInUser.name + ".");
                            found = true;
                            break;
                        }
                    }
                    System.out.println("===== WELCOME STUDENT " + loggedInUser.name);
                    undergraduate.displayInfo();
                    if (!found) {
                        System.out.println("Wrong ID Number or Password. Please try again.");
                    }
                    break;

                case 3: // Professor
                    //to be made

                case 4: // EXIT
                    System.out.println("\nExiting program. Goodbye!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please select between 1 and 5.");
            }
        } while (choice != 5);

        in.close();
    }
}