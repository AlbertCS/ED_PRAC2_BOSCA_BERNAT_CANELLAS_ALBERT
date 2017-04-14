package Dades.Base;

/**
 * @author Bernat Bosca Candel
 * 		   Albert Cañellas Sole
 * 
 */
public class Alumne implements Comparable<Alumne>{
	private String codiAlum;
	private String nomAlum;
	private Matricula matric;
	
	/**
	 * Constructor de la classe
	 * 
	 * @param codiAlum Codi del Alumne
	 * @param nomAlum Nom del Alumne
	 */
	public Alumne(String codiAlum, String nomAlum) {
		this.codiAlum=codiAlum;
		this.nomAlum=nomAlum;
		matric=null;
	}

	/**
	 * Getter de matricula
	 * @return matric retorna la matricula
	 */
	public Matricula getMatric() {
		return matric;
	}

	/**
	 * Setter de matricula
	 * @param matric a definir
	 */
	public void setMatric(Matricula matric) {
		this.matric = matric;
	}

	/**
	 * Getter de codiAlumne
	 * @return codiAlum el codi de l'alumne
	 */
	public String getCodiAlum() {
		return codiAlum;
	}

	/**
	 * Setter de codiAlumne
	 * @param codiAlum a definir
	 */
	public void setCodiAlum(String codiAlum) {
		this.codiAlum = codiAlum;
	}

	/**
	 * Getter de NomAlumne
	 * @return nomAlum nom de l'alumne
	 */
	public String getNomAlum() {
		return nomAlum;
	}

	/**
	 * Setter de NomAlumne
	 * @param nomAlum a definir
	 */
	public void setNomAlum(String nomAlum) {
		this.nomAlum = nomAlum;
	}

	
	@Override
	public String toString() {
		String aux;
		if(nomAlum.length()<=6) aux="Alumne:\t"+ nomAlum + ".\t\t\tAmb codi:  " + codiAlum;
		else if(nomAlum.length()<=15) aux="Alumne:\t"+ nomAlum + ".\t\tAmb codi:  " + codiAlum;
		else aux="Alumne:\t"+ nomAlum + ".\tAmb codi:  " + codiAlum;
		return aux;
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
