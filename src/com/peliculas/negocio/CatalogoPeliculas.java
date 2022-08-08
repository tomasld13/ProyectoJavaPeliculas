package com.peliculas.negocio;
//Contiene las operaciones necesarias de la app CatalogoPeliculas
public interface CatalogoPeliculas {
	
	String NOMBRE_RECURSO = "/home/tomas/progra/Java/ProyectoFinalPeliculas/Peliculas/peliculas.txt";
	
	void agregarPelicula(String nombrePelicula);
	
	void listarPeliculas();
	
	void buscarPelicula(String buscar);
	
	void iniciarCatalogoPeliculas();
}
