package Dades.Llistes;

import java.util.*;
import Exceptions.*;

public class LlistaDinamica<T extends Comparable<T>> implements Iterable<T>, TADLlistaGenerica<T> {
	
	private Node<T> elem;
	private static int numElems=0;
	
	
	public LlistaDinamica() {
		elem=null;
	}

	public void afegirElement(T p) throws LlistaPlena {
		Node<T> nou=new Node<T>(p, null, null);
		if(numElems==0) {
			elem=nou;
		}
		else {
			nou.setAnterior(elem);
			elem.setSeguent(nou);
			elem=nou;
		}
		numElems++;
	}

	/**
	 * @return the primer
	 */
	public Node<T> getElem() {
		return elem;
	}

	/**
	 * @param primer the primer to set
	 */
	public void setElem(Node<T> elem) {
		this.elem = elem;
	}

	/**
	 * @return the numElem
	 */
	public int numElems() {
		return numElems;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LlistaDinamica [elem=" + elem + "]";
	}

	@Override
	public T consultarPosicio(int num) throws LlistaBuida {
		Node<T> aux;
		aux=elem;
		if(num==numElems-1) return aux.getX();
		else {
			for(int i=numElems-1; i>num; i--){
			aux=aux.getAnterior();
			}
		return aux.getX();	
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new MeuIterator<T>(this, 2);
	}
	
	
}
