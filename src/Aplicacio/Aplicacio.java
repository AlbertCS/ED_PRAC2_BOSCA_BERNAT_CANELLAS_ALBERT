package Aplicacio;

import Dades.Base.*;
import java.io.*;
import java.util.*;
import Exceptions.*;
import Dades.Llistes.*;

/**
 * Class per testejar el programa
 * 	 
 * @author Albert Cañellas Solé
 * @author Bernat Bosca Candel
 *
 */

public class Aplicacio {
		
	/**
	 * Metode que mostra un menu per indicar el tipus d'implementacio.
	 * @param teclat variable de tipus Scanner
	 * @return	opcio escollida
	 */
	public static int tipusImplementacio(Scanner teclat) {
		boolean opcioOk=true;
		String op;
		int opcio=0;
			
		System.out.println("Indica tipus de llista a utilitzar:\n\t1. Estàtica\n\t2. Dinàmica\n\t3. JavaCollection");
		op=teclat.nextLine();
		if(Character.isDigit(op.charAt(0))) opcio=Integer.parseInt(op);
		
		while(opcioOk){
			switch(opcio){
				case 1: 
					opcioOk=false; break;
				case 2: 
					opcioOk=false; break;
				case 3: 
					opcioOk=false; break;
				default:
					System.out.println("Valor incorrecte. Indica tipus de llista a utilitzar:\n\t1. Estàtica\n\t2. Dinàmica\n\t3. JavaCollection");
					op=teclat.nextLine();
					if(Character.isDigit(op.charAt(0))) opcio=Integer.parseInt(op); break;
			}
		}
		return opcio;
	}
		
	/**
	 * Metode que crea el tipus de llista corresponent
	 * @param opcio implementacio escollida
	 * @param mida dimensio de la llista
	 * @param llista la llista implementada
	 * @return llista inicialitzada
	 */
	public static TADLlistaGenerica<Alumne> implementacioLlistaAlum(int opcio, int mida, TADLlistaGenerica<Alumne> llista) {
		switch(opcio){
			case 1:
				llista=new LlistaEstatica<Alumne>(mida); break;
			case 2:
				llista=new LlistaDinamica<Alumne>(); break;
			case 3: 
				llista=new LlistaJava<Alumne>(); break;
			default: break;
		}
		return llista;
	}
	
	public static TADLlistaGenerica<Assignatura> implementacioLlistaAssig(int opcio, int mida, TADLlistaGenerica<Assignatura> llista) {
		switch(opcio){
			case 1:
				llista=new LlistaEstatica<Assignatura>(mida); break;
			case 2:
				llista=new LlistaDinamica<Assignatura>(); break;
			case 3: 
				llista=new LlistaJava<Assignatura>(); break;
			default: break;
		}
		return llista;
	}

	
	/**
	 * Metode que tractara les dades amb el metode triat
	 * @param nomFitxer	nom del fitxer d'on es llegirant les dades, amb aquest nom es creara el fitxer on guardar les dades
	 * @param llistaAlumne llista d'alumnes
	 * @param llistaAssignatura llista d'assignatures
	 */
	public static void cargarLlistes(String nomFitxer, TADLlistaGenerica<Alumne> llistaAlumne, TADLlistaGenerica<Assignatura> llistaAssignatura) {
		
		try {
			//Variables
			BufferedReader f=new BufferedReader(new FileReader(nomFitxer));
			String frase, nomAssig, quad, nomAlum, codiAlum;
			Integer credits, curs, quadri,codiAssig;			
			frase=f.readLine();
			while(frase!=null){ 
				StringTokenizer st = new StringTokenizer(frase, ";");
				codiAssig=Integer.parseInt(st.nextToken());
				nomAssig=st.nextToken();
				credits=Integer.parseInt(st.nextToken());
				curs=Integer.parseInt(st.nextToken());
				quad=st.nextToken();
				quadri=(int) (quad.charAt(0))-48;
				Assignatura auxAssig= new Assignatura(codiAssig, nomAssig, credits, curs, quadri);
				llistaAssignatura.afegirElement(auxAssig);
				codiAlum=st.nextToken();
				nomAlum=st.nextToken();
				Alumne auxAlum=new Alumne (codiAlum, nomAlum);
				llistaAlumne.afegirElement(auxAlum);
				
				frase = f.readLine();
			}
			f.close();
			}catch (IOException | LlistaPlena e) {
				System.err.println("Error de tipus IOException.");
			}
	}
	
