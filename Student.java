public abstract class Student extends Person{
    protected String course;
    protected String year;
    protected double totalGWA;
    protected int totalUnits;
    protected SubjectItem[] subjects; // groups subject and units
    protected boolean meritScholar = false;

    public Student(){};
    
    public abstract void displayInfo();

    public abstract void addInfo(); 

    public int calculateUnits(){
        for (int i = 0; i < subjects.length; i++) {
            totalUnits = totalUnits + subjects[i].getUnits();
        }
        return totalUnits;
    }
    
    public void inputGrades() {
    if (subjects == null || subjects.length == 0) {
        System.out.println("No subjects found. Please complete course registration first.");
        return;
    }

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

    public abstract boolean isPassing();

    public double computeGWA() {
        return 0.3;
    }
}
