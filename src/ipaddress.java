import java.net.*; 
import java.io.*; 


public class ipaddress {

	private static ipaddress instance;
	
	
	public static ipaddress getInstance() {
		if (instance == null) {
			instance = new ipaddress();
			
		}
		return instance;
	}
	
	private ipaddress() {
	}
	
	public String getlocalip() throws Exception {
		
        // Returns the instance of InetAddress containing 
        // local host name and address 
        InetAddress localhost = InetAddress.getLocalHost(); 		
		return (localhost.getHostAddress()).trim().toString();
	}
	
	public String getpublicip() {
        // Find public IP address 
        String systemipaddress = ""; 
        try
        { 
            URL url_name = new URL("http://bot.whatismyipaddress.com"); 
  
            BufferedReader sc = 
            new BufferedReader(new InputStreamReader(url_name.openStream())); 
  
            // reads system IPAddress 
            systemipaddress = sc.readLine().trim(); 
        } 
        catch (Exception e) 
        { 
            systemipaddress = "Cannot Execute Properly"; 
        }
        return systemipaddress;
	}
	
	
}
