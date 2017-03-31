package Dades;
import java.util.*;

public interface TADLlistaGenerica<E, T extends Comparable<T>>{

		/**
		 * 
		 * @param elem
		 * @throws LlistaPlena
		 */
		void afegirElement(E elem) throws LlistaPlena;
		
		/**
		 * 
		 * @return
		 * @throws LlistaBuida
		 */
		E consultarIessim() throws LlistaBuida;
		
		/**
		 * Metode que retorna el numero d'elements
		 * @return numElems
		 */
		int numElems();
		
		public String toString();
		
		public Iterator<T> iterator();
	

}
