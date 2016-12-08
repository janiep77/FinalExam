import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author janie_000
 *
 */
public class Main {
	private JFrame frame;
	private JButton btnSend;
	private JEditorPane txtArea;
	private JTextField loc;
	private JScrollPane scroller;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("Incorrect # of arguments");
            System.out.println("usage: java CourseImporter <name or grades> <URL>");
            System.exit(1);
        }

		CourseImporter c = new CourseImporter();
		c.readCourseFile(args[1]);

		String sortby = args[0].toLowerCase();
		if(sortby.equals("name")) {
			c.printInNameOrder();
		} else if (sortby.equals("grades")) {
			c.printAverageGradeOrder();
		} else {
			System.out.println("Invalid argument. Acceptable arguments are " +
					"name or grades");
		}

		//Main m = new Main();
		//m.startImporter();

	}
/*	public void startImporter(){
		frame = new JFrame("Course Importer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtArea = new JEditorPane();		
		txtArea.setEditable(true);

		
		scroller = new JScrollPane();
		scroller.getViewport().add(txtArea);
 
		
		frame.add(BorderLayout.CENTER, scroller);
		
		loc = new JTextField();
		
		frame.add(BorderLayout.NORTH, loc);
		
		btnSend = new JButton ("Go");
		btnSend.addActionListener(new GoButtonListener());
		frame.add(BorderLayout.SOUTH, btnSend);
	
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	class GoButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(loc.getText().length() == 0) return;
			
			
			URL u = null;
			HttpURLConnection con = null;
			BufferedReader br = null;
			
			try {
				u = new URL(loc.getText());
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
				txtArea.setText(content);
				
				//txtArea.setText("<h1>This is a test</h1>");
				
				
			} catch (MalformedURLException mue){
				JOptionPane.showMessageDialog(frame, "Invalid URL. Try again", "Malformed URL", JOptionPane.ERROR_MESSAGE);
				mue.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			} finally {
				try {
					if (br != null) br.close();
					if (con != null) con.disconnect();					
				} catch (Exception e){
					System.out.println("Error closing.");
					e.printStackTrace();
				}
			
			}
			
		}
		
	}*/
}
