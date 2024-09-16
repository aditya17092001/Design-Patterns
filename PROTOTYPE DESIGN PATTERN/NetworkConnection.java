import java.util.ArrayList;
import java.util.List;

public class NetworkConnection implements Cloneable{
    
    private String ip;
    private String data;
    private List<String> domains;

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
        List<String> domains = new ArrayList<>();
        domains.add("abc.com");
        domains.add("def.com");
        domains.add("ghi.com");
        domains.add("jkl.com");
        setDomains(domains);
        Thread.sleep(5000); // This is used to simulate the time taking complex process.
    }

    
    public List<String> getDomains() {
         return domains;
    }
    
    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    @Override
    public String toString() {
        return "NetworkConnection [ip=" + ip + ", data=" + data + ", domains=" + domains + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // This is the process of cloning the object using shallow copy which only copies the object and doesnot copies the nested objects.
        // System.out.println("Cloning the object!");
        // return super.clone();


        // Below is the process of implementing deep copy.
        NetworkConnection network = new NetworkConnection();
        network.ip = getIp();
        network.data = getData();
        network.domains = new ArrayList<>();
        for(String i: this.domains) {
            network.domains.add(i);
        }

        return network;
    }

    
}
