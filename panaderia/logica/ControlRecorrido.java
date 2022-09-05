package panaderia.logica;

import java.util.List;

import panaderia.datos.EscritorArchivoOrdenes;
import panaderia.entidades.base.Producto;
import panaderia.entidades.base.Recorrido;
import panaderia.entidades.base.Tienda;
import panaderia.entidades.pedido.OrdenPedido;

/**
 * Lógica del programa de un recorrido de un vendedor,
 * para crear las órdenes de pedido de las tiendas.
 * 
 * @version 1.0
 */
public class ControlRecorrido {
	private Recorrido recorrido;
	private OrdenPedido ordenEnProceso;
	
	public ControlRecorrido() {
		this.recorrido = new Recorrido();
		this.ordenEnProceso = null;
	}

	public void cargarDatosIniciales() {
		CargadorDatos cargador = new CargadorDatos(recorrido);
		cargador.cargarDatosIniciales();
	}
	
	
	// COMPLETAR LOS MÉTODOS QUE FALTAN

	public boolean existeTienda(String codigoTienda) {
		
		Tienda tiendaPrueba = recorrido.buscarTienda(codigoTienda);
		
		if (tiendaPrueba != null) {
			return true;
		} else {
			return false;
		}

	}

	public void crearOrden(String nombreArchivoProductos, String codigoTienda) {

		

	}

	public void crearDetalle(OrdenPedido orden, String [] datosBaseDetalle) {

		Producto productoDetalle = recorrido.buscarProducto(datosBaseDetalle[0]);

		orden.addDetalle(productoDetalle, Integer.parseInt(datosBaseDetalle[1]));
	}

	public String obtenerDatosTienda(String codigoTienda) {
		
		Tienda tienda = recorrido.buscarTienda(codigoTienda);

		return tienda.toString();

	}

	public List<String> obtenerDetallesOrdenados() {
		
		return ordenEnProceso.getDetallesOrdenados();

	}

	/**
	 * Envía la orden para que su información 
	 * se guarde en un archivo, y luego
	 * deja el atributo en null para que se
	 * pueda procesar una nueva orden.
	 */
	public void guardarOrden() {
		EscritorArchivoOrdenes escritor = new EscritorArchivoOrdenes();
		escritor.escribirOrden(ordenEnProceso);
		ordenEnProceso = null;
	}
}





