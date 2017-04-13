package Dades.Llistes;
import Exceptions.*;
import Dades.Base.*;

/**
 * E i T són per al cas de voler fer una multillista en un altre tipus de variables
 * 
 * @author Bernat Bosca Candel
 * 		   Albert Cañellas Sole
 * 
 * @param <T> En aquest cas serà Assignatura
 * @param <E> En aquest cas serà Alumne
 * 
 */
public class Multillista<E extends Comparable<E>,T extends Comparable<T>> {
	private TADLlistaGenerica<E> llistaAssig;
	private TADLlistaGenerica<T> llistaAlum;
	
	/**
	 * Constructor de la classe
	 * 
	 * @param llistaAssig Llista de Assignatures
	 * @param llistaAlum Llista de Alumnes
	 * @param tipus tipus de implementació de la llista
	 */
	public Multillista(TADLlistaGenerica<E> llistaAssig, TADLlistaGenerica<T> llistaAlum, int tipus) {
		switch(tipus){
			case 1:
				this.llistaAssig=new LlistaEstatica<E>(llistaAssig.numElems());
				this.llistaAlum=new LlistaEstatica<T>(llistaAlum.numElems()); break;
			case 2:
				this.llistaAssig=new LlistaDinamica<E>();
				this.llistaAlum=new LlistaDinamica<T>(); break;
			case 3: 
				this.llistaAssig=new LlistaJava<E>();
				this.llistaAlum=new LlistaJava<T>(); break;
			default: break;
		}
		try{
			for (int i=0; i<llistaAssig.numElems(); i++) 
				this.llistaAssig.afegirElement(llistaAssig.consultarPosicio(i));
			for (int i=0; i<llistaAlum.numElems(); i++) 
				this.llistaAlum.afegirElement(llistaAlum.consultarPosicio(i));
		} catch (LlistaPlena|LlistaBuida e){
			System.out.println("Aquesta circunstancia no deuria de passar mai.");
		}
	}
	
	/**
	 * Aquest mètode crea i retorna una llista de assignatures que es corresponen que cursa l'alumne indicat amb el seu codi
	 * 
	 * @param alum Codi del Alumne
	 * @param tipus tipus de implementació que ha de tenir la llista
	 * @return retorna una llista de assignatures
	 */
	public TADLlistaGenerica<Assignatura> consultarMatriculaAlum (String alum, int tipus) {
		int i=0;
		Alumne alumAux=null;
		Matricula matAux=null;
		boolean ok=false; //boolea per controlar quan es null
		TADLlistaGenerica<Assignatura> llistaAssigAux=null;
		switch(tipus){
			case 1:
				llistaAssigAux=new LlistaEstatica<Assignatura>(llistaAssig.numElems()); break;
			case 2:
				llistaAssigAux=new LlistaDinamica<Assignatura>(); break;
			case 3: 
				llistaAssigAux=new LlistaJava<Assignatura>(); break;
			default: break;
		}
		
		try {
			//Busquem el alumne a la llista
			alumAux=(Alumne) llistaAlum.consultarPosicio(i);
			while(!ok) {
				i++;
				if(alumAux!=null)ok=alum.equals(alumAux.getCodiAlum());
				else ok=true;
				alumAux=(Alumne) llistaAlum.consultarPosicio(i);
			}
			if(alumAux!=null){
				//Una vegada ja l'hem trobat
				matAux=alumAux.getMatric();
				while(matAux!=null) {
					llistaAssigAux.afegirElement(matAux.getAssignatura());
					matAux=matAux.getSeguentAssig();
				}
			}	
		} catch (LlistaPlena|LlistaBuida e) {
			e.printStackTrace();
		}
		//Ojo que si no existeix la relació entre assignatura i alumne retornara null
		if(llistaAssigAux.numElems()==0) return null;
		return llistaAssigAux;
	}
	
	/**
	 * Aquest mètode crea i retorna una llista de alumnes que cursen la assignatura indica pel codi
	 * 
	 * @param assig Codi de la Assignatura
	 * @param tipus tipus de implementació que ha de tenir la llista
	 * @return retorna una llista de Alumnes
	 */
	public TADLlistaGenerica<Alumne> consultarMatriculaAssig (Integer assig, int tipus) {
		int i=0;
		Assignatura assigAux=null;
		Matricula matAux=null;
		boolean ok=false; //boolea per controlar quan es null
		TADLlistaGenerica<Alumne> llistaAlumAux=null;
		switch(tipus){
			case 1:
				llistaAlumAux=new LlistaEstatica<Alumne>(llistaAlum.numElems()); break;
			case 2:
				llistaAlumAux=new LlistaDinamica<Alumne>(); break;
			case 3: 
				llistaAlumAux=new LlistaJava<Alumne>(); break;
			default: break;
		}
		try {
			//Busquem la assignatura a la llista
			assigAux=(Assignatura) llistaAssig.consultarPosicio(i);
			while(!ok) {
				i++;
				if(assigAux!=null) ok=assig.equals(assigAux.getCodiAssig());
				else ok=true;
				assigAux=(Assignatura) llistaAssig.consultarPosicio(i);
			}
			if(assigAux!=null){
				//Una vegada ja l'hem trobat
				matAux=assigAux.getMatric();
				while(matAux!=null) {
					llistaAlumAux.afegirElement(matAux.getAlumne());
					matAux=matAux.getSeguentAlumne();
				}
			}
		} catch (LlistaPlena|LlistaBuida e) {
			e.printStackTrace();
		}
		//Ojo que si no existeix la relació entre assignatura i alumne retornara null
		if(llistaAlumAux.numElems()==0) return null;
		return llistaAlumAux;
	}
	
