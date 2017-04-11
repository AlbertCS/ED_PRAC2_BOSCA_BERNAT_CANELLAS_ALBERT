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

	private static int  numElems=0;
	LinkedList<T> llista=new LinkedList<T>();
=======
	private int  numElems;
	ArrayList<T> llista;
>>>>>>> refs/remotes/origin/master
		
	public LlistaJava() {
		llista=new ArrayList<T>();
		numElems=0;
	}
	
	@Override
	public void afegirElement(T p) throws LlistaPlena {
		if(numElems==0){
			llista.add(0, p);
			numElems++;
		}
		else {
			int pos=0;
			T aux=llista.get(0);
			while ((pos<numElems) && (!p.equals(aux))){
				pos++;
				if(pos<numElems) aux=llista.get(pos);
			}
			if(pos==numElems) {
				pos=numElems-1;
				aux=llista.get(pos);
				while ((pos>=0) && (p.compareTo(aux)<0)) {
					aux=llista.get(pos);
					pos++;
					if(pos==numElems) llista.add(pos, aux);
					else llista.set(pos, aux);
					pos=pos-2;
				}
				pos++;
				if(pos==numElems) llista.add(pos, p);
				else {
					if(p.compareTo(aux)>0) pos++;
					llista.set(pos, p);
				}
				numElems++;
			}
		}
<<<<<<< HEAD
		

=======
>>>>>>> refs/remotes/origin/master
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
