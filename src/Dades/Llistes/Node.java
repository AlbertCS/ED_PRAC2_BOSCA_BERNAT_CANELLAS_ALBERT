package Dades.Llistes;

/**
 * @author Bernat Bosca Candel
 * 		   Albert Cañellas Sole
 * 
 *
 */
public class Node<T extends Comparable<T>> {
	
	private T x;
	private Node<T> seguent;
	private Node<T> anterior;
	
	/**
	 * Constructor de la class Node
	 * @param element element guardat en el node actual 
	 * @param seguent referencia al seguent element
	 */
	public Node(T element, Node<T> seguent, Node<T> anterior) {
		x=element;
		this.seguent=seguent;
		this.anterior=anterior;
	}

	/**
	 * Getter de l'element
	 * @return x
	 */
	public T getX() {
		return x;
	}

	/**
	 * Setter de l'element
	 * @param x element
	 */
	public void setX(T x) {
		this.x = x;
	}

	/**
	 * Metode que retorna una referencia del seguent Node
	 * @return seguent
	 */
	public Node<T> getSeguent() {
		return seguent;
	}
	
	/**
	 * Metode que retorna una referencia del anterior Node
	 * @return anterior
	 */
	public Node<T> getAnterior() {
		return anterior;
	}

	/**
	 * Setter de la referencia del seguent element
	 * @param seguent element seguent
	 */
	public void setSeguent(Node<T> seguent) {
		this.seguent = seguent;
	}
	
	/**
	 * Setter de la referencia del anterior element
	 * @param anterior element anterior
	 */
	public void setAnterior(Node<T> anterior) {
		this.anterior = anterior;
	}
	
}
