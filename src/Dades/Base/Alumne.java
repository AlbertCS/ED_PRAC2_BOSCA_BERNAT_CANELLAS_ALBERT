package Dades.Base;

public class Alumne implements Comparable<Alumne>{
	private String codiAlum;
	private String nomAlum;
	private Matricula matric;
	
	public Alumne(String codiAlum, String nomAlum) {
		this.codiAlum=codiAlum;
		this.nomAlum=nomAlum;
		matric=null;
	}

	public Matricula getMatric() {
		return matric;
	}

	public void setMatric(Matricula matric) {
		this.matric = matric;
	}

	public String getCodiAlum() {
		return codiAlum;
	}

	public void setCodiAlum(String codiAlum) {
		this.codiAlum = codiAlum;
	}

	public String getNomAlum() {
		return nomAlum;
	}


	public void setNomAlum(String nomAlum) {
		this.nomAlum = nomAlum;
	}

	@Override
	public String toString() {
		return "Alumne [codiAlum=" + codiAlum + ", nomAlum=" + nomAlum + "]";
	}
	
	@Override
	public int compareTo(Alumne alum) { 
		return (this.nomAlum.compareTo(alum.nomAlum));
	}

	@Override
	public boolean equals(Object alum) {
		Alumne aux=(Alumne) alum;
		if((codiAlum==aux.getCodiAlum())&&(nomAlum==aux.getNomAlum())) return true;
		else return false;
	}
	
	public void clone(Alumne alum) {
		this.codiAlum=alum.getCodiAlum();
		this.nomAlum=alum.getNomAlum();
		this.matric=alum.getMatric();
	}
}
