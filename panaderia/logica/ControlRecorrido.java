package panaderia.logica;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import panaderia.datos.DatosPruebaOrdenes;
import panaderia.datos.EscritorArchivoOrdenes;
import panaderia.datos.IFuenteDatos;
import panaderia.datos.LectorArchivo;
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

	public void cargarDatosIniciales() throws IOException {
		CargadorDatos cargador = new CargadorDatos(recorrido);
		cargador.cargarDatosIniciales();
	}
	
	
	// COMPLETAR LOS MÉTODOS QUE FALTAN

	/**
	 * Este metodo verifica que una tienda existe
	 * usando un metodo ya implementado y despues evalua 
	 * lo que devuleve buscarTienda() para así darle un valor a su retorno
	 * @param codigoTienda
	 * @return Boolean
	 */

	public boolean existeTienda(String codigoTienda) {
		
		Tienda tiendaPrueba = recorrido.buscarTienda(codigoTienda);
		
		if (tiendaPrueba != null) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Crea la orden mediante la lectura del archivo que se 
	 * encuentra en la ruta especificada y usa un código de tienda
	 * para crear esta orden despues de verificar si esta exite.
	 * Se usa una exepción en casao de que el archivo no exista.
	 * @param nombreArchivoProductos
	 * @param codigoTienda
	 * @throws IOException
	 */

	public void crearOrden(String nombreArchivoProductos, String codigoTienda) throws IOException {

		//IFuenteDatos datosPrueba = new DatosPruebaOrdenes();
	    IFuenteDatos datosPrueba = new LectorArchivo("ordenes/" + nombreArchivoProductos);
		Tienda tiendaDeOrden = recorrido.buscarTienda(codigoTienda);

		ordenEnProceso = new OrdenPedido(tiendaDeOrden);

		try {
			List<String[]> datosDeOrden = datosPrueba.obtenerDatosBase();

			for (String[] orden : datosDeOrden) {
				crearDetalle(ordenEnProceso, orden);
			}
		} catch (IOException io) {
			Logger logger = Logger.getLogger(ControlRecorrido.class.getName());
			logger.warning("No fue posible obtener los datos");
		}

	}

	/**
	 * Crea los detalles del pedido para mostrar al usuario
	 * @param orden
	 * @param datosBaseDetalle
	 */
	public void crearDetalle(OrdenPedido orden, String [] datosBaseDetalle) {

		Producto productoDetalle = recorrido.buscarProducto(datosBaseDetalle[0]);

		if (productoDetalle != null) {
			orden.addDetalle(productoDetalle, Integer.parseInt(datosBaseDetalle[1]));
		}

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





