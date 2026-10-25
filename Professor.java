public class Professor extends Person {
    
    // Private variables from your class diagram
    private double hourlySalary;
    private int hoursWorked;
    private String department;
    private int academicRank;

    // Default Constructor
    public Professor() {}

    public void register(){
        System.out.println("\n-----REGISTRATION-----");
        System.out.print("Enter Full Name: ");
        name = in.nextLine();
        System.out.print("Enter address: ");
        address = in.nextLine();
    }

    public void displayInfo() {
        System.out.println("=== Professor Dashboard ===");
        System.out.println("Department: " + department);
        System.out.println("Academic Rank Level: " + academicRank);
        System.out.println("Hourly Salary: ₱" + hourlySalary);
        System.out.println("Hours Worked: " + hoursWorked);
    }

    public void updateInfo() {
        System.out.println("Professor information has been updated.");
    }

    public double computeSalary() {
        double totalSalary = hourlySalary * hoursWorked;
        System.out.println("Computed Salary: ₱" + totalSalary);
        return totalSalary;
    }

    public void teachingLoad() {
        System.out.println("Displaying teaching schedule and assigned units for " + department + ".");
    }

    // Getters and Setters (Encapsulation)
    public double getHourlySalary() { return hourlySalary; }
    public void setHourlySalary(double hourlySalary) { this.hourlySalary = hourlySalary; }

    public int getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(int hoursWorked) { this.hoursWorked = hoursWorked; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public int getAcademicRank() { return academicRank; }
    public void setAcademicRank(int academicRank) { this.academicRank = academicRank; }
}