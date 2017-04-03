package Dades.Base;

public class Alumne implements Comparable<Alumne>{
	private String codiAlum;
	private String nomAlum;
	
	public Alumne(String codiAlum, String nomAlum) {
		this.codiAlum=codiAlum;
		this.nomAlum=nomAlum;
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

	public boolean equals(Alumne alum) {
		if((this.codiAlum==alum.getCodiAlum())&&(this.nomAlum==alum.getNomAlum())) return true;
		else return false;
	}
	
	public void clone(Alumne alum) {
		this.codiAlum=alum.getCodiAlum();
		this.nomAlum=alum.getNomAlum();
	}
}
