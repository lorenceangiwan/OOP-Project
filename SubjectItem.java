// Represents one course subject and its enrolled units and grade.
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

    // Returns the curriculum for a recognized course code
    public static SubjectItem[] courseSubjects(String course) {
        if (course.equalsIgnoreCase("BSCS")) {
            //baccalaureate in CS (18 units)
            return new SubjectItem[] {
                new SubjectItem("Data Structures and Algorithms", 3),
                new SubjectItem("Discrete Structures 2", 3),
                new SubjectItem("Object-Oriented Programming", 3),
                new SubjectItem("Information Management", 3),
                new SubjectItem("Algorithms and Complexities", 3),
                new SubjectItem("Operating Systems", 3)
            };
        } else if (course.equalsIgnoreCase("BSIT")) {
            //baccalaureate in IT (21 units)
            return new SubjectItem[] {
                new SubjectItem("Information Management", 3),
                new SubjectItem("Networking 1", 3),
                new SubjectItem("Object Oriented Programming", 3),
                new SubjectItem("Systems Integration and Architecture", 3),
                new SubjectItem("Platform Technologies", 3),
                new SubjectItem("Webpage Design Using HTML", 3),
                new SubjectItem("Database Administration", 3)
            };
        } else if (course.equalsIgnoreCase("MSCS")) {
            // Masteral in Computer Science (9 units)
            return new SubjectItem[] {
                new SubjectItem("Advanced Data Structures and Algorithms", 3),
                new SubjectItem("Advanced Operating Systems", 3),
                new SubjectItem("Software Engineering Principles", 3)
            };
        } else if (course.equalsIgnoreCase("MSIT")) {
            // Masteral in Information Technology (9 units)
            return new SubjectItem[] {
                new SubjectItem("Advanced Database Management Systems", 3),
                new SubjectItem("Enterprise Architecture and Information Security", 3),
                new SubjectItem("IT Project Management", 3)
            };
        } else if (course.equalsIgnoreCase("PhDCS")) {
            // Doctor of Philosophy in Computer Science (9 units)
            return new SubjectItem[] {
                new SubjectItem("Advanced Algorithms and Complexity", 3),
                new SubjectItem("Distributed Systems and Cloud Computing", 3),
                new SubjectItem("Doctoral Research in Computer Science", 3)
            };
        } else if (course.equalsIgnoreCase("PhDIT")) {
            // Doctor of Philosophy in Information Technology (9 units)
            return new SubjectItem[] {
                new SubjectItem("Advanced Information Systems", 3),
                new SubjectItem("IT Innovation and Emerging Technologies", 3),
                new SubjectItem("Doctoral Research in Information Technology", 3)
            };
        }
        
        return new SubjectItem[0]; // Empty array if course is not found
    }
}