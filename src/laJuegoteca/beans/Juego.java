package laJuegoteca.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author david
 */
public class Juego implements Serializable{  //Debe implementar serializable, ya que vamos a introducir estos objetos en un archivo bin.
    private String titulo;
    private String genero;
    private String plataforma;
    private String compania;
    private Date lanzamiento; //Declaramos todos los atributos del objeto...
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");  //Creamos el SimpleDateFormat para que en la tabla aparezca la fecha como queremos...
    
    public Juego(String titulo, String genero, String plataforma, String compania, Date lanzamiento) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.compania = compania;
        this.lanzamiento = lanzamiento;  //El constructor...
    }

    //...Y los diferentes getters y setters.
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public Date getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(Date lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public SimpleDateFormat getSdf() {  //El método que devolverá el SimpleDateFormat...
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) { //Y el getter del mismo.
        this.sdf = sdf;
    }
  
    public String[] toArrayString(){  //Un método para añadir el juego a un array en forma de string.
        String[] juego = new String[5];
        juego[0] = titulo;
        juego[1] = genero;
        juego[2] = plataforma;
        juego[3] = compania;
        juego[4] = sdf.format(lanzamiento);
         
        return juego;       
    }
}
