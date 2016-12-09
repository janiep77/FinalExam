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
	
	public String toString(){
		Collections.sort(studentList, new NameComparator());
		String displayString = "Course Name: " + courseName + "\n" + "Teacher Name: " + teacherName + "\n";
		for(int i = 0; i < studentList.size(); i++){
			displayString += studentList.get(i) + "\n";
		}
		return displayString;
	}
	public String toStringSortedByAverageGrade(){
		Collections.sort(studentList, new GradeAverageComparator());
		String displayString = "Course Name: " + courseName + "\n" + "Teacher Name: " + teacherName + "\n";
		for(int i = 0; i < studentList.size(); i++){
			displayString += studentList.get(i) + "\n";
		}
			
		return displayString;
	}

}
