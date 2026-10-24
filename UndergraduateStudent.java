public class UndergraduateStudent extends Student {

    public void displayInfo() {
        if (!isLoggedIn) {
            System.out.println("Please log in to view your information.\n");
            return;
        }

        int choice = 0;
        while (choice != 4) {
            System.out.println("\n===== WELCOME =====");
            System.out.println("Name: " + name);
            System.out.println("Address: " + address);
            System.out.println("ID Number: " + idNumber);
            System.out.println("Course: " + course);
            System.out.println("Assigned Subjects:");

            if (subjects != null) {
                for (int i = 0; i < subjects.length; i++) {
                    System.out.println("- " + subjects[i].getName() + " (" + subjects[i].getUnits() + " units)"); //display subjects and units
                }
            } else {
                System.out.println("No Subjects Yet");
            }
            System.out.println("===================\n");

            System.out.println("1. Add student information");
            System.out.println("2. Enter grades");
            System.out.println("3. Compute overall GWA");
            System.out.println("4. Return to main menu");
            System.out.print("Enter choice: ");
            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    addInfo();
                    break;
                case 2:
                    inputGrades();
                    break;
                case 3:
                    System.out.println("GWA computation is under development.");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 4.");
            }
        }
    }

    public void addInfo(){
    System.out.println("-----STUDENT INFORMATION-----");

    //selecting courses
    int courseChoice = 0;
    do {
        System.out.println("Select Course:");
        System.out.println("[1] Bachelor of Science in Computer Science (BSCS)");
        System.out.println("[2] Bachelor of Science in Information Technology (BSIT)");
        System.out.print("Enter choice (1 or 2): ");
        courseChoice = in.nextInt();
        in.nextLine();

        if (courseChoice != 1 && courseChoice != 2) {
            System.out.println("Invalid selection. Please choose 1 or 2.\n");
        }

    } while (courseChoice != 1 && courseChoice != 2);

    // courses and its units
    switch (courseChoice) {
    case 1:
        course = "BSCS";
        subjects = new SubjectItem[] {
            new SubjectItem("Data Structures and Algorithms", 3),
            new SubjectItem("Discrete Structures 2", 3),
            new SubjectItem("Object-Oriented Programming", 3),
            new SubjectItem("Information Management", 3),
            new SubjectItem("Readings in Philippine History", 3),
            new SubjectItem("The Entrepreneurial Mind", 3)
        };
        break;
    case 2:
        course = "BSIT";
        subjects = new SubjectItem[] {
            new SubjectItem("Networking", 3),
            new SubjectItem("Database Systems", 3),
            new SubjectItem("Web Development", 3),
            new SubjectItem("System Administration", 3)
        };
        break;
}


        System.out.println("\n===== STUDENT INFORMATION =====");
        System.out.println("Course: " + course);
        System.out.println("Assigned Subjects:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println("- " + subjects[i].getName() + " (" + subjects[i].getUnits() + " units)");
        }
        System.out.println("===============================\n");
        System.out.println("Student information saved.");
    }

    public boolean isPassing(){
        return true;
    }
}
