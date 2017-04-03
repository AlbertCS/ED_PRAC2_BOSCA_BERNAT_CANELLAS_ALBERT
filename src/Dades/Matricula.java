package Dades;
//Class Node
public class Matricula {

	private Integer assig;
	private String alum;
	Matricula ante_hor, next_hor, ante_ver, next_ver;
	
	public Matricula(Integer assig, String alum) {
		this.assig=assig;
		this.alum=alum;
		ante_hor=null;
		next_hor=null;
		ante_ver=null;
		next_ver=null;
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

	/**
	 * @return the ante_hor
	 */
	public Matricula getAnte_hor() {
		return ante_hor;
	}

	/**
	 * @param ante_hor the ante_hor to set
	 */
	public void setAnte_hor(Matricula ante_hor) {
		this.ante_hor = ante_hor;
	}

	/**
	 * @return the next_hor
	 */
	public Matricula getNext_hor() {
		return next_hor;
	}

	/**
	 * @param next_hor the next_hor to set
	 */
	public void setNext_hor(Matricula next_hor) {
		this.next_hor = next_hor;
	}

	/**
	 * @return the ante_ver
	 */
	public Matricula getAnte_ver() {
		return ante_ver;
	}

	/**
	 * @param ante_ver the ante_ver to set
	 */
	public void setAnte_ver(Matricula ante_ver) {
		this.ante_ver = ante_ver;
	}

	/**
	 * @return the next_ver
	 */
	public Matricula getNext_ver() {
		return next_ver;
	}

	/**
	 * @param next_ver the next_ver to set
	 */
	public void setNext_ver(Matricula next_ver) {
		this.next_ver = next_ver;
	}

	
	
	
	
}
