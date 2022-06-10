package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private JDialogAddForm jDialogAddForm;
	private MainPanel mainPanel;
	
	public MainWindow(ActionListener listener) {
		jDialogAddForm = new JDialogAddForm(this, listener);
		setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		mainPanel = new MainPanel(listener);
		add(new JScrollPane(mainPanel), BorderLayout.CENTER);
		
		setVisible(true);
		

	}
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}
	
	public JDialogAddForm getjDialogAddForm() {
		return jDialogAddForm;
	}
	public void showAddPostDialog() {
		jDialogAddForm.setVisible(true);	
	}
	
	public String getFileImage() {
		return jDialogAddForm.getFile();
	}
	public void closeShowAddDialog() {
		jDialogAddForm.dispose();
	}
}
