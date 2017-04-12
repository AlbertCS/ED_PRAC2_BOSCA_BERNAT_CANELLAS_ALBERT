package Dades.Llistes;

import java.util.Iterator;

import Exceptions.*;

public class MeuIterator<T extends Comparable<T>> implements Iterator<T> {
	private TADLlistaGenerica<T> llista;	//nou atribut que ens guardarà una copia de la llista actual de elements
	private int posicioIterator;
	
	public MeuIterator(TADLlistaGenerica<T> ll, int tipus) {
		switch(tipus){
			case 1:
				llista=new LlistaEstatica<T>(ll.numElems()); break;
			case 2:
				llista=new LlistaDinamica<T>(); break;
			default: break;
		}
		try{
			for (int i=0; i<ll.numElems(); i++) llista.afegirElement(ll.consultarPosicio(i));
		} catch (LlistaPlena|LlistaBuida e){
			System.out.println("Aquesta circunstancia no deuria de passar mai.");
		}
		posicioIterator=0; 	// ens preparem per a retornar els elements a partir de la posicio 0
	}
	
	/**
	 * Metode que mira si hi han mes elements
	 * @return si hi a mes elements
	 */
	@Override
	public boolean hasNext() {
		return ((posicioIterator<llista.numElems()));
	}

	/**
	 * Metode que retorna el seguent element
	 * @return aux seguent element
	 */
	@Override
	public T next() {
		try {
			T aux=llista.consultarPosicio(posicioIterator);
			posicioIterator++;
			return aux;
		} catch (LlistaBuida e) {
			e.printStackTrace();
			return null;
		}
	}

}
