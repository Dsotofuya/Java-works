package model.priorityList;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {
	@Override
	public int compare(Task o1, Task o2) {
		if (o1.getPoints() < o2.getPoints())
			return 1;
		else if (o1.getPoints() > o2.getPoints())
			return -1;
		return 0;
	}

}
