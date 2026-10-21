import java.util.*;

public class Person {
    protected String name, address, registerIDNumber, loginIDNumber, registerPassword, loginPassword;
    protected boolean isloggedIn = false;
    Scanner in = new Scanner(System.in);

    public Person(){}

    public void register(){
        System.out.println("-----REGISTRATION-----");
        System.out.print("Enter Full Name: ");
        name = in.nextLine();
        System.out.print("Enter address: ");
        address = in.nextLine();

        do {
            System.out.print("Enter ID Number: ");
            registerIDNumber = in.nextLine();
        
            if (registerIDNumber.isEmpty()) {
                System.out.println("Input failed. ID Number must not be empty.");
            }
        } while (registerIDNumber.isEmpty());

        do{
            System.out.print("Enter password: ");
            registerPassword = in.nextLine();

            if (registerPassword.isEmpty())
                System.out.println("Input failed. Password must not be empty.");
            else if (registerPassword.length() <= 5) {
                System.out.println("Input failed. Password must be at least 6 characters long.");
            }
        } while (registerPassword.isEmpty() || registerPassword.length() <= 5);

        System.out.print("Registration Complete! " + name + " has been added.");
    }

    public void login() {
        System.out.println("-----LOGIN----");
        System.out.print("Enter ID Number: ");
        loginIDNumber = in.nextLine();
        System.out.print("Enter Password: ");
        loginPassword = in.nextLine();

        if (loginIDNumber != null && loginPassword != null && registerIDNumber.equals(loginIDNumber) && registerPassword.equals(loginPassword)) {
            isloggedIn = true;
            System.out.print("Login Successful!");
        } else{
            System.out.print("Wrong ID Number or Password. Please try again.");
        }
    }

    public void logout(){
        if (isloggedIn) {
            isloggedIn = false;
            System.out.println("You logged out.");
        }
    }

    public void displayInfo() {
        if(isloggedIn){
            System.out.println("=====WELCOME=====");
            System.out.println("Name: " + name);
            System.out.println("Address: " + address);
            System.out.println("ID Number: " + registerIDNumber);
        }
        

    }
}



