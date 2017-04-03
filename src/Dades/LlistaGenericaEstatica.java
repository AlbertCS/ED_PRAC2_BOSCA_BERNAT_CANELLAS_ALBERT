package Dades;

import java.util.Arrays;
import java.util.Iterator;
import Exceptions.*;

public class LlistaGenericaEstatica<T extends Comparable<T>> implements Iterable<T>, TADLlistaGenerica<T> {
	private T[] llista;
	private int num;
	
	@SuppressWarnings("unchecked")
	public LlistaGenericaEstatica(int dim) {
		llista=(T[])new Comparable[dim];
		num=0;
	}

	@SuppressWarnings("unchecked")
	public void afegirElement(T p) {
		if (num>=llista.length) {
			// amplio
			T[] nova=(T[]) new Comparable[llista.length*2];
			for (int i=0; i<llista.length; i++) nova[i]=llista[i];
			llista=nova;
		}
		// segur que tinc espai
		int pos=num-1;
		while ((pos>=0) && (p.compareTo(llista[pos])<0)) {
			llista[pos+1]=llista[pos];
			pos--;
		}
		llista[pos+1]=p;
		num++;
	}
	
	public int getNum() {
		return num;
	}

	@Override
	public String toString() {
		return "LlistaPunts [llista=" + Arrays.toString(llista) + ", num=" + num + "]";
	}

	@Override
	public Iterator<T> iterator() {
		return new MeuIterator<T>(this);
	}

	@Override
	public T consultarPosicio(int i) throws LlistaBuida {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numElems() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
