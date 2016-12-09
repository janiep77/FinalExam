
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
/**
 * This method will print each course, with the students in each course sorted by Average Grade
 */
	public void printAverageGradeOrder() {
		System.out.println(courseList.get(0).toStringSortedByAverageGrade());
	}
/**
 * This method will print each course, with the students in each course sorted by Student name
 */
	public void printInNameOrder() {
		System.out.println(courseList.get(0).toString());
	}
/**
 * This method reads the given filename, and creates a course object full of students.
 * @param url
 */
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
