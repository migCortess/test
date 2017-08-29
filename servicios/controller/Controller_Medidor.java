package controller;

import modelo.medidor.EmuladorMedidor;

public class Controller_Medidor{

	Runnable emulador;
	Thread ejecutarEmulador;

	public Controller_Medidor(){

		emulador = new EmuladorMedidor();
		ejecutarEmulador = new Thread(emulador);
		ejecutarEmulador.start();

	}

	/*public String datoDomestico(){
		return EmuladorMedidor.wattDomestico();
	}

	public String datoNegocio(){
		return EmuladorMedidor.wattNegocio();
	}


	public String datoEmpresa(){
		return EmuladorMedidor.wattEmpresa();
	}*/

	public void detenerEmulador(){
		ejecutarEmulador.interrupt();
	}


}