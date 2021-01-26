package edu.escuelaing.arem.ASE.app;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/*
 * Clase principal que ejecuta todo el programa 
 * @author Carlos
 *
 */
public class App 
{	
	/*
	 * Procedemos a sacar la desviación estandar con la formula depejando alfa
	 * @param datos Una lista enlazada con los datos de la tabla
	 * @param datosCopia Una lista enlazada con los datos de la tabla como copia
	 * @return desviacion Resultado de la operación realizada
	 */
	public static String sacarDesviacion(ListaEnlazada datos, ListaEnlazada datosCopia) 
	{
		DesviacionEstandar desviacion = new DesviacionEstandar();
		desviacion.datos(datos, datosCopia);
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(desviacion.getDesviacion());
	}
	
	/*
	 * Crear la lista enlazada con los datos que se encuentran en el archivo
	 * @param ruta Ruta donde se encuentra el archivo con los datos (Por defecto "archivo.txt")
	 * @return datos lista enlazada con los datos de la tabla (archivo de texto)
	 */
	public static ListaEnlazada leerArchivo(String ruta)
	{
		LecturaArchivo archivo = new LecturaArchivo();
		ListaEnlazada datos = archivo.leerArchivo(ruta);
		return datos;
	}
	
	/*
	 * Método principal
	 */
    public static void main( String[] args )
    {
    	ListaEnlazada datos = leerArchivo("archivo.txt");
    	ListaEnlazada datosCopia = leerArchivo("archivo.txt");
    	String res = sacarDesviacion(datos, datosCopia);
    }
}