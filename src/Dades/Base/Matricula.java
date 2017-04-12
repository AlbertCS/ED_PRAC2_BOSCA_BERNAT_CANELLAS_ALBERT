package Dades.Base;

//Class Node
public class Matricula {

	private Integer codiAssig;
	private String codiAlum;
	private Matricula seguentAssig, seguentAlumne, anteriorAssig, anteriorAlumne;
	private Alumne alumne;
	private Assignatura assignatura;
	
	public Matricula(Integer assig, String alum) {
		this.codiAssig=assig;
		this.codiAlum=alum;
		seguentAssig=null;
		seguentAlumne=null;
		anteriorAssig=null;
		anteriorAlumne=null;
		alumne=null;
		assignatura=null;
	}

	/**
	 * Getter anteriorAssignatura
	 * @return anteriorAssig
	 */
	public Matricula getAnteriorAssig() {
		return anteriorAssig;
	}

	/**
	 * Setter anteriorAssignatura
	 * @param anteriorAssig a definir
	 */
	public void setAnteriorAssig(Matricula anteriorAssig) {
		this.anteriorAssig = anteriorAssig;
	}

	/**
	 * Getter anteriorAlumne
	 * @return anterior alumne
	 */
	public Matricula getAnteriorAlumne() {
		return anteriorAlumne;
	}

	/**
	 * Getter alumne
	 * @return alumne
	 */
	public Alumne getAlumne() {
		return alumne;
	}

	/**
	 * Setter alumne
	 * @param alumne a definir
	 */
	public void setAlumne(Alumne alumne) {
		this.alumne = alumne;
	}

	/**
	 * Getter assignatura
	 * @return assignatura a consultar
	 */
	public Assignatura getAssignatura() {
		return assignatura;
	}

	/**
	 * Setter assignatura
	 * @param assignatura a definir
	 */
	public void setAssignatura(Assignatura assignatura) {
		this.assignatura = assignatura;
	}

	/**
	 * Setter anteriorAlumne
	 * @param anteriorAlumne a definir
	 */
	public void setAnteriorAlumne(Matricula anteriorAlumne) {
		this.anteriorAlumne = anteriorAlumne;
	}

	/**
	 * Getter de codiAssignatura
	 * @return the assig
	 */
	public Integer getCodiAssig() {
		return codiAssig;
	}

	/**
	 * Setter codiAssignatura
	 * @param assig the assig to set
	 */
	public void setCodiAssig(Integer assig) {
		this.codiAssig = assig;
	}

	/**
	 * Getter de codiAlumne
	 * @return the alum
	 */
	public String getCodiAlum() {
		return codiAlum;
	}

	/**
	 * Setter de codiAlumne
	 * @param alum the alum to set
	 */
	public void setCodiAlum(String alum) {
		this.codiAlum = alum;
	}

	/**
	 * Getter de seguentAssignatura
	 * @return seguentAssig
	 */
	public Matricula getSeguentAssig() {
		return seguentAssig;
	}

	/**
	 * Setter de seguentAssignatura
	 * @param seguentAssig a definir
	 */
	public void setSeguentAssig(Matricula seguentAssig) {
		this.seguentAssig = seguentAssig;
	}

	/**
	 * Getter de seguentAlumne
	 * @return seguentAlumne a consultar
	 */
	public Matricula getSeguentAlumne() {
		return seguentAlumne;
	}

	/**
	 * Setter seguentAlumne
	 * @param seguentAlumne a definir
	 */
	public void setSeguentAlumne(Matricula seguentAlumne) {
		this.seguentAlumne = seguentAlumne;
	}

	@Override
	public String toString() {
		return "Matricula [assig=" + codiAssig + ", alum=" + codiAlum + "]";
	}
	
	public int compareTo(Assignatura assig) {
		return (this.codiAssig.compareTo(assig.getCodiAssig()));
	}
	
	public int compareTo(Alumne alum) { 
		return (this.codiAlum.compareTo(alum.getCodiAlum()));
	}
	
	public boolean equals(Assignatura assig) {
		if(this.compareTo(assig)==0) return true;
		else return false;
	}
	
	public boolean equals(Matricula mat) {
		if((this.codiAssig==mat.getCodiAssig())&&(this.codiAlum==mat.getCodiAlum())&&(this.seguentAssig==mat.getSeguentAssig())&&(this.seguentAlumne==mat.getSeguentAlumne())) 
			return true;
		else return false;
	}
	
	@Override
	public Object clone() {
		Matricula aux;
		try {
			aux = (Matricula) super.clone();
			return aux;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
