import java.io.Serializable;

class Student3 implements Serializable, Cloneable{

    private static Student3 lazy; // This object is for lazy initialization

    private Student3() {

    }

    public static Student3 lazyCreateObject() { 
        if(lazy == null) {
            synchronized(Student3.class) { 
                lazy = new Student3();
            }
        }
        return lazy;
    }

    public Object readResolve() {
        return lazy;
    }

    @Override
    public Object clone(){
        return lazy;
    }
}