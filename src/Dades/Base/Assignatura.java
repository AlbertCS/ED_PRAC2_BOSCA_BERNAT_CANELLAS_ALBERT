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

	public Matricula getMatric() {
		return matric;
	}

	public void setMatric(Matricula matric) {
		this.matric = matric;
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
		return "Assignatura: " + nomAssig + ". Amb codi: " + codiAssig + ", credits: " + credits + ", curs: " + curs + ", quadrimestres: " + quad;
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
