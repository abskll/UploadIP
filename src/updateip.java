// Java program to find IP address of your computer 
// java.net.InetAddress class provides method to get 
// IP of any host name 
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class updateip extends Application
{ 
	
	TextField tf;
	TextField sleeptime;
	
    public static void main(String args[]) throws Exception 
    { 
    	
		launch(args);

    } 
    
	public void start(Stage myStage) {
		myStage.setTitle("Upload IP Address");
		FlowPane rootNode = new FlowPane(10,10);
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(rootNode, 230, 140);
		myStage.setScene(myScene);
		sleeptime = new TextField();
		Button btnGetText = new Button("Enter File Path");
		tf = new TextField();
		
		tf.setPromptText("Enter a File Path.");
		sleeptime.setPromptText("Enter time to sleep in millis.");
		tf.setPrefColumnCount(15);
		
		tf.setOnAction((ae) -> runprogram(tf.getText(), sleeptime));
		
		btnGetText.setOnAction((ae) -> runprogram(tf.getText(), sleeptime));
		Separator separator = new Separator();
		separator.setPrefWidth(180);
		Separator separator2 = new Separator();
		separator2.setPrefWidth(180);
		
		rootNode.getChildren().addAll(tf, separator, sleeptime, separator2, btnGetText);
		myStage.show();
	}
	
	
	
	public void runprogram(String filepath, TextField sleeptime) {
		
    	String localipaddress, publicipaddress;
  	
		while(true) {
			
	    	ipaddress ipadd = ipaddress.getInstance();
	    	try {
	    		localipaddress = ipadd.getlocalip();
	    	} catch (Exception e) {
	    		System.out.println("local ip address get failure");
	    		localipaddress = "error";
	    		break;
	    	}
	    	publicipaddress = ipadd.getpublicip();
	    	
	    	System.out.println("System IP Address : " + 
	                localipaddress);
	        System.out.println("Public IP Address: " + publicipaddress +"\n"); 
	        fileio fio = new fileio();
	        try {
	        	fio.filewrite(localipaddress, publicipaddress, filepath);
	        } catch (Exception e) {
	        	System.out.println("Filewrite failure");
	        	break;
	        }
	        
			try {
				Thread.sleep(Long.parseLong(sleeptime.getText().toString()));
			} catch (Exception e) {
				System.out.println("sleep error occured");
				break;
			}
		}
	}
} 