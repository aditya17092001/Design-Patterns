import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        YoutubeChannel channel = new YoutubeChannel();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("Enter 1 to add subscriber");
            System.out.println("Enter 2 to add upload new Video");
            System.out.println("Enter 3 to show all the subscribers");
            System.out.println("Enter 4 to remove subscriber");
            System.out.println("Enter 5 to exit");
            System.out.println("Please enter your choice: ");
            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    System.out.println("Please enter the name of the subscriber: ");
                    String name = br.readLine();
                    Subscriber subscriber = new Subscriber(name);
                    channel.subscribe(subscriber);
                    break;
                case 2: 
                    System.out.println("Please enter the title of the video: ");
                    String title = br.readLine();
                    channel.newVideoUpload(title);
                    break;
                case 3: 
                    channel.showSubscribers();
                    break;
                case 4:
                    System.out.println("Please enter the id of the subscriber: ");
                    int removeSubscriber = Integer.parseInt(br.readLine());
                    channel.unsubscribe(removeSubscriber);
                    break;
                case 5: 
                    System.out.println("Thank you for using, Please visit again!");
                    return ;
                default:
                    System.out.println("Please enter the valid input");
                    break;
            }
        }
    }
}
