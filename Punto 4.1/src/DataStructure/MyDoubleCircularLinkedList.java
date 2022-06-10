package DataStructure;


public class MyDoubleCircularLinkedList <T>{
	private MyDoubleNode<T> head;
	private MyDoubleNode<T> finish;
	private long length;
	
	public MyDoubleCircularLinkedList() {
		this.head = null;
		this.length = 0;
		this.finish = null;
	}
	
	
	public boolean isEmpty(){
		return (this.head == null);
	}
	
	
	public void add(T data){
        // Define un nuevo nodo
        MyDoubleNode<T> nuevo = new MyDoubleNode<T>(data);
        // Agrega al valor al nodo.
        // Consulta si la lista esta vacia.
        if (this.isEmpty()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            this.head = nuevo;
            // De igual forma el ultimo nodo sera el nuevo.
            this.finish = nuevo;
            this.head.setNext(finish);
            this.finish.setPrevious(head);
            // Y el puntero del ultimo debe apuntar al primero.
            this.finish.setNext(this.head);
           
        // Caso contrario el nodo se agrega al final de la lista.
        }else{
            // Apuntamos con el ultimo nodo de la lista al nuevo.
        	
            this.finish.setNext(nuevo);
            // Apuntamos con el nuevo nodo al inicio de la lista.
            nuevo.setNext(this.head);
            // Como ahora como el nuevo nodo es el ultimo se actualiza
            // la variable ultimo.
            nuevo.setPrevious(head);
            this.finish = nuevo;
            this.head.setPrevious(finish);
            
        }
        // Incrementa el contador de tamaño de la lista
        this.length ++;
        
    }
	
	
	
	
	public void print(){
		MyDoubleNode<T> actual = head;
		for (int i = 0; i < this.length; i++) {
			System.out.println(actual.getElement());
			actual = actual.getNext();
			
		}
	}
	
	public long size(){
		return this.length;
	}
	
	

}
