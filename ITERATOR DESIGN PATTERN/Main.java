public class Main{
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        userManagement.addUser(new User("Aadi", "17"));
        userManagement.addUser(new User("Nani", "18"));
        userManagement.addUser(new User("Ram", "19"));
        userManagement.addUser(new User("Geetha", "20"));

        MyIterator myIterator = userManagement.getIterator();
        while(myIterator.hasNext()) {
            User user = (User) myIterator.next();
            System.out.println(user.getName());
        }
    }
}

