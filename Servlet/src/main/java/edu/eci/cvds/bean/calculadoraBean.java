package edu.eci.cvds.bean;

import java.util.ArrayList;
import javax.faces.bean.*;

/**
*
* @author DanielVaron-SebastianVillamarin
*/

@ManagedBean(name = "calculadora") 

@ApplicationScoped
//@SessionScoped
public class calculadoraBean {
	private ArrayList<Double> datos=new ArrayList<Double>();
	private double promedio;
	private double moda;
	private double desviacion;
	private double varianza;
	
	public calculadoraBean(){
		reiniciar();
	}
	
	public void addDato(String dato) {
		String[] parts = dato.split(";");
		double bucle;
		for(int i=0;i<parts.length;i++) {
			bucle=Double.parseDouble(parts[i]);
			datos.add(bucle);
		}
		calculateMean();
		calculateStandardDeviation();
		calculateVariance();
		calculateMode();
	}
	
	public double calculateMean() {
		promedio=0;
		//int[] valoresPromedio = int[] promedio;
		for(int i=0; i<datos.size();i++) {
			promedio+=datos.get(i);
		}
		promedio=promedio/datos.size();
		return promedio;
	}
	public double calculateStandardDeviation() {
		desviacion=0;
		double prome, sum = 0;
		int n = datos.size();
		prome = calculateMean();
		for(int i=0; i<datos.size();i++) {
			sum += Math.pow (datos.get(i)- prome, 2 );
		}
		desviacion = Math.sqrt (sum/( double)n);
		return desviacion;
	}
	
	public double calculateVariance() {
		varianza=0;
		double acMedia = 0, acMedia2 = 0;
		for(int i=0; i<datos.size();i++) {
			acMedia = acMedia + datos.get(i) ;
			acMedia2 = acMedia2 + datos.get(i) * datos.get(i);
			
		}
		varianza = acMedia2 / (datos.size()-1) - (acMedia * acMedia)/ (datos.size()*(datos.size()-1));
		return varianza;
	}
	
	public double calculateMode() {
		moda=0;
		int maxCount = 0;
		for(int i=0;i<datos.size();i++) {
			int count = 0;
			for(int j=0;j<datos.size();j++) {
				if(datos.get(i)==datos.get(j)) count++;
			}
			if(count > maxCount) {
				maxCount = count;
				moda = datos.get(i);  //valor moda
			}
		}
		return moda;
	}
	
	public void reiniciar() {
		datos.clear();
		promedio=0;
		moda=0;
		desviacion=0;
		varianza=0;
	}
	public double getPromedio() {
		return promedio;
	}
	public ArrayList<Double> getDatos(){
		return datos;
	}
	public double getModa(){
		return moda;
	}
	public double getDesviacion(){
		return desviacion;
	}
	public double getVarianza(){
		return varianza;
	}
}
