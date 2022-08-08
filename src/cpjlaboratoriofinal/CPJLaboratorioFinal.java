package cpjlaboratoriofinal;

import java.util.Scanner;

import com.peliculas.negocio.CatalogoPeliculasImp;

//Contiene el menu que permite al usuario seleccionar la accion a ejecutar sobre el catálogo de peliculas.
///home/tomas/progra/Java/ProyectoFinalPeliculas/Peliculas/

public class CPJLaboratorioFinal {
	static int opcion = -1;
	String nombreArchivo;
	static CatalogoPeliculasImp catalogo = new CatalogoPeliculasImp();

	public static void main(String[] args) {
		System.out.println("¡Bienvenido a tu catalogo de Peliculas!");
		while (opcion != 0) {
			@SuppressWarnings("resource")
			Scanner consola = new Scanner(System.in);
			System.out.println(
					"\n" + "Elige una opción: \n" + "1) Iniciar catalogo de peliculas. \n" + "2) Agregar pelicula. \n"
							+ "3) Listar peliculas. \n" + "4) Buscar peliculas. \n" + "0) Salir. \n");
			opcion = Integer.parseInt(consola.nextLine());
			switch (opcion) {
			case 0:
				System.out.println("¡Hasta pronto!");
				break;
			case 1:
				catalogo.iniciarCatalogoPeliculas();
				break;
			case 2:
				System.out.println("Ingrese el nombre de la pelicula a añadir:");
				String nombrePelicula = consola.nextLine();
				System.out.println(nombrePelicula);
				catalogo.agregarPelicula(nombrePelicula);
				break;
			case 3:
				catalogo.listarPeliculas();
				break;
			case 4:
				System.out.println("Ingrese el nombre de la pelicula a buscar:");
				String nombrePeliculaBuscar = consola.nextLine();
				catalogo.buscarPelicula(nombrePeliculaBuscar);
				break;
			default:
				System.out.println("Orden no reconocida :/");
			}
		}
	}

}
