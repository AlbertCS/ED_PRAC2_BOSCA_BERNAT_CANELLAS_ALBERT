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

	public Matricula getAnteriorAssig() {
		return anteriorAssig;
	}

	public void setAnteriorAssig(Matricula anteriorAssig) {
		this.anteriorAssig = anteriorAssig;
	}

	public Matricula getAnteriorAlumne() {
		return anteriorAlumne;
	}

	public Alumne getAlumne() {
		return alumne;
	}

	public void setAlumne(Alumne alumne) {
		this.alumne = alumne;
	}

	public Assignatura getAssignatura() {
		return assignatura;
	}

	public void setAssignatura(Assignatura assignatura) {
		this.assignatura = assignatura;
	}

	public void setAnteriorAlumne(Matricula anteriorAlumne) {
		this.anteriorAlumne = anteriorAlumne;
	}

	/**
	 * @return the assig
	 */
	public Integer getCodiAssig() {
		return codiAssig;
	}

	/**
	 * @param assig the assig to set
	 */
	public void setCodiAssig(Integer assig) {
		this.codiAssig = assig;
	}

	/**
	 * @return the alum
	 */
	public String getCodiAlum() {
		return codiAlum;
	}

	/**
	 * @param alum the alum to set
	 */
	public void setCodiAlum(String alum) {
		this.codiAlum = alum;
	}

	public Matricula getSeguentAssig() {
		return seguentAssig;
	}

	public void setSeguentAssig(Matricula seguentAssig) {
		this.seguentAssig = seguentAssig;
	}

	public Matricula getSeguentAlumne() {
		return seguentAlumne;
	}

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
	
	public void clone(Matricula mat) {
		this.codiAssig=mat.getCodiAssig();
		this.codiAlum=mat.getCodiAlum();
		this.seguentAssig=mat.getSeguentAssig();
		this.seguentAlumne=mat.getSeguentAlumne();
		this.anteriorAssig=mat.getAnteriorAssig();
		this.anteriorAlumne=mat.getAnteriorAlumne();
		this.alumne=mat.getAlumne();
		this.assignatura=mat.getAssignatura();
	}
}
