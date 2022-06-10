package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

import models.Partition;
import models.Process;
import models.ProcessManager;
import persistence.CreatePDF;
import utilities.Utilities;
import view.JFMainWindow;

import javax.swing.*;

@SuppressWarnings("unused")
public class Controller implements ActionListener {

	private JFMainWindow mainWindow;
	private ProcessManager manager;
	private CreatePDF createPDF;

	public Controller() {
		manager = new ProcessManager(50);
		mainWindow = new JFMainWindow(this);
		mainWindow.setVisible(true);
	}

	public void test() {
		loadProcessInTable();
	}

	public void createReport() {
		manager.setSizeMemory(mainWindow.getPartitionSize());
		if ((manager.getProcessList().size() != 0) && manager.getSizeMemory() > 0) {
			System.out.println(manager.getSizeMemory());
			System.out.println(mainWindow.getPartitionSize());
			manager.setSizeMemory(mainWindow.getPartitionSize());
			ejecutar2();
			createPDF = new CreatePDF();
			try {
				createPDF.createReport(manager.getExitProcessList(), manager.getCondensacionesList(),
						manager.getExitPartitionList(), manager.getPartititonList().getHistorial());
				continueReport();
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			showMessage("No tiene procesos en lista o no asigno memoria", "Error");
		}
	}

	public void continueReport() {
		if (JOptionPane.showConfirmDialog(mainWindow, "¿Desea agregar más procesos?", "Pregunta",
				JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
			if (JOptionPane.showConfirmDialog(mainWindow, "¿Desea limpiar la lista de procesos?", "Pregunta",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				mainWindow.clearTablePartition();
			}
		}
	}

	public void addProcess() {
		String name = mainWindow.getNameProcess();
		int time = mainWindow.getTimeProcess();
		int size = mainWindow.getSizeProcess();

		if (time <= 0) {
			showMessage("El tiempo del proceso debe ser mayor a 0", "Error");
		}
		if (name.length() == 0) {
			showMessage("Debe ingresar un nombre en el proceso", "Error");
		}
		if (size <= 0) {
			showMessage("El tamaño del proceso debe ser mayor a 0", "Error");
		}
		if (time > 0 && name.length() > 0 && size > 0) {
			if (!manager.processExist(name)) {
				Process process = manager.addProcess(name, time, size);
				mainWindow.addProcessInTable(process);
			} else {
				showMessage("Proceso con ese nombre ya existe en la lista", "Error");
			}
		}
	}

	public void showMessage(String message, String error) {
		JOptionPane.showMessageDialog(mainWindow, message, error, JOptionPane.ERROR_MESSAGE, null);
	}

	public void deleteProcess() {
		String name = JOptionPane.showInputDialog("Ingrese el nombre del proceso a eliminar");
		Process pro = Utilities.searchProcess(name, manager.getProcessList().getHistorial());
		if (pro != null) {
			if (JOptionPane.showConfirmDialog(mainWindow,
					"¿Segundo que desea borrar el proceso con el nombre: " + name + "?", "Pregunta",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				manager.remove(name);
				manager.getProcessList().menosSize();
				manager.getProcessList().resetHistorial();
				mainWindow.clearTableProcess();
				loadProcessInTable();
			}
		} else {
			showMessage("Proceso con ese nombre no existe", "Error");
		}
	}

	public void loadProcessInTable() {
		ArrayList<Process> list = manager.getProcessList().getHistorial();
		for (Process process : list) {
			System.out.println(process.getProcessName());
			mainWindow.addProcessInTable(process);
		}
	}

	public void ejecutar2() {
		if ((manager.getSizeMemory() > 0) && (manager.getProcessList().size() > 0)) {
			manager.ejecutar();
		} else {
			showMessage("No hay procesos o no se asigno memoria", "Error");
		}
	}

	public void reboot() {
		manager.rebootList();
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case ADD_PROCESS:
			addProcess();
			mainWindow.cleanProcessForm();
			break;
		case CLEAR:
			break;
		case START:
			createReport();
			break;
		case CLOSE:
			mainWindow.close();
			break;
		case MINIMIZE:
			mainWindow.minimize();
			break;
		case ADD_PARTITION:
			mainWindow.cleanPartitionForm();
			break;
		case DELETE_PARTITION:
			break;
		case DELETE_PROCESS:
			deleteProcess();
			break;
		}
	}
}
