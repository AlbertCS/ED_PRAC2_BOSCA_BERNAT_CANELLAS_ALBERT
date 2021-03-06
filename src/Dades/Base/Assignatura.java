package Dades.Base;

/**
 * @author Bernat Bosca Candel
 * 		   Albert Ca�ellas Sole
 * 
 */
public class Assignatura implements Comparable<Assignatura>{
	private Integer codiAssig;
	private String nomAssig;
	private Integer credits, curs,  quad;
	private Matricula matric;
	
	/**
	 * Constructor de la classe
	 * 
	 * @param codiAssig Codi de la Assignatura
	 * @param nomAssig Nom de la Assignatura
	 * @param credits Credits
	 * @param curs Curs
	 * @param quad Quadrimestre
	 */
	public Assignatura(Integer codiAssig, String nomAssig, Integer credits, Integer curs, Integer quad){
		this.codiAssig=codiAssig;
		this.nomAssig=nomAssig;
		this.credits=credits;
		this.curs=curs;
		this.quad=quad;
	}

	/**
	 * Getter de matricula
	 * @return matric
	 */
	public Matricula getMatric() {
		return matric;
	}

	/**
	 * Setter de matricula
	 * @param matric a definir
	 */
	public void setMatric(Matricula matric) {
		this.matric = matric;
	}
	
	/**
	 * Getter de codiAssignatura
	 * @return codiAssig
	 */
	public Integer getCodiAssig() {
		return codiAssig;
	}

	/**
	 * Setter de codiAssignatura
	 * @param codiAssig a definir
	 */
	public void setCodiAssig(Integer codiAssig) {
		this.codiAssig = codiAssig;
	}

	/**
	 * Getter de nomAssignatura
	 * @return nomAssig
	 */
	public String getNomAssig() {
		return nomAssig;
	}

	/**
	 * Setter de nomAssignatura
	 * @param nomAssig a definir
	 */
	public void setNomAssig(String nomAssig) {
		this.nomAssig = nomAssig;
	}

	/**
	 * Getter de credits de l'assignatura
	 * @return credits
	 */
	public Integer getCredits() {
		return credits;
	}

	/**
	 *  Setter de credits de l'assignatura
	 * @param credits a definir
	 */
	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	/**
	 * Getter de nomAssignatura
	 * @return nomAssig
	 */
	public String getNom() {
		return nomAssig;
	}

	/**
	 * Setter de nomAssignatura
	 * @param nomAssig a definir
	 */
	public void setNom(String nomAssig) {
		this.nomAssig = nomAssig;
	}

	/**
	 * Getter de curs
	 * @return curs
	 */
	public Integer getCurs() {
		return curs;
	}

	/**
	 * Setter de curs
	 * @param curs a definir
	 */
	public void setCurs(Integer curs) {
		this.curs = curs;
	}

	/**
	 * Get quadri
	 * @return quad
	 */
	public Integer getQuad() {
		return quad;
	}

	/**
	 * Setter de quadri
	 * @param quad a definir
	 */
	public void setQuad(Integer quad) {
		this.quad = quad;
	}

	@Override
	public String toString() {
		String aux;
		if((nomAssig.length()<14) || (codiAssig.equals(17234007))) aux="Assignatura: " + nomAssig + ".\t\t\t\t\tAmb codi:  " + codiAssig + " , credits: " + credits + " , curs: " + curs + " , quadrimestres: " + quad;
		else if(nomAssig.length()<22) aux="Assignatura: " + nomAssig + ".\t\t\t\tAmb codi:  " + codiAssig + " , credits: " + credits + " , curs: " + curs + " , quadrimestres: " + quad;
		else if(nomAssig.length()<=29) aux="Assignatura: " + nomAssig + ".\t\t\tAmb codi:  " + codiAssig + " , credits: " + credits + " , curs: " + curs + " , quadrimestres: " + quad;
		else if(nomAssig.length()<=35) aux="Assignatura: " + nomAssig + ".\t\tAmb codi:  " + codiAssig + " , credits: " + credits + " , curs: " + curs + " , quadrimestres: " + quad;
		else aux="Assignatura: " + nomAssig + ".\tAmb codi:  " + codiAssig + " , credits: " + credits + " , curs: " + curs + " , quadrimestres: " + quad;
		return aux;
	}

	@Override
	public int compareTo(Assignatura assig) {
		if (this.curs<assig.curs) return -1;
		else if (this.curs>assig.curs) return 1;
		else if (this.quad<assig.quad) return -1;
		else if (this.quad>assig.quad) return 1;
		else if (this.nomAssig.compareTo(assig.nomAssig)==0) return (this.codiAssig.compareTo(assig.codiAssig));
		else return (this.nomAssig.compareTo(assig.nomAssig));
	}
	
	@Override
	public boolean equals(Object assig) {
		if(assig!=null){
			Assignatura aux=(Assignatura) assig;
			if((codiAssig.equals(aux.getCodiAssig()))&&(nomAssig.equals(aux.getNomAssig()))&&(credits.equals(aux.getCredits()))&&(quad.equals(aux.getQuad()))) 
				return true;
			else return false;
		}
		else return false;
		
	}
	
	@Override
	public Object clone() {
		Assignatura aux;
		try {
			aux = (Assignatura) super.clone();
			return aux;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
