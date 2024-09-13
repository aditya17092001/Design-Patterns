import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakRules{
    public static void main(String[] args) throws Exception, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        /*
         * 1. Reflection API using this we can dynamically change the properties and accessiblity of the class or an interface which breaks the rule of SINGLETON.
         * 
         * Solution of the Reflection API is to throw an exception from the constructor if the object exists
         */

        // Student s1 = Student.lazyCreateObject();
        // System.out.println(s1.hashCode());

        // Constructor<Student> constructor = Student.class.getDeclaredConstructor();
        // constructor.setAccessible(true); // We can cange the constructor accessible 
        // Student s2 = constructor.newInstance();
        // System.out.println(s2.hashCode());

        /*
         * 2. Using enum: This is a safe approach that prevents reflection-based attacks on the Singleton.
         */

        // Using the enum Singleton (reflection proof)
        // Student2 s3 = Student2.INSTANCE;
        // System.out.println(s3.hashCode());
        // s3.test();

        // Student2 s4 = Student2.INSTANCE;
        // System.out.println(s4.hashCode());


        /*
         * 3. Using Serialization and deserialization
         * 
         * To use this method we need to implements the Serializable
         * Serialization:
Serialization is the process of converting an object into a format (typically binary or text) that can be easily stored or transmitted. The serialized data can be stored in a file, sent over a network, or saved in a database. This allows the object to be reconstructed later.

For example, if you have a Java object, serialization converts that object into a byte stream. This byte stream can be saved to a file or sent over a network.

Deserialization:
Deserialization is the reverse process of serialization. It involves converting the byte stream (or any serialized data) back into an object. This process allows you to restore the original state of the object when needed.
         *
         * To solve we need to implements the readResolve().
         */

        // Student3 s5 = Student3.lazyCreateObject();

        // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.ob"));
        // oos.writeObject(s5);
        // System.out.println(s5.hashCode());
        // System.out.println("Serialization done..");

        // ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abc.ob"));
        // Student3 s6 = (Student3) ois.readObject();
        // System.out.println(s6.hashCode());



        /*
         * 
         * 4. We can also break using Cloning the Object
         * 
         * To use this method we need to implement the interface Clonable 
         */


        Student3 s7 = Student3.lazyCreateObject();
        System.out.println(s7.hashCode());

        Student3 s8 =  (Student3) s7.clone();
        System.out.println(s8.hashCode());

    }
}

