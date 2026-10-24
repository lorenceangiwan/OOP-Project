public class UndergraduateStudent extends Student {

    public void displayInfo() {
        if (!isLoggedIn) {
            System.out.println("Please log in to view your information.\n");
            return;
        }

        int choice = 0;
        while (choice != 3) {
            System.out.println("\n===== WELCOME =====");
            System.out.println("Name: " + name);
            System.out.println("Address: " + address);
            System.out.println("ID Number: " + idNumber);
            System.out.println("Course: " + course);
            System.out.println("Assigned Subjects:");
                for (int i = 0; i < subjects.length; i++) {
                    System.out.printf("- %s (%d units): %.2f%n",
                        subjects[i].getName(), subjects[i].getUnits(), subjects[i].getGrade());
                }

            System.out.printf("Overall GWA: %.2f%n", computeGWA());
            System.out.print("Status: ");
            academicStatus();

            System.out.println("===================\n");

            System.out.println("1. Enter grades");
            System.out.println("2. Update Information");
            System.out.println("3. Return to main menu");
            System.out.print("Enter choice: ");
            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1: //grades
                    inputGrades();
                    break;
                case 2: //updating information
                    double gwa = computeGWA();
                    if (gwa > 0.0) {
                        System.out.printf("Overall GWA: %.2f%n", gwa);
                    }
                    break;
                case 3: //return to menu
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 3.");
            }
        }
    }

    public void selectCourse(){
        int courseChoice = 0;
        do {
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
                in.nextLine(); // Clear invalid non-integer input
            }
        } while (courseChoice != 1 && courseChoice != 2);

        // 2. Assign Course String
        if (courseChoice == 1) {
            course = "BSCS";
        } else {
            course = "BSIT";
        }

        // 3. Fetch subjects dynamically from the SubjectItem catalog class
        subjects = SubjectItem.courseSubjects(course);
    }

    public void academicStatus(){
        if(computeGWA() >= 1.00 && computeGWA() <= 1.99) {
            System.out.println("Outstanding");
        } else if(computeGWA() >= 2.00 && computeGWA() <= 2.99){
            System.out.println("Satisfactory");
        } else if(computeGWA() >= 3.00 && computeGWA() <= 3.49) {
            System.out.println("Passed");
        } else if(computeGWA() >= 3.50 && computeGWA() <= 4.00){
            System.out.println("Conditional");
        } else if(computeGWA() >= 5.00){
            System.out.println("Failed");
        } else{
            System.out.println("None");
        }
    }
}
