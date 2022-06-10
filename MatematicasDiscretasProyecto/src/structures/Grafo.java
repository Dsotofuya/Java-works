package structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class Grafo<T> {

	public int[][] grafoMatriz;
	public Place<T>[] nodeList;
	private Comparator compare;

	public Grafo(Comparator compare) {
		grafoMatriz = new int[0][0];
		nodeList = new Place[1];
		this.compare = compare;
	}

	public void route(Place<T> u, Place<T> v) {
		int positionU = positionOf(u);
		int positionV = positionOf(v);
		if (positionU != 0 && positionV != 0)
			grafoMatriz[positionU][positionV] = 1;
	}

	public Place<T>[] getNodeList(){
		return this.nodeList;
	}

	public String printMatrix() {
		String str = "";
		for (int i = 0; i < grafoMatriz.length; i++) {
			for (int j = 0; j < grafoMatriz.length; j++) {
				str += grafoMatriz[i][j];
			}
			str += "\n";
		}
		return str;
	}
	
	public boolean isDirect(){
		boolean directed = false;
		for (int i = 0; i < grafoMatriz.length; i++) {
			for (int j = 0; j < grafoMatriz.length; j++) {
				if(grafoMatriz[i][j] == grafoMatriz[j][i])
				directed = true;
			}
		}
		return directed;
	}

	public void route(Place<T> u, Place<T> v, int w) {
		int positionU = positionOf(u);
		int positionV = positionOf(v);
		if (positionU != 0 && positionV != 0)
			grafoMatriz[positionU][positionV] = w;
	}

	public void deleteRoute(Place<T> u, Place<T> v) {
		int positionU = positionOf(u);
		int positionV = positionOf(v);
		if (positionU != 0 && positionV != 0)
			grafoMatriz[positionU][positionV] = 0;
	}

	public boolean adyacente(Place<T> u, Place<T> v) {
		return grafoMatriz[positionOf(u)][positionOf(v)] != 0;
	}

	public void newPlace(Place<T> u) {
		Place<T>[] nodeList2 = new Place[nodeList.length + 1];
		for (int i = 0; i < nodeList.length; i++) {
			nodeList2[i] = nodeList[i];
		}
		nodeList2[nodeList.length] = u;
		nodeList = nodeList2;
		resizeMatrix();
	}

	public void deletePlace(Place<T> u) {
		int position = positionOf(u);
		nodeList[position] = null;
		for (int i = 0; i < grafoMatriz.length; i++) {
			grafoMatriz[position][i] = 0;
			grafoMatriz[i][position] = 0;
		}
	}

	private void resizeMatrix() {
		int[][] matrix2 = new int[nodeList.length][nodeList.length];
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2.length; j++) {
				try {
					matrix2[i][j] = grafoMatriz[i][j];
				} catch (Exception NullPointerException) {
					matrix2[i][j] = 0;
				}
			}
		}
		grafoMatriz = matrix2;
	}

	public int positionOf(Place<T> u) {
		int position = 1;
		boolean found = false;
		for (Place<T> node : nodeList) {
			try {
				if (compare.compare(node.getData(), u.getData()) != 0 && !found)
					position++;
				else
					found = true;
			} catch (Exception nullPoException) {
			}
		}
		if (position > nodeList.length)
			position = 0;
		return position;
	}

	public String iterateWidth(Place<T> u) {
		Queue<T> queu = new Queue<T>(compare);
		ArrayList<T> marc = new ArrayList<T>();
		queu.push(u.getData());
		String str = "";
		str = iterate(queu, marc, str);
		return str;
	}

	public String iterate(Queue<T> queu, ArrayList<T> marc, String str) {
		T vertice = queu.peek();
		str += "\n" + vertice;
		int position = positionOf(new Place<T>(vertice));
		marc.add(vertice);
		queu.poll();
		for (int i = 0; i < grafoMatriz.length; i++) {
			if (grafoMatriz[i][position] != 0)
				if (!marc.contains(nodeList[i].getData())) {
					marc.add(nodeList[i].getData());
					queu.push(nodeList[i].getData());
				}
		}
		if (!queu.isEmpty()) {
			str = iterate(queu, marc, str);
		}
		return str;
	}

	public String calculateShortestRoad(Place<T> start, Place<T> destiny) {
		String str = "";
		if (!adyacente(start, destiny)) {
			HashMap<Integer, String> nodesStep = new HashMap<Integer, String>();
			int positionStart = positionOf(start);
			nodesStep.put(positionStart, 0 + "");
			ArrayList<Place<T>> marc = new ArrayList<Place<T>>();
			marc.add(start);
			@SuppressWarnings("unchecked")
			Queue<Place<T>> orderNodes = new Queue<Place<T>>(compare);
			orderNodes.push(start);
			calculatePlaces(orderNodes, nodesStep, marc);
			int num = positionOf(destiny);
			int distance = getFactor(nodesStep.get(num));
			str = nodeList[num].getData()+ str;
			num = getPosition(nodesStep.get(num));
			do {
				str = nodeList[num].getData() + " - " + str;
				num = getPosition(nodesStep.get(num));
			} while (num != positionStart);
			str = nodeList[num].getData() + " - " + str;
			str = "camino : " + str;
			str += "\n"+String.format("el tiempo de vuelo mas corto de  %1$s a %2$s",start.getData(),destiny.getData())+ 
			" es: " + distance +" minutos" ;
		}
		else{
		str = "camino directo ";
		str += "\n"+String.format("el tiempo de vuelo mas corto de  %1$s a %2$s",start.getData(),destiny.getData())+ 
		" es: " + grafoMatriz[positionOf(start)][positionOf(destiny)] +" minutos" ;
	}			
	return str;
	}

	private int getFactor(String value) {
		return Integer.parseInt(value.split(";")[0]);
	}

	private int getPosition(String value) {
		return Integer.parseInt(value.split(";")[1]);
	}

	public void calculatePlaces(Queue<Place<T>> orderNodes, HashMap<Integer, String> nodesStep, ArrayList<Place<T>> marc) {
		Place<T> point = orderNodes.peek();
		orderNodes.poll();
		int pointPosition = positionOf(point);
		ArrayList<String> tempList = new ArrayList<String>();
		for (int i = 0; i < grafoMatriz.length; i++) {
			if (grafoMatriz[i][pointPosition] != 0) {
				if (!marc.contains(nodeList[i])) {
					try {
						int actualFactor = getFactor(nodesStep.get(positionOf(nodeList[i])));
						int tempFactor = grafoMatriz[i][pointPosition] + getFactor(nodesStep.get(pointPosition));
						if (actualFactor > tempFactor) {
							nodesStep.remove(positionOf(nodeList[i]));
							nodesStep.put(positionOf(nodeList[i]), tempFactor + ";" + pointPosition);
						}
					} catch (Exception e) {
						nodesStep.put(positionOf(nodeList[i]), grafoMatriz[i][pointPosition]
								+ getFactor(nodesStep.get(pointPosition)) + ";" + pointPosition);
					}
					tempList.add(nodesStep.get(positionOf(nodeList[i])));
				}
			}
		}
		putList(tempList, marc, orderNodes, nodesStep);
		if (!orderNodes.isEmpty())
			calculatePlaces(orderNodes, nodesStep, marc);
	}

	private void putList(ArrayList<String> tempList, ArrayList<Place<T>> marc, Queue<Place<T>> orderNodes,
			HashMap<Integer, String> nodesStep) {
		try {
			tempList.sort(new SortComparator());
			Set<Integer> kSet = nodesStep.keySet();
			for (String str : tempList) {
				for (Integer integer : kSet) {
					if (str.compareTo(nodesStep.get(integer)) == 0)
						orderNodes.push(nodeList[integer]);
				}
			}
			for (Integer integer : kSet) {
				if (tempList.get(0).compareTo(nodesStep.get(integer)) == 0)
					marc.add(nodeList[integer]);
			}
		} catch (Exception e) {
		}
	}
}
