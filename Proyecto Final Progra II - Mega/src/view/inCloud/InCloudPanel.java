package view.inCloud;

import java.awt.BorderLayout;
import java.util.Properties;

import javax.swing.JPanel;

import Control.Control;

public class InCloudPanel extends JPanel {
	private static final long serialVersionUID = -3763704185554649160L;
	
	private ProfilePanel profilePanel;
	private FindBarPanel findBarPanel;
	private FooterPanel footerPanel;
	private archivesPanel archivesPanel;
	
	public InCloudPanel(Control control, Properties properties) {
		findBarPanel = new FindBarPanel(control, properties);
		footerPanel = new FooterPanel(control);
		archivesPanel = new archivesPanel(control, properties);
		profilePanel = new ProfilePanel(control, properties);
		setLayout(new BorderLayout());
		add(findBarPanel, BorderLayout.NORTH);
		add(archivesPanel, BorderLayout.CENTER);
		add(footerPanel, BorderLayout.SOUTH);
	}
		
	public String getSelectedLanguaje() {
		return profilePanel.getSelectedLanguaje();
	}
	
	public void percentageUsed(int percentage) {
		profilePanel.percentageUsed(percentage);
	}
	
	public void showMenu() {
		findBarPanel.showMenu();
	}
	
	public void showProfilePanel() {
		findBarPanel.showButtonBack();
		archivesPanel.setVisible(false);
		add(profilePanel, BorderLayout.CENTER);
		footerPanel.setVisible(false);
		profilePanel.setVisible(true);
	}
	
	public void showCloudPanel() {
		findBarPanel.showMenuButton();
		profilePanel.setVisible(false);
		archivesPanel.setVisible(true);
		footerPanel.setVisible(true);
	}
	
	public void setText(String text) {
		findBarPanel.setText(text);
	}
	
	public void addFolder(String name) {
		archivesPanel.addFolder(name);
	}

	public void addArchive(String name) {
		archivesPanel.addArchive(name);
	}
	
	public void setUserNameText(String name) {
		profilePanel.setUserNameText(name);
	}
	
	public void clean() {
		archivesPanel.clean();
	}
}