	/**
	 * Metode per inicialitzar tots els nodes realcio de la multillista
	 * @param nomFitxer nom del fitxer d'on es llegirant les dades
	 * @param multilist la multillista on es ficaran els nodes relacio
	 */
	public static void cargarMultilist(String nomFitxer, Multillista<Assignatura, Alumne> multilist) {
		
		try {
		//Variables
		BufferedReader f=new BufferedReader(new FileReader(nomFitxer));
		String frase, codiAlum;
		Integer codiAssig;
			
		frase=f.readLine();
		while(frase!=null){ 
			StringTokenizer st = new StringTokenizer(frase, ";");
				
			codiAssig=Integer.parseInt(st.nextToken());
			st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
			codiAlum=st.nextToken();
			st.nextToken();
				
			multilist.afegirMatricula(new Matricula(codiAssig, codiAlum));
			
			frase = f.readLine();
		}
		
		f.close();
		}catch (IOException e) {
			System.err.println("Error de tipus IOException.");
		}
	}
	
	/**
	 * Metode que comprova que el nom del fitxer sigui correcte
	 * @param teclat variable de tipus Scanner
	 * @return nomFitxer retorna el nom del teclat
	 */
	public static String nomCorrecte(Scanner teclat) {
		String nomFitxer;
		boolean isOk=true;
		
		System.out.println("\nIndica el nom del fitxer. Si no has creat cap, el nom que has de ficar és 'DadesMatricula.csv' o 'text.txt'.");
		nomFitxer=teclat.nextLine();
		File nameFile = new File(nomFitxer);
		while(isOk){
			if(nameFile.isFile()) isOk=false;
			else {
				System.out.println("El fitxer amb el nom "+nomFitxer+" NO existeix. Indica un altre nom: ");
				nomFitxer=teclat.nextLine();
				nameFile = new File(nomFitxer);
			}
		}
		return nomFitxer;
	}
	
	/**
	 * Metode que mitjançant el codi d'un alumne, ens mostra les dades de les assignatures cursades i el numero total de credits
	 * @param codeAlum codi de l'alumne que es vol consultar
	 * @param tipus tipus d'implementacio de les llistes
	 * @param multilist la multillista on trobem les relacions
	 * @throws LlistaBuida excepcio si la llista esta buida
	 */
	public static void consultaPerCodiAl(String codeAlum, int tipus,  Multillista<Assignatura, Alumne> multilist) throws LlistaBuida{
		TADLlistaGenerica<Assignatura> llistaAss;
		int totalCredits=0;		
		
		llistaAss=multilist.consultarMatriculaAlum(codeAlum, tipus);
		if(llistaAss==null) System.out.println("\nEl alumne no es troba matriculat en cap assignatura de la URV.");
		else{
			System.out.println("");			//Salt de linea
			for(int i=0; i<llistaAss.numElems(); i++){
				System.out.println("\t"+(i+1)+". "+llistaAss.consultarPosicio(i).toString());
				totalCredits+=llistaAss.consultarPosicio(i).getCredits();
			}
			System.out.println("\n\tNúmero de crèdits totals: "+totalCredits);
		}
	}
	
	/**
	 * Metode que mitjançant el codi d'una assignatura ens mostra els noms del alumnes que la cursen i el seu total d'alumnes
	 * @param codeAss codi de l'assignatura que es vol consultar
	 * @param tipus tipus d'implementacio de les llistes
	 * @param multilist la multillista on trobem les relacions
	 * @throws LlistaBuida excepcio si la llista esta buida
	 */
	public static void consultaPerAss(int codeAss, int tipus, Multillista<Assignatura, Alumne> multilist) throws LlistaBuida{
		TADLlistaGenerica<Alumne> llistaAlu;
		int i;
		
		llistaAlu=multilist.consultarMatriculaAssig(codeAss, tipus);
		if(llistaAlu==null) System.out.println("\nNo existeix aquesta assignatura o no té cap alumne matriculat.");
		else{
			System.out.println("");			//Salt de linea
			for(i=0; i<llistaAlu.numElems(); i++){
				System.out.println("\t"+(i+1)+". "+llistaAlu.consultarPosicio(i).getNomAlum());
			}
			System.out.println("\n\tTotal d'alumnes: "+i);
		}
	}
	
