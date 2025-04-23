public class Student {
    // 필드 (모두 private)
    private String studentId;
    private String name;
    private String major;
    private int grade;

    // 생성자
    public Student(String studentId, String name, String major, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        setGrade(grade);
    }

    // Getter와 Setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade >= 1 && grade <= 4) {
            this.grade = grade;
        } else {
            System.out.println("학년은 1~4 사이여야 합니다.");
        }
    }

    public void printInfo() {
        System.out.println(name + " / " + major + " / " + grade + "학년");
    }
}