package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JComponent;
import javax.swing.JFileChooser;

import Constants.Constants;
import model.Archive;
import model.User;
import model.UserManager;
import utilities.Utilities;
import view.MainFrame;

public class Control implements ActionListener {

	private UserManager userManager;
	private MainFrame mainFrame;
	private Properties properties;
	private User user;
	private Archive toRename;

	public Control() throws FileNotFoundException, IOException {
		userManager = new UserManager();
		properties = new Properties();
		properties.load(new FileReader("src/data/languajes/Spanish.properties"));
		mainFrame = new MainFrame(this, properties);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equalsIgnoreCase(Constants.LOGINBTN)) {
			user = loginUser(mainFrame.getUsernameText(), mainFrame.getPasswordText());
		}
		
		if (event.getActionCommand().equalsIgnoreCase(Constants.CREATEACCOUNTBTN)) {
			mainFrame.loadCreateAccount();
		}
		
		if (event.getActionCommand().equalsIgnoreCase(Constants.CREATENEWACCOUNTBTN)) {
			if (createNewUser() == true) {
				mainFrame.loadLogin();
			}
		}
		
		if (event.getActionCommand().equalsIgnoreCase(Constants.TOLOGINBTN)) {
			mainFrame.loadLogin();
		}
		
		if (event.getActionCommand().equalsIgnoreCase(Constants.OPTIONSBTN)) {
			mainFrame.showMenu();
		}
		
		if (event.getActionCommand().equalsIgnoreCase(Constants.ADDFOLDER)) {
			createNewFolder();
		}
		
		if (event.getActionCommand().equalsIgnoreCase(Constants.MENUBTN)) {
			loadProfile();
		}
		
		if (event.getActionCommand().equalsIgnoreCase(Constants.BACKBTN)) {
			mainFrame.showCloudPanel();
			mainFrame.setBarText(properties.getProperty("myCloud"));
		}
		
		if (event.getActionCommand().equalsIgnoreCase(Constants.LOGOUT)) {
			mainFrame.cleanFolder();
			mainFrame.showCloudPanel();
			mainFrame.loadLoginBeforeLogout();
		}
		
		if (event.getActionCommand().equalsIgnoreCase(Constants.RENAMEFOLDER)) {
			String name = ((JComponent) event.getSource()).getName();
			toRename = user.findArchive(name);
			mainFrame.showRenameArchiveDialog();
		}
		
		if (event.getActionCommand().equalsIgnoreCase(Constants.DELETEFOLDER)) {
			Archive archiveToDelete = user.findArchive(((JComponent) event.getSource()).getName());
			user.deleteArchive(archiveToDelete);
			mainFrame.cleanFolder();
			paintArchives(user);
			userManager.getUsersDao().writeDates(userManager.getUserList());
		}
		
		if (event.getActionCommand().equalsIgnoreCase(Constants.ACCEPT)) {
			renameFolder();
		}
		
