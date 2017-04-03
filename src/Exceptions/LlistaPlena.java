package Exceptions;

/**
 * @author Bernat Bosca Candel
 *		   Albert Ca�ellas Sol� 
 *
 */
public class LlistaPlena extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de l'excepcio LListaPlena amb el missatge corresponent
	 * @param e objecte que provoca la excepcio
	 */
	public LlistaPlena(Object e){
		super("ERROR : Llista plena i no podem afegir apartir del car�cter "+e);

	}
}
