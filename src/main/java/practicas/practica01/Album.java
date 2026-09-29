package practicas.practica01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Album implements Iterable<Cancion> {
	private String titulo;
	private String anyoLanzamiento;
	private Artista artista;
	private String coverImagenUrl;
	private final LinkedList<Cancion> canciones;
	
	public Album(String...values) {
		 //5 líneas
		 this.titulo = values[0];
		 this.anyoLanzamiento = values[1];
		 this.artista = new Artista(values[2]);
		 this.coverImagenUrl = values[3];
		 this.canciones = new LinkedList<>();
	}
	
	public Album(String titulo) {
		this.titulo = titulo;
		this.anyoLanzamiento = null;
		this.artista = null;
		this.coverImagenUrl = null;
		this.canciones = null;
	}
	
	public void setArtista (Artista artista) {
		this.artista = artista;
	}
		
	public String getTitulo() {
		return this.titulo;
	}
	
	public Artista getArtista() {
		return this.artista;
	}
	
	public String getAnyoLanzamiento() {
		return this.anyoLanzamiento;
	}
	
	public String getCoverImagenURL() {
		return this.coverImagenUrl;
	}
	
	public ArrayList<String> getCanciones() {
		//Devuelve null si la estructura no está inicializada
		//1 for()
		ArrayList<String> result = new ArrayList<>();
		if (result == null) return null;
		for (Cancion can : canciones) {
			if (can == null) continue;
			if (result.contains(can.getTitulo())) continue;
			result.add(can.getTitulo());
		}
		return result;
	}
	
	public void addCanciones(Cancion...canciones) {
		//1 for()
		for (Cancion can : canciones) {
			if (can == null) continue;
			if (this.canciones.contains(can)) continue;
			this.canciones.add(can);
		}
	}
	
	public void clear() {
		//2 líneas
		if (canciones == null) return;
		this.canciones.clear();
	}
	
	@Override
	public String toString() {
		String aux2 = //...
		String aux3 = //...
		return this.titulo + " <" + aux2  +  ">: " + aux3;
	}

	@Override
	public boolean equals(Object otro) {
		//Clave: atributo titulo
		//4 líneas
		//...
	}
	
	@Override
	public Iterator<Cancion> iterator() {
		if (this.canciones == null) return Collections.emptyIterator(); //Esto es genial...¿por qué hace falta en este método?
		return //...
	}
}