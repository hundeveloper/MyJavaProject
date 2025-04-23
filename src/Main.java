public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("2025001", "김민수", "컴퓨터공학", 3);
        s1.printInfo();

        System.out.println("5학년으로 변경");
        s1.setGrade(5);
    }
}