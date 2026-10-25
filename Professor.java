import java.util.*;

public class Professor extends Person implements Taxable {
    
    private String department;
    private AcademicRank rank; // Delegated helper object

    Scanner in = new Scanner(System.in);

    public Professor() {}

    public void displayInfo() {
        while (true) {
            System.out.println("\n=== PROFESSOR DASHBOARD ===");
            System.out.println("Name: " + name);
            System.out.println("Address: " + address);
            System.out.println("Department: " + department);
            System.out.println("Academic Rank: " + rank.getTitle());
            System.out.printf("\nDaily Earnings: %,.2f", rank.dailyEarnings());
            System.out.printf("\nGross Pay: %,.2f", rank.getMonthlySalary());
            System.out.printf("\nTax Rate: %.1f%%", taxRate * 100);
            System.out.printf("\nNet Pay: %,.2f", computeTax());

            System.out.println("===================\n");

            System.out.println("1. View teaching load");
            System.out.println("2. Update Information");
            System.out.println("3. Return to main menu");
            System.out.print("Enter choice: ");

            switch (in.nextLine().trim()) {
                case "1":
                    teachingLoad();
                    break;
                case "2":
                    updateInfo();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 3.");
            }
        }
    }
    
    public void register() {
        System.out.println("\n-----REGISTRATION-----");
        System.out.print("Enter Full Name: ");
        name = in.nextLine();
        System.out.print("Enter Address: ");
        address = in.nextLine();

        // Course selection
        while (true) {
            System.out.println("\nSelect assigned course:");
            System.out.println("1. BSCS");
            System.out.println("2. BSIT");
            System.out.println("3. MSCS");
            System.out.println("4. MSIT");
            System.out.print("Enter choice (1-4): ");
            
            switch (in.nextLine().trim()) {
                case "1": department = "BSCS"; break;
                case "2": department = "BSIT"; break;
                case "3": department = "MSCS"; break;
                case "4": department = "MSIT"; break;
                
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
                    continue;
            }
            break;
        }

        // Academic Rank Selection using helper class
        while (true) {
            AcademicRank.displayRankMenu();
            System.out.print("Enter rank choice (1-15): ");

            try {
                int choice = Integer.parseInt(in.nextLine().trim());
                this.rank = AcademicRank.getRankByChoice(choice);
                
                if (this.rank == null) {
                    System.out.println("Invalid choice. Please select between 1 and 15.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number between 1 and 15.");
                continue;
            }
            break;
        }

        do {
            System.out.print("Enter ID Number: ");
            idNumber = in.nextLine().trim();
            if (idNumber.isEmpty()) {
                System.out.println("Input failed. ID Number must not be empty.");
            }
        } while (idNumber.isEmpty());

        do {
            System.out.print("Enter password: ");
            password = in.nextLine();
            if (password.length() <= 5) {
                System.out.println("Input failed. Password must be at least 6 characters long.");
            }
        } while (password.length() <= 5);

        System.out.println("Registration completed successfully!");
    }

    public void updateInfo() {
        boolean done = false;

        while (!done) {
            System.out.println("\n-----CHANGE PROFESSOR INFORMATION-----");
            System.out.println("1. Name (" + name + ")");
            System.out.println("2. Address (" + address + ")");
            System.out.println("3. ID Number (" + idNumber + ")");
            System.out.println("4. Academic Rank (" + rank.getTitle() + ")");
            System.out.println("5. Password");
            System.out.println("6. Done");
            System.out.print("What do you want to change? ");

            switch (in.nextLine().trim()) {
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
                    System.out.print("Enter your current password to continue: ");
                    if (!in.nextLine().equals(password)) {
                        System.out.println("Incorrect password. Change cancelled.");
                        break;
                    }
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
                    AcademicRank.displayRankMenu();
                        System.out.print("Enter new rank choice (1-15): ");
                        
                        if (in.hasNextInt()) {
                            int choice = in.nextInt();
                            in.nextLine(); // Clear the newline buffer left by nextInt()
                            
                            AcademicRank newRank = AcademicRank.getRankByChoice(choice);
                            if (newRank != null) {
                                this.rank = newRank;
                                System.out.println("Academic rank updated.");
                                break; // Successfully updated, exit the loop
                            } else {
                                System.out.println("Invalid rank choice. Please select between 1 and 15.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid number.");
                            in.next(); // Clear the invalid text token from the scanner
                        }
                    break;

                case "5":
                    System.out.print("Enter your current password to continue: ");
                    if (!in.nextLine().equals(password)) {
                        System.out.println("Incorrect password. Change cancelled.");
                        break;
                    }
                    System.out.print("Enter new password: ");
                    String newPass = in.nextLine();
                    if (newPass.length() <= 5) {
                        System.out.println("Input failed. Password must be at least 6 characters long.");
                    } else {
                        password = newPass;
                        System.out.println("Password updated.");
                    }
                    break;

                case "6":
                    done = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public double computeTax(){
        double taxAmount = rank.getMonthlySalary() * taxRate;
        return rank.getMonthlySalary() - taxAmount;
    }

    public void teachingLoad() {
        System.out.println("\nTeaching load for " + department + ":");
        SubjectItem[] subjects = SubjectItem.courseSubjects(department);

        if (subjects.length == 0) {
            System.out.println("No subjects found for this course.");
            return;
        }

        for (int i = 0; i < subjects.length; i++) {
            System.out.println("- " + subjects[i].getName());
        }
    }

    // Getters and Setters
    public String getCourse() { return department; }
    public void setCourse(String course) { this.department = course; }

    public AcademicRank getRank() { return rank; }
    public void setRank(AcademicRank rank) { this.rank = rank; }

    
}