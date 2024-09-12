
package laJuegoteca.gui.tablemodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import laJuegoteca.beans.Juego;

/**
 *
 * @author david
 */
public class JuegosTableModel extends AbstractTableModel{

    private List<Juego> listaJuego;
    private String[] columnas = {"Título", "Género", "Plataforma", "Compañía", "Lanzamiento"};
    
    public JuegosTableModel(List<Juego> listaJuego){
        this.listaJuego = listaJuego;
    }
    
    @Override
    public int getRowCount() {
        return listaJuego.size();     
    }

    @Override
    public int getColumnCount() {
        return columnas.length; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return listaJuego.get(rowIndex).getTitulo();
            case 1:
                return listaJuego.get(rowIndex).getGenero();
            case 2:
                return listaJuego.get(rowIndex).getPlataforma();
            case 3:
                return listaJuego.get(rowIndex).getCompania();
            case 4:
                return listaJuego.get(rowIndex).getLanzamiento();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column]; 
    }
    
    
}
