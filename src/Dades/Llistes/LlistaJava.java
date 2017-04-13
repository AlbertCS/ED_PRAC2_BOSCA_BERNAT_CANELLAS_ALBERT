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


	private int  numElems;
	ArrayList<T> llista;
		
	public LlistaJava() {
		llista=new ArrayList<T>();
		numElems=0;
	}
	
	/**
	 * Metode que afegeix un element
	 * @param p element a afegir
	 */
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

	}

	/**
	 * Metode per consultar la posicio
	 * @param i posicio a consultar
	 */
	@Override
	public T consultarPosicio(int i) throws LlistaBuida {
		if (i<numElems) return llista.get(i);
		else return (null);
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
	public Iterator<T> iterator() {
		return llista.iterator();
	}

	@Override
	public String toString() {
		return "LlistaJava [llista=" + llista + "]";
	}
}
