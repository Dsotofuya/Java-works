package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Tree;
import model.Type;
import model.userTree.State;
import model.userTree.TreeUser;
import network.Network;
import view.AddFolderDialog;
import view.AddImageDialog;
import view.AddTextDialog;
import view.AddUserDialog;
import view.DialogPostal;
import view.GenericDialog;
import view.Peanut;
import view.SelectDialog;
import view.SelectDialogV2;
import view.SelectDialogV3;

public class Control implements MouseListener, ActionListener {

	private Peanut peanut;
	private Tree tree;
	private Network network;
	private TreeUser users;
	private GenericDialog genericDialog;
	private SelectDialog selectDialog;
	private AddFolderDialog addFolderDialog;
	private AddImageDialog addImageDialog;
	private AddTextDialog addTextDialog;
	private SelectDialogV2 selectDialogV2;
	private SelectDialogV3 selectDialogV3;
	private AddUserDialog addUserDialog;

	public Control() {
		tree = new Tree();
		users = new TreeUser();
		network = new Network();
		changeHost();
		peanut = new Peanut(this, tree.getRoot(), users.getRoot(), this);
		tree = network.getTreePostal();
		peanut.getTreePostal().paintTree(tree.getRoot());
		users = network.getTreeUsers();
		peanut.getTreeUser().paintTree(users.getRoot());
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case SHOW_ADD_FOLDER:
			showAddFolder();
			break;
		case ADD_FOLDER:
			addFolder();
			break;
		case SHOW_ADD_FOLDER_INSIDE_OTHER:
			showAddFolderInsideOther();
			break;
		case ADD_FOLDER_INSIDE_OTHER:
			addFolderInsideOther();
			break;
		case SHOW_ADD_POSTAL:
			showAddPostal();
			break;
		case ADD_POSTAL:
			addPostal();
			break;
		case SHOW_ADD_IMAGE:
			showAddImage();
			break;
		case ADD_IMAGE:
			addImage();
			break;
		case SHOW_ADD_TEXT:
			showAddText();
			break;
		case ADD_TEXT:
			addText();
			break;
		case SHOW_EDIT:
			showEdit();
			break;
		case EDIT:
			edit();
			break;
		case SHOW_EDIT_TEXT:
			showEditText();
			break;
		case EDIT_TEXT:
			editText();
			break;
		case SHOW_EDIT_IMAGE:
			showEditImage();
			break;
		case EDIT_IMAGE:
			editImage();
			break;
		case SHOW_DELETE:
			showDelete();
			break;
		case DELETE:
			delete();
			break;
		case SHOW_VIEW_POSTAL:
			showViewPostal();
			break;
		case VIEW_POSTAL:
			viewPostal();
			break;
		case SHOW_VIEW_TEXT:
			showViewText();
			break;
		case VIEW_TEXT:
			viewText();
			break;
		case SHOW_VIEW_IMAGE:
			showViewImage();
			break;
		case VIEW_IMAGE:
			viewImage();
			break;
		case CHANGE_HOST:
			changeHost();
			break;
		case POSTAL_SELECTED:
			generateLists();
			break;
		case SHOW_ADD_USER:
			showAddUser();
			break;
		case ADD_USER:
			addUser();
			break;
		case SHOW_CHANGE_PASSWORD:
			showChangePassWord();
			break;
		case CHANGE_PASSWORD:
			changePassword();
			break;
		case SHOW_CONCEDE_PRIVILEGES:
			showConcedePrivileges();
			break;
		case CONCEDE_PRIVILEGES:
			concedePrivileges();
			break;
		case RELOAD:
			reaload();
			break;
		default:
			break;
		}
	}

	private void reaload() {
		tree = network.getTreePostal();
		peanut.getTreePostal().paintTree(tree.getRoot());
		users = network.getTreeUsers();
		peanut.getTreeUser().paintTree(users.getRoot());
	}

	private void concedePrivileges() {
		network.ConcedePrivileges(selectDialogV3.getSelectedObj(), selectDialogV3.getSelectedImage(), selectDialogV3.getSelectedText());
		users = network.getTreeUsers();
		peanut.getTreeUser().paintTree(users.getRoot());
		selectDialogV3.setVisible(false);
	}

	private void showConcedePrivileges() {
		String[] listPrivileges = {State.CREATE.toString(), State.EDIT.toString(), State.VIEW.toString(), State.ALL.toString()};
		selectDialogV3 = new SelectDialogV3(this, "Concede privileges", Events.CONCEDE_PRIVILEGES.toString(), listUsers(), listAll(), listPrivileges);
	}

	private void changePassword() {
		network.changePasswordUser(genericDialog.getSelectedObj(), genericDialog.getNameObj());
		genericDialog.clearComponents();
		genericDialog.setVisible(false);
	}

	private void showChangePassWord() {
		genericDialog = new GenericDialog(this, "Change user password", Events.CHANGE_PASSWORD.toString(), listUsers());
	}

	private void addUser() {
		network.addUser(addUserDialog.getNameObj(), addUserDialog.getNewPassword());
		users = network.getTreeUsers();
		peanut.getTreeUser().paintTree(users.getRoot());
		addUserDialog.clearComponents();
		addUserDialog.setVisible(false);
	}

	private void showAddUser() {
		addUserDialog = new AddUserDialog(this, "Add user", Events.ADD_USER.toString());
	}

	private void generateLists() {
		String name = selectDialogV2.getSelectedObj();
		selectDialogV2.writeImages(listEspesific(name, Type.IMAGE));
		selectDialogV2.writeText(listEspesific(name, Type.TEXT));
	}

	private void viewPostal() {
		try {
			String img = selectDialogV2.getSelectedImage();
			String text = selectDialogV2.getSelectedText();
			network.getTextPostal(text);
			byte[] image = network.getImage(img);
			new DialogPostal(paintPostal(ImageIO.read(new File(processImageRecived(image, img))), 500, 500, text));
			selectDialogV2.setVisible(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showViewPostal() {
		selectDialogV2 = new SelectDialogV2(this, "Show Postal", Events.VIEW_POSTAL.toString(),
				listObjects(Type.POSTAL));
	}

	private void viewText() {
		String name = selectDialog.getSelectedObj();
		new DialogPostal(paintText(500, 500, network.getTextPostal(name)));
		selectDialog.clearComponents();
		selectDialog.setVisible(false);
	}

	private void showViewText() {
		selectDialog = new SelectDialog(this, "View Text", Events.VIEW_TEXT.toString(), listObjects(Type.TEXT));
	}

	private void viewImage() {
		try {
			String name = selectDialog.getSelectedObj();
			new DialogPostal(ImageIO.read(new File(processImageRecived(network.getImage(name), name))));
			selectDialog.clearComponents();
			selectDialog.setVisible(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showViewImage() {
		selectDialog = new SelectDialog(this, "View Image", Events.VIEW_IMAGE.toString(), listObjects(Type.IMAGE));
	}

	private void delete() {
		network.delete(selectDialog.getSelectedObj());
		tree = network.getTreePostal();
		peanut.getTreePostal().paintTree(tree.getRoot());
		selectDialog.clearComponents();
		selectDialog.setVisible(false);
	}

	private void showDelete() {
		selectDialog = new SelectDialog(this, "Delete", Events.DELETE.toString(), listAll());
	}

	private void editImage() {
		network.editImage(addImageDialog.getSelectedObj(), processImage(addImageDialog.getFileImage()));
		tree = network.getTreePostal();
		peanut.getTreePostal().paintTree(tree.getRoot());
		addImageDialog.clearComponents();
		addImageDialog.setVisible(false);
	}

	private void showEditImage() {
		addImageDialog = new AddImageDialog(this, "Add image", Events.EDIT_IMAGE.toString(), listObjects(Type.IMAGE));
	}

	private void editText() {
		network.editText(genericDialog.getSelectedObj(), genericDialog.getNameObj());
		tree = network.getTreePostal();
		peanut.getTreePostal().paintTree(tree.getRoot());
		genericDialog.clearComponents();
		genericDialog.setVisible(false);
	}

	private void showEditText() {
		genericDialog = new GenericDialog(this, "Edit text", Events.EDIT_TEXT.toString(), listObjects(Type.TEXT));
	}

	private void edit() {
		network.edit(genericDialog.getSelectedObj(), genericDialog.getNameObj());
		tree = network.getTreePostal();
		peanut.getTreePostal().paintTree(tree.getRoot());
		genericDialog.clearComponents();
		genericDialog.setVisible(false);
	}

	private void showEdit() {
		genericDialog = new GenericDialog(this, "Rename", Events.EDIT.toString(), listAll());
	}

	private void addText() {
		network.addText(addTextDialog.getSelectedObj(), addTextDialog.getNameObj(), addTextDialog.getTextPostal());
		tree = network.getTreePostal();
		peanut.getTreePostal().paintTree(tree.getRoot());
		addTextDialog.clearComponents();
		addTextDialog.setVisible(false);
	}

	private void showAddText() {
		addTextDialog = new AddTextDialog(this, "Add text", Events.ADD_TEXT.toString(), listObjects(Type.POSTAL));
	}

	private void addImage() {
		network.addImage(addImageDialog.getSelectedObj(), addImageDialog.getNameObj(),
				processImage(addImageDialog.getFileImage()));
		tree = network.getTreePostal();
		peanut.getTreePostal().paintTree(tree.getRoot());
		addImageDialog.clearComponents();
		addImageDialog.setVisible(false);
	}

	private void showAddImage() {
		addImageDialog = new AddImageDialog(this, "Add image", Events.ADD_IMAGE.toString(), listObjects(Type.POSTAL));
	}

	private void addPostal() {
		network.addPostal(genericDialog.getSelectedObj(), genericDialog.getNameObj());
		tree = network.getTreePostal();
		peanut.getTreePostal().paintTree(tree.getRoot());
		genericDialog.clearComponents();
		genericDialog.setVisible(false);
	}

	private void showAddPostal() {
		genericDialog = new GenericDialog(this, "Add Postal", Events.ADD_POSTAL.toString(), listObjects(Type.FOLDER));
	}

	private void addFolderInsideOther() {
		network.addFolderInsideOtheFolder(genericDialog.getSelectedObj(), genericDialog.getNameObj());
		tree = network.getTreePostal();
		peanut.getTreePostal().paintTree(tree.getRoot());
		genericDialog.clearComponents();
		genericDialog.setVisible(false);
	}

	private void showAddFolderInsideOther() {
		genericDialog = new GenericDialog(this, "Add folder inside other", Events.ADD_FOLDER_INSIDE_OTHER.toString(),
				listObjects(Type.FOLDER));
	}

	private void addFolder() {
		network.addFolder(addFolderDialog.getNameFolder());
		tree = network.getTreePostal();
		peanut.getTreePostal().paintTree(tree.getRoot());
		addFolderDialog.clearField();
		addFolderDialog.setVisible(false);
	}

	private void showAddFolder() {
		addFolderDialog = new AddFolderDialog(this);
	}

	private Object[] listEspesific(String name, Type type) {
		return tree.listEspesific(name, type).toArray();
	}

	private Object[] listAll() {
		return tree.listAll().toArray();
	}

	private Object[] listObjects(Type type) {
		return tree.listObjects(type).toArray();
	}
	
	private Object[] listUsers() {
		return users.listUsers().toArray();
	}

	private String processImageRecived(byte[] image, String name) {
			ByteArrayInputStream bis = new ByteArrayInputStream(image);
		BufferedImage bufferedImage;
		String path = "src/img/" + name + ".png";
		try {
			bufferedImage = ImageIO.read(bis);
			ImageIO.write(bufferedImage, "png", new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	private byte[] processImage(File file) {
		byte[] image = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(getScaledImage(ImageIO.read(file), 500, 500), "png", bos);
			image = bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	private BufferedImage paintText(int w, int h, String text) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Arial", Font.ITALIC, 30));
		g2.drawString(text, 50, 50);
		g2.dispose();
		return resizedImg;
	}

	private BufferedImage paintPostal(Image srcImg, int w, int h, String text) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Arial", Font.ITALIC, 30));
		g2.drawString(text, 50, 50);
		g2.dispose();
		return resizedImg;
	}

	private BufferedImage getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();
		return resizedImg;
	}

	private void changeHost() {
		network.setHost(Utilities.inputString("Input the new host", "Change host"));
		Utilities.showMessage("Host has changed", "New host");
	}

	public static void main(String[] args) {
		new Control();
	}
}