import java.util.ArrayList;
import java.util.List;

public class MyIteratorImplementation implements MyIterator{
    private List<User> user;
    private int length;
    private int position = 0;
    public MyIteratorImplementation(List<User> user) {
        this.user = user;
        this.length = user.size(); 
    }

    @Override
    public boolean hasNext() {
        if(position >= length) {
            return false;
        } 
        return true;
    }

    @Override
    public Object next() {
        User person = user.get(position);
        position++;
        return person;  
    }
    
}
