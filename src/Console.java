import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Console {
	
	
	public static void pingChecker(String server) throws UnknownHostException, IOException, InterruptedException{
		
		
		
		Runnable runner = new Runnable()
	    {
	        public void run() {
	        	int min=5000,average=0, max=0;
	    		String ipAddress = server;
	    	    InetAddress inet = null;
				try {
					inet = InetAddress.getByName(ipAddress);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    
	    	    for(int i=0; i<100;i++){
	    	    	long start = System.currentTimeMillis();
	    		    try {
						inet.isReachable(5000);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		    long end = System.currentTimeMillis() - start;
	    		    if(end < min) min = (int)end;
	    		    if(end > max) max = (int)end;
	    		    average+=end;
	    		    GUI.index = i+1;
	    		    GUI.progressBar.setValue(i+1);
	    		    GUI.progressBar.repaint();
	    		    GUI.textField.setText("Max: " + max);
					GUI.textField_1.setText("Average: " + average/(i+1));
					GUI.textField_2.setText("Min: " + min);
	    		    System.out.println("Ping: " + end);
	    	    }
	    	    
	    	    System.out.println("Min: " + min);
	    	    System.out.println("Average: " + average/100);
	    	    System.out.println("Max: " + max);
	        }
	    };
	    Thread t = new Thread(runner, "Code Executer");
	    t.start();
		
	}

}
