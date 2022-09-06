package panaderia.datos;

import java.util.ArrayList;
import java.util.List;

public class DatosPruebaOrdenes implements IFuenteDatos {

    @Override
    public List<String[]> obtenerDatosBase() {
        
        String[] primeraOrden = {"0001", "3"};
        String[] segundaOrden = {"0002", "2"};
        String[] terceraOrden = {"0004", "1"};

        List<String[]> ordenes = new ArrayList<>();
        ordenes.add(primeraOrden);
        ordenes.add(segundaOrden);
        ordenes.add(terceraOrden);

        return ordenes;

    }

}
