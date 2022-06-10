package view;


import java.awt.Color;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Control.Control;
import view.createAccount.CreateAccountMainPanel;
import view.dialogChangeFolderName.RenameFolderFrame;
import view.dialogChangePassword.ChangePasswordFrame;
import view.dialogChangeoUserName.RenameUserFrame;
import view.inCloud.InCloudPanel;
import view.login.LoginMainPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 2759812542498748168L;
	private InCloudPanel inCloudPanel;
	private LoginMainPanel loginMainPanel;
	private CreateAccountMainPanel createAccountMainPanel;
	private RenameFolderFrame renameArchive;
	private RenameUserFrame renameUser;
	private ChangePasswordFrame changePassword;
	@SuppressWarnings("unused")
	private Properties properties;

	public MainFrame(Control control, Properties properties) {
		setBackground(Color.decode("#FFFFFF"));
		setIconImage(new ImageIcon("src/data/images/MegaIcon.png").getImage());
		inCloudPanel = new InCloudPanel(control, properties);
		loginMainPanel = new LoginMainPanel(control, properties);
		createAccountMainPanel = new CreateAccountMainPanel(control, properties);
		renameArchive = new RenameFolderFrame(control, properties);
		renameUser = new RenameUserFrame(control, properties);
		changePassword = new ChangePasswordFrame(control, properties);
		setSize(400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setUndecorated(true);
		getContentPane().setBackground(Color.decode("#FAFAFA"));
		setResizable(false);
		loadLogin();
		setVisible(true);
	}
	
	public void diposeDialogRenameArchive() {
		renameArchive.setVisible(false);
		renameArchive.clean();
	}
	
	public void diposeDialogRenameUser() {
		renameUser.setVisible(false);
		renameUser.clean();
	}
	
	public void diposeDialogChangePassword() {
		changePassword.setVisible(false);
		changePassword.clean();
	}
	
	public void cleanArchiveDialog() {
		renameArchive.clean();
	}
	
	public void cleanUserDialog() {
		renameUser.clean();
	}
	
	public void cleanPasswordDialog() {
		changePassword.clean();
	}
	
	public String getNewPassword() {
		return changePassword.getNewPassword();
	}
	
	public String getNewUserName() {
		return renameUser.getNewUserName();
	}
	
	public String getNewArchiveName() {
		return renameArchive.getNewArchiveName();
	}
	
	public void showRenameArchiveDialog() {
		renameArchive.setVisible(true);
	}
	
	public void showRenameUserDialog() {
		renameUser.setVisible(true);
	}
	
	public void showChangePasswordDialog() {
		changePassword.setVisible(true);
	}
	
	public void percentageUsed(int percentage) {
		inCloudPanel.percentageUsed(percentage);
	}
	
	public void showMenu() {
		inCloudPanel.showMenu();
	}
	
	public void showProfilePanel() {
		loginMainPanel.cleanTextFields();
		inCloudPanel.showProfilePanel();
	}
	
	public String getSelectedLanguaje() {
		return inCloudPanel.getSelectedLanguaje();
	}
	
	public void showCloudPanel() {
		inCloudPanel.showCloudPanel();
	}
	
	public void cleanFolder() {
		inCloudPanel.clean();
	}
	
	public void loadCreateAccount(){
		loginMainPanel.setVisible(false);
		createAccountMainPanel.setVisible(true);
		add(createAccountMainPanel);
		repaint();
	}
	
	public void loadLogin() {
		createAccountMainPanel.setVisible(false);
		loginMainPanel.setVisible(true);
		add(loginMainPanel);
		repaint();
	}
	
	public void loadLoginBeforeLogout(){
		inCloudPanel.setVisible(false);
		loginMainPanel.setVisible(true);
		add(loginMainPanel);
		repaint();
	}
	
	public void loadApp() {
		loginMainPanel.setVisible(false);
		add(inCloudPanel);
		inCloudPanel.setVisible(true);
		repaint();
	}
	
	public void addFolder(String name) {
		inCloudPanel.addFolder(name);
	}
	
	public void addArchive(String name) {
		inCloudPanel.addArchive(name);
	}
	
	public String getUsernameText() {
		return loginMainPanel.getUsernameText();
	}
	
	public String getPasswordText() {
		return loginMainPanel.getPasswordText();
	}
	
	public String getUsernameToCreateText() {
		return createAccountMainPanel.getUsernameText();
	}

	public String getPasswordToCreateText() {
		return createAccountMainPanel.getPasswordText();
	}
	
	public boolean isSelectedCheck() {
		return createAccountMainPanel.selectedCheck();
	}
	
	public void setBarText(String text) {
		inCloudPanel.setText(text);
	}
	
	public void setUserNameProfileText(String name) {
		inCloudPanel.setUserNameText(name);
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
//		loginMainPanel.setProperties(properties);
//		createAccountMainPanel.setProperties(properties);
//		renameArchive.setProperties(properties);
//		renameUser.setProperties(properties);
//		changePassword.setProperties(properties);
	}
}
