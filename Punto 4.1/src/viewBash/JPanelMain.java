package viewBash;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import DataStructure.MyQueue;
import controller.EActionBatchMono;
import modelsBatchMono.Execution;
import modelsBatchMono.MaquineBatchMono;

public class JPanelMain extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JPanelLeft jPanelLeft;
	private JPanelRight jPanelRight;
	private JPanelLog jPanelLog;
	private JButton jButtonNumPrograms;
	private JButton jButtonStartSimulation;
	private MyQueue<Execution> executions;
	
	public JPanelMain(ActionListener actionListener) {
		this.executions = new MyQueue<Execution>();
		init(actionListener);
	}
	
	
	public void fillJPanel() {
		this.jPanelLog.add(new Label("LOGS"));
		
		ArrayList<Execution> list = executions.getQueue();
		
		for (Iterator<Execution> iterator = list.iterator(); iterator.hasNext();) {
			Execution execution = (Execution) iterator.next();
			if (!execution.isFinish()) {
				
			}else {
				
			}
		}
	}
	
	
	private void init(ActionListener actionListener) {
		
		JPanel jPanelSimulation = new JPanel(new GridLayout(1, 3));
		
		// this Jpanel
		this.setLayout(new BorderLayout());
		// JPanelLog
		this.jPanelLog = new JPanelLog();
		JScrollPane jScrollPaneLog = new JScrollPane(jPanelLog);
		//JPanelLeft
		this.jPanelLeft = new JPanelLeft();
		//JPanelright
		this.jPanelRight = new JPanelRight();
		
		//JButton
		this.jButtonNumPrograms = new JButton("Agregar numero de programas a simular");
		jButtonNumPrograms.addActionListener(actionListener);
		jButtonNumPrograms.setActionCommand(EActionBatchMono.NUM_PROGRAMS.name());
		
		this.jButtonStartSimulation = new JButton("Iniciar simulacion");
		jButtonStartSimulation.addActionListener(actionListener);
		jButtonStartSimulation.setActionCommand(EActionBatchMono.START_SIMULATION.name());
		
		this.jPanelLeft.setSize(200, Toolkit.getDefaultToolkit().getScreenSize().height);
		
		
		//Agregar al panel main
		//jPanelSimulation.add(jButtonNumPrograms);
		jPanelSimulation.add(jPanelLeft);
		jPanelSimulation.add(jScrollPaneLog);
		jPanelSimulation.add(jPanelRight);
		
		this.add(jButtonNumPrograms,BorderLayout.PAGE_START);
		this.add(jButtonStartSimulation,BorderLayout.PAGE_END);
		this.add(jPanelSimulation,BorderLayout.CENTER);
	}
	
	
	public void renderView(MaquineBatchMono maquineBatchMono) {
		jPanelLeft.renderJPanelLeft(maquineBatchMono);
		jPanelLog.renderJPanelLog(maquineBatchMono);
		
		for (Iterator<Execution> iterator = maquineBatchMono.getQueueExecution().getQueue().iterator(); iterator.hasNext();) {
			Execution execution = (Execution) iterator.next();
			this.jPanelRight.renderFinish(execution.getFinishs());
		}
	}

}
