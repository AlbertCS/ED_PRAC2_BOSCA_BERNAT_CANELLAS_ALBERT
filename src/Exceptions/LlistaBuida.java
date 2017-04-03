package Exceptions;

/**
 * @author Bernat Bosca Candel
 * 		   Albert Ca�ellas Sol�
 *
 */
public class LlistaBuida extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor de l'excepcio LlistaBuida amb el missatge corresponent
	 */
	public LlistaBuida(){
		super("ERROR : Llista buida i no podem llegir car�cters. ");
	}
}
