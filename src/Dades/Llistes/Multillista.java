package Dades.Llistes;
import Exceptions.*;
import Dades.Base.*;

public class Multillista<T extends Comparable<T>> {
	private TADLlistaGenerica<T> llistaAssig;
	private TADLlistaGenerica<T> llistaAlum;
	
	public Multillista(TADLlistaGenerica<T> llistaAssig, TADLlistaGenerica<T> llistaAlum, int tipus) {
		switch(tipus){
			case 1:
				this.llistaAssig=new LlistaEstatica<T>(llistaAssig.numElems());
				this.llistaAlum=new LlistaEstatica<T>(llistaAlum.numElems()); break;
			case 2:
				this.llistaAssig=new LlistaDinamica<T>();
				this.llistaAlum=new LlistaDinamica<T>(); break;
			case 3: break;
			default: break;
		}
		try{
			for (int i=0; i<llistaAssig.numElems(); i++) 
				this.llistaAssig.afegirElement(llistaAssig.consultarPosicio(i));
			for (int i=0; i<llistaAssig.numElems(); i++) 
				this.llistaAlum.afegirElement(llistaAlum.consultarPosicio(i));
		} catch (LlistaPlena|LlistaBuida e){
			System.out.println("Aquesta circunstancia no deuria de passar mai.");
		}
	}
	
	public Matricula consultarMatricula (Integer assig, String alum) {
		int i=0;
		Assignatura assigAux=null;
		Matricula matAux=null;
		try {
			//Busquem la assignatura a la llista
			assigAux=(Assignatura) llistaAssig.consultarPosicio(i);
			while(assig!=assigAux.getCodiAssig()) {
				i++;
				assigAux=(Assignatura) llistaAssig.consultarPosicio(i);
			}
			//Una vegada ja l'hem trobat
			matAux=assigAux.getMatric();
			//Busquem la relacio entre aquesta asignatura i el alumne
			while((matAux.getSeguentAssig()!=null)&&(matAux.getAlum()!=alum)) matAux=matAux.getSeguentAssig();
		} catch (LlistaBuida e) {
			e.printStackTrace();
		}
		//Ojo que si no existeix la relació entre assignatura i alumne retornara null
		return matAux;
	}
	
	public void afegirMatricula (Integer assig, String alum) {
		int i=0;
		Matricula newMat=new Matricula(assig, alum);
		Assignatura assigAux=null;
		Alumne aluAux=null;
		Matricula matAux=null;
		try {
			//Busquem la assignatura a la llista
			assigAux=(Assignatura) llistaAssig.consultarPosicio(i);
			while(assig!=assigAux.getCodiAssig()) {
				i++;
				assigAux=(Assignatura) llistaAssig.consultarPosicio(i);
			}
			//Una vegada ja l'hem trobat
			matAux=assigAux.getMatric();
			//Mirem si es la primera relació que hauria de fer o deuria ser referenciada
			if(matAux==null) assigAux.setMatric(newMat);
			//Si ja tenim la primera relació
			else {
				//Busquem que no existisca previament una relacio amb aquesta asignatura i el mateix alumne
				while((matAux.getSeguentAssig()!=null)&&(matAux.getAlum()!=alum)) matAux=matAux.getSeguentAssig();
				//Sino existeix cap relacio amb aquesta asignatura i aquest alumne
				if((matAux.getSeguentAssig()==null)&&(matAux.getAlum()!=alum)) {
					matAux.setSeguentAssig(newMat);
					newMat.setAnteriorAssig(matAux);
				}
			}
			i=0;
			aluAux=(Alumne) llistaAssig.consultarPosicio(i);
			while(alum!=aluAux.getCodiAlum()) {
				i++;
				aluAux=(Alumne) llistaAssig.consultarPosicio(i);
			}
			matAux=aluAux.getMatric();
			if(matAux==null) aluAux.setMatric(newMat);
			else {
				while((matAux.getSeguentAlumne()!=null)&&(matAux.getAssig()!=assig)) matAux=matAux.getSeguentAlumne();
				if((matAux.getSeguentAlumne()==null)&&(matAux.getAssig()!=assig)) {
					matAux.setSeguentAlumne(newMat);
					newMat.setAnteriorAlumne(matAux);
				}
			}
		} catch (LlistaBuida e) {
			e.printStackTrace();
		}
	}
}
