package Dades.Llistes;

import java.util.*;
import Exceptions.*;

/**
 * @author Bernat Bosca Candel
 * 		   Albert Cañellas Sole
 * 
 * @param <T> Tipus d'element
 * 
 */
public class LlistaDinamica<T extends Comparable<T>> implements Iterable<T>, TADLlistaGenerica<T> {
	
	private Node<T> elem;
	private int numElems=0;
	
	
	/**
	 * Constructor de la classe
	 */
	public LlistaDinamica() {
		elem=null;
	}

	/**
	 * Metode que afegeix un nou element a la llista
	 * @param p element a afegir
	 */
	public void afegirElement(T p) throws LlistaPlena {
		Node<T> nou=new Node<T>(p, null, null);
		if(numElems==0) {
			elem=nou;
			numElems++;
		}
		else {
			Node<T> elemAux=elem;
			Node<T> dretaElement=elem;
			int pos=0;
			while((elemAux!=null) && (!p.equals(elemAux.getX()))){
				if((p.compareTo(dretaElement.getX())<0) && (dretaElement.getAnterior()!=null)) {
					dretaElement=dretaElement.getAnterior();
				}
				elemAux=elemAux.getAnterior();
				pos++;
			}
			if(pos==numElems) {
				if(p.compareTo(dretaElement.getX())<0){
					Node<T> anterior=dretaElement.getAnterior();
					dretaElement.setAnterior(nou);
					nou.setSeguent(dretaElement);
					if(anterior!=null){
						anterior.setSeguent(nou);
						nou.setAnterior(anterior);
					}
				}
				else {
					Node<T> seguent=dretaElement.getSeguent();
					dretaElement.setSeguent(nou);
					nou.setAnterior(dretaElement);
					if(seguent!=null){
						seguent.setAnterior(nou);
						nou.setSeguent(seguent);
					}
				}
				while (elem.getSeguent()!=null) {
					elem=elem.getSeguent();
				}
				numElems++;
			}
		}
	}

	/**
	 * Getter de l'element
	 * @return elem
	 */
	public Node<T> getElem() {
		return elem;
	}

	/**
	 * Setter de l'element
	 * @param elem a canviar
	 */
	public void setElem(Node<T> elem) {
		this.elem = elem;
	}

	/**
	 * Getter de numElems
	 * @return numElems
	 */
	public int numElems() {
		return numElems;
	}

	
	@Override
	public String toString() {
		return "LlistaDinamica [elem=" + elem + "]";
	}

	@Override
	public T consultarPosicio(int num) throws LlistaBuida {
		Node<T> aux;
		aux=elem;
		int i;
		if(num==numElems-1) return aux.getX();
		else {
			for(i=numElems-1; i>num; i--){
				aux=aux.getAnterior();
			}
			if(aux!=null) return aux.getX();
			else return null;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new MeuIterator<T>(this, 2);
	}
	
	
}
