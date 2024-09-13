import javax.management.RuntimeErrorException;

class Student {

    /*
     * Here we created a global object with static because if we make constructor private its impossible to create an object from outside of the class.
     * So to create an object we'll create static method to access this static object.
     */
    private static Student lazy; // This object is for lazy initialization
    private static Student eager = new Student(); // this object is for eager initialization

    /*
     * We need to make the constructor private because we need to restrict the object creation multiple times.
     * If the constructor is private how to create an object?
     * To create an object we'll make an method for object creation.
     */
    private Student() {

        // We are creating the below if block to check if the constructor is created or not while breaking this using Reflection API
        if(lazy != null) {
            throw new RuntimeErrorException(null, "You are trying to break the SINGLETON");
        }
    }

    /*
     * Lazy way of creating an object
     * If we our application contains multiple threads which access the below object creation method multiple times then there have a chance to create multiple objects because both the thread will found the student object = null.
     * To overcome this we need to synchronize.
     */
    public static Student lazyCreateObject() { 

        if(lazy == null) {

            /*
             * We synchronized the below block because if we synchorized the complete this method then thread have to wait until the engaged thread leaves this method.
             * So we made block synchronized then multiple threads can access the method simultaneously.
             */
            synchronized(Student.class) { 
                lazy = new Student();
            }
        }
        return lazy;
    }


    /*
     * Eager way
     */

    public static Student eagerCreateObject() {
        return eager;
    }

}