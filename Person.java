import java.util.*;

public class Person {
    protected String name, address, registerIDNumber, loginIDNumber, registerPassword, loginPassword;
    Scanner in = new Scanner(System.in);

    public Person(){}

    public void register(){
        System.out.println("-----REGISTRATION----");
        System.out.print("Enter Full Name: ");
        name = in.nextLine();
        System.out.print("Enter address: ");
        address = in.nextLine();
        System.out.print("Enter ID Number: ");
        registerIDNumber = in.nextLine();
        System.out.print("Enter password: ");
        registerPassword = in.nextLine();
    }

    public void login() {
        System.out.println("-----LOGIN----");
        System.out.print("Enter ID Number: ");
        System.out.print("Enter Password: ");

        if (registerIDNumber == loginIDNumber) {
            if (registerPassword == loginPassword) {
                System.out.print("Welcome!");
            }
        } else{
            System.out.print("Wrong ID Number or Password. Please try again.");
        }
    }
}



