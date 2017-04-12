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
		return "Alumne: "+ nomAlum + ". Amb codi: " + codiAlum;
	}
	
	@Override
	public int compareTo(Alumne alum) { 
		if (this.nomAlum.compareTo(alum.nomAlum)==0) return (this.codiAlum.compareTo(alum.codiAlum));
		else return (this.nomAlum.compareTo(alum.nomAlum));
	}

	@Override
	public boolean equals(Object alum) {
		if(alum!=null){
			Alumne aux=(Alumne) alum;
			if((codiAlum.equals(aux.getCodiAlum()))&&(nomAlum.equals(aux.getNomAlum()))) return true;
			else return false;
		}
		else return false;
		
	}
	
	@Override
	public Object clone() {
		Alumne aux;
		try {
			aux = (Alumne) super.clone();
			return aux;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
