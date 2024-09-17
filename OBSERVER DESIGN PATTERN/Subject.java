public interface Subject {
    void subscribe(Observer ob);
    void unsubscribe(int id);
    void newVideoUpload(String title);
    void showSubscribers();
}
