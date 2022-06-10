package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import model.INode;
import model.Tree;
import view.Peanut;

public class Control implements ActionListener, MouseListener {

	private static final String DISABLE = "El usuario que llama o intenta llamar esta deshabilitado";
	private static final String COSTO = "El costo de esta llamada fue: ";
	private static final String INPUT_COMPANY = "Ingresa el nombre de la compania:";
	private static final String INPUT_COMPANY3 = "Ingresa el nombre de la compania a la cual quiere balancear:";
	private static final String INPUT_COMPANY2 = "Ingresa el nombre de la compania a la cual agregar una zona:";
	private static final String INPUT_ZONE = "Ingresa el nombre de la zona:";
	private static final String INPUT_ZONE3 = "Ingresa el nombre de la zona a la cual quiere deshabilitar usuarios:";
	private static final String INPUT_ZONE2 = "Ingresa el nombre de la zona a la cual agregar usuario:";
	private static final String INPUT_USER = "Ingresa el nombre del usuario que va a llamar:";
	private static final String INPUT_DESTINY = "Ingresa el nombre del destinatario de la llamada:";
	private static final String INPUT_LVL = "Ingresa hasta que nivel deshabilitar";
	
	private Tree tree;
	private Peanut peanut;

	public Control() {
		try {
			tree = new Tree();
			tree.addNewCompany("Tigo");
			tree.addNewZone("Tigo", "zona centro");
			tree.addNewZone("Tigo", "zona sur");
			tree.addNewUser("1-zona centro");
			tree.addNewUser("1-zona centro");
			tree.addNewUser("1-zona centro");
			tree.addNewUser("1-zona centro");
			tree.addNewUser("1-zona centro");
			tree.addNewUser("1-zona centro");
			tree.addNewUser("1-zona centro");
			tree.addNewUser("1-zona centro");
			tree.addNewUser("2-zona sur");
			tree.addNewUser("2-zona sur");
			tree.addNewCompany("Claro");
			tree.addNewZone("Claro", "zona centro");
			tree.addNewUser("3-zona centro");
			tree.addNewUser("User 5");
			tree.addNewUser("User 12");
			tree.addNewUser("User 13");
			tree.addNewUser("User 14");
			tree.search("User 3").changeState();
			peanut = new Peanut(this, this, tree.getRoot());
			peanut.paintTree(tree.getRoot());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case ADDCOMPANY:
			addCompany();
			break;
		case ADDUSER:
			addUser();
			break;
		case ADDZONE:
			addZone();
			break;
		case BALANCE:
			balanceTree();
			break;
		case UNABLE:
			disableUsers();
			break;
		case CALL_USER:
			callUser();
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		peanut.showMenu(e);
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

	private void addZone() {
		String nameCompany = JOptionPane.showInputDialog(INPUT_COMPANY2);
		String nameZone = JOptionPane.showInputDialog(INPUT_ZONE);
		tree.addNewZone(nameCompany, nameZone);
		peanut.paintTree(tree.getRoot());
	}

	public void addCompany() {
		String name = JOptionPane.showInputDialog(INPUT_COMPANY);
		tree.addNewCompany(name);
		peanut.paintTree(tree.getRoot());
	}

	private void addUser() {
		String nameZone = JOptionPane.showInputDialog(INPUT_ZONE2);
		tree.addNewUser(nameZone);
		peanut.paintTree(tree.getRoot());
	}

	private void balanceTree() {
		String nameCompany = JOptionPane.showInputDialog(INPUT_COMPANY3);
		while (tree.checkZones(nameCompany) == false) {
			tree.balance(nameCompany);
		}
		peanut.paintTree(tree.getRoot());
	}

	private void disableUsers() {
		String zone = JOptionPane.showInputDialog(INPUT_ZONE3);
		String lvl = JOptionPane.showInputDialog(INPUT_LVL);
		tree.disableUsersInZone(tree.search(zone), 0,Integer.parseInt(lvl));
		peanut.paintTree(tree.getRoot());
	}

	private void callUser() {
		String user = JOptionPane.showInputDialog(INPUT_USER);
		String destiny = JOptionPane.showInputDialog(INPUT_DESTINY);
		double value = 0;
		HashMap<String, Double> list = new HashMap<String, Double>();
		INode auxUser = tree.search(user);
		INode auxDestiny = tree.search(destiny);
		if (auxUser.getState() == true && auxDestiny.getState() == true) {
			while (auxUser != tree.getRoot()) {
				list.put(auxUser.getData(), auxUser.getTax());
				auxUser = tree.searchDad(auxUser);
			} 
			while (auxDestiny != tree.getRoot()) {
				list.put(auxDestiny.getData(), auxDestiny.getTax());
				auxDestiny = tree.searchDad(auxDestiny);
			}
			for (Entry<String, Double> entry : list.entrySet()) {
				tree.search(entry.getKey()).setColor("#b33434");
				value += entry.getValue();
			}
//		list.forEach((k,v) -> System.out.println("key: "+k+" value:"+v));
			peanut.paintTree(tree.getRoot());
			JOptionPane.showMessageDialog(peanut, COSTO + value);
	
		} else {
			JOptionPane.showMessageDialog(peanut, DISABLE);
		}
	}

	public static void main(String[] args) {
		new Control();
	}
}
