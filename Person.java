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
        System.out.print("Enter ID Number: ");
        registerIDNumber = in.nextLine();
        System.out.print("Enter password: ");
        registerPassword = in.nextLine();
        System.out.print("Registration Complete!" + name + " has been added.");
    }

    public void login() {
        System.out.println("-----LOGIN----");
        System.out.print("Enter ID Number: ");
        System.out.print("Enter Password: ");

        if (registerIDNumber == loginIDNumber && registerPassword == loginPassword) {
            System.out.print("Login Successful!");
        } else{
            System.out.print("Wrong ID Number or Password. Please try again.");
        }
    }

    public void logout(){
        isloggedIn = false;
    }
}



