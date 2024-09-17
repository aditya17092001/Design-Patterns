public class Subscriber implements Observer{
    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void notified(String title) {
        System.out.println("Hello "+ this.name + " new video uploaded! "+title);
    }

    @Override
    public void showDetails(int id) {
        if(id != -1) {
            System.out.println(id+". "+this.name);        
        }
    }
}
