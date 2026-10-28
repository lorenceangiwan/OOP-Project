// Stores a professor's rank and the salary assigned to that rank.
public class AcademicRank {
    private String title;
    private double monthlySalary;

    public AcademicRank(String title, double monthlySalary) {
        this.title = title;
        this.monthlySalary = monthlySalary;
    }

    public String getTitle() { return title; }
    public double getMonthlySalary() { return monthlySalary; }

    // Estimates daily pay using a standard 22-workday month.
    public double dailyEarnings() {
        return monthlySalary / 22.0; // Assumes 22 days of work in a month
    }

    // Static lookup method for choices 1-15
    public static AcademicRank getRankByChoice(int choice) {
        switch (choice) {
            case 1: return new AcademicRank("Assistant Professor 1", 35000.0);
            case 2: return new AcademicRank("Assistant Professor 2", 38000.0);
            case 3: return new AcademicRank("Assistant Professor 3", 41000.0);
            case 4: return new AcademicRank("Assistant Professor 4", 45000.0);
            case 5: return new AcademicRank("Associate Professor 1", 50000.0);
            case 6: return new AcademicRank("Associate Professor 2", 56000.0);
            case 7: return new AcademicRank("Associate Professor 3", 62000.0);
            case 8: return new AcademicRank("Associate Professor 4", 70000.0);
            case 9: return new AcademicRank("Associate Professor 5", 78000.0);
            case 10: return new AcademicRank("Professor 1", 88000.0);
            case 11: return new AcademicRank("Professor 2", 101000.0);
            case 12: return new AcademicRank("Professor 3", 114000.0);
            case 13: return new AcademicRank("Professor 4", 129000.0);
            case 14: return new AcademicRank("Professor 5", 145000.0);
            case 15: return new AcademicRank("Professor 6", 164000.0);
            default: return null;
        }
    }

    public static void displayRankMenu() {
        System.out.println("\n--- Choose Academic Rank ---");
        System.out.println("Assistant Professors:");
        System.out.println("1. Assistant Professor 1");
        System.out.println("2. Assistant Professor 2");
        System.out.println("3. Assistant Professor 3");
        System.out.println("4. Assistant Professor 4");
        System.out.println("Associate Professors:");
        System.out.println("5. Associate Professor 1");
        System.out.println("6. Associate Professor 2");
        System.out.println("7. Associate Professor 3");
        System.out.println("8. Associate Professor 4");
        System.out.println("9. Associate Professor 5");
        System.out.println("Professors:");
        System.out.println("10. Professor 1");
        System.out.println("11. Professor 2");
        System.out.println("12. Professor 3");
        System.out.println("13. Professor 4");
        System.out.println("14. Professor 5");
        System.out.println("15. Professor 6");
    }
}