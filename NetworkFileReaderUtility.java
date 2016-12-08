
/**
 * @author janie_000
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

	
public class NetworkFileReaderUtility {
	
	

	private ArrayList<String> lines = new ArrayList<String>();
	private BufferedReader br;

	/**
	 * This will return the next line of the text file.
	 * 
	 * @return String that holds the next line in the text file,
	 *         <code>null</code> if there are no more lines in the file.
	 */
	public String getNextLine() {
		if(br == null) return null;
	    try {
	    	String line = br.readLine();
	        if(line == null)
	        br.close();
	        return line;
	     } catch (Exception e){ return null;}
	}

	/**
	 * This function will read the entire contents of a file, and store the
	 * different lines so that they can be retrieved by a call to
	 * <code>getNextLine()</code>.
	 * 
	 * @param filename The name of the file to be read
	 * @return True if the file can be read, false if the file does not exist or
	 * cannot be read for other reasons.
	 * @throws MalformedURLException 
	 */
	public boolean readFile(String URL) throws MalformedURLException {
		
		HttpURLConnection con = null;
		BufferedReader br = null;
		
		try {
			URL u = new URL(URL); 
			con = (HttpURLConnection) u.openConnection();
			
			con.setRequestMethod("GET");
			con.setConnectTimeout(5000);
			con.connect();
			
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			String line = null;
			String content = "";
			while((line = br.readLine()) != null){
				content += line + "\n";
			}
			System.err.println(content);
			
			
		} catch (MalformedURLException mue){
			System.out.println("Invalid URL. Try again " + "Malformed URL");
			mue.printStackTrace();
			return false;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (br != null) br.close();
				if (con != null) con.disconnect();					
			} catch (Exception e){
				System.out.println("Error closing.");
				e.printStackTrace();
				return false;
			}
		
		}
		
		return true;
	}
	


}
