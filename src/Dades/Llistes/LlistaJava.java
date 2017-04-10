package Dades.Llistes;
import java.util.*;

import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;



/**
 * @author Bernat Bosca Candel
 * 		   Albert Ca�ellas Sole
 * @param <T> Tipus Element
 *
 */
public class LlistaJava<T extends Comparable<T>> implements Iterable<T>, TADLlistaGenerica<T>{

	private static int  numElems=0;
	LinkedList<T> llista=new LinkedList<T>();
		
	@Override
	public void afegirElement(T elem) throws LlistaPlena {
		int pos=numElems-1;
		while ((pos>=0) && (elem.compareTo(llista.get(pos))<0)) {
			llista.add(pos+1, llista.get(pos));
			pos--;
		}
		llista.add(pos+1, elem);
		numElems++;
	}

	@Override
	public T consultarPosicio(int i) throws LlistaBuida {
		return llista.get(i);
	}

	@Override
	public int numElems() {
		return numElems;
	}

	@Override
	public Iterator<T> iterator() {
		return llista.iterator();
	}

	@Override
	public String toString() {
		return "LlistaJava [llista=" + llista + "]";
	}
}
