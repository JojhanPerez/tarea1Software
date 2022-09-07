package panaderia.vista;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import panaderia.logica.ControlRecorrido;

/**
 * Realiza la interacción con el usuario
 * para poder iniciar el programa y procesar
 * las órdenes de pedido de un recorrido de ventas.
 * 
 * @version 1.0
 */
public class ProgramaPancita {
	private ControlRecorrido control;

	public ProgramaPancita() {
		this.control = new ControlRecorrido();
	}
	
	/**
	 * Permite cargar los datos iniciales necesarios
	 * para hacer el recorrido.
	 * @throws IOException
	 */
	public void iniciar() throws IOException {
		this.control.cargarDatosIniciales();
	}
	
	/**
	 * Es el ciclo de control general del programa,
	 * para saber si hay más ordenes o termina.
	 * @throws IOException
	 */
	public void hacerRecorrido() throws IOException {
		Scanner consola = new Scanner(System.in);
		String respuesta = "S";
		while (respuesta.equals("S")) {
			System.out.println("¿Desea crear orden de pedido (S/N)?");
			respuesta = consola.next();
			if (respuesta.equals("S")) {
				this.procesarUnaOrden();
			}
		}
		System.out.println("Fin del programa. Muchas gracias.");
		consola.close();
	}
	
	/**
	 * Coordina el proceso para poder crear una orden
	 * de pedido, mostrarla y pedir la aceptación
	 * del usuario.
	 * @throws IOException
	 */
	private void procesarUnaOrden() throws IOException {
		// COMPLETAR:
		// PRIMERO PEDIR EL CÓDIGO DE LA TIENDA
		Scanner datosUsuario = new Scanner(System.in);
		System.out.println("Ingrese el código de la tienda: ");
		String codigo = datosUsuario.nextLine();
		// Y VERIFICAR SI EXISTE.
		if (control.existeTienda(codigo) == false) {
			System.out.println("Tienda no encontrada");
		} else {

			// SI EXISTE:
			// PEDIR LA RUTA CON LOS PRODUCTOS DEL PEDIDO
			System.out.println("Ingrese la ruta con los productos del pedido: ");
			String rutaPedido = datosUsuario.nextLine();
			// Y SOLICITAR AL CONTROL CREAR LA ORDEN.
			control.crearOrden(rutaPedido, codigo);

			// LUEGO: PEDIR AL CONTROL LOS DATOS DE LA TIENDA
			// Y LOS DETALLES ORDENADOS, PARA MOSTRAR AL USUARIO.
			String tienda = control.obtenerDatosTienda(codigo);
			System.out.println(tienda);

			List<String> listaDetalles = control.obtenerDetallesOrdenados();
			for (String detallesOrdenados : listaDetalles) {
				System.out.println(detallesOrdenados);
			}

			// PREGUNTAR SI DESEA ACEPTAR. SI ACEPTA:
			// INFORMAR AL CONTROL PARA QUE GUARDE LA ORDEN.
			String aceptar;
			System.out.println("¿Esta deacuerdo con la Orden? (S/N): ");
			aceptar = datosUsuario.nextLine();
			if (aceptar.equals("S")) {
				control.guardarOrden();
			} else {
				System.out.println("Orden no aceptada");
			}
		}
	}
}
