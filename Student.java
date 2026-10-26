public abstract class Student extends Person{
    protected String course;
    protected String year;
    protected double totalGWA;
    protected int totalUnits;
    protected SubjectItem[] subjects; // groups subject and units
    protected boolean meritScholar = false;

    public Student() {
    super();
    this.isStudent = true;
    }
    
    public void displayInfo() {
        int choice = 0;
        while (choice != 3) {
            System.out.println("\n===== STUDENT DASHBOARD =====");
            System.out.println("Name: " + name);
            System.out.println("Address: " + address);
            System.out.println("ID Number: " + idNumber);
            System.out.println("Course: " + course);
            System.out.println("Assigned Subjects for this Semester:");
            for (int i = 0; i < subjects.length; i++) {
                System.out.printf("- %s (%d units): %.2f%n",
                    subjects[i].getName(), subjects[i].getUnits(), subjects[i].getGrade());
            }

            System.out.printf("\nTotal Tution: Php%,.2f", computeTuition());
            System.out.printf("\nOverall GWA: %.2f%n", computeGWA());
            System.out.print("Academic Status: ");
            academicStatus();

            System.out.println("===================\n");

            System.out.println("1. Enter grades");
            System.out.println("2. Update information");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");
            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    inputGrades();
                    break;
                case 2:
                    super.updateInfo();
                    break;
                case 3:
                    isLoggedIn = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 3.");
            }
        }
    }

    public int computeUnits(){
        totalUnits = 0;

        for (int i = 0; i < subjects.length; i++) {
            totalUnits = totalUnits + subjects[i].getUnits();
        }
        return totalUnits;
    }
    
    public void inputGrades() {
    System.out.println("----- ENTER GRADES -----");
    for (int i = 0; i < subjects.length; i++) {
        double grade = 0.0;
        boolean isValid = false;

        do {
            System.out.print("Enter grade for " + subjects[i].getName() + " (" + subjects[i].getUnits() + " units): ");
            
            if (in.hasNextDouble()) {
                grade = in.nextDouble();
                in.nextLine();

                // grade range
                if (grade >= 1.0 && grade <= 5.0) { 
                    isValid = true;
                } else {
                    System.out.println("Invalid grade range. Please enter a value between 1.0 and 5.0.");
                }
            } else {
                System.out.println("Invalid input! Please enter a numeric grade.");
                in.nextLine();
            }
        } while (!isValid);

        // Save grade directly into the specific SubjectItem object
        subjects[i].setGrade(grade);
    }
    System.out.println("All grades successfully recorded!\n");
    }

    public double computeGWA() {
        double totalGrades = 0.0;

        for (int i = 0; i < subjects.length; i++) {
            SubjectItem subject = subjects[i];

            totalGrades = totalGrades + subject.getGrade() * subject.getUnits();
        }

        totalGWA = totalGrades / computeUnits();
        return totalGWA;
    }

    public abstract void academicStatus();

    public double computeTuition(){
        return computeUnits() * 1200.0;
    }

    public boolean confirmPassword(){
        return confirmPassword();
    }
}
