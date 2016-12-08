import java.util.Comparator;

/**
 * 
 */

/**
 * @author janie_000
 *
 */
public class NameComparator implements Comparator<Student> {
	@Override
	public int compare(Student e1, Student e2) {

		int compVal = e1.getLastName().compareTo(e2.getLastName());
		if (compVal != 0)
			return compVal;

		return e1.getFirstName().compareTo(e2.getFirstName());
	}

}


