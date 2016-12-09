/**
 * 
 */

/**
 * @author janie_000
 *
 */
public class Student {
	private String firstName;
	private String lastName;
	private int numOfGrades;
	private int sumOfGrades;
	
	/**
	 * Constructor for student
	 * @param first
	 * @param last
	 */
	public Student(String first, String last){
		this.firstName = first;
		this.lastName = last;
		this.numOfGrades = 0;
		this.sumOfGrades = 0;
	}
	/**
	 * adds a grade to student
	 * @param grade
	 */
	public void addGrade(int grade){
		sumOfGrades += grade;
		numOfGrades++;
	}
	
	public double getCurrentAverage(){
		if(numOfGrades == 0){
			return 0;
		}
		
		return sumOfGrades/numOfGrades;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the numOfGrades
	 */
	public int getNumOfGrades() {
		return numOfGrades;
	}
	/**
	 * @param numOfGrades the numOfGrades to set
	 */
	public void setNumOfGrades(int numOfGrades) {
		this.numOfGrades = numOfGrades;
	}
	/**
	 * @return the sumofGrades
	 */
	public int getSumOfGrades() {
		return sumOfGrades;
	}
	/**
	 * @param sumofGrades the sumofGrades to set
	 */
	public void setSumOfGrades(int sumofGrades) {
		this.sumOfGrades = sumofGrades;
	}
	/**
	 * @overidetoString in class Object
	 * @return String representation of this student 
	 */
	public String toString(){
		return lastName + ", " + firstName + ":	" + getCurrentAverage();
	} 
	

}
