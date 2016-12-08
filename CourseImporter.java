import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author janie_000
 *
 */
public class CourseImporter {
	private ArrayList<Course> courseList = new ArrayList<Course>();
	
	public CourseImporter(){
		
	}
	
	void printAverageGradeOrder(){
		new GradeAverageComparator();
	}
	
	void printInNameOrder(){
		new NameComparator();
	}
	
	void readCourseFile(String url){
		NetworkFileReaderUtility fru = new NetworkFileReaderUtility();
        try {
			if(!fru.readFile(url)){
			    System.err.println("Error reading url. Exiting");
			    System.exit(1);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		String input = fru.getNextLine();
		if(input == null) return; //nothing to process

		while(input != null){
			String[] course = input.split("\\\n");
			Course c = new Course(course[0], course[1]);
			String[] name = input.split("\\s");
			Student s = new Student(name[3], name[2]);

			String grade = "";
			while(!(grade = input).equals("-1")){
				s.addGrade(Integer.parseInt(grade));
			}
			c.enrollStudent(s);
			courseList.add(c);
		
		}

	}
}
