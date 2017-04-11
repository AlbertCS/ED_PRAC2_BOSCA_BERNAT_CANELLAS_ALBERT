package Dades.Llistes;

import java.util.*;
import Exceptions.*;

public class LlistaDinamica<T extends Comparable<T>> implements Iterable<T>, TADLlistaGenerica<T> {
	
	private Node<T> elem;
	private int numElems=0;
	
	
	public LlistaDinamica() {
		elem=null;
	}

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
				if((p.compareTo(dretaElement.getX())==1) && (dretaElement.getAnterior()!=null)) {
					dretaElement=dretaElement.getAnterior();
				}
				elemAux=elemAux.getAnterior();
				pos++;
			}
			if(pos==numElems) {
				Node<T> anterior=dretaElement.getAnterior();
				dretaElement.setAnterior(nou);
				nou.setSeguent(dretaElement);
				if(anterior!=null){
					anterior.setSeguent(nou);
					nou.setAnterior(anterior);
				}
				while (elem.getSeguent()!=null) {
					elem=elem.getSeguent();
				}
				numElems++;
			}
		}
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
