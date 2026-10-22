public class Student extends Person{
    private String course;
    private String year;
    private SubjectItem[] subjects; // Replaces separate subject and grade arrays
    private boolean meritScholar = false;

    public Student(){};

    public void addInfo() {
    System.out.println("-----STUDENT INFORMATION-----");

    // 1. Select Course with Input Validation
    int courseChoice = 0;
    do {
        System.out.println("Select Course:");
        System.out.println("[1] Bachelor of Science in Computer Science (BSCS)");
        System.out.println("[2] Bachelor of Science in Information Technology (BSIT)");
        System.out.print("Enter choice (1 or 2): ");

        if (in.hasNextInt()) {
            courseChoice = in.nextInt();
            in.nextLine(); // Clear the newline character from the buffer
            
            if (courseChoice != 1 && courseChoice != 2) {
                System.out.println("Invalid selection. Please choose 1 or 2.\n");
            }
        } else {
            System.out.println("Invalid input! Please enter a number.\n");
            in.nextLine(); // Clear invalid non-integer input
        }
    } while (courseChoice != 1 && courseChoice != 2);

    // 2. Assign Course Name and Specific Subjects
    switch (courseChoice) {
    case 1:
        course = "BSCS";
        subjects = new SubjectItem[] {
            new SubjectItem("Data Structures", 3),
            new SubjectItem("Discrete Mathematics", 3),
            new SubjectItem("Object-Oriented Programming", 5),
            new SubjectItem("Information Management", 3)
        };
        break;
    case 2:
        course = "BSIT";
        subjects = new SubjectItem[] {
            new SubjectItem("Networking", 3),
            new SubjectItem("Database Systems", 3),
            new SubjectItem("Web Development", 5),
            new SubjectItem("System Administration", 3)
        };
        break;
}
    // 3. Enter Year Level
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

    
}
