import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class fileio {

	public fileio() {
		
	}
	
	public boolean filewrite(String localip, String publicip, String filepath) throws IOException {
		
		File fout = new File(filepath);
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(fos));
		bw.write(localip);
		bw.newLine();
		bw.write(publicip);
		
		bw.close();
		return true;
	}
	
	
	
}