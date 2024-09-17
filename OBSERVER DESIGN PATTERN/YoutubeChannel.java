import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject{
    private List<Observer> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Observer ob) {
        this.subscribers.add(ob);        
    }
    
    @Override
    public void unsubscribe(int index) {
        Observer removedSubscriber = this.subscribers.remove(index-1);
        System.out.print("SuccessFully unsubscribed the user ");
        removedSubscriber.showDetails(-1);
    }
    
    @Override
    public void newVideoUpload(String title) {
        for(Observer ob: subscribers) {
            ob.notified(title);
        }
    }

    @Override
    public void showSubscribers() {
        int i = 1;
        for(Observer ob: subscribers) {
            ob.showDetails(i);
            i++;
        }        
    }
}
