package panaderia.datos;

import java.util.ArrayList;
import java.util.List;

public class DatosPruebaProductos implements IFuenteDatos {

    @Override
	public List<String[]> obtenerDatosBase() {
		String[] prodcuto1 = {"0001","3000"}; //de tipo string? o de tipo double?
		String[] producto2 = {"0002","700"};
		String[] producto3 = {"0003","1500"};
		List<String[]> productos = new ArrayList<>();
		productos.add(prodcuto1);
		productos.add(producto2);
		productos.add(producto3);
		return productos;
	}

}