package network;

import javax.swing.JOptionPane;

public class Tree {
	
	private Node root;
	
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
		String message = JOptionPane.showInputDialog("Mensaje");
		root = new Node(-1, new ICalculate() {
			@Override
			public String getResponse() {
				return "";
			}
		});
		root.addChild(new Node(60, new ICalculate() {
			@Override
			public String getResponse() {
				if (message.contains("free")) {
					return "SPAM";
				}else {
					return "NO_SPAM";
				}
			}
		}));
		root.addChild(new Node(40, new ICalculate() {
			@Override
			public String getResponse() {
				return "NO_SPAM";
			}
		}));
		
		int spam = 0;
		int noSpam = 0;
		
		for (Node actual : root.getChildren()) {
			if (actual.getValue().equals("SPAM")) {
				spam += actual.getWeigth();
			}else if (actual.getValue().equals("NO_SPAM")) {
				noSpam += actual.getWeigth();
			}
		}
		
		if(spam > noSpam) {
			JOptionPane.showMessageDialog(null, "Spam");
		}else{
			JOptionPane.showMessageDialog(null, "No Spam");
		}
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
	}
}