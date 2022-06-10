package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.Node;
import model.Profile;
import model.ProfileList;
import view.desktop.AddDialog;
import view.desktop.PeanutDesktop;
import view.mobile.PeanutMobile;

public class Control implements ActionListener {

	private PeanutDesktop desktop;
	private ProfileList list;
	private AddDialog addDialog;
	private PeanutMobile mobile;
	private File path;
	private int count;
	private Node node;
	
	public Control() {
		path = null;
		count = 0;
		list = new ProfileList();
		node = list.getFirst();
		desktop = new PeanutDesktop(this);
		addDialog = new AddDialog(this);
		mobile = new PeanutMobile(this);
		mobile.revalidateCard(node);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case ADD_FIRST:
			addFirst();
			break;
		case ADD_LAST:
			addLast();
			break;
		case DELETE_BY_ID:
			deleteById();
			break;
		case DELETE_FIRST:
			deleteFirst();
			break;
		case DELETE_LAST:
			deleteLast();
			break;
		case SHOW_ADD_DIALOG:
			showDialog();
			break;
		case SHOW_CHOOSER:
			showChooser();
			break;
		case UPDATE:
			update();
			break;
		case UPDATE_MOBILE:
			updateMobile();
			break;
		case LIKE:
			like();
			break;
		case DISLIKE:
			dislike();
			break;
		default:
			break;
		}
	}

	private void like() {
		Node aux = list.get(Integer.valueOf(mobile.getPanelName()));
		int likes = aux.getData().getLikes();
		aux.getData().setLikes(likes += 1);
		node = aux.getNext();
		mobile.revalidateCard(node);
	}

	private void dislike() {
		node = list.get(Integer.valueOf(mobile.getPanelName())).getNext();
		mobile.revalidateCard(node);
	}

	private void updateMobile() {
		mobile.revalidateCard(list.getFirst());
	}

	private void update() {
		desktop.getCards().graphicCards(list);
		desktop.revalidate();
	}

	private void deleteById() {
		String option = JOptionPane.showInputDialog(desktop, "What profile do you want delete?", "Delete by id",
				JOptionPane.INFORMATION_MESSAGE);
		if (option != null) {
			list.delete(Integer.valueOf(option));
			update();
		}
	}

	private void deleteLast() {
		list.deleteLast();
		update();
	}

	private void deleteFirst() {
		list.deleteHead();
		update();
	}

	private void addLast() {
		try {
			list.addNode(new Node(new Profile(count, ImageIO.read(path), addDialog.getNameText(), processDate(),
					addDialog.getDescriptionText())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		update();
		addDialog.setVisible(false);
		count++;
	}

	private void addFirst() {
		try {
			list.addNodeToHead(new Node(new Profile(count, ImageIO.read(path), addDialog.getNameText(), processDate(),
					addDialog.getDescriptionText())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		update();
		addDialog.setVisible(false);
		count++;
	}

	private void showChooser() {
		JFileChooser fileChooser = new JFileChooser();
		int seleccion = fileChooser.showOpenDialog(fileChooser);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			path = fileChooser.getSelectedFile();
			addDialog.setPathText(path.getPath());
		}
	}

	private void showDialog() {
		addDialog.setVisible(true);
	}

	private String processDate() {
		return addDialog.getDayText() + "/" + addDialog.getMonthText() + "/" + addDialog.getYearText();
	}

	public static void main(String[] args) throws IOException {
		new Control();
	}

}
