package Dades.Llistes;
import java.util.*;
import Exceptions.*;

public interface TADLlistaGenerica<T extends Comparable<T>>{

		/**
		 * Metode que afegeix un element
		 * @param elem
		 * @throws LlistaPlena
		 */
		void afegirElement(T elem)  throws LlistaPlena;
		
		/**
		 * Metode que consulta l'element de la posicio demanada
		 * @return
		 * @throws LlistaBuida
		 */
		T consultarPosicio(int i) throws LlistaBuida;
		
		/**
		 * Metode que retorna el numero d'elements
		 * @return numElems
		 */
		int numElems();
		
		/**
		 * Metode toString
		 * @return el string 
		 */
		String toString();
		
		/**
		 * Metode iterador
		 * @return iterador
		 */
		Iterator<T> iterator();

}