	/**
	 * Metode que mostra els alumnes que han matriculat x credits o menys 
	 * @param creditsMin el minim de credtis
	 * @param tipus tipus d'implementacio de les llistes
	 * @param llistaAlumne la llista d'alumnes
	 * @param multilist la multillista on trobem les relacions
	 * @throws LlistaBuida excepcio si la llista esta buida
	 */
	public static void alumCredits(int creditsMin, int tipus, TADLlistaGenerica<Alumne> llistaAlumne, Multillista<Assignatura, Alumne> multilist) throws LlistaBuida{
		TADLlistaGenerica<Assignatura> llistaAss;
		int totalCredits=0, num=1;		
		
		System.out.println("");			//Salt de linea
		for(int i=0; i<llistaAlumne.numElems(); i++){
			llistaAss=multilist.consultarMatriculaAlum(llistaAlumne.consultarPosicio(i).getCodiAlum(), tipus);
			if(llistaAss!=null){
				totalCredits=0;
				for(int y=0; y<llistaAss.numElems(); y++){
					totalCredits+=llistaAss.consultarPosicio(y).getCredits();
				}
				if(totalCredits<=creditsMin){
					System.out.println("\t"+num+". "+llistaAlumne.consultarPosicio(i).toString()+" i crèdits totals: "+totalCredits);
					num++;
				}
			}	
		}
		if(num==1) System.out.println("\tNo hi ha cap alumne amb "+creditsMin+ " o menys.");
	}
	
	/**
	 * Metode que mostra les assignatures amb un minim numero de alumnes matriculats
	 * @param estudiantsMin numero minim d'alumnes matriculats
	 * @param tipus tipus d'implementacio de les llistes
	 * @param llistaAssignatura la llista d'assignatures
	 * @param multilist la multillista on trobem les relacions
	 * @throws LlistaBuida excepcio si la llista esta buida
	 */
	public static void assigAlums(int estudiantsMin, int tipus, TADLlistaGenerica<Assignatura> llistaAssignatura, Multillista<Assignatura, Alumne> multilist) throws LlistaBuida{
		TADLlistaGenerica<Alumne> llistaAlu;
		int num=1;
		
		System.out.println("");	
		for(int i=0; i<llistaAssignatura.numElems(); i++){
			llistaAlu=multilist.consultarMatriculaAssig(llistaAssignatura.consultarPosicio(i).getCodiAssig(), tipus);
			if(llistaAlu!=null){
				if(llistaAlu.numElems()>=estudiantsMin){
					System.out.println("\t"+num+". "+llistaAssignatura.consultarPosicio(i).toString()+" i estudiants totals: "+llistaAlu.numElems());
					num++;
				}
			}	
		}
		if(num==1) System.out.println("\tNo hi ha cap assignatura que tingui un mínim de "+estudiantsMin+" estudiants.");
	}
	
