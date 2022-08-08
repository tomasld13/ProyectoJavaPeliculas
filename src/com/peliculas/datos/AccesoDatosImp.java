package com.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import com.peliculas.domain.Pelicula;
import com.peliculas.excepciones.AccesoDatosEx;
import com.peliculas.excepciones.LecturaDatosEx;

public class AccesoDatosImp implements AccesoDatos{

	@Override
	public boolean existe(String nombreArchivo) throws AccesoDatosEx {
		// TODO Auto-generated method stub
		var archivo = new File(nombreArchivo);
		return archivo.exists();	
	}

	@Override
	public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
		// TODO Auto-generated method stub
		var archivo = new File(nombre);
		List<Pelicula> pelicula = new ArrayList<Pelicula>();
		try {
			var entrada = new BufferedReader(new FileReader(archivo));
			var lectura = entrada.readLine();
			while(lectura != null) {
				var peliculaActual = new Pelicula(lectura);
				pelicula.add(peliculaActual);
				lectura = entrada.readLine();
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.out);
			throw new LecturaDatosEx("El archivo solicitado no existe -> Error: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace(System.out);
			throw new LecturaDatosEx("Error al intentar leer el archivo -> " + e.getMessage());
		}
		return pelicula;
	}

	@Override
	public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws AccesoDatosEx {
		// TODO Auto-generated method stub
		File archivo = new File(nombreArchivo);
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
			salida.println(pelicula.getNombre());
			salida.close();
			System.out.println("¡Pelicula añadida con éxito!");
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.out);
			throw new AccesoDatosEx("El archivo solicitado no existe -> Error: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace(System.out);
			throw new AccesoDatosEx("Error al intentar leer el archivo -> " + e.getMessage());
		}
	}

	@Override
	public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
		// TODO Auto-generated method stub
		var archivo = new File(nombreArchivo);
		try {
			@SuppressWarnings("resource")
			var entrada = new BufferedReader(new FileReader(archivo));
			var lectura = entrada.readLine();
			int indice = 1;
			while(lectura != null) {
				if(lectura.equalsIgnoreCase(buscar)) {
					return "Se ha encontrado la pelicula " + buscar + " en el indice " + indice + " !";
				}
				lectura = entrada.readLine();
				indice++;
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.out);
			throw new LecturaDatosEx("El archivo solicitado no existe -> Error: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace(System.out);
			throw new LecturaDatosEx("Error al intentar leer el archivo -> " + e.getMessage());
		}
		return "No se ha encontrado ninguna pelicula con ese nombre";
	}

	@Override
	public void crear(String nombreArchivo) throws AccesoDatosEx {
		// TODO Auto-generated method stub
		File archivo = new File(nombreArchivo);
		try {
			PrintWriter salida = new PrintWriter(archivo);
			salida.close();
			System.out.println("Catalogo creado con éxito");
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.out);
			throw new AccesoDatosEx("El archivo solicitado no existe -> Error: " + e.getMessage());
		}
	}

	@Override
	public void borrar(String nombreArchivo) {
		// TODO Auto-generated method stub
		File archivo = new File(nombreArchivo);
		archivo.delete();
		System.out.println("¡Archivo borrado con éxito!");
	}


}
