public class NetworkConnection implements Cloneable{
    
    private String ip;
    private String data;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getData() {
        return data;
    }
    
    public void setData(String data) throws InterruptedException {
        this.data = data;
        Thread.sleep(5000); // This is used to simulate the time taking complex process.
    }

    @Override
    public String toString() {
        return "NetworkConnection [ip=" + ip + ", data=" + data + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("Cloning the object!");
        return super.clone();
    }

    
}
