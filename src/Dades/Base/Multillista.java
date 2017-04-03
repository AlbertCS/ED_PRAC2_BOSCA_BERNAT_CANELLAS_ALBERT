package Dades.Base;
import Dades.Llistes.LlistaDinamica;
import Dades.Llistes.LlistaEstatica;
import Dades.Llistes.TADLlistaGenerica;
import Exceptions.*;

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
}