	/**
	 * Aquest mètode crea les relacions de la multillista
	 * 
	 * @param newMat Matricula a afegir
	 */
	public void afegirMatricula (Matricula newMat) {
		int i=0;
		Assignatura assigAux=null;
		Alumne aluAux=null;
		Matricula matAuxAssig=null, matAuxAlum=null;
		try {
			//Busquem la assignatura a la llista
			assigAux=(Assignatura) llistaAssig.consultarPosicio(i);
			while(!newMat.getCodiAssig().equals(assigAux.getCodiAssig())) {
				i++;
				assigAux=(Assignatura) llistaAssig.consultarPosicio(i);
			}
			//Una vegada ja l'hem trobat
			matAuxAssig=assigAux.getMatric();
			i=0;
			aluAux=(Alumne) llistaAlum.consultarPosicio(i);
			//Busquem el alumne a la llista
			while(!newMat.getCodiAlum().equals(aluAux.getCodiAlum())) {
				i++;
				aluAux=(Alumne) llistaAlum.consultarPosicio(i);
			}
			//Una vegada ja l'hem trobat
			matAuxAlum=aluAux.getMatric();
			//Mirem si es la primera relació que hauria de fer en la llista asignatures
			if(matAuxAssig==null) {
				assigAux.setMatric(newMat);
				newMat.setAssignatura(assigAux);
			}
			//Si ja tenim la primera relació feta
			else {
				//Fiquem en la última posició de alumnes
				while(matAuxAssig.getSeguentAlumne()!=null) matAuxAssig=matAuxAssig.getSeguentAlumne();
				//Busquem el ordre de la relacio de la nova matricula amb les que ja hi han respecte als alumnes ja que la assignatura es la mateixa
				while((matAuxAssig.getAnteriorAlumne()!=null) && (aluAux.compareTo(matAuxAssig.getAlumne())<0)) {
					matAuxAssig=matAuxAssig.getAnteriorAlumne();
				}
				if(aluAux.compareTo(matAuxAssig.getAlumne())<0){
					Matricula anterior=matAuxAssig.getAnteriorAlumne();
					matAuxAssig.setAnteriorAlumne(newMat);
					newMat.setSeguentAlumne(matAuxAssig);
					if(anterior!=null){
						anterior.setSeguentAlumne(newMat);
						newMat.setAnteriorAlumne(anterior);
					}
					else assigAux.setMatric(newMat);
				}
				else {
					Matricula seguent=matAuxAssig.getSeguentAlumne();
					matAuxAssig.setSeguentAlumne(newMat);
					newMat.setAnteriorAlumne(matAuxAssig);
					if(seguent!=null){
						seguent.setAnteriorAlumne(newMat);
						newMat.setSeguentAlumne(seguent);
					}
				}
				newMat.setAssignatura(assigAux);
			}
			//Mirem si es la primera relació que hauria de fer en la llista alumnes
			if(matAuxAlum==null) {
				aluAux.setMatric(newMat);
				newMat.setAlumne(aluAux);
			}
			else {
				//Fiquem en la última posició de assignatures
				while(matAuxAlum.getSeguentAssig()!=null) matAuxAlum=matAuxAlum.getSeguentAssig();
				//Busquem el ordre de la relacio de la nova matricula amb les que ja hi han respecte a les assignatures ja que el alumne el mateix
				while((matAuxAlum.getAnteriorAssig()!=null) && (assigAux.compareTo(matAuxAlum.getAssignatura())<0)) {
					matAuxAlum=matAuxAlum.getAnteriorAssig();
				}
				if(assigAux.compareTo(matAuxAlum.getAssignatura())<0){
					Matricula anterior=matAuxAlum.getAnteriorAssig();
					matAuxAlum.setAnteriorAssig(newMat);
					newMat.setSeguentAssig(matAuxAlum);
					if(anterior!=null){
						anterior.setSeguentAssig(newMat);
						newMat.setAnteriorAssig(anterior);
					}
					else aluAux.setMatric(newMat);
				}
				else {
					Matricula seguent=matAuxAlum.getSeguentAssig();
					matAuxAlum.setSeguentAssig(newMat);
					newMat.setAnteriorAssig(matAuxAlum);
					if(seguent!=null){
						seguent.setAnteriorAssig(newMat);
						newMat.setSeguentAssig(seguent);
					}
				}
				newMat.setAlumne(aluAux);
			}
		} catch (LlistaBuida e) {
			e.printStackTrace();
		}
	}
}
