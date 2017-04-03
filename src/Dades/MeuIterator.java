package Dades;

import java.util.Iterator;
import Exceptions.*;

public class MeuIterator<T extends Comparable<T>> implements Iterator<T> {
	private TADLlistaGenerica<T> llista;	//nou atribut que ens guardarà una copia de la llista actual de elements
	private int posicioIterator;
	
	public MeuIterator(TADLlistaGenerica<T> ll) {
		llista=new TADLlistaGenerica<T>(ll.getNum());
		for (int i=0; i<ll.getNum(); i++) {
			llista.afegirElement(ll.consultarPosicio(i));
		}
		posicioIterator=0; 	// ens preparem per a retornar els elements a partir de la posicio 0
	}
	
	@Override
	public boolean hasNext() {
		return ((posicioIterator<llista.getNum()));
	}

	@Override
	public TADLlistaGenerica next() {
		TADLlistaGenerica<T> aux=null;
		aux=llista.consultarPosicio(posicioIterator);
		posicioIterator++;
		return aux;
	}

	

}
