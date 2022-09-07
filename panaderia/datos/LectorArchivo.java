package panaderia.datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivo implements IFuenteDatos {

    private String nombreArchivo;

    public LectorArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public List<String[]> obtenerDatosBase() throws IOException {
        Path rutaArchivo = Paths.get("pedidos/" + nombreArchivo);
        BufferedReader lector = Files.newBufferedReader(rutaArchivo);

        String linea;
        List<String[]> listaDatos = new ArrayList<>();
        while ((linea = lector.readLine()) != null) {
            listaDatos.add(linea.split(","));
        }
        lector.close();

        return listaDatos;
    }
}