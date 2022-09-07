package panaderia.vista;

import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		ProgramaPancita programa = new ProgramaPancita();
		programa.iniciar();
		programa.hacerRecorrido();
	}
}
