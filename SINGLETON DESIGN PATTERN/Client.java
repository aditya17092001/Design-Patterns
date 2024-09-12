public class Client {
    public static void main(String[] args) {
        Student student = Student.lazyCreateObject();
        System.out.println(student.hashCode());
        Student student1 = Student.lazyCreateObject();
        System.out.println(student1.hashCode());


        Student student2 = Student.eagerCreateObject();
        System.out.println(student2.hashCode());
        Student student3 = Student.eagerCreateObject();
        System.out.println(student3.hashCode());
    }
}
