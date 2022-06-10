package model;

import model.postalTree.TreePostal;
import model.userTree.ANode;
import model.userTree.State;
import model.userTree.TreeUser;

public class UserManager {

	private TreeUser users;
	private TreePostal postals;

	public UserManager() {
		postals = new TreePostal();
		users = new TreeUser();
	}

	public boolean addUser(String name, String password) {
		if (users.search(name) == null) {
			users.addUser(name, password);
			return true;
		} else {
			return false;
		}
	}

	public boolean login(String name, String password) {
		ANode user = users.search(name);
		if (user != null && user.getData().equalsIgnoreCase(password)) {
			return true;
		} else {
			return false;
		}
	}

	public TreeUser getUsers() {
		return users;
	}

	public TreePostal getTreeGeneral() {
		return postals;
	}

	public TreePostal listArchives(String user) {
		ANode userNode = users.search(user);
		TreePostal aux = getTreeGeneral();
		for (ANode userFolders : userNode.getChildren()) {
			switch (State.valueOf(userFolders.getName().toString())) {
			case CREATE:
				for (ANode archive : userFolders.getChildren()) {
					aux.search(archive.getName()).setState(model.postalTree.State.CREATE);
				}
				break;
			case EDIT:
				for (ANode archive : userFolders.getChildren()) {
					aux.search(archive.getName()).setState(model.postalTree.State.EDIT);
				}
				break;
			case VIEW:
				for (ANode archive : userFolders.getChildren()) {
					aux.search(archive.getName()).setState(model.postalTree.State.VIEW);
				}
				break;
			case ALL:
				for (ANode archive : userFolders.getChildren()) {
					aux.search(archive.getName()).setState(model.postalTree.State.ALL);
				}
				break;
			default:
				break;
			}
		}
		return aux;
	}

	public void concedePrivilege(String user, String archive, State privilege) {
		switch (State.valueOf(privilege.toString())) {
		case CREATE:
			users.search(user).getChildren().get(0).add(archive, "");
			break;
		case EDIT:
			users.search(user).getChildren().get(1).add(archive, "");
			break;
		case VIEW:
			users.search(user).getChildren().get(2).add(archive, "");
			break;
		case ALL:
			users.search(user).getChildren().get(3).add(archive, "");
			break;
		default:
			break;
		}
	}
}
