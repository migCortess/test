package modelo.medidor;
import java.io.IOException;

public class EmuladorMedidor implements Runnable{

	/*String static wattDomestico="";
	String static wattNegocio="";
	String static wattEmpresa="";*/

	public EmuladorMedidor(){
		
	}

	public void run(){
		Medidor medidorDomestico = new Medidor(1);
		Medidor medidorNegocio = new Medidor(2);
		Medidor medidorEmpresarial = new Medidor(3);
		boolean escape=true;
		do{
			try{
				
				medidorDomestico.watssAcumulados();
				medidorNegocio.watssAcumulados();
				medidorEmpresarial.watssAcumulados();
				/*wattDomestico=medidorDomestico.getWattsTotales();
				wattNegocio=medidorNegocio.getWattsTotales();
				wattEmpresa=medidorEmpresa.getWattsTotales();*/
				
			}catch(IOException e){
					e.printStackTrace();
			}
			try{
				Thread.sleep(5000);
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
				escape=false;

			}
		}while(escape);
	}
/*
	public String datoWattDomestico(){
		return wattDomestico;
	}
	public String datoWattNegocio(){
		return wattNegocio;
	}
	public String datoWattEmpresa(){
		return wattEmpresa;
	}
*/
}