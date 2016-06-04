import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Console {
	public static int min=5000,average=0,max=0;
	
	public static void pingChecker(String server) throws UnknownHostException, IOException, InterruptedException{
		String ipAddress = server;
	    InetAddress inet = InetAddress.getByName(ipAddress);
	    
	    for(int i=0; i<100;i++){
	    	long start = System.currentTimeMillis();
		    inet.isReachable(5000);
		    long end = System.currentTimeMillis() - start;
		    if(end < min) min = (int)end;
		    if(end > max) max = (int)end;
		    average+=end;
		    System.out.println("Ping: " + end);
	    }
	    
	    System.out.println("Min: " + min);
	    System.out.println("Average: " + average/100);
	    System.out.println("Max: " + max);
	}

}
