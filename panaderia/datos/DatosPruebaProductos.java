package panaderia.datos;

import java.util.ArrayList;
import java.util.List;

public class DatosPruebaProductos implements IFuenteDatos {

    @Override
	public List<String[]> obtenerDatosBase() {
		String[] prodcuto1 = {"0001","Pan Trensa", "2000"}; //de tipo string? o de tipo double?
		String[] producto2 = {"0002","Pan Agridulse", "500"};
		String[] producto3 = {"0003","Pan Hawaiano", "3000"};
		List<String[]> productos = new ArrayList<>();
		productos.add(prodcuto1);
		productos.add(producto2);
		productos.add(producto3);
		return productos;
	}

}