public class User {
    /*
     * We are making the below data as an immutablity.
     */
    private final String userId;
    private final String userName;
    private final String userMail;

    /*
     * Constructor contains the parameter of the static class which contains the data setters.
     */
    private User(UserBuilder builder){
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.userMail = builder.userMail;
    }

    /*
     * This class can only provide the getters
     * The data is set using another static class
     */
    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserMail() {
        return userMail;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userMail=" + userMail + "]";
    }

    /*
     * static class
     */
    static class UserBuilder{
        private String userId;
        private String userName;
        private String userMail;

        /*
         * We are making the constructor as public because main method can create an object to set the data using setters.
         */
        public UserBuilder(){

        }

        public UserBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder setUserMail(String userMail) {
            this.userMail = userMail;
            return this;
        }

        /*
         * build method creates an object of the Outer class User and pass the arguments to it.
         */
        public User build(){
            User user = new User(this);
            return user;
        }
    }
}