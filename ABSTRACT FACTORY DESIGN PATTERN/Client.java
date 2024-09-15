public class Client {
    public static void main(String[] args) {
        Employee webDev = EmployeeFactory.getEmployee(new WebDevFactory());
        webDev.name();

        Employee andDev = EmployeeFactory.getEmployee(new AndroidDevFactory());
        andDev.name();
    }
}
