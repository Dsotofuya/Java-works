package model.priorityList;

import java.util.PriorityQueue;

public class TaskList {
	
	private PriorityQueue<Task> taskList;

	public TaskList() {
		taskList = new PriorityQueue<Task>(new TaskComparator());
	} 
	
	public void addTask(Task task) {
		taskList.add(task);
	}
	
	public Task poll() {
		return taskList.poll();
	}
	
	public Task peek() {
		return taskList.peek();
	}
}

