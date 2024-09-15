public class Client {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {

        System.out.println("Creating an prototype object!");
        NetworkConnection conn = new NetworkConnection();
        conn.setIp("192.168.16.1");
        conn.setData("Important data");
        System.out.println(conn);
        
        /*
         *  The above is the creation of prototype object which already computed the complex steps.
         *  To clone the above object dont take any time.
         *  Let's clone it.
         */
        
        NetworkConnection conn1 = (NetworkConnection) conn.clone();
        System.out.println(conn1);
    }
}