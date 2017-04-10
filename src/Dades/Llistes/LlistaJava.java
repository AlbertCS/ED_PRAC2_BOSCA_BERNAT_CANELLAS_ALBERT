package Dades.Llistes;
import java.util.*;

import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;



/**
 * @author Bernat Bosca Candel
 * 		   Albert Cañellas Sole
 * @param <T> Tipus Element
 *
 */
public class LlistaJava<T extends Comparable<T>> implements Iterable<T>, TADLlistaGenerica<T>{

	private static int  numElem=0;
	LinkedList<T> list=new LinkedList<T>();
		
	@Override
	public void afegirElement(T elem) throws LlistaPlena {
		list.add(elem);
		numElem++;
	}

	@Override
	public T consultarPosicio(int i) throws LlistaBuida {
		return list.get(i);
	}

	@Override
	public int numElems() {
		return list.size();
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public String toString() {
		return "LlistaJava [list=" + list + "]";
	}
}
