package structures;

import java.util.Comparator;

public class SortComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return getFactor(o1)-getFactor(o2);
	}

	private int getFactor(String value) {
		int valuer = Integer.parseInt(value.split(";")[0]);
		return valuer;
	}
}