	/**
	 * Metode auxiliar que serveix per preguntar els valors necesaris que te d'introduir l'usuari, i comprova que siguin correctes
	 * @param opcioM numero de la consulta escollida
	 * @param teclat variable de tipus scanner
	 * @return valor introduit per l'alumne correctament
	 */
	public static int demanarUsuari(int opcioM, Scanner teclat) {
		int x=0, i;
		String y="";
		boolean ok=true;
		switch(opcioM){
			case 2:
				//consultar per assignatura
				boolean bien=false;
				int contador=0;
				Character a='a', b='b';
				String codiCorrecte="17234";
				
				System.out.println("Escriu el codi de la assignatura a consultar: ");
				y=teclat.nextLine();
				i=0;
				
				while(ok){
					//Comprovem que els 5 primers digits es correspongen amb 17234
					while((!bien) && (i<5)) {
						if(i<y.length()) a=y.charAt(i);
						b=codiCorrecte.charAt(i);
						if(a.equals(b)) contador++;
						i++;
					}
					//Si es correcte bien=true;		
					if(i==contador) bien=true;
					else bien=false;
					//Comprovem que la resta de caracters siguen digits
					while((i<y.length())&&(ok)){
						if(Character.isDigit(y.charAt(i)))	i++;
						else ok=false;
					}
					//Si es cumpleix que els 5 primers nombres son 17234 i a més té altres 3 dígits considerarem el codi correcte i surtira del while
					if((i==8) && (bien)) ok=false;
					else {
						i=0; contador=0;
						ok=true; bien=false;
						System.out.println("\nCodi incorrecte. Escriu el codi de la assignatura a consultar: ");
						y=teclat.nextLine();
					}
				}
				x=Integer.parseInt(y);
				break;
			case 3: 
				//alumnes amb min credits
				System.out.println("\nEscriu el número de credits màxims que pot tenir un alumne: ");
				y=teclat.nextLine();
				i=0;
				
				while(ok){
					while((i<y.length())&&(ok)){
						if(Character.isDigit(y.charAt(i))) i++;
						else ok=false;
					}
					if(i==y.length()) ok=false;
					else {
						i=0;
						ok=true;
						System.out.println("Número incorrecte. Escriu el número de credits màxims que pot tenir un alumne: ");
						y=teclat.nextLine();
					}
				}
				x=Integer.parseInt(y);
				break;
			case 4:
				//assig per min alums
				System.out.println("Escriu el número mínim d'alumnes: ");
				y=teclat.nextLine();
				i=0;
				
				while(ok){
					while((i<y.length())&&(ok)){
						if(Character.isDigit(y.charAt(i))) i++;
						else ok=false;
					}
					if(i==y.length()) ok=false;
					else {
						i=0;
						ok=true;
						System.out.println("Número incorrecte. Escriu el número mínim d'alumnes: ");
						y=teclat.nextLine();
					}
				}
				x=Integer.parseInt(y);
				break;
			default:
				break;
		}
		return x;
	}
	
	/**
	 * Metode que comprova que el codi del alumne sigui correcte
	 * @param teclat variable de tipus Scanner
	 * @return codi retorna el nom del alumne
	 */
	public static String codiAlumCorrecte(Scanner teclat) {
		boolean opcioOk=true, bien=false, ok=true;
		String codi, codiCorrecte="URV_0";
		int i=0, contador=0;
		Character a='a', b='b';
			
		System.out.println("\nEscriu el codi del alumne a consultar: ");
		codi=teclat.nextLine();
		
		while(opcioOk) {
			while((!bien) && (i<5)) {
				if(i<codi.length()) a=codi.charAt(i);
				b=codiCorrecte.charAt(i);
				if(a.equals(b)) contador++;
				i++;
			}
			
			if(i==contador) bien=true;
			else bien=false;
			
			while((i<codi.length())&&(ok)){
				if(Character.isDigit(codi.charAt(i)))	i++;
				else ok=false;
			}
			
			if((i==8) && (bien)) opcioOk=false;
			else {
				i=0; contador=0;
				ok=true; bien=false;
				System.out.println("\nEl codi del alumne es incorrecte. Escriu el codi del alumne a consultar: ");
				codi=teclat.nextLine();
			}
		}
		return codi;
	}
	
