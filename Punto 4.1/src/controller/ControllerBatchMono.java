package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelsBatchMono.MaquineBatchMono;
import viewBash.JMainFrame;


public class ControllerBatchMono implements ActionListener, IObserverMonitorController{
	
	private MaquineBatchMono batchMono;
	private JMainFrame jMainFrame;
	
	public ControllerBatchMono() {
		this.jMainFrame = new JMainFrame(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		switch (EActionBatchMono.valueOf(arg0.getActionCommand())) {
		case NUM_PROGRAMS:
			int num = Integer.parseInt(JOptionPane.showInputDialog("Numero de programas"));
			initMaquine(num);
			executeProgramRender();
			break;
			
		case START_SIMULATION:
			batchMono.executePrograms();
			break;

		default:
			break;
		}
		
	}

	private void initMaquine(int num) {
		this.batchMono = new MaquineBatchMono(num,this);
		batchMono.addIObserverMonitorController(this);
		jMainFrame.renderView(batchMono);
	}

	@Override
	public void executeProgramRender() {
		System.out.println("Llego un aviso al controlador de una ejecucion");
		jMainFrame.renderView(batchMono);
	}

}
