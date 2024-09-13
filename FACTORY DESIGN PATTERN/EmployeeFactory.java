public class EmployeeFactory {
    public static Employee getEmployeeObject(String empType) {
        if(empType.trim().equals("ANDROID DEVELOPER")) {
            return new AndroidDeveloper();
        } else if(empType.trim().equals("WEB DEVELOPER")) {
            return new WebDeveloper();
        } else {
            return null;
        }
    }
}