	/**
	 * Metode que mostra les diferents consultes perque el usuari triï una.
	 * @param opcio tipus d'implementacio de les llistes
	 * @param llistaAlumne la llista d'alumnes
	 * @param llistaAssignatura la llista d'assignatures
	 * @param multilist  la multillista on trobem les relacions
	 * @param teclat variable de tipus scanner
	 */
	public static void menu(int opcio, TADLlistaGenerica<Alumne> llistaAlumne, TADLlistaGenerica<Assignatura> llistaAssignatura, Multillista<Assignatura, Alumne> multilist, Scanner teclat){
		int opcioM=1, x;
		long tempsi=0, tempsf=0;
		String op, codeAlum;
		boolean ok=true;
		
		while(ok) {
			if((opcioM>0)&&(opcioM<5)) {
				System.out.println("\n\nMenú de consultes:\n\t1. Consulta per Codi del Alumne.\n\t2. Consulta per Codi Assignatura.\n\t3. Alumnes amb X crèdits o menys.\n\t4. Assignatures amb Y alumnes com a mínim.\n\t5. Sortir del menú.");
				op=teclat.nextLine();
				if(Character.isDigit(op.charAt(0))) opcioM=Integer.parseInt(op);
				else  opcioM=10; //valor incorrecte
			}
		
			switch(opcioM){
				case 1: 
					try {
						codeAlum=codiAlumCorrecte(teclat);
						tempsi=System.nanoTime();
						consultaPerCodiAl(codeAlum, opcio, multilist);
						tempsf=System.nanoTime();
						System.out.println("\nEl programa ha tardat: "+(tempsf-tempsi)+"ns.");
					} catch (LlistaBuida e) {
						e.printStackTrace();
					}
					break;
				case 2: 
					try {
						x=demanarUsuari(opcioM, teclat);
						tempsi=System.nanoTime();
						consultaPerAss(x, opcio, multilist);
						tempsf=System.nanoTime();
						System.out.println("\nEl programa ha tardat: "+(tempsf-tempsi)+"ns.");
					} catch (LlistaBuida e) {
						e.printStackTrace();
					}
					break;
				case 3: 
					try {
						x=demanarUsuari(opcioM, teclat);
						tempsi=System.nanoTime();
						alumCredits(x, opcio, llistaAlumne, multilist);
						tempsf=System.nanoTime();
						System.out.println("\nEl programa ha tardat: "+(tempsf-tempsi)+"ns.");
					} catch (LlistaBuida e) {
						e.printStackTrace();
					}
					break;
				case 4:
					try {
						x=demanarUsuari(opcioM, teclat);
						tempsi=System.nanoTime();
						assigAlums(x, opcio, llistaAssignatura, multilist);
						tempsf=System.nanoTime();
						System.out.println("\nEl programa ha tardat: "+(tempsf-tempsi)+"ns.");
					} catch (LlistaBuida e) {
						e.printStackTrace();
					}
					break;
				case 5:
					ok=false;
					System.out.println("\nHeu sortit del menú.");
					break;
				default:
					System.out.println("\nValor incorrecte.\n\tMenú de consultes:\n\t1. Consulta per Codi del Alumne.\n\t2. Consulta per Codi Assignatura.\n\t3. Alumnes amb X crèdits o menys.\n\t4. Assignatures amb Y alumnes com a mínim.\n\t5. Sortir del menú.");
					op=teclat.nextLine();
					if(Character.isDigit(op.charAt(0))) opcioM=Integer.parseInt(op);
					break;
			}
		}
	}

	/**
	 * 	/-Main-/
	 * @param args args
	 */
	public static void main(String[] args) {
		//Assignatura[] assiglist= new Assignatura [1000];
		//Alumne[] alumlist=new Alumne [1000];
		Scanner teclat=new Scanner(System.in);
		TADLlistaGenerica<Alumne> llistaAlumne=null;
		TADLlistaGenerica<Assignatura> llistaAssignatura=null;
		Multillista<Assignatura, Alumne> multilist=null;
		String nomFitxer="DadesMatricula.csv";
		int opcio;
		long tempsi, tempsf;
		
		//Tipus de implementació
		opcio=3;//=tipusImplementacio(teclat);
		
		//Nom fitxer
		//nomFitxer=nomCorrecte(teclat);
		
		//Operacions
		tempsi=System.nanoTime();
		llistaAlumne=implementacioLlistaAlum(opcio, 1000, llistaAlumne);
		llistaAssignatura=implementacioLlistaAssig(opcio, 50, llistaAssignatura);
		cargarLlistes(nomFitxer, llistaAlumne, llistaAssignatura);
		multilist=new Multillista<Assignatura, Alumne>(llistaAssignatura, llistaAlumne, opcio);
		cargarMultilist(nomFitxer, multilist);
		tempsf=System.nanoTime();
		System.out.println("\nLa carrega de les dades ha tardat: "+(tempsf-tempsi)+"ns.");
		
		menu(opcio, llistaAlumne, llistaAssignatura, multilist, teclat);
					
		System.out.println("\nEl programa ha finalitzat.\n");
		
		teclat.close();
	}
}
