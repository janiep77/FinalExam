
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

	public CourseImporter() {

	}

	public void printAverageGradeOrder() {
		System.out.println(courseList.get(0).toStringSortedByAverageGrade());
	}

	public void printInNameOrder() {
		System.out.println(courseList.get(0).toString());
	}

	public void readCourseFile(String url) {
		NetworkFileReaderUtility fru = new NetworkFileReaderUtility();

		if (!fru.readFile(url)) {
			System.err.println("Error reading url. Exiting");
			System.exit(1);
		}

		String input = fru.getNextLine();
		if (input == null)
			return; // nothing to process
		String course = input;
	
		String teacher = fru.getNextLine();
			
		Course c = new Course(course, teacher);
		input = fru.getNextLine();
		while (input != null) {
			
			String[] name = input.split("\\s");
			Student s = new Student(name[0], name[1]);

			String grade = fru.getNextLine();
			while (!grade.equals("-1")) {
				
				s.addGrade(Integer.parseInt(grade));
				grade = fru.getNextLine();
			}
			c.enrollStudent(s);
			courseList.add(c);
			input = fru.getNextLine();
			
		}

	}
}
