package edu.eci.cvds.bean;

import java.util.ArrayList;
import java.util.Random;
import javax.faces.bean.*;

import java.util.Scanner;


@ManagedBean(name = "calculadoraBean") 
/**
 *
 * @author DanielVaron-SebastianVillamarin
 */
@ApplicationScoped
//@SessionScoped
public class calculadoraBean {
	private ArrayList<Integer> datos=new ArrayList<Integer>();
	private int prom=0;
	private int numero=0;
	private int indice;
	private int valormoda;
	Scanner reader = new Scanner(System.in);
	public calculadoraBean(){
        restart();
    }
	public double calculateMean(ArrayList<Integer> promedio) {
		//int[] valoresPromedio = int[] promedio;
		for(int i=0; i<promedio.size();i++) {
			prom+=promedio.get(i);
		}
		return prom=prom/promedio.size();
	}
	public void calculateStandardDeviation(ArrayList<Integer> dEstandar) {
		double prome, sum = 0;
		int n = dEstandar.size();
		double desviacion;
		prome = calculateMean(dEstandar);
		for(int i=0; i<dEstandar.size();i++) {
			sum += Math.pow (dEstandar.get(i)- prome, 2 );
		}
		desviacion = Math.sqrt (sum/( double)n);
	}
	
	public void calculateVariance(ArrayList<Integer> varianza) {
		double acMedia = 0, acMedia2 = 0;
		for(int i=0; i<varianza.size();i++) {
			acMedia = acMedia + varianza.get(i) ;
			acMedia2 = acMedia2 + varianza.get(i) * varianza.get(i);
			
		}
		double valorVarianza = acMedia2 / (varianza.size()-1) - (acMedia * acMedia)/ (varianza.size()*(varianza.size()-1));
	}
	public void calculateMode(ArrayList<Integer> moda) {
		int maximaVecesQueSeRepite = 0;
		int valModa=0;
		for(int i=0;i<moda.size();i++) {
			int vecesQueSeRepite = 0;
			for(int j=0;j<moda.size();j++) {
				if(moda.get(i)==moda.get(j)) {
					vecesQueSeRepite++;
				}
			}if(vecesQueSeRepite > maximaVecesQueSeRepite) {
				valModa = moda.get(i);  //valor moda
				maximaVecesQueSeRepite = vecesQueSeRepite;

			}
			valormoda=valModa;
			
		}
	}
	public void restart(){
        for(int i=0;i<10;i++) {
        	numero = reader.nextInt();
        	datos.add(numero);
        }
        
    }
	public void menu() {
		indice = reader.nextInt();
		if(indice==1) {
			calculateMean(datos);
		}else if(indice == 2) {
			calculateStandardDeviation(datos);
		}else if(indice ==3) {
			calculateVariance(datos);
			
		}else if(indice==4) {
			calculateMode(datos);
		}else {
			menu();
		}
		
	}
	public int getPromedio() {
		return prom;
	}
	public ArrayList<Integer> getDatos(){
		return datos;
	}
	public int getmoda(){
		return valormoda;
	}
}
