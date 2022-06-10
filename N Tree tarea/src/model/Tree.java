package model;

public class Tree {

	private static final String TOURNAMENT = "Tournament";

	private Node root;
	private static int count = 1;

	public Tree() {
		root = new Node(TOURNAMENT);
	}

	public void add(Node child) {
		if (root.getChildren().isEmpty() == true) {
			addNewTeam(child);
		} else {
			for (Node team : root.getChildren()) {
				if (team.getChildren().size() < 3) {
					team.addChild(child);
				} else {
					addNewTeam(child);
				}
			}
		}

	}
	
	public void validateTeams() {
		Node def = new Node("DefaultTeam");
		root.addChild(def);
		for (int i = 0; i < root.getChildren().size(); i++) {
			if (root.getChildren().get(i).getChildren().size() < 3) {
//				def.addChild(root.getChildren().get(i).getChildren());
			}
		}
	}

	private void addNewTeam(Node child) {
		Node team = new Node(String.valueOf("Equipo " + count++));
		root.addChild(team);
		team.addChild(child);
	}

	public void print() {
		print(root, "");
	}

	private void print(Node node, String level) {
		level += "  ";
		System.out.println(level + node);
		for (Node actual : node.getChildren()) {
			print(actual, level);
		}
	}

	public void delete(String name) {
		for (Node team : root.getChildren()) {
			for (Node player : team.getChildren()) {
				if (player.getData().equalsIgnoreCase(name)) {
					team.removeChild(player);
				}
				if (team.getChildren().size() == 0) {
					root.removeChild(team);
				}
			}
		}
	}

	public void update() {
		update(null, root);
	}

	private void update(Node dad, Node child) {
		if (child.getChildren().isEmpty()) {
			dad.removeChild(child);
		} else {
			for (Node actual : child.getChildren()) {
				update(child, actual);
			}
		}
	}

	public Node getRoot() {
		return root;
	}
}