package com.peliculas.negocio;

import com.peliculas.datos.AccesoDatos;
import com.peliculas.datos.AccesoDatosImp;
import com.peliculas.domain.Pelicula;
import com.peliculas.excepciones.AccesoDatosEx;
import com.peliculas.excepciones.LecturaDatosEx;

//COntiene la implementacion de las operaciones necesarias de la aplicacion CatalogoPeliculas
public class CatalogoPeliculasImp implements CatalogoPeliculas{
	
	private final AccesoDatos datos;
	
	public CatalogoPeliculasImp() {
		this.datos = new AccesoDatosImp();
	}
	
	@Override
	public void agregarPelicula(String nombrePelicula) {
		// TODO Auto-generated method stub
		Pelicula pelicula = new Pelicula(nombrePelicula);
		boolean anexar = false;
		try {
			anexar = this.datos.existe(NOMBRE_RECURSO);
			datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
		} catch (AccesoDatosEx e) {
			// TODO Auto-generated catch block
			System.out.println("Error en Catalogo - Agregar Pelicula: ");
			e.printStackTrace(System.out);
		}
	}

	@Override
	public void listarPeliculas() {
		// TODO Auto-generated method stub
		try {
			var listaPeliculas = datos.listar(NOMBRE_RECURSO);
			listaPeliculas.forEach(pelicula -> {
				System.out.println(pelicula.getNombre());
			});
		} catch (LecturaDatosEx e) {
			// TODO Auto-generated catch block
			System.out.println("Error en Catalogo - Listar Pelicula: ");
			e.printStackTrace(System.out);
		}
	}

	@Override
	public void buscarPelicula(String buscar) {
		// TODO Auto-generated method stub
		try {
			var encontro = datos.buscar(NOMBRE_RECURSO, buscar);
			System.out.println(encontro);
		} catch (LecturaDatosEx e) {
			// TODO Auto-generated catch block
			System.out.println("Error en Catalogo - Buscar Pelicula: ");
			e.printStackTrace(System.out);
		}
	}

	@Override
	public void iniciarCatalogoPeliculas() {
		// TODO Auto-generated method stub
		try {
			if(this.datos.existe(NOMBRE_RECURSO)) {
				datos.borrar(NOMBRE_RECURSO);
				datos.crear(NOMBRE_RECURSO);
			}else {
				datos.crear(NOMBRE_RECURSO);
			}
		} catch (AccesoDatosEx e) {
			// TODO Auto-generated catch block
			System.out.println("Error en Catalogo - Iniciar Catalogo Peliculas: ");
			e.printStackTrace(System.out);
		}
	}
	
}
