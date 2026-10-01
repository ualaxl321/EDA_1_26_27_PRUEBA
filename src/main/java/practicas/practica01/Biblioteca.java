package practicas.practica01;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	private final ArrayList<Artista> artistas = new ArrayList<>(); //¿Por qué no hacemos esto en la clase Artista o Cancion?
	private final ArrayList<Cancion> canciones = new ArrayList<>();
	private final ArrayList<Album> albumes = new ArrayList<>();

	public void loadArtistas(String fileName) {
		
		InputStream input = getClass().getResourceAsStream(fileName);
		if (input == null)	throw new RuntimeException("Archivo no encontrado");
		
		//Limpiamos estructuras
		//3 líneas
		this.artistas.clear();
		this.canciones.clear();
		this.albumes.clear();
		
		Scanner scan = new Scanner(input);

		while(scan.hasNextLine()) {
			String line = scan.nextLine().trim(); //¿Para qué sirve trim()?
			//Fundamental que hagas syso(line) para saber qué estás haciendo en cada momento... 
			//Ya sabes, si line está vacía o comienza con el carácter # --> ignoramos esa línea
			//Para parsear haz uso de split(",")
			//5 líneas
			if (line.isEmpty()) continue;
			if (line.startsWith("#")) continue;
			String[] items = line.split(",");
			if (items.length != 5) continue;
			Artista  newArt = new Artista (items[0], items[1], items[2], items[3]);
			
			//Para eliminar los caracteres { y } haz uso de substring()
			//Y para separar los nombres, split(";"), ¿verdad?
			//substring() + split() en una única línea
			//3 líneas
			String[] aux = items[4].substring(1, items[4].length()-1).split(";");
			newArt.addMiembros(aux);
			this.artistas.add(newArt);
		}
		scan.close();
	}
	
	public int getNumArtistas() {
		return this.artistas.size();
	}
		
	public void loadCanciones(String fileName) {
		InputStream input = getClass().getResourceAsStream(fileName);
		if (input == null)	throw new RuntimeException("Archivo no encontrado");
		
		//limpiamos estructuras
		//2 líneas
		if(this.canciones != null) this.canciones.clear();
		
		Scanner scan = new Scanner(input);
		while(scan.hasNextLine()) {
			String line = scan.nextLine().trim();
			//muy similar al método de carga de archivo anterior
			if (line.isEmpty()) continue;
			if (line.startsWith("#")) continue;
			String[] items = line.split(",");
			if (items.length != 6) continue;
			Cancion newCan = new Cancion (items[0], items[1], items[2], items[3], items[4]);
			String[] aux = items[5].substring(1, items[5].length()-1).split(";");
			for (String nombre : aux) {
				newCan.addArtistas(new Artista(nombre));
			}
			this.canciones.add(newCan);
		}
		scan.close();
	}
	
	public int getNumCanciones() {
		return this.canciones.size();
	}
	

	public void loadAlbumes(String fileName) {
		InputStream input = getClass().getResourceAsStream(fileName);
		if (input == null)	throw new RuntimeException("Archivo no encontrado");		
		
		this.albumes.clear();
		
		Scanner scan = new Scanner(input);
		while(scan.hasNextLine()) {
			String line = scan.nextLine().trim();
			
			//Seguimos la misma lógica que los métodos de carga de archivos anteriores
			if (line.isEmpty()) continue;
			if (line.startsWith("#")) continue;
			String[] items = line.split(",");
			if (items.length != 6) continue;
			Album newAl = new Album (items[0], items[1], items[2], items[3], items[4]);
			String[] aux = items[5].substring(1, items[5].length()-1).split(";");
			for (String nombre : aux) {
				newAl.addCanciones(new Cancion(nombre));
			}
			this.albumes.add(newAl);
		}
		scan.close();	
	}
	
	public int getNumAlbumes() {
		return this.albumes.size();
	}

	public void clear() {
		this.albumes.clear();
		this.canciones.clear();
		this.artistas.clear();
	}
	
	//Algunas consultas
	
	public ArrayList<String> getAlbumesByTituloCancion(String titulo){
		ArrayList<String> result = new ArrayList<>();
		//2 for() anidados
		//¿Es necesario el uso de break? Analiza y decide.
		for (Album aux : albumes) {
			for (String aux2 : aux.getCanciones()) {
				if (aux2.toLowerCase().equals(titulo.toLowerCase())) {
					result.add(aux.getTitulo() + " (" + aux.getArtista() + ")");
					break;
				}
			}
		}
		return result;
	}
	
	public ArrayList<String> getGeneroByNombreArtista(String nombre){
		ArrayList<String> result = new ArrayList<>();
		//1 único for()
		//Haz uso de continue; al menos 2 continue debe haber.
		for (Cancion can : canciones) {
			if(!(can.getNombresArtistas().contains(nombre))) continue;
			if(result.contains(can.getGenero())) continue;
			result.add(can.getGenero());
		}
		return result;
	}
	
	public Integer getDuracionByAlbum(String titulo){
		//Se exige el uso de indexOf(). Nada de iterar para buscar...¡está prohibido por norma!
		int pos = this.albumes.indexOf(new Album(titulo));
		if (pos == -1) return null;
		int suma = 0;
		//1 for()
		for (String can : this.albumes.get(pos).getCanciones()) {
			int posCancion = this.canciones.indexOf(new Cancion(can));
			if (posCancion != -1) {
				suma += this.canciones.get(posCancion).getDuracion();
			}
		}
		return suma;
	}
	
	public ArrayList<String> getCancionesPropiasEnAlbumesAjenos(String nombreArtista){
		ArrayList<String> result = new ArrayList<>();
		//2 for() anidados
		//Resuelto con solo 7 líneas...¿mejoramos propuesta?
		for (Album aux : albumes) {
			if (aux.getArtista().equals(aux.getArtista())) continue;
			for (String aux2 : aux.getCanciones()) {
				int pos = canciones.indexOf(new Cancion(aux2));
				if (pos != -1 && canciones.get(pos).getNombresArtistas().contains(nombreArtista)) {
					result.add(aux2 + "(" + aux.getTitulo() + ")");
				}
			}
		}
		
		return result;
	}
}