package practicas.practica01;

import java.util.ArrayList;
import auxiliar.Format;

public class Cancion {
	 private String titulo;
	 private int duracion;
	 private String fechaLanzamiento;
	 private boolean explicit;
	 private String genero;
	 private final ArrayList<Artista> artistas;
	 
	 public Cancion(String...values) {
		 //7 líneas
		 //Revisa el método Format.formatFecha() existente en el paquete auxiliar. Te hará falta.
		 if (values.length != 5) throw new IllegalArgumentException("Formato: título,duración en segundos, fecha de lanzamiento, contenido explícito, género"); //Mira línea 123 del catch
		 this.titulo = values[0];
		 this.duracion = Integer.parseInt(values[1]);
		 this.fechaLanzamiento = Format.formatFecha(values[2]);
		 this.explicit = Boolean.parseBoolean(values[3]);
		 this.genero = values[4];
		 this.artistas = new ArrayList<Artista>();
	 }
	 
	 public Cancion(String titulo) {
		//6 líneas
		this.titulo = titulo;
		this.duracion = -1;
		this.fechaLanzamiento = null;
		this.explicit = false;
		this.genero = null;
		this.artistas = null;
	 }
	 
	 public String getTitulo() {
		 return this.titulo;
	 }
	 
	 public int getDuracion() {
		 return this.duracion;
	 }
	 
	 public String getFechaLanzamiento() {
		 return this.fechaLanzamiento;
	 }
	 
	 public boolean getExplicit() {
		 return this.explicit;
	 }
	 
	 public String getGenero() {
		 return this.genero;
	 }

	 public void addArtistas(Artista...artistas) {
		 if (this.artistas == null) return;
		 //1 for()
		 for (Artista art : artistas) {
			if (art == null || this.artistas.contains(art)) continue;
			this.artistas.add(art);
		}
	 }
	 
	 public ArrayList<String> getNombresArtistas() {
		 if (this.artistas == null) return null;
		 ArrayList<String> result = new ArrayList<>();
		 //1 for()
		 for (Artista art : this.artistas) {
			result.add(art.getNombre());
		}
		 return result;
	 }
	 
	 public void clear() {
		 //2 líneas
		 if (artistas == null) return;
	    	this.artistas.clear();
	 }
	 
	 @Override
	 public String toString() {
		 return this.titulo + " --> " + (this.artistas==null ? "[]" : this.getNombresArtistas());
	 }
	 
	 @Override
	 public boolean equals(Object otro) {
		 //Clave -> atributo titulo
		 //4 líneas
		 if (otro == null) return false; // ¿Por qué false?
		 if (this == otro) return true; // ¿Por qué true?
		 if (!(otro instanceof Cancion)) return false; //¿Para qué sirve esto?
		 return this.titulo.equals(((Cancion) otro).titulo);
	 }
}