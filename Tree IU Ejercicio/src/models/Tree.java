package models;

public class Tree {

	private Node root;

	public void add(Node node) {
		if (root != null) {
			addNode(root, node);
		} else {
			root = node;
		}
	}

	private void addNode(Node base, Node node) {
		if (node.getData() < base.getData()) {
			if (base.getLeft() != null) {
				addNode(base.getLeft(), node);
			} else {
				base.setLeft(node);
			}
		} else {
			if (base.getRight() != null) {
				addNode(base.getRight(), node);
			} else {
				base.setRight(node);
			}
		}
	}

	public void printPreOrder() {
		printPreOrder(root);
	}

	private void printPreOrder(Node node) {
		if (node != null) {
			System.out.println(node);
			printPreOrder(node.getLeft());
			printPreOrder(node.getRight());
		}
	}

	public void printPosOrder() {
		printPosOrder(root);
	}

	public void printInOrder() {
		printInOrder(root);
	}

	private void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.getLeft());
			System.out.println(node);
			printInOrder(node.getRight());
		}
	}

	private void printPosOrder(Node node) {
		if (node != null) {
			printPreOrder(node.getLeft());
			printPreOrder(node.getRight());
			System.out.println(node);
		}
	}

	public boolean search(Node actual, int information, int finded) {
		if (actual == null) {
			return false;
		}
		actual.setFinded(finded);
		if (actual.getData() == information) {
			System.out.println("es el dato");
			return true;
		} else if (actual.getData() > information) {
			System.out.println("el dato " + information + " es menor que " + actual.getData());
			return search(actual.getLeft(), information, finded);
		} else {
			System.out.println("el dato " + information + " es mayor que " + actual.getData());
			return search(actual.getRight(), information, finded);
		}
	}

	public void delete(int data) {
		delete(null, root, data);
	}

	private void delete(Node father, Node actual, int data) {
		System.out.println("--Nueva busqueda--");
		if (data == actual.getData()) {
			System.out.println("Encontrado");
			Node remplacement = actual;
			int baseData = actual.getData();
			if (actual.isLeaf()) {
				System.out.println("Hoja");
				if (data < father.getData()) {
					father.setLeft(null);
				} else {
					father.setRight(null);
				}
			} else if (actual.isFull()) {
				System.out.println("Dos hijos");
				int right = getMin(actual.getRight()).getData();
				int left = getMax(actual.getLeft()).getData();
				if (Math.abs(right - baseData) < Math.abs(left - baseData)) {
					delete(right);
					actual.setData(right);
				} else {
					delete(left);
					actual.setData(left);
				}
				remplacement = actual;
			} else {
				System.out.println("Un hijo");
				if (actual.getLeft() != null) {
					actual.setData(actual.getLeft().getData());
					actual.setLeft(null);
				} else {
					actual.setData(actual.getRight().getData());
					actual.setRight(null);
				}
				remplacement = actual;
			}
			if (baseData == root.getData()) {
				root = remplacement;
			}
		} else if (data < actual.getData()) {
			System.out.println("Izq");
			delete(actual, actual.getLeft(), data);
		} else {
			System.out.println("Der");
			delete(actual, actual.getRight(), data);
		}
	}

	public int count() {
		return count(root);
	}

	private int count(Node actual) {
		if (actual == null) {
			return 0;
		} else {
			return count(actual.getLeft()) + 1 + count(actual.getRight());
		}
	}

	public int getLevelByRight(Node actual) {
		int count = 0;
		while (actual.getRight() != null) {
			actual = actual.getRight();
			count++;
		}
		return count;
	}

	public int getLevelByLeft(Node actual) {
		int count = 0;
		while (actual.getLeft() != null) {
			actual = actual.getLeft();
			count++;
		}
		return count;
	}

	public Node getMin(Node actual) {
		while (actual.getLeft() != null) {
			actual = actual.getLeft();
		}
		return actual;
	}

	public Node getMax(Node actual) {
		while (actual.getRight() != null) {
			actual = actual.getRight();
		}
		return actual;
	}

	public void cleanFinded(Node node) {
		if (node != null) {
			node.setFinded(0);
			if (node.getLeft() != null) {
				cleanFinded(node.getLeft());
			}
			if (node.getRight() != null) {
				cleanFinded(node.getRight());
			}
		}
	}

	public void calculateFB(Node node) {
		node.setfB(getLevelByLeft(node) - getLevelByRight(node));
		if (node.getLeft() != null) {
			calculateFB(node.getLeft());
		}
		if (node.getRight() != null) {
			calculateFB(node.getRight());
		}
	}

	public Node rotateLeft(Node node) {
		Node auxNode = node.getLeft();
		node.setLeft(auxNode.getRight());
		auxNode.setRight(node);
		node.setfB(Math.max(getFB(node.getLeft()), getFB(node.getRight())) + 1);
		auxNode.setfB(Math.max(getFB(auxNode.getLeft()), getFB(auxNode.getRight())) + 1);
		return auxNode;
	}

	public Node rotateRight(Node node) {
		Node auxNode = node.getRight();
		node.setRight(auxNode.getLeft());
		auxNode.setLeft(node);
		node.setfB(Math.max(getFB(node.getLeft()), getFB(node.getRight())) + 1);
		auxNode.setfB(Math.max(getFB(auxNode.getLeft()), getFB(auxNode.getRight())) + 1);
		return auxNode;
	}

	public Node rotateRightLeft(Node node) {
		Node auxNode = null;
		node.setLeft(rotateRight(node.getLeft()));
		auxNode = rotateLeft(node);
		return auxNode;
	}

	public Node rotateLeftRight(Node node) {
		Node auxNode = null;
		node.setRight(rotateLeft(node.getRight()));
		auxNode = rotateRight(node);
		return auxNode;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public Node getRoot() {
		return root;
	}

	private Node addNodeBalanced(Node node, Node base) {
		if (node.getData() < base.getData()) {
			if (base.getLeft() == null) {
				base.setLeft(node);
			} else {
				base.setLeft(addNodeBalanced(node, base.getLeft()));
				if (getFB(base.getLeft()) - getFB(base.getRight()) == 2) {
					if (node.getData() < base.getLeft().getData()) {
						base = rotateLeft(base);
					} else {
						base = rotateRightLeft(base);
					}
				}
			}
		} else if (node.getData() > base.getData()) {
			if (base.getRight() == null) {
				base.setRight(node);
			} else {
				base.setRight(addNodeBalanced(node, base.getRight()));
				if (getFB(base.getRight()) - getFB(base.getLeft()) == 2) {
					if (node.getData() > base.getRight().getData()) {
						base = rotateRight(base);
					} else {
						base = rotateLeftRight(base);
					}
				}
			}
		}
		if (base.getLeft() == null && base.getRight() != null) {
			base.setfB(getFB(base.getRight()) + 1);
		} else if (base.getRight() == null && base.getLeft() != null) {
			base.setfB(getFB(base.getLeft()) + 1);
		} else {
			base.setfB(Math.max(getFB(base.getLeft()), getFB(base.getRight())) + 1);
		}
		root = base;
		return root;
	}

	public void addNodeBalanced(Node node) {
		if (root == null) {
			root = node;
		} else {
			addNodeBalanced(node, root);
		}
	}

	public int getFB(Node node) {
		if (node == null) {
			return -1;
		} else {
			return node.getfB();
		}
	}

//	public static void main(String[] args) throws Exception {
//		Tree t = new Tree();
//		t.add(new Node(10));
//		t.add(new Node(12));
//		t.add(new Node(5));
//		t.add(new Node(6));
//		t.add(new Node(3));
//		System.out.println(t.search(t.getRoot(), 3, 1));
//		t.printInOrder();
//		System.out.println("------------------------------------");
//		t.cleanFinded(t.getRoot());
//		t.printInOrder();
//		System.out.println(t.count());
//		t.calculateFB(t.root);
//		t.addNodeBalanced(new Node(10));
//		t.addNodeBalanced(new Node(5));
//		t.addNodeBalanced(new Node(13));
//		t.addNodeBalanced(new Node(1));
//		t.addNodeBalanced(new Node(6));
//		t.addNodeBalanced(new Node(17));
//		t.printInOrder();
//		t = null;
//	}
}