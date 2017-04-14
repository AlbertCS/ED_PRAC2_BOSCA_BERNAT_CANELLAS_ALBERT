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
public interface TADLlistaGenerica<T extends Comparable<T>>{

		/**
		 * Metode que afegeix un element
		 * @param elem a afegir
		 * @throws LlistaPlena excepcio de llista plena
		 */
		void afegirElement(T elem)  throws LlistaPlena;
		
		/**
		 * Metode que consulta l'element de la posicio demanada
		 * @param i Indica la posició que es vol consultar
		 * @return retorna lelement
		 * @throws LlistaBuida excepcio de llista buida
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