		if (event.getActionCommand().equalsIgnoreCase(Constants.CANCEL)) {
			mainFrame.diposeDialogRenameArchive();
		}
		if (event.getActionCommand().equalsIgnoreCase(Constants.CHANGENAMEBTN)) {
			mainFrame.showRenameUserDialog();	
		}
		if (event.getActionCommand().equalsIgnoreCase(Constants.ACCEPTCHANGENAME)) {
				changeUserName();
		}
		if (event.getActionCommand().equalsIgnoreCase(Constants.CANCELCHANGENAME)) {
			mainFrame.diposeDialogRenameUser();
		}
		if (event.getActionCommand().equalsIgnoreCase(Constants.CHANGEPASSWORDBTN)) {
			mainFrame.showChangePasswordDialog();	
		}
		if (event.getActionCommand().equalsIgnoreCase(Constants.ACCEPTCHANGEPASSWORD)) {
				changePassword();
		}
		if (event.getActionCommand().equalsIgnoreCase(Constants.CANCELCHANGEPASSWORD)) {
			mainFrame.diposeDialogChangePassword();
		}
		if (event.getActionCommand().equalsIgnoreCase(Constants.DELETEACCOUNT)) {
			ArrayList<User> xd = userManager.getUserList();
			for (User user : xd) {
				if (this.user.getUser().equalsIgnoreCase(user.getUser())) {
					userManager.getUserList().remove(user);
					mainFrame.cleanFolder();
					mainFrame.showCloudPanel();
					mainFrame.loadLoginBeforeLogout();
					userManager.getUsersDao().writeDates(userManager.getUserList());
				}
			}
		}
		if (event.getActionCommand().equalsIgnoreCase(Constants.LANGUAJESELECTED)) {
			changeLanguaje();
		}
	}

	private void renameFolder() {
		String text = mainFrame.getNewArchiveName();
		toRename.setName(text);
		mainFrame.cleanFolder();
		paintArchives(user);
		userManager.getUsersDao().writeDates(userManager.getUserList());
		mainFrame.diposeDialogRenameArchive();
		mainFrame.cleanArchiveDialog();
	}

	public void changeNameArchive(String name) {
		user.findArchive(name);
	}

	public void changeUserName() {
		User userTochange = userManager.findUser(user.getUser());
		userTochange.setUser(mainFrame.getNewUserName());
		userManager.getUsersDao().writeDates(userManager.getUserList());
		mainFrame.setUserNameProfileText(user.getUser());
		mainFrame.diposeDialogRenameUser();
		mainFrame.cleanUserDialog();
		loadProfile();
	}

	public void changePassword() {
		User userTochange = userManager.findUser(user.getUser());
		userTochange.setPassword(mainFrame.getNewPassword());
		userManager.getUsersDao().writeDates(userManager.getUserList());
		mainFrame.diposeDialogChangePassword();
		mainFrame.cleanPasswordDialog();
	}

	public void changeLanguaje() {
		try {
			if (mainFrame.getSelectedLanguaje().equalsIgnoreCase("English")) {
				System.out.println(mainFrame.getSelectedLanguaje());
				properties.load(new FileReader("src/data/languajes/English.properties"));
				mainFrame.setProperties(properties);
			}
			if (mainFrame.getSelectedLanguaje().equalsIgnoreCase("Portuguese")) {
				System.out.println(mainFrame.getSelectedLanguaje());
				properties.load(new FileReader("src/data/languajes/Portuguese.properties"));
				mainFrame.setProperties(properties);
			}
			if (mainFrame.getSelectedLanguaje().equalsIgnoreCase("Espa\u00F1ol")) {
				System.out.println(mainFrame.getSelectedLanguaje());
				properties.load(new FileReader("src/data/languajes/Espa\\u00F1ol.properties"));
				mainFrame.setProperties(properties);
			}
		} catch (Exception e) {
		}
	}

	public void deleteAccount(String name) {
		System.out.println(name);
	}

	public void createNewFolder() {
		JFileChooser path = new JFileChooser();
		path.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		path.showOpenDialog(path);
		Archive newArchive = user.createNewArchiveFromPath(path.getSelectedFile().getAbsolutePath());
		user.addNewArchive(newArchive);
		if (newArchive.getType().equalsIgnoreCase("C")) {
			mainFrame.addFolder(newArchive.getName());
		}
		if (newArchive.getType().equalsIgnoreCase("A")) {
			mainFrame.addArchive(newArchive.getName());
		}
		userManager.getUsersDao().writeDates(userManager.getUserList());
	}

	public boolean createNewUser() {
		boolean correctly = false;
		if (mainFrame.getUsernameToCreateText() != "" && !mainFrame.getUsernameToCreateText().isEmpty()) {
			if (mainFrame.getPasswordToCreateText() != "" && !mainFrame.getPasswordToCreateText().isEmpty()) {
				if (mainFrame.isSelectedCheck() == true) {
					if (userManager.validateUser(mainFrame.getUsernameToCreateText()) == true) {
						userManager.add(userManager.createUser(mainFrame.getUsernameToCreateText(),
								mainFrame.getPasswordToCreateText(), new ArrayList<Archive>()));
						userManager.getUsersDao().writeDates(userManager.getUserList());
						correctly = true;
					} else {
						Utilities.showMessageError(properties.getProperty("userAlreadyExist"),
								properties.getProperty("userAlreadyExistTitle"));
					}
				} else {
					Utilities.showMessageError(properties.getProperty("notAceptedTerms"),
							properties.getProperty("notAceptedTermsTitle"));
				}
			} else {
				Utilities.showMessageError(properties.getProperty("passwordEmpty"),
						properties.getProperty("passwordEmptyTitle"));
			}
		} else {
			Utilities.showMessageError(properties.getProperty("userEmpty"), properties.getProperty("userEmptyTitle"));
		}
		return correctly;
	}

	private User loginUser(String userName, String password) {
		User user = userManager.findUser(userName);
		if (user != null) {
			if (user.getUser().equalsIgnoreCase(userName) && user.getPassword().equalsIgnoreCase(password)) {
				mainFrame.loadApp();
				paintArchives(user);
			} else {
				Utilities.showMessageError(properties.getProperty("wrongPasswordOrUser"),
						properties.getProperty("wrongPasswordOrUserTitle"));
			}
		} else {
			Utilities.showMessageError(properties.getProperty("userNoFounded"),
					properties.getProperty("userNoFoundedTitle"));
		}
		return user;
	}

	public void paintArchives(User user) {
		try {
			for (Archive archive : user.getArchiveList()) {
				if (archive.getType().equalsIgnoreCase("C")) {
					mainFrame.addFolder(archive.getName());
				}
				if (archive.getType().equalsIgnoreCase("A")) {
					mainFrame.addArchive(archive.getName());
				}
			}
		} catch (Exception e) {
		}
	}

	private void loadProfile() {
		mainFrame.setUserNameProfileText(user.getUser());
		mainFrame.percentageUsed(userManager.datesToBar(userManager.getSizeUsedByUser(user)));
		mainFrame.showProfilePanel();
		mainFrame.setBarText(properties.getProperty("profile"));
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		new Control();

	}
}
