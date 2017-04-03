package Dades;

import java.util.Iterator;
import Exceptions.*;

public class MeuIterator<T extends Comparable<T>> implements Iterator<T> {
	private TADLlistaGenerica<T> llista;	//nou atribut que ens guardarà una copia de la llista actual de elements
	private int posicioIterator;
	
	public MeuIterator(TADLlistaGenerica<T> ll, int tipus) {
		switch(tipus){
		case 1:
			llista=new LlistaGenericaEstatica<T>(ll.getNum()); break;
		case 2:
			llista=new LlistaGenericaDinamica<T>(ll.getNum()); break;
		case 3: break;
		default: break;
		}
		try{
			for (int i=0; i<ll.getNum(); i++) llista.afegirElement(ll.consultarPosicio(i));
		} catch (LlistaPlena|LlistaBuida e){
			System.out.println("Aquesta circunstancia no deuria de passar mai.");
		}
		posicioIterator=0; 	// ens preparem per a retornar els elements a partir de la posicio 0
	}
	
	@Override
	public boolean hasNext() {
		return ((posicioIterator<llista.getNum()));
	}

	@Override
	public T next() {
		posicioIterator++;
		try {
			return llista.consultarPosicio(posicioIterator);
		} catch (LlistaBuida e) {
			e.printStackTrace();
			return null;
		}
	}

	

}
