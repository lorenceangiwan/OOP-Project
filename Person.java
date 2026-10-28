import java.util.*;

public abstract class Person {
    protected String name, address, idNumber, password;

    Scanner in = new Scanner(System.in);

    public Person() {}

    public abstract void displayInfo();

    public abstract void updateInfo(); 

    public boolean confirmPassword() {
        System.out.print("Enter your current password to continue: ");
        String entered = in.nextLine();
        if (password.equals(entered)) {
            return true;
        }
        System.out.println("Incorrect password. Change cancelled.");
        return false;
    }
}