import java.util.Comparator;

/**
 * 
 */

/**
 * @author janie_000
 *
 */
public class GradeAverageComparator implements Comparator<Student>{

	@Override
	public int compare(Student e1, Student e2) {
		int compVal = 0;

		if (e1.getCurrentAverage() > e2.getCurrentAverage())
			compVal = -1;
		else if (e1.getCurrentAverage() < e2.getCurrentAverage())
			compVal = 1;
		
		return compVal;
	}


}
