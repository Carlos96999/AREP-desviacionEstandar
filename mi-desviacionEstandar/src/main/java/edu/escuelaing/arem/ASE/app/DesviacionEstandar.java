package edu.escuelaing.arem.ASE.app;

import java.util.ArrayList;

/*
 * Clase de la formula de desviaci�n estandar
 */
public class DesviacionEstandar 
{
	private double sumatoria; 	//Sumatoria de xi (datos de la tabla)
	private int i;			//Indice donde esta el valor x
	private int x;			//Valor que se encuentra en la posici�n i de la tabla
	private int n;			//Cantidad de valores en la tabla
	private double alfa;		//Alfa de la desviaci�n estandar
	
	/*
	 * Constructor
	 */
	public DesviacionEstandar()
	{
		sumatoria = 0;
		i = 0;
		x = 0;
		n = 0;
		alfa = 0;
	}

	/*
	 * Inicio de la operaci�n enviando los datos
	 * @param datos Lista enlazada con los datos de la tabla
	 */
	public void datos(ListaEnlazada datos, ListaEnlazada datosCopia) 
	{
		operacion(datos, datosCopia);
	}
	
	/*
	 * Realizamos la operaci�n de la formula
	 * @param datos Lista enlazada con los datos de la tabla
	 */
	public void operacion(ListaEnlazada datos, ListaEnlazada datosCopia)
	{
		n = datos.getCola() + 1; 
		sumatoria = sumatoria(datos);
		double xPromedio = sumatoria/n;
		sumatoria = equisMenosEquisPromedio(datosCopia, xPromedio);
		alfa = raiz(sumatoria, n);
	}

	/*
	 * Realizamos la sumatoria de los datos
	 * @param datos Lista enlazada con los datos de la tabla
	 * @return sumatoria
	 */
	public double sumatoria(ListaEnlazada datos)
	{
		double sumatoria = 0;
		
		for (int i = 0; i < n; i++)
		{
			sumatoria += datos.extraer();
		}
		return sumatoria;
	}
	
	/*
	 * Sacamos la sumatoria de (xi-xPromedio)**2
	 * @param datos Lista enlazada con los datos de la tabla
	 * @param xPromedio promedio de los datos de la tabla
	 * @return sumatoria
	 */
	public double equisMenosEquisPromedio(ListaEnlazada datos, double xPromedio)
	{
		int sumatoria = 0;
		
		for (int i = 0; i < n; i++)
		{
			double valor = datos.extraer();
			sumatoria += ((valor - xPromedio)*(valor - xPromedio));
		}
		return sumatoria;
	}
	
	/*
	 * Calculamos la ra�z para conocer el valor de alfa
	 * @param sumatoria La sumatoria total de la formula (xi-xPromedio)**2
	 * @param n Cantidad de datos en la tabla
	 * @return res
	 */
	public double raiz(double sumatoria, int n)
	{
		double res = Math.sqrt(sumatoria/(n-1));
		return res;
	}
	
	/*
	 * Obtenemos el resultado de la desviaci�n estandar
	 * @return alfa
	 */
	public double getDesviacion() 
	{
		return alfa;
	}
	
	/*
	 * Establecemos le valor de n, la cantidad de datos en la tabla
	 * @param n
	 */
	public void setN(int n)
	{
		this.n = n;
	}
}
