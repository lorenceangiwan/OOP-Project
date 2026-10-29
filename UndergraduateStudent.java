public class UndergraduateStudent extends Student {

    // Uses the common student dashboard.
    public void displayInfo() {
        super.displayInfo();
    }
    
    public void updateInfo(){
        boolean done = false;

        while (!done) {
            System.out.println("\n-----CHANGE STUDENT INFORMATION-----");
            System.out.println("1. Name (" + name + ")");
            System.out.println("2. Address (" + address + ")");
            System.out.println("3. Course (" + course + ")");
            System.out.println("4. Password");
            System.out.println("5. Done");
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

                case "3": {
                    System.out.println("Changing course will replace your subjects and reset their grades.");
                    System.out.print("Continue? (y/n): ");

                    String confirmation = in.nextLine().trim();
                    while (!confirmation.equalsIgnoreCase("y") && !confirmation.equalsIgnoreCase("n")) {
                        System.out.println("Invalid input. Please enter y or n.");
                        System.out.print("Continue? (y/n): ");
                        confirmation = in.nextLine().trim();
                    }
                    if (confirmation.equalsIgnoreCase("n")) {
                        System.out.println("Cancelled.");
                        break;
                    }

                    String oldCourse = course;
                    selectCourse();

                    if (oldCourse.equals(course)) {
                        System.out.println("You are already enrolled in " + course + ". Your grades were not changed.");
                        break;
                    }

                    subjects = SubjectItem.courseSubjects(course);
                    System.out.println("Course updated to " + course + ". Subjects and grades have been reset.");
                    break;
                }

                case "4":
                    if (!confirmPassword()) {
                        break;
                    }
                    System.out.print("Enter new password: ");
                    String newPassword = in.nextLine();
                    if (newPassword.length() <= 5) {
                        System.out.println("Input failed. Password must be at least 6 characters long.");
                    } else {
                        password = newPassword;
                        System.out.println("Password updated.");
                    }
                    break;

                case "5":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Collects the student's profile, course, and login credentials.
    public void register(){
        System.out.println("\n-----REGISTRATION-----");
        degreeType = "Undergraduate";
        System.out.print("Enter Full Name: ");
        name = in.nextLine();
        System.out.print("Enter address: ");
        address = in.nextLine();

        selectCourse();
        // Fetch subjects dynamically from the SubjectItem catalog class
        subjects = SubjectItem.courseSubjects(course);
        System.out.println("Chosen course: " + course);

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

    }

    public void selectCourse() {
        int courseChoice = 0;
        while (courseChoice != 1 && courseChoice != 2) {
            System.out.println("Select Course:");
            System.out.println("[1] Bachelor of Science in Computer Science (BSCS)");
            System.out.println("[2] Bachelor of Science in Information Technology (BSIT)");
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
        }

        if (courseChoice == 1) {
            course = "BSCS";
        } else {
            course = "BSIT";
        }
    }

    public int computeUnits(){
        return super.computeUnits();
    }

    public void inputGrades(){
        super.inputGrades();
    }

    public double computeGWA(){
        return super.computeGWA();
    }

    public String academicStatus(){
        // Convert the computed average into the undergraduate status category.
        double gwa = computeGWA();
        if(gwa >= 1.00 && gwa <= 1.99) {
            return "Outstanding";
        } else if(gwa >= 2.00 && gwa <= 2.99){
            return "Satisfactory";
        } else if(gwa >= 3.00 && gwa <= 3.49) {
            return "Passed";
        } else if(gwa >= 3.50 && gwa <= 4.00){
            return "Conditional";
        } else if(gwa > 4.00){
            return "Failed";
        } else{
            return "None";
        }
    }

    public double computeTuition(){
        return computeUnits() * 1200.0;
    }

    // Describes the merit award determined by the student's GWA.
    public String isMerit() {
    double gwa = computeGWA(); // Calling once to avoid recalculating multiple times

        if (gwa >= 1.00 && gwa <= 1.25) {
            return "Gold (100% Discount)";
        } else if (gwa > 1.25 && gwa <= 1.50) {
            return "Silver (50% Discount)";
        } else if (gwa > 1.50 && gwa <= 1.75) {
            return "Bronze (25% Discount)";
        } else {
            return "None";
        }
    }

    public double discountedTuition(){
        double baseTuition = computeTuition();
        double gwa = computeGWA();

        // Apply the tuition reduction according to student's merit tier.
        if (gwa >= 1.00 && gwa <= 1.25) {
            return baseTuition - baseTuition * 1.0; // Gold (100% discount)
        } else if (gwa > 1.25 && gwa <= 1.50) {
            return baseTuition - baseTuition * 0.50; // Silver Merit (50% discount)
        } else if (gwa > 1.50 && gwa <= 1.75) {
            return baseTuition - baseTuition * 0.25; // Bronze Merit (25% discount)
        } else {
            return baseTuition; // No discount
        }
    }

    public boolean confirmPassword(){
        return super.confirmPassword();
    }
}
