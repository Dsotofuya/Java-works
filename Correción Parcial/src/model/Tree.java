package model;

import java.io.IOException;
import java.util.ArrayList;

public class Tree {

	private static final String GENERIC_ZONE = "Generic zone";
	private static final String SEPARATOR = "-";
	private static final String USER = "User ";
	private static final String TELECOMUNICACIONES = "Telecomunicaciones";
	private static int count = 0;
	private static int countZone = 0;

	private NodeTelecomunicacion root;

	public Tree() throws IOException {
		root = new NodeTelecomunicacion(TELECOMUNICACIONES);
	}

	public INode getRoot() {
		return root;
	}

	public void print() {
		print(root, "");
	}

	private void print(INode node, String level) {
		level += "  ";
		System.out.println(level + node);
		for (INode actual : ((NodeCompany) node).getChilds()) {
			print(actual, level);
		}
	}

	public INode search(String id) {
		if (root.getData().equals(id)) {
			return root;
		}
		return search(root, id);
	}

	private INode search(INode node, String name) {
		if (!node.getChildren().isEmpty()) {
			for (INode actual : node.getChildren()) {
				if (actual.getData().equalsIgnoreCase(name)) {
					return actual;
				} else {
					INode search = search(actual, name);
					if (search != null) {
						return search;
					}
				}
			}
		}
		return null;
	}

	public INode searchDad(INode node) {
		for (int i = 0; i < root.getChilds().size(); i++) {
			if (root.search(node.getData())) {
				return root;
			}
		}
		return searchDad(root, node);
	}

	private INode searchDad(INode node, INode nodeChild) {
		if (!node.getChildren().isEmpty()) {
			for (INode actual : node.getChildren()) {
				if (actual.search(nodeChild.getData())) {
					return actual;
				} else {
					INode search = searchDad(actual, nodeChild);
					if (search != null) {
						return search;
					}
				}
			}
		}
		return null;
	}

	public void addNewCompany(String child) {
		root.add(child);
	}

	public void addNewZone(String company, String child) {
		search(company).add(++countZone + SEPARATOR + child);
	}

	public void addNewUser(String zone) {
		search(zone).add(USER + ++count);
	}

	public void delete(String name) {
		for (INode team : root.getChildren()) {
			for (INode player : team.getChildren()) {
				if (player.getData().equalsIgnoreCase(name)) {
					team.removeChild(player);
				}
				if (team.getChildren().size() == 0) {
					root.removeChild(team);
				}
			}
		}
	}

	public ArrayList<INode> path(INode node) {
		ArrayList<INode> path = new ArrayList<INode>();
		while (node != root) {
			node = searchDad(node);
			path.add(node);
		}

		return path;
	}

	public void balance(String nameCompany) {
		ArrayList<String> users = new ArrayList<String>();
		INode company = search(nameCompany);
		for (INode zone : company.getChildren()) {
			if (zone.getChildren().size() > 3) {
				for (int i = 3; i < zone.getChildren().size(); i++) {
					users.add(zone.getChildren().get(i).getData());
					zone.removeChild(zone.getChildren().get(i));
				}
			} else if (zone.getChildren().size() < 3) {
				zone.add(users.get(0));
				users.remove(0);
			}
		}
		if (users.isEmpty() == false) {
			addNewZone(nameCompany, GENERIC_ZONE);
			INode node = search(countZone + SEPARATOR + GENERIC_ZONE);
			while (users.isEmpty() == false) {
				node.add(users.get(0));
				users.remove(0);
			}
		}
	}

	public boolean checkZones(String companyName) {
		INode company = search(companyName);
		for (INode zone : company.getChildren()) {
			if (zone.getChildren().size() > 3) {
				return false;
			}
		}
		return true;
	}

	public int disableUsersInZone(INode zone, int count, int lvlWished) {
		int lvl = count+1;
		if (lvl <= lvlWished) {
			disableUsers(zone);
			for (INode user : zone.getChildren()) {
				if (user.getChildren().isEmpty() == false) {
					disableUsersInZone(user, lvl, lvlWished);
				}
			}
		}
		return lvl;
	}

	public void disableUsers(INode zone) {
		for (INode user : zone.getChildren()) {
			user.changeState();
		}
	}

}