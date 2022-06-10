package classifier;

import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

public class Tree {
	
	private Node root;
	private String [][] data;
	
	public void print() {
		print(root, "");
	}
	
	private void print(Node node, String level) {
		System.out.println(level + node);
		level += "  "; 
		for (Node actual : node.getChildren()) {
			print(actual, level);
		}
	}

	public Tree() {
		root = new Node("Sistema");
		data = new String[6][4];
					
		data[0][0] = "Genero";
		data[0][1] = "Edad";
		data[0][2] = "Azucar";
		data[0][3] = "Seguro";
					
		data[1][0] = "M";
		data[1][1] = "10-45";
		data[1][2] = "Alto";
		data[1][3] = "Si";
					
		data[2][0] = "H";
		data[2][1] = "10-45";
		data[2][2] = "Bajo";
		data[2][3] = "No";
					
		data[3][0] = "M";
		data[3][1] = "46-80";
		data[3][2] = "Alto";
		data[3][3] = "No";
				
		data[4][0] = "H";
		data[4][1] = "10-45";
		data[4][2] = "Medio";
		data[4][3] = "Si";
		
		data[5][0] = "M";
		data[5][1] = "46-80";
		data[5][2] = "Alto";
		data[5][3] = "No";
		
		addToLastLevel(getCategoricalLevel(0));
		addToLastLevel(getCategoricalLevel(1));
		addToLastLevel(getCategoricalLevel(2));
		
		for (int i = 0; i < data.length - 1; i++) {
			addLabel(data[i]);
		}
		
		start();
	}
	
	public void addLabel(String[] data) {
		addLabel(root, data, 0);
	}
	
	private void addLabel(Node base, String[] data, int count) {
		if(count == data.length - 1) {
			base.addChild(new Node(data[count]));
		}
		for (Node actual : base.getChildren()) {
			if (actual.getLabel().equals(data[count])) {
				addLabel(actual, data, ++count);
				break;
			}
		}
	}

	public HashSet<String> getCategoricalLevel(int col){
		HashSet<String> elements = new HashSet<>();
		for (int i = 1; i < data.length; i++) {
			elements.add(data[i][col]);
		}
		return elements;
	}
	
	public void addToLastLevel(HashSet<String> categories) {
		addToLastLevel(root, categories);
	}
	
	private void addToLastLevel(Node actual, HashSet<String> categories) {
		if(actual.getChildren().size() == 0) {
			for (String category : categories) {
				actual.addChild(new Node(category));
			}
		}else {
			for (Node next : actual.getChildren()) {
				addToLastLevel(next, categories);
			}
		}
	}
	
	public void start() {
		start(root);
	}

	private void start(Node base) {
		int option = JOptionPane.showOptionDialog(null, "Elija una:",
				"Pregunta", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null,
				base.getChildren().toArray(), 
				base.getChildren().get(0).toString());
		start(base.getChildren().get(option));
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.print();
	}
}