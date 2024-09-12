/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laJuegoteca.logica;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import laJuegoteca.beans.Juego;

/**
 *
 * @author david
 */
public class LogicaNegocio{
    private static List<Juego> listaJuegos = new ArrayList<>(); //Declaramos la listaJuegos fuera de todos los métodos, ya que lo usarán varios.
    
    public static void agregarJuego(Juego juego){
        listaJuegos.add(juego); //El método agregar juego agrega un objeto Juego a la lista.
    }
    
    public static void escribirFichero(){ //El método escribirFichero...
            FileOutputStream fichero = null;
        try{
            fichero = new FileOutputStream("src/laJuegoteca/docs/miListaJuegos.bin"); //Creamos el archivo y le damos la ruta...
            ObjectOutputStream flujo = new ObjectOutputStream(fichero); //Como trabajamos con objetos, usamos ObjectOutputStream para escribir en el archivo.
            for (Juego juego : listaJuegos){  //Escribiremos un objeto por cada juego de la lista.
                flujo.writeObject(juego);
            }
        }   
        catch (Exception ex) {  //Los diferentes catch...
            ex.printStackTrace();
        }
        finally{
            try{
                fichero.close();  //Y un finally try-catch para cerrar el flujo.
            }   catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
    }
    
    public static void leerFichero() throws IOException{ //La clase leerFichero funciona de manera similar a escribirFichero.
            FileInputStream fichero = null;
        try{
            fichero = new FileInputStream("src/laJuegoteca/docs/miListaJuegos.bin");  
            ObjectInputStream flujo = new ObjectInputStream(fichero);  //Utilizaremos ObjectInputStream...
            Juego juego = (Juego) flujo.readObject();
            while (juego != null){  //Y con un bucle leeremos el archivo hasta que no queden objetos.
                listaJuegos.add((Juego) juego);
                juego = (Juego) flujo.readObject();
            }
                   
        }
        catch (FileNotFoundException ex) { //Los diferentes catch...
            ex.printStackTrace();
        } 
        catch (IOException ex) {
            fichero.close();     
        } 
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }   
        finally{
            try{
                fichero.close();
            }   catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
    } 
    
    
    public static List<Juego> getListaJuegos(){  //Y un método para devolver la listaJuegos que usaremos en el JFrame y JDialog.
        return listaJuegos;
    }
    
}
