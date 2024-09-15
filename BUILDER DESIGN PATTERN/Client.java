public class Client {
    public static void main(String[] args) {
        /*
         * Using this we can create as many as objects possible without following any order and it provides a functionallity to skip any data.
         */
        User user = new User.UserBuilder().setUserId("123").setUserMail("aditya@gmail.com").setUserName("Aditya").build();
        System.out.println(user);


        User user1 = new User.UserBuilder().setUserId("124").setUserName("Nani").build();
        System.out.println(user1);

    }
}
