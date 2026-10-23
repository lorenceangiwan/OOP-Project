public class UndergraduateStudent extends Student {

    public void displayInfo() {
        if (isLoggedIn) {
            System.out.println("\n===== WELCOME =====");
            System.out.println("Name: " + name);
            System.out.println("Address: " + address);
            System.out.println("ID Number: " + idNumber);
            System.out.println("===================\n");
        } else {
            System.out.println("Please log in to view your information.\n");
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
        } else {
            System.out.println("Invalid input! Please enter a number.\n");
            in.nextLine();
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
    //year level
    do {
        System.out.print("Enter Year Level (e.g., 1, 2, 3, 4): ");
        year = in.nextLine().trim();
        if (year.isEmpty()) {
            System.out.println("Year level must not be empty.");
        }
    } while (year.isEmpty());

        System.out.println("\n===== STUDENT INFORMATION =====");
        System.out.println("Course: " + course);
        System.out.println("Year Level: " + year);
        System.out.println("Assigned Subjects:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println("- " + subjects[i].getName());
        }
        System.out.println("===============================\n");
        System.out.println("Student information saved.");
    }

    public boolean isPassing(){
        return true;
    }
}
