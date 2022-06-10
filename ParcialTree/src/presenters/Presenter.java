package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import models.Tree;
import views.MyJFrameContainer;

public class Presenter implements ActionListener, TreeSelectionListener {

	private MyJFrameContainer container;
	private Tree tree;

	public Presenter() {
		tree = new Tree();
		tree.addEmpresa("Claro");
		tree.addZona("zona 1", "Claro");
		tree.addUser("Jose", "zona 1");
		tree.addUser("Jose", "zona 1");
		tree.addUser("Jose", "zona 1");
		tree.addUser("Jose", "zona 1");
		tree.addEmpresa("Claroajy");
		tree.addZona("zona 2", "Claroajy");
		tree.addUser("Joe", "zona 2");
		tree.addUser("Joe", "zona 2");
		tree.addUser("Joe", "zona 2");
		tree.addUser("Joe", "zona 2");
		tree.addEmpresa("Clar");
		tree.addZona("zona 3", "Clar");
		tree.addUser("Jo", "zona 3");
		tree.addUser("Jo", "zona 3");
		tree.addUser("Jo", "zona 3");
		tree.addUser("Jo", "zona 3");
		tree.addUser("Jo", "zona 3");
		tree.addUser("Jo", "zona 3");
		tree.addUser("Jo", "zona 3");
		tree.addUser("Jo", "zona 3");
		container = new MyJFrameContainer(this);
		container.paintTree(tree.getRoot());
		container.setVisible(true);
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case ADD:
			tree.addEmpresa(JOptionPane.showInputDialog("Nombre de la empresa"));
			container.paintTree(tree.getRoot());
			break;
		case ADD_ZONA:
			tree.addZona(JOptionPane.showInputDialog("Nombre de la zona"),
					JOptionPane.showInputDialog("Nombre de la empresa"));
			container.paintTree(tree.getRoot());
			break;
		case ADD_USER:
			tree.addUser(JOptionPane.showInputDialog("Nombre del usuario"),
					JOptionPane.showInputDialog("Nombre de la zona"));
			container.paintTree(tree.getRoot());
			break;
		case VALIDATE:
			tree.orgZona();
			container.paintTree(tree.getRoot());
			break;
		}
	}

}
