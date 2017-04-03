package Dades.Llistes;
import java.util.*;
import Exceptions.*;

public interface TADLlistaGenerica<T extends Comparable<T>>{

		/**
		 * 
		 * @param elem
		 * @throws LlistaPlena
		 */
		void afegirElement(T elem)  throws LlistaPlena;
		
		/**
		 * 
		 * @return
		 * @throws LlistaBuida
		 */
		T consultarPosicio(int i) throws LlistaBuida;
		
		/**
		 * Metode que retorna el numero d'elements
		 * @return numElems
		 */
		int numElems();
		
		String toString();
		
		Iterator<T> iterator();

}
