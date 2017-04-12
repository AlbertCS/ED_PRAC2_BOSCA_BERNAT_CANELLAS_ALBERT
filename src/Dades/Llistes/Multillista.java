package Dades.Llistes;
import Exceptions.*;
import Dades.Base.*;

public class Multillista<E extends Comparable<E>,T extends Comparable<T>> {
	private TADLlistaGenerica<E> llistaAssig;
	private TADLlistaGenerica<T> llistaAlum;
	
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
	
	public TADLlistaGenerica<Assignatura> consultarMatriculaAlum (String alum, int tipus) {
		int i=0;
		Alumne alumAux=null;
		Matricula matAux=null;
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
			while(alum.equals(alumAux.getCodiAlum())) {
				i++;
				alumAux=(Alumne) llistaAlum.consultarPosicio(i);
			}
			//Una vegada ja l'hem trobat
			matAux=alumAux.getMatric();
			while(matAux!=null) {
				llistaAssigAux.afegirElement(matAux.getAssignatura());
				matAux=matAux.getSeguentAssig();
			}
		} catch (LlistaPlena|LlistaBuida e) {
			e.printStackTrace();
		}
		//Ojo que si no existeix la relaci� entre assignatura i alumne retornara null
		return llistaAssigAux;
	}
	
	public TADLlistaGenerica<Alumne> consultarMatriculaAssig (Integer assig, int tipus) {
		int i=0;
		Assignatura assigAux=null;
		Matricula matAux=null;
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
			while(assig.equals(assigAux.getCodiAssig())) {
				i++;
				assigAux=(Assignatura) llistaAssig.consultarPosicio(i);
			}
			//Una vegada ja l'hem trobat
			matAux=assigAux.getMatric();
			while(matAux!=null) {
				llistaAlumAux.afegirElement(matAux.getAlumne());
				matAux=matAux.getSeguentAlumne();
			}
		} catch (LlistaPlena|LlistaBuida e) {
			e.printStackTrace();
		}
		//Ojo que si no existeix la relaci� entre assignatura i alumne retornara null
		return llistaAlumAux;
	}
	
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
			//Mirem si es la primera relaci� que hauria de fer en la llista asignatures
			if(matAuxAssig==null) {
				assigAux.setMatric(newMat);
				newMat.setAssignatura(assigAux);
			}
			//Si ja tenim la primera relaci� feta
			else {
				//Busquem el ordre de la relacio de la nova matricula amb les que ja hi han respecte als alumnes ja que la assignatura es la mateixa
				i=0;
				while((matAuxAssig.getAnteriorAlumne()!=null) && (aluAux.compareTo(matAuxAssig.getAlumne())<0)) {
					i++;
					matAuxAssig=matAuxAssig.getAnteriorAlumne();
				}
				if(i==0) assigAux.setMatric(newMat);
				if(aluAux.compareTo(matAuxAssig.getAlumne())<0){
					Matricula anterior=matAuxAssig.getAnteriorAlumne();
					matAuxAssig.setAnteriorAlumne(newMat);
					newMat.setSeguentAlumne(matAuxAssig);
					if(anterior!=null){
						anterior.setSeguentAlumne(newMat);
						newMat.setAnteriorAlumne(anterior);
					}
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
			//Mirem si es la primera relaci� que hauria de fer en la llista alumnes
			if(matAuxAlum==null) {
				aluAux.setMatric(newMat);
				newMat.setAlumne(aluAux);
			}
			else {
				//Busquem el ordre de la relacio de la nova matricula amb les que ja hi han respecte a les assignatures ja que el alumne el mateix
				i=0;
				while((matAuxAlum.getAnteriorAssig()!=null) && (assigAux.compareTo(matAuxAlum.getAssignatura())<0)) {
					i++;
					matAuxAlum=matAuxAlum.getAnteriorAssig();
				}
				if(i==0) aluAux.setMatric(newMat);
				if(assigAux.compareTo(matAuxAlum.getAssignatura())<0){
					Matricula anterior=matAuxAlum.getAnteriorAssig();
					matAuxAlum.setAnteriorAssig(newMat);
					newMat.setSeguentAssig(matAuxAlum);
					if(anterior!=null){
						anterior.setSeguentAssig(newMat);
						newMat.setAnteriorAssig(anterior);
					}
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
