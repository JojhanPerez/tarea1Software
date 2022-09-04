package panaderia.datos;

import java.util.List;

public class LectorArchivo implements IFuenteDatos {

    private String nombreArchivo;

    public LectorArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public List<String[]> obtenerDatosBase() {
        
        return null;
    }
}