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
	
	public void afegirMatricula (Integer assig, String alum) {
		int i=0;
		Matricula newMat=new Matricula(assig, alum);
		Assignatura assigAux=null;
		Alumne aluAux=null;
		Matricula matAux=null;
		try {
			assigAux=(Assignatura) llistaAssig.consultarPosicio(i);
			while(assig!=assigAux.getCodiAssig()) {
				i++;
				assigAux=(Assignatura) llistaAssig.consultarPosicio(i);
			}
			matAux=assigAux.getMatric();
			if(matAux==null) assigAux.setMatric(newMat);
			else {
				while(matAux.getSeguentAssig()!=null) matAux=matAux.getSeguentAssig();
				matAux.setSeguentAssig(newMat);
			}
			aluAux=(Alumne) llistaAssig.consultarPosicio(i);
			while(alum!=aluAux.getCodiAlum()) {
				i++;
				aluAux=(Alumne) llistaAssig.consultarPosicio(i);
			}
			aluAux.setMatric(newMat);
		} catch (LlistaBuida e) {
			e.printStackTrace();
		}
	}
}
