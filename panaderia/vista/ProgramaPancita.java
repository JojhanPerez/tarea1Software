package panaderia.vista;

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
	 */
	public void iniciar() {
		this.control.cargarDatosIniciales();
	}
	
	/**
	 * Es el ciclo de control general del programa,
	 * para saber si hay más ordenes o termina.
	 */
	public void hacerRecorrido() {
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
	 */
	private void procesarUnaOrden() {
		// COMPLETAR:
		
		// PRIMERO PEDIR EL CÓDIGO DE LA TIENDA
		// Y VERIFICAR SI EXISTE.
		
		// SI EXISTE:
		// PEDIR LA RUTA CON LOS PRODUCTOS DEL PEDIDO
		// Y SOLICITAR AL CONTROL CREAR LA ORDEN.
		
		// LUEGO: PEDIR AL CONTROL LOS DATOS DE LA TIENDA
		// Y LOS DETALLES ORDENADOS, PARA MOSTRAR AL USUARIO.
		
		// PREGUNTAR SI DESEA ACEPTAR. SI ACEPTA:
		// INFORMAR AL CONTROL PARA QUE GUARDE LA ORDEN.
	}
}
