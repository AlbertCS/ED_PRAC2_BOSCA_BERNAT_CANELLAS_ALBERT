package Dades.Base;

//Class Node
public class Matricula {

	private Integer assig;
	private String alum;
	Matricula seguentAssig, seguentAlumne, anteriorAssig, anteriorAlumne;
	
	public Matricula(Integer assig, String alum) {
		this.assig=assig;
		this.alum=alum;
		seguentAssig=null;
		seguentAlumne=null;
		anteriorAssig=null;
		anteriorAlumne=null;
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

	public void setAnteriorAlumne(Matricula anteriorAlumne) {
		this.anteriorAlumne = anteriorAlumne;
	}

	/**
	 * @return the assig
	 */
	public Integer getAssig() {
		return assig;
	}

	/**
	 * @param assig the assig to set
	 */
	public void setAssig(Integer assig) {
		this.assig = assig;
	}

	/**
	 * @return the alum
	 */
	public String getAlum() {
		return alum;
	}

	/**
	 * @param alum the alum to set
	 */
	public void setAlum(String alum) {
		this.alum = alum;
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
		return "Matricula [assig=" + assig + ", alum=" + alum + "]";
	}
	
	public int compareTo(Assignatura assig) {
		return (this.assig.compareTo(assig.getCodiAssig()));
	}
	
	public int compareTo(Alumne alum) { 
		return (this.alum.compareTo(alum.getCodiAlum()));
	}
	
	public boolean equals(Assignatura assig) {
		if(this.compareTo(assig)==0) return true;
		else return false;
	}
	
	public boolean equals(Matricula mat) {
		if((this.assig==mat.getAssig())&&(this.alum==mat.getAlum())&&(this.seguentAssig==mat.getSeguentAssig())&&(this.seguentAlumne==mat.getSeguentAlumne())) 
			return true;
		else return false;
	}
	
	public void clone(Matricula mat) {
		this.assig=mat.getAssig();
		this.alum=mat.getAlum();
		this.seguentAssig=mat.getSeguentAssig();
		this.seguentAlumne=mat.getSeguentAlumne();
	}
}
