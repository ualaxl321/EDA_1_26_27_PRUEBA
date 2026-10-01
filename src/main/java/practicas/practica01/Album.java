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
		if (values.length != 3) throw new RuntimeException("Formato: título, año de lanzamiento, url imagen de la portada");
		this.titulo = values[0];
		this.anyoLanzamiento = values[1];
		this.coverImagenUrl = values[2];
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
		if (this.canciones == null) return null;
		ArrayList<String> result = new ArrayList<>();
		for (Cancion can : this.canciones) {
			result.add(can.getTitulo());
		}
		return result;
	}

	public void addCanciones(Cancion...canciones) {
		//1 for()
		if (this.canciones == null || canciones == null) return;
		for (Cancion can : canciones) {
			if (can != null && !this.canciones.contains(can)) {
				this.canciones.add(can);
			}
			
		}
	}

	public void clear() {
		//2 líneas
		if(this.canciones != null) this.canciones.clear();
	}

	@Override
	public String toString() {
		String aux2 = this.artista == null ? "sinArtista" : this.artista.getNombre();
		String aux3 = this.canciones == null ? "[]" : this.canciones.toString();
		return this.titulo + " <" + aux2  +  ">: " + aux3;
	}

	@Override
	public boolean equals(Object otro) {
		//Clave: atributo titulo
		//4 líneas
		if (otro == null) return false;
		if (this == otro) return true;
		if (!(otro instanceof Album)) return false;
		return this.titulo.equals(((Album) otro).titulo);
	}

	@Override
	public Iterator<Cancion> iterator() {
		if (this.canciones == null) return Collections.emptyIterator(); //Esto es genial...¿por qué hace falta en este método?
		return this.canciones.iterator();
	}
}