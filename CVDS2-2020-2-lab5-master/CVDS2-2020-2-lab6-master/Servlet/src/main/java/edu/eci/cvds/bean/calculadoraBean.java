package edu.eci.cvds.bean;

import java.util.ArrayList;
import javax.faces.bean.*;

/**
*
* @author DanielVaron-SebastianVillamarin
*/

@ManagedBean(name = "calculadoraBean") 

@ApplicationScoped
//@SessionScoped
public class calculadoraBean {
	private ArrayList<Double> datos=new ArrayList<Double>();
	private double promedio;
	private int indice;
	private double valorModa;
	
	public calculadoraBean(){
		valorModa=0;
	}
	
	public void addDato(String dato) {
		String[] parts = dato.split(";");
		double bucle;
		for(int i=0;i<parts.length;i++) {
			bucle=Double.parseDouble(parts[i]);
			datos.add(bucle);
		}
		calculateMean();
	}
	
	public double calculateMean() {
		//int[] valoresPromedio = int[] promedio;
		for(int i=0; i<datos.size();i++) {
			promedio+=datos.get(i);
		}
		promedio=promedio/datos.size();
		return promedio;
	}
	public double calculateStandardDeviation() {
		double prome, sum = 0;
		int n = datos.size();
		double desviacion;
		prome = calculateMean();
		for(int i=0; i<datos.size();i++) {
			sum += Math.pow (datos.get(i)- prome, 2 );
		}
		desviacion = Math.sqrt (sum/( double)n);
		return desviacion;
	}
	
	public double calculateVariance() {
		double acMedia = 0, acMedia2 = 0;
		for(int i=0; i<datos.size();i++) {
			acMedia = acMedia + datos.get(i) ;
			acMedia2 = acMedia2 + datos.get(i) * datos.get(i);
			
		}
		double valorVarianza = acMedia2 / (datos.size()-1) - (acMedia * acMedia)/ (datos.size()*(datos.size()-1));
		return valorVarianza;
	}
	public double calculateMode() {
		int maximaVecesQueSeRepite = 0;
		double valModa=0;
		for(int i=0;i<datos.size();i++) {
			int vecesQueSeRepite = 0;
			for(int j=0;j<datos.size();j++) {
				if(datos.get(i)==datos.get(j)) {
					vecesQueSeRepite++;
				}
			}if(vecesQueSeRepite > maximaVecesQueSeRepite) {
				valModa = datos.get(i);  //valor moda
				maximaVecesQueSeRepite = vecesQueSeRepite;

			}
			valorModa=valModa;
		}
		return valorModa;
	}
	public void reiniciar() {
		datos.clear();
		promedio=0;
		valorModa=0;
	}
	
	public void menu() {
		//indice = reader.nextInt();
		if(indice==1) {
			calculateMean();
		}else if(indice == 2) {
			calculateStandardDeviation();
		}else if(indice ==3) {
			calculateVariance();
			
		}else if(indice==4) {
			calculateMode();
		}else {
			menu();
		}
		
	}
	public double getPromedio() {
		return promedio;
	}
	public ArrayList<Double> getDatos(){
		return datos;
	}
	public double getmoda(){
		return valorModa;
	}
}
