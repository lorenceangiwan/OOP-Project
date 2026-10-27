public class SubjectItem {
    private String name;
    private int units;
    private double grade;

    public SubjectItem(String name, int units) {
        this.name = name;
        this.units = units;
        this.grade = 0.0;
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getUnits() { return units; }
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }

    /**
     * Static catalog method providing the curriculum for each course.
     */
    public static SubjectItem[] courseSubjects(String course) {
        if (course.equalsIgnoreCase("BSCS")) {
            
            return new SubjectItem[] {
                new SubjectItem("Data Structures and Algorithms", 3),
                new SubjectItem("Discrete Structures 2", 3),
                new SubjectItem("Object-Oriented Programming", 3),
                new SubjectItem("Information Management", 3),
                new SubjectItem("Readings in Philippine History", 3),
                new SubjectItem("The Entrepreneurial Mind", 3)
            };
        } else if (course.equalsIgnoreCase("BSIT")) {
            return new SubjectItem[] {
                new SubjectItem("Information Management", 3),
                new SubjectItem("Readings in Philippine History", 3),
                new SubjectItem("Object Oriented Programming", 3),
                new SubjectItem("Reading Visual Arts", 3),
                new SubjectItem("Platform Technologies", 3),
                new SubjectItem("Webpage Design Using HTML", 3),
                new SubjectItem("Ethics", 3)
            };
        } else if (course.equalsIgnoreCase("MSCS")) {
            // Masteral in Computer Science (9 units total)
            return new SubjectItem[] {
                new SubjectItem("Advanced Data Structures and Algorithms", 3),
                new SubjectItem("Advanced Operating Systems", 3),
                new SubjectItem("Software Engineering Principles", 3)
            };
        } else if (course.equalsIgnoreCase("MSIT")) {
            // Masteral in Information Technology (9 units total)
            return new SubjectItem[] {
                new SubjectItem("Advanced Database Management Systems", 3),
                new SubjectItem("Enterprise Architecture and Information Security", 3),
                new SubjectItem("IT Project Management", 3)
            };
        }
        
        return new SubjectItem[0]; // Empty array if course is not found
    }
}