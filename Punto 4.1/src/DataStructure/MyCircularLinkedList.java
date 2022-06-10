package DataStructure;


public class MyCircularLinkedList <T>{
	private Node<T> head;
	private Node<T> finish;
	private long contAdd;
	
	public MyCircularLinkedList() {
		this.contAdd = 0;
		this.finish = null;
		this.head = null;
		
	}
		public void add(T data){
	        // Define un nuevo nodo
	        Node<T> nuevo = new Node<T>(data);
	       
	        if (this.isEmpty()) {
	            // Inicializa la lista agregando como inicio al nuevo nodo.
	            this.head = nuevo;
	            // De igual forma el ultimo nodo sera el nuevo.
	            this.finish = nuevo;
	            // Y el puntero del ultimo debe apuntar al primero.
	            this.finish.setNext(this.head);
	           
	      
            }else{
	            // Apuntamos con el ultimo nodo de la lista al nuevo.
	            this.finish.setNext(nuevo);
	            // Apuntamos con el nuevo nodo al inicio de la lista.
	            nuevo.setNext(this.head);
	            // Como ahora como el nuevo nodo es el ultimo se actualiza
	            // la variable ultimo.
	            this.finish = nuevo;
	        }
	        // Incrementa el contador de tamaño de la lista
	        this.contAdd ++;
	        
	    }
		
		public T getLast(){
			return this.finish.getData();
		}
		
		 public void agregarAlInicio(T data){
		        // Define un nuevo nodo.
		        Node<T> nuevo = new Node<T>();
		        // Agrega al valor al nodo.
		        nuevo.setData(data);
		        // Consulta si la lista esta vacia.
		        if (isEmpty()) {
		            // Inicializa la lista agregando como inicio al nuevo nodo.
		            this.head = nuevo;
		            // De igual forma el ultimo nodo sera el nuevo.
		            this.finish = nuevo;  
		            // Y el puntero del ultimo debe apuntar al primero.
		            this.finish.setNext(this.head);
		        // Caso contrario va agregando los nodos al inicio de la lista.
		        } else{
		            // Une el nuevo nodo con la lista existente.
		            nuevo.setNext(this.head);
		            // Renombra al nuevo nodo como el inicio de la lista.
		            this.head = nuevo;
		            // El puntero del ultimo debe apuntar al primero.
		            this.finish.setNext(this.head);
		        }
		        // Incrementa el contador de tamaño de la lista.
		        contAdd++;
		    }
		
		 
		 public void addAtReferencePos(T valorLast,T valor){
		        // Define un nuevo nodo.
		        Node<T> nuevo = new Node<T>();
		        // Agrega al valor al nodo.
		        nuevo.setData(valor);
		        // Verifica si la lista contiene elementos
		        if (!isEmpty()) {
		            // Consulta si el valor existe en la lista.
		            if (this.search(valorLast)) {
		                // Crea ua copia de la lista.
		                Node<T> aux = this.head;
		                // Recorre la lista hasta llegar al nodo de referencia.
		                while (aux.getData() != valorLast) {
		                    aux = aux.getNext();
		                }
		                // Consulta si el nodo a insertar va despues del ultimo
		                if (aux == this.finish) {
		                    // Apuntamos con el ultimo nodo de la lista al nuevo.
		                    aux.setNext(nuevo);
		                    // Apuntamos con el nuevo nodo al inicio de la lista.
		                    nuevo.setNext(this.head);
		                    // Como ahora como el nuevo nodo es el ultimo se actualiza
		                    // la variable ultimo.
		                    this.finish = nuevo;
		                } else {
		                    // Crea un respaldo de la continuación de la lista.
		                    Node<T> siguiente = aux.getNext();
		                    // Enlaza el nuevo nodo despues del nodo de referencia.
		                    aux.setNext(nuevo);
		                    // Une la continuacion de la lista al nuevo nodo.
		                    nuevo.setNext(siguiente);
		                }
		                // Incrementa el contador de tamaño de la lista.
		                this.contAdd++;
		            }
		        }      
		    }
		 
		 public boolean search(T data){
		        // Crea una copia de la lista.
		        Node<T> aux = this.head;
		        // Bandera para indicar si el valor existe.
		        boolean encontrado = false;
		        // Recorre la lista hasta encontrar el elemento o hasta 
		        // llegar al primer nodo nuevamente.
		        do{
		            // Consulta si el valor del nodo es igual al de referencia.
		            if (data == aux.getData()){
		                // Canbia el valor de la bandera.
		                encontrado = true;
		            }
		            else{
		                // Avansa al siguiente. nodo.
		                aux = aux.getNext();
		            }
		        }while(aux != this.head && encontrado != true);
		        // Retorna el resultado de la bandera.
		        return encontrado;
		    }
		 
		 
		 public void addAtPos(long pos, T data){
		        // Verifica si la posición ingresada se encuentre en el rango
		        // >= 0 y <= que el numero de elementos del la lista.
		        if(pos >= 0 && pos <= this.contAdd){
		            Node<T> nuevo = new Node<T>();
		            nuevo.setData(data);
		            // Consulta si el nuevo nodo a ingresar va al inicio de la lista.
		            if(pos == 0){
		                // Une el nuevo nodo con la lista existente.
		                nuevo.setNext(this.head);
		                // Renombra al nuevo nodo como el inicio de la lista.
		                this.head = nuevo;
		                // El puntero del ultimo debe apuntar al primero.
		                this.finish.setNext(this.head);
		            }
		            else{
		                // Si el nodo a inserta va al final de la lista.
		                if(pos == this.contAdd){
		                    // Apuntamos con el ultimo nodo de la lista al nuevo.
		                    this.finish.setNext(nuevo);
		                    // Apuntamos con el nuevo nodo al inicio de la lista.
		                    nuevo.setNext(this.head);
		                    // Como ahora como el nuevo nodo es el ultimo se actualiza
		                    // la variable ultimo.
		                    this.finish = nuevo;     
		                }
		                else{
		                    // Si el nodo a insertar va en el medio de la lista.
		                    Node<T> aux = this.head;
		                    // Recorre la lista hasta llegar al nodo anterior
		                    // a la posicion en la cual se insertara el nuevo nodo.
		                    for (int i = 0; i < (pos-1); i++) {
		                        aux = aux.getNext();
		                    }
		                    // Guarda el nodo siguiente al nodo en la posición
		                    // en la cual va a insertar el nevo nodo.
		                    Node<T> siguiente = aux.getNext();
		                    // Inserta el nuevo nodo en la posición indicada.
		                    aux.setNext(nuevo);
		                    // Une el nuevo nodo con el resto de la lista.
		                    nuevo.setNext(siguiente);
		                }
		            }
		            // Incrementa el contador de tamaño de la lista.
		            this.contAdd++;
		        }
		    }
		 
		 
		 public T getDataAtPos(long pos) throws Exception{
		        // Verifica si la posición ingresada se encuentre en el rango
		        // >= 0 y < que el numero de elementos del la lista.
		        if(pos >= 0 && pos < this.contAdd){
		            // Consulta si la posicion es el inicio de la lista.
		            if (pos == 0) {
		                // Retorna el valor del inicio de la lista.
		                return this.head.getData();
		            }else{
		                // Crea una copia de la lista.
		                Node<T> aux = this.head;
		                // Recorre la lista hasta la posición ingresada.
		                for (int i = 0; i < pos; i++) {
		                    aux = aux.getNext();
		                }
		                // Retorna el valor del nodo.
		                return aux.getData();
		            }
		        // Crea una excepción de Posicion inexistente en la lista.
		        } else {
		            throw new Exception("Posicion inexistente en la lista.");
		        }
		    }
		 
		 public Node<T> getNodeAtPos(long pos) throws Exception{
		        // Verifica si la posición ingresada se encuentre en el rango
		        // >= 0 y < que el numero de elementos del la lista.
		        if(pos >= 0 && pos < this.contAdd){
		            // Consulta si la posicion es el inicio de la lista.
		            if (pos == 0) {
		                // Retorna el valor del inicio de la lista.
		                return this.head;
		            }else{
		                // Crea una copia de la lista.
		                Node<T> aux = this.head;
		                // Recorre la lista hasta la posición ingresada.
		                for (int i = 0; i < pos; i++) {
		                    aux = aux.getNext();
		                }
		                // Retorna el valor del nodo.
		                return aux;
		            }
		        // Crea una excepción de Posicion inexistente en la lista.
		        } else {
		            throw new Exception("Posicion inexistente en la lista.");
		        }
		    }
		 
