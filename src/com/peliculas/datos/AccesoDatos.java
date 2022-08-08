package com.peliculas.datos;
import java.util.List;
import com.peliculas.domain.*;
import com.peliculas.excepciones.AccesoDatosEx;
import com.peliculas.excepciones.LecturaDatosEx;
//Contiene las operaciones a ejecutar en el archivo de peliculas.txt
public interface AccesoDatos {
	boolean existe(String nombreArchivo) throws AccesoDatosEx;
	
	List<Pelicula> listar(String nombre) throws LecturaDatosEx;
	
	void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws AccesoDatosEx;
	
	String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
	
	void crear(String nombreArchivo) throws AccesoDatosEx;
	
	void borrar(String nombreArchivo);
}

