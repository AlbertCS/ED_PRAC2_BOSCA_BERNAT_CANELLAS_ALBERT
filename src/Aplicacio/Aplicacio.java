package Aplicacio;
import Dades.Base.*;


import java.io.*;
import java.util.*;

import Exceptions.*;
import Dades.*;
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
<<<<<<< HEAD
					System.out.println("Valor incorrecte. Indica tipus de cua a utilitzar:\n\t1. Estàtica\n\t2. Dinàmica\n\t3. JavaCollection");
=======
					System.out.println("Valor incorrecte. Indica tipus de llista a utilitzar:\n\t1. Estàtica\n\t2. Dinàmica\n\t3. JavaCollection");
>>>>>>> refs/remotes/origin/master
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
	 * @param cua	la llista implementada
	 */
<<<<<<< HEAD
	public static void implementacio(int opcio, int mida, TADLlistaGenerica<Alumne> llistaAlumne, TADLlistaGenerica<Assignatura> llistaAssignatura) {
		switch(opcio){
			case 1:
				llistaAlumne=new LlistaEstatica<Alumne>(mida); 
				llistaAssignatura=new LlistaEstatica<Assignatura>(mida); break;
			case 2:
				llistaAlumne=new LlistaDinamica<Alumne>(); 
				llistaAssignatura=new LlistaDinamica<Assignatura>(); break;
			case 3:
				llistaAlumne=new LlistaJava<Alumne>(); 
				llistaAssignatura=new LlistaJava<Assignatura>(); break;
			default: break;
		}
	}
	
	
=======
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
>>>>>>> refs/remotes/origin/master
	
	/**
	 * Metode que tractara les dades amb el metode triat
	 * @param nomFitxer	nom del fitxer d'on es llegirant les dades, amb aquest nom es creara el fitxer on guardar les dades
	 * @param cuaClau cua que conte la clau
	 * @param signe indica si s'ha de sumar(xifrar) o restar(desxifrar)
	 */
<<<<<<< HEAD
	public static void cargarDades(String nomFitxer, TADLlistaGenerica<Alumne> llistaAlumne, TADLlistaGenerica<Assignatura> llistaAssignatura) {
		
		try {
			//Variables
			BufferedReader f=new BufferedReader(new FileReader(nomFitxer+".csv"));
			String frase, nomAssig, nomAlum, codiAlum;
			Character a;
			Integer num, credits, curs, quad, codiAss;
=======
	public static void cargarLlistes(String nomFitxer, TADLlistaGenerica<Alumne> llistaAlumne, TADLlistaGenerica<Assignatura> llistaAssignatura) {
		
		try {
			//Variables
			BufferedReader f=new BufferedReader(new FileReader(nomFitxer));
			String frase, nomAssig, quad, nomAlum, codiAlum;
			Integer credits, curs, quadri,codiAssig;
>>>>>>> refs/remotes/origin/master
			
			frase=f.readLine();
			while(frase!=null){ 
				StringTokenizer st = new StringTokenizer(frase, ";");
				
<<<<<<< HEAD
					codiAss=Integer.parseInt(st.nextToken());
					nomAssig=st.nextToken();
					credits=Integer.parseInt(st.nextToken());
					curs=Integer.parseInt(st.nextToken());
					quad=Integer.parseInt(st.nextToken());
					Assignatura auxass= new Assignatura(codiAss, nomAssig, credits, curs, quad);
					afegirAssignatura(auxass);
					codiAlum=st.nextToken();
					nomAlum=st.nextToken();
					Alumne auxal=new Alumne (codiAlum, nomAlum);
					afegirAlumne(auxal);
				
					frase = f.readLine();
			}
			
			f.close();
			}catch (IOException e) {
=======
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
>>>>>>> refs/remotes/origin/master
				System.err.println("Error de tipus IOException.");
			}
	}
	
<<<<<<< HEAD
	public void afegirAssignatura(Assignatura assig){
		
	}
	
	public void afegirAlumne(Alumne alum){
		
	}
	
=======
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
	
	public void afegirAssignatura(Assignatura assig){
		
	}
	
	public void afegirAlumne(Alumne alum){
		
	}
	
>>>>>>> refs/remotes/origin/master
	
	/**
	 * Metode que comprova que el nom del fitxer sigui correcte
	 * @param teclat variable de tipus Scanner
	 * @return nomFitxer retorna el nom del teclat
	 */
	public static String nomCorrecte(Scanner teclat) {
		String nomFitxer;
		boolean isOk=true;
		
		System.out.println("Indica el nom del fitxer. Si no has creat cap, el nom que has de ficar és 'DadesMatricula.csv' o 'text.txt'.");
		nomFitxer=teclat.nextLine();
<<<<<<< HEAD
		File nameFile = new File(nomFitxer+".csv");
=======
		File nameFile = new File(nomFitxer);
>>>>>>> refs/remotes/origin/master
		while(isOk){
			if(nameFile.isFile()) isOk=false;
			else {
				System.out.println("El fitxer amb el nom "+nomFitxer+" NO existeix. Indica un altre nom: ");
				nomFitxer=teclat.nextLine();
<<<<<<< HEAD
				nameFile = new File(nomFitxer+".csv");
=======
				nameFile = new File(nomFitxer);
>>>>>>> refs/remotes/origin/master
			}
		}
		return nomFitxer;
	}
	
	
	public static void consultaperCodiAl(){
		
		
	}
	
	public static void consultaperAss(){
		
<<<<<<< HEAD
		
	}
	
	public static void alumcredits(){
		
		
	}
	
	public static void assigalums(){
		
		
	}
	
=======
		
	}
	
	public static void alumcredits(){
		
		
	}
	
	public static void assigalums(){
		
		
	}
	
>>>>>>> refs/remotes/origin/master
	
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
		String nomFitxer;
<<<<<<< HEAD
		int opcio, dim=1000;
=======
		int opcio;
>>>>>>> refs/remotes/origin/master
		long tempsi=0, tempsf=0;
		
		//Tipus de implementació
		opcio=1;//tipusImplementacio(teclat);
		
		//Nom fitxer
		nomFitxer="DadesMatricula.csv";//nomCorrecte(teclat);
		
		//Operacions
<<<<<<< HEAD
		
		implementacio(opcio, dim, llistaAlumne, llistaAssignatura);
		cargarDades(nomFitxer, llistaAlumne, llistaAssignatura);
		
		
		
=======
		llistaAlumne=implementacioLlistaAlum(opcio, 1000, llistaAlumne);
		llistaAssignatura=implementacioLlistaAssig(opcio, 50, llistaAssignatura);
		cargarLlistes(nomFitxer, llistaAlumne, llistaAssignatura);
		multilist=new Multillista<Assignatura, Alumne>(llistaAssignatura, llistaAlumne, opcio);
		cargarMultilist(nomFitxer, multilist);
		
		/*
>>>>>>> refs/remotes/origin/master
		//Menu
		int opcioM=0;
		
		String op;
		System.out.println("Menu de consultes:\n\t1. Consulta per Codi del Alumne\n\t2. Consulta per Codi Assignatura\n\t3. Alumnes amb x credits o menys\n4. Assignatures amb x alumnes o menys");
		op=teclat.nextLine();
		if(Character.isDigit(op.charAt(0))) opcioM=Integer.parseInt(op);
		
			switch(opcioM){
				case 1: 
					tempsi=System.nanoTime();
					consultaperCodiAl();
					tempsf=System.nanoTime();
					break;
				case 2: 
					tempsi=System.nanoTime();
					consultaperAss();
					tempsf=System.nanoTime();
					break;
				case 3: 
					tempsi=System.nanoTime();
					alumcredits();
					tempsf=System.nanoTime();
					break;
				case 4:
					tempsi=System.nanoTime();
					assigalums();
					tempsf=System.nanoTime();
					break;
				default:
					System.out.println("Valor incorrecte.\tMenu de consultes:\n\t1. Consulta per Codi del Alumne\n\t2. Consulta per Codi Assignatura\n\t3. Alumnes amb x credits o menys\n4. Assignatures amb x alumnes o menys");
					op=teclat.nextLine();
					if(Character.isDigit(op.charAt(0))) opcioM=Integer.parseInt(op); break;
			}
<<<<<<< HEAD
		
=======
			*/
>>>>>>> refs/remotes/origin/master
		
		System.out.println("Les Dades s'han tractat correctament.\n");
		System.out.println("El programa ha tardat: "+(tempsf-tempsi)+"ns.");
		
		teclat.close();
	}
}