		 public long getPositionNode(T data){
			        // Crea una copia de la lista.
			        Node<T> aux = this.head;
			       long pos = -1;
			       long cont = 0;
			       boolean flag = false;
			       if(aux.getData() == data && aux == this.head){
			    	   pos = 0;
			       }else{
			    	   while(cont <= this.contAdd && flag == false){
			    	  if(aux.getData() == data){
			    		  pos = cont;
			    		  flag = true;
			    	  }
			    	  cont ++;
			    	  aux = aux.getNext();
			      }
			    
			    }
			      return pos;  
			    }
		 
		 
		 public byte removeAtData(T data){
		        // Consulta si el valor de referencia existe en la lista.
			 byte result = -1;
		        if (search(data)) {
		            // Consulta si el nodo a eliminar es el pirmero
		            if (this.head.getData() == data) {
		                // El primer nodo apunta al siguiente.
		                this.head = this.head.getNext();
		                // Apuntamos con el ultimo nodo de la lista al inicio.
		                this.finish.setNext(this.head); 
		                result = 1;
		            } else{
		                // Crea ua copia de la lista.
		                Node<T> aux = this.head;
		                // Recorre la lista hasta llegar al nodo anterior 
		                // al de referencia.
		                while(aux.getNext().getData() != data){
		                    aux = aux.getNext();
		                }
		                if (aux.getNext() == this.finish) {
		                    aux.setNext(this.head);
		                    this.finish = aux;
		                } else {
		                    // Guarda el nodo siguiente del nodo a eliminar.
		                    Node<T> next = aux.getNext();
		                    // Enlaza el nodo anterior al de eliminar con el 
		                    // sguiente despues de el.
		                    aux.setNext(next.getNext());  
		                    result = 1;
		                    // Actualizamos el puntero del ultimo nodo
		                }
		            }
		            // Disminuye el contador de tamaño de la lista.
		            this.contAdd--;
		        }
		        return result;
		    }
		 
		 
		 public byte removeAtPos(int pos){
		        // Verifica si la posición ingresada se encuentre en el rango
		        // >= 0 y < que el numero de elementos del la lista.
			 	byte result = -1;
			 	if(pos > this.size()){
			 	}else if(pos>=0 && pos<this.size()){
		            // Consulta si el nodo a eliminar es el primero
		            if(pos == 0){
		                // Elimina el primer nodo apuntando al siguinte.
		                this.head = this.head.getNext();
		                // Apuntamos con el ultimo nodo de la lista al inicio.
		                this.finish.setNext(this.head);
		                result = 1;
		            }
		            // En caso que el nodo a eliminar este por el medio 
		            // o sea el ultimo
		            else{
		                // Crea una copia de la lista.
		                Node<T> aux = this.head;
		                // Recorre la lista hasta lleger al nodo anterior al eliminar.
		                for (int i = 0; i < pos-1; i++) {
		                    aux = aux.getNext();
		                }
		                if (aux.getNext() == this.finish) {
		                    aux.setNext(this.head);
		                    this.finish = aux;
		                    result =1;
		                } else {
		                    // Guarda el nodo siguiente del nodo a eliminar.
		                    Node<T> next = aux.getNext();
		                    // Enlaza el nodo anterior al de eliminar con el 
		                    // sguiente despues de el.
		                    aux.setNext(next.getNext());  
		                    result = 1;
		                    // Actualizamos el puntero del ultimo nodo
		                }
		            }
		            // Disminuye el contador de tamaño de la lista.
		            this.contAdd-- ; 
		        }
		            return result;
		        }
		 
		 public void emiminateList(){
		        // Elimina el valor y la referencia a los demas nodos.
		        this.head = null;
		        // Elimina el valor y la referencia al primer nodo.
		        this.finish = null;
		        // Reinicia el contador de tamaño de la lista a 0.
		        this.contAdd = 0;
		    }  
		 
		    
	
	public boolean isEmpty(){
		return (this.head == null);
	}
	
	public long size(){
		return this.contAdd;
	}
	
	public long contAdd(){
		return this.contAdd;
	}
	
	
	public void print(){
		Node<T> actual = head;
		for (int i = 0; i < contAdd; i++) {
			System.out.println(actual.getData());
			actual = actual.getNext();
			
		}
	}

	
	
	
}
