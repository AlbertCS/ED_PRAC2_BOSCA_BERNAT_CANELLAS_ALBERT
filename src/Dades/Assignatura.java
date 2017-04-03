package Dades;

public class Assignatura implements Comparable<Assignatura>{
	private Integer codiAssig;
	private String nomAssig;
	private Integer credits, curs,  quad;
	
	public Assignatura(Integer codiAssig, String nomAssig, Integer credits, Integer curs, Integer quad){
		this.codiAssig=codiAssig;
		this.nomAssig=nomAssig;
		this.credits=credits;
		this.curs=curs;
		this.quad=quad;
	}

	public Integer getCodiAssig() {
		return codiAssig;
	}

	public void setCodiAssig(Integer codiAssig) {
		this.codiAssig = codiAssig;
	}

	public String getNomAssig() {
		return nomAssig;
	}

	public void setNomAssig(String nomAssig) {
		this.nomAssig = nomAssig;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public String getNom() {
		return nomAssig;
	}

	public void setNom(String nomAssig) {
		this.nomAssig = nomAssig;
	}

	public Integer getCurs() {
		return curs;
	}

	public void setCurs(Integer curs) {
		this.curs = curs;
	}

	public Integer getQuad() {
		return quad;
	}

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
		else return (this.nomAssig.compareTo(assig.nomAssig)); 
	}
	
	public boolean equals(Assignatura assig) {
		if(this.compareTo(assig)==0) return true;
		else return false;
	}
	
	public void clone(Assignatura assig) {
		this.codiAssig=assig.getCodiAssig();
		this.nomAssig=assig.getNomAssig();
		this.credits=assig.getCredits();
		this.curs=assig.getCurs();
		this.quad=assig.getQuad();
	}
}
