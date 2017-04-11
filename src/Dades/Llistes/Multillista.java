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
			//Busquem el laumne a la llista
			alumAux=(Alumne) llistaAlum.consultarPosicio(i);
			while(alum!=alumAux.getCodiAlum()) {
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
		//Ojo que si no existeix la relació entre assignatura i alumne retornara null
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
			while(assig!=assigAux.getCodiAssig()) {
				i++;
				assigAux=(Assignatura) llistaAssig.consultarPosicio(i);
			}
			//Una vegada ja l'hem trobat
			matAux=assigAux.getMatric();
			while(matAux!=null) {
				llistaAlumAux.afegirElement(matAux.getAlumne());
				matAux=matAux.getSeguentAssig();
			}
		} catch (LlistaPlena|LlistaBuida e) {
			e.printStackTrace();
		}
		//Ojo que si no existeix la relació entre assignatura i alumne retornara null
		return llistaAlumAux;
	}
	
	public void afegirMatricula (Matricula newMat) {
		int i=0;
		Assignatura assigAux=null;
		Alumne aluAux=null;
		Matricula matAux=null;
		try {
			//Busquem la assignatura a la llista
			assigAux=(Assignatura) llistaAssig.consultarPosicio(i);
			while(!newMat.getCodiAssig().equals(assigAux.getCodiAssig())) {
				i++;
				assigAux=(Assignatura) llistaAssig.consultarPosicio(i);
			}
			//Una vegada ja l'hem trobat
			matAux=assigAux.getMatric();
			//Mirem si es la primera relació que hauria de fer o deuria ser referenciada
			if(matAux==null) {
				assigAux.setMatric(newMat);
				newMat.setAssignatura(assigAux);
			}
			//Si ja tenim la primera relació
			else {
				//Busquem que no existisca previament una relacio amb aquesta asignatura i el mateix alumne
				while((matAux.getSeguentAssig()!=null)&&(!matAux.getCodiAlum().equals(newMat.getCodiAlum()))) matAux=matAux.getSeguentAssig();
				//Sino existeix cap relacio amb aquesta asignatura i aquest alumne
				if((matAux.getSeguentAssig()==null)&&(!matAux.getCodiAlum().equals(newMat.getCodiAlum()))) {
					matAux.setSeguentAssig(newMat);
					newMat.setAnteriorAssig(matAux);
					newMat.setAssignatura(assigAux);
				}
			}
			i=0;
			aluAux=(Alumne) llistaAlum.consultarPosicio(i);
			//Busquem el alumne a la llista
			while(!newMat.getCodiAlum().equals(aluAux.getCodiAlum())) {
				i++;
				aluAux=(Alumne) llistaAlum.consultarPosicio(i);
			}
			//Una vegada ja l'hem trobat
			matAux=aluAux.getMatric();
			//Mirem si es la primera relació que hauria de fer o deuria ser referenciada
			if(matAux==null) {
				aluAux.setMatric(newMat);
				newMat.setAlumne(aluAux);
			}
			else {
				//Busquem que no existisca previament una relacio amb aquesta asignatura i el mateix alumne
				while((matAux.getSeguentAlumne()!=null)&&(!matAux.getCodiAssig().equals(newMat.getCodiAssig()))) matAux=matAux.getSeguentAlumne();
				//Sino existeix cap relacio amb aquesta asignatura i aquest alumne
				if((matAux.getSeguentAlumne()==null)&&(!matAux.getCodiAssig().equals(newMat.getCodiAssig()))) {
					matAux.setSeguentAlumne(newMat);
					newMat.setAnteriorAlumne(matAux);
					newMat.setAlumne(aluAux);
				}
			}
		} catch (LlistaBuida e) {
			e.printStackTrace();
		}
	}
}
