package Dades;

import java.util.*;
import Exceptions.*;

public class LlistaDinamica<T extends Comparable<T>> implements Iterable<T>, TADLlistaGenerica<T> {
	
	private Node<T> primer;
	private static int numElem=0;
	
	
	public LlistaDinamica() {
		primer=null;
	}

	public void afegirElement(T p) throws LlistaPlena {
		Node<T> nou=new Node<T>(p, null, null);
		if(numElem==0) {
			primer=nou;
		}
		else {
			nou.setSeguent(primer);
			primer.setAnterior(nou);
			primer=nou;
		}
		numElem++;
	}

	/**
	 * @return the primer
	 */
	public Node<T> getPrimer() {
		return primer;
	}

	/**
	 * @param primer the primer to set
	 */
	public void setPrimer(Node<T> primer) {
		this.primer = primer;
	}

	/**
	 * @return the numElem
	 */
	public static int getNumElem() {
		return numElem;
	}

	/**
	 * @param numElem the numElem to set
	 */
	public static void setNumElem(int numElem) {
		LlistaDinamica.numElem = numElem;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LlistaDinamica [primer=" + primer + "]";
	}

	@Override
	public T consultarPosicio(int num) throws LlistaBuida {
		Node<T> aux;
		aux=primer;
		if(num==0) return aux.getX();
		else {
			for(int i=0; i<num; i++){
			aux=aux.getSeguent();
			}
		return aux.getX();	
		}
	}

	@Override
	public int numElems() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new MeuIterator<T>(this, 1);
	}
	
	
}
