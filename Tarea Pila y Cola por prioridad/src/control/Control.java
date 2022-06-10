package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.SwingWorker;
import javax.swing.Timer;

import model.RecessService;
import model.priorityList.Task;
import model.priorityList.TaskList;
import view.Peanut;

public class Control implements ActionListener {

	private Peanut peanut;
	private ArrayList<Task> tasks;
	private RecessService recessService;
	private TaskList taskList;
	private int count;
	private Random random;
	private Timer timer;
	
	public Control() {
		taskList = new TaskList();
		random = new Random();
		count = 0;
		tasks = new ArrayList<Task>();
		recessService = new RecessService(); 
		peanut = new Peanut(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case ADD:
			addTask();
			break;
		case GET:
			getPriorityTask();
			break;
		case COMPLETE_TASK:
			completeTask();
			break;
		case TAKE_RECESS:
			takeRecess();
			break;
		}
	}

	private void addTask() {
//		priorityQueue.add(peanut.getFindPanel().getPriorityText(), peanut.getFindPanel().getTaskText());
		taskList.addTask(new Task(peanut.getFindPanel().getTaskText(), Integer.parseInt(peanut.getFindPanel().getPriorityText())));
//		task.add(new Task(peanut.getFindPanel().getTaskText(), Integer.parseInt(peanut.getFindPanel().getPriorityText())));
//		for (Task task2 : task) {
//			System.out.println(task2.getName() + "-" + task2.getPoints());
//		}
//		System.out.println("--------------------------------------------");
	}

	private void takeRecess() {
		try {
			int x = recessService.getLastEvent();
			peanut.getFindPanel().setRecess(x);
			peanut.getFindPanel().disableBtnRecess();
			peanut.getFindPanel().disableBtnGetTask();
			peanut.getCardsPanel().disableBtn();
			peanut.getFindPanel().disableBtnAddTask();
			SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					int xd = x;
					while (xd > 0 ) {
						peanut.getCardsPanel().fill(String.valueOf(xd));
						xd -= 1;
						Thread.sleep(1000);
					}
					return null;
				}
				
				@Override
				protected void done() {
					peanut.getCardsPanel().fill("Recess Done");
					peanut.getFindPanel().enableBtnGetTask();
					peanut.getCardsPanel().enableBtn();
					peanut.getFindPanel().enableBtnAddTask();
				}
				
			};
			worker.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void completeTask() {
//		count += tasks.get(tasks.size()-1).getPoints();
		count += taskList.poll().getPoints();
		if (count >= 10 ) {
			recessService.add(random.nextInt(180));
			recessService.printRecess();
			System.out.println("-----------------------");
			peanut.getFindPanel().enableBtnRecess();
			count = 0;
		}
		timer.stop();
		peanut.getCardsPanel().disableBtn();
//		tasks.remove(tasks.size()-1);
	}

	private void getPriorityTask() {
//		priorityQueue.peek();
//		peanut.getCardsPanel().fill(tasks.get(tasks.size()-1).getName());
		peanut.getCardsPanel().fill(taskList.peek().getName() + "- P: " +taskList.peek().getPoints());
		peanut.getCardsPanel().enableBtn();
		timer = new Timer(1000, new ActionListener() {
			int aux = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				peanut.getCardsPanel().updateTime(aux += 1);
			}
		});
		timer.start();
	}
	
	public static void main(String[] args) {
		new Control();
	}
}
