class SubjectItem {
    private String name;
    private int units;
    private double grade;

    public SubjectItem(String name, int units) {
        this.name = name;
        this.units = units;
        this.grade = 0.0; // Default grade
    }

    public int getUnits() { return units; }
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }
    public String getName() { return name; }
}
