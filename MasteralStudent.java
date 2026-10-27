public class MasteralStudent extends Student {

    public void displayInfo() {
        super.displayInfo();
    }

    public void register() {
        System.out.println("\n-----REGISTRATION-----");
        System.out.print("Enter Full Name: ");
        name = in.nextLine();
        System.out.print("Enter address: ");
        address = in.nextLine();

        int courseChoice = 0;
        do {
            System.out.println("Select Masteral Course:");
            System.out.println("[1] Master of Science in Computer Science (MSCS)");
            System.out.println("[2] Master of Science in Information Technology (MSIT)");
            System.out.print("Enter choice (1 or 2): ");

            if (in.hasNextInt()) {
                courseChoice = in.nextInt();
                in.nextLine();

                if (courseChoice != 1 && courseChoice != 2) {
                    System.out.println("Invalid selection. Please choose 1 or 2.\n");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.\n");
                in.nextLine();
            }
        } while (courseChoice != 1 && courseChoice != 2);

        if (courseChoice == 1) {
            course = "MSCS";
        } else {
            course = "MSIT";
        }

        subjects = SubjectItem.courseSubjects(course);

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

            if (password.isEmpty()) {
                System.out.println("Input failed. Password must not be empty.");
            } else if (password.length() <= 5) {
                System.out.println("Input failed. Password must be at least 6 characters long.");
            }
        } while (password.isEmpty() || password.length() <= 5);

        System.out.println("Registration Complete! " + name + " has been added.");
    }

    public String isMerit() {
        double gwa = computeGWA();

        if (gwa >= 1.00 && gwa <= 1.25) {
            return "Gold (100% Discount)";
        } else if (gwa > 1.25 && gwa <= 1.50) {
            return "Silver Merit (50% Discount)";
        } else if (gwa > 1.50 && gwa <= 1.75) {
            return "Bronze Merit (25% Discount)";
        } else {
            return "None";
        }
    }

    public double discountedTuition() {
        double baseTuition = computeTuition();
        double gwa = computeGWA();

        if (gwa >= 1.00 && gwa <= 1.25) {
            return baseTuition - baseTuition * 1.0;
        } else if (gwa > 1.25 && gwa <= 1.50) {
            return baseTuition - baseTuition * 0.50;
        } else if (gwa > 1.50 && gwa <= 1.75) {
            return baseTuition - baseTuition * 0.25;
        } else {
            return baseTuition;
        }
    }

    public void academicStatus() {
        if (computeGWA() >= 1.00 && computeGWA() <= 1.99) {
            System.out.println("Outstanding");
        } else if (computeGWA() >= 2.00 && computeGWA() <= 2.49) {
            System.out.println("Passed");
        } else if (computeGWA() >= 2.50 && computeGWA() <= 2.99) {
            System.out.println("Conditional");
        } else if (computeGWA() >= 3.00) {
            System.out.println("Failed");
        } else {
            System.out.println("None");
        }
    }
}
