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

<<<<<<< HEAD
	private static int  numElem=0;
	LinkedList<T> list= new LinkedList<T>();
		
	@Override
	public void afegirElement(T elem) throws LlistaPlena {
		list.add(elem);
		numElem++;
=======
	private static int  numElems=0;
	LinkedList<T> llista=new LinkedList<T>();
		
	@Override
	public void afegirElement(T elem) throws LlistaPlena {
		int pos=0;
		while (!elem.equals(llista.get(pos))&& (pos!=numElems)){
			pos++;
		}
		if(pos==numElems) {
			pos=numElems-1;
			while ((pos>=0) && (elem.compareTo(llista.get(pos))<0)) {
				llista.add(pos+1, llista.get(pos));
				pos--;
			}
			llista.add(pos+1, elem);
			numElems++;
		}
		
>>>>>>> refs/remotes/origin/master
	}

	@Override
	public T consultarPosicio(int i) throws LlistaBuida {
<<<<<<< HEAD
		return list.get(i);
=======
		return llista.get(i);
>>>>>>> refs/remotes/origin/master
	}

	@Override
	public int numElems() {
<<<<<<< HEAD
		return list.size();
=======
		return numElems;
>>>>>>> refs/remotes/origin/master
	}

	@Override
	public Iterator<T> iterator() {
<<<<<<< HEAD
		return list.iterator();
	}

	
	
	
	
=======
		return llista.iterator();
	}

	@Override
	public String toString() {
		return "LlistaJava [llista=" + llista + "]";
	}
>>>>>>> refs/remotes/origin/master
}
