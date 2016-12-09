import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 */

/**
 * @author janie_000
 *
 */
public class Course {
	private String courseName;
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private String teacherName;

	
	public Course(String courseName, String teacherName){
		this.courseName = courseName;
		this.teacherName = teacherName;
	}
	/**
	 * This method enrolls the Student, s, in this course, assuming s is not null.
	 * @param s - The Student object to be enrolled
	 * @return True if the student was added correctly. False if there was an error
	 */
	
	public boolean enrollStudent(Student s){
		if(s == null) return false;
		else {
			studentList.add(s);
			return true;
		}
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @returns the number of students currently enrolled in this course.
	 */
		

	public int getNumEnrolled(){
		return studentList.size();
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}




	/**
	 * @return the studentList
	 */
	public ArrayList<Student> getStudentList() {
		return studentList;
	}




	/**
	 * @param studentList the studentList to set
	 */
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}




	/**
	 * @return the teacherName
	 */
	public String getTeacher() {
		return teacherName;
	}




	/**
	 * @param teacherName the teacherName to set
	 */
	public void setTeacher(String teacherName) {
		this.teacherName = teacherName;
	}
	/**
	 * Returns a string holding the Course object, with students sorted by Name (last, then first)
	 * @override toString in class Object
	 * @return String representation of this course, sorted by name
	 */
	public String toString(){
		Collections.sort(studentList, new NameComparator());
		String displayString = "Course Name: " + courseName + "\n" + "Teacher Name: " + teacherName + "\n";
		for(int i = 0; i < studentList.size(); i++){
			displayString += studentList.get(i) + "\n";
		}
		return displayString;
	}
	/**
	 * Returns a string holding the Course object, with students sorted by Average Grade
	 * @return String representation of this course, sorted by Average Grade
	 */
	public String toStringSortedByAverageGrade(){
		Collections.sort(studentList, new GradeAverageComparator());
		String displayString = "Course Name: " + courseName + "\n" + "Teacher Name: " + teacherName + "\n";
		for(int i = 0; i < studentList.size(); i++){
			displayString += studentList.get(i) + "\n";
		}
			
		return displayString;
	}

}
