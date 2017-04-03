package Dades;
//Class Node
public class Matricula {

	private Integer assig;
	private String alum;
	Matricula seguentAssig, seguentAlumne;
	
	public Matricula(Integer assig, String alum) {
		this.assig=assig;
		this.alum=alum;
		seguentAssig=null;
		seguentAlumne=null;
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
	
}
