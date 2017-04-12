package Dades.Base;

public class Assignatura implements Comparable<Assignatura>{
	private Integer codiAssig;
	private String nomAssig;
	private Integer credits, curs,  quad;
	private Matricula matric;
	
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
	 * @param matric
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
	 * @param codiAssig
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
	 * @param nomAssig
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
	 * @param credits
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
	 * @param nomAssig
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
	 * @param curs
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
	 * @param quad
	 */
	public void setQuad(Integer quad) {
		this.quad = quad;
	}

	@Override
	public String toString() {
		return "Assignatura [codiAssig=" + codiAssig + ", nomAssig=" + nomAssig + ", credits=" + credits + ", curs="
				+ curs + ", quad=" + quad + "]";
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
