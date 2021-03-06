package Dades.Llistes;

import java.util.Arrays;
import java.util.Iterator;

import Exceptions.*;

/**
 * @author Bernat Bosca Candel
 * 		   Albert Ca�ellas Sole
 * 
 * @param <T> Tipus d'element
 * 
 */
public class LlistaEstatica<T extends Comparable<T>> implements Iterable<T>, TADLlistaGenerica<T> {
	private T[] llista;
	private int numElems;
	
	/**
	 * Constructor de la classe
	 *
	 * @param dim dimenci� inicial de la llista
	 */
	@SuppressWarnings("unchecked")
	public LlistaEstatica(int dim) {
		llista=(T[])new Comparable[dim];
		numElems=0;
	}

	/**
	 * Metode que afegeix un element+
	 * @param p element a afegir
	 */
	@SuppressWarnings("unchecked")
	public void afegirElement(T p) throws LlistaPlena {
		if (numElems>=llista.length) {
			// amplio
			T[] nova=(T[]) new Comparable[llista.length*2];
			for (int i=0; i<llista.length; i++) nova[i]=llista[i];
			llista=nova;
		}
		// segur que tinc espai
		int pos=0;
		while ((!p.equals(llista[pos])) && (pos<numElems)){
			pos++;
		}
		if(pos==numElems) {
			pos=numElems-1;
			while ((pos>=0) && (p.compareTo(llista[pos])<0)) {
				llista[pos+1]=llista[pos];
				pos--;
			}
			llista[pos+1]=p;
			numElems++;
		}
	}
	
	/**
	 * Getter de numElems
	 * @return numElems
	 */
	@Override
	public int numElems() {
		return numElems;
	}

	
	@Override
	public String toString() {
		return "LlistaPunts [llista=" + Arrays.toString(llista) + ", numElems=" + numElems + "]";
	}

	@Override
	public Iterator<T> iterator() {
		return new MeuIterator<T>(this, 1);
	}

	@Override
	public T consultarPosicio(int i) throws LlistaBuida {
		if (i<numElems) return (llista[i]);
		else return (null);
	}
	
}
