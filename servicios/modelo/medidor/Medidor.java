package modelo.medidor;

import modelo.manejodearchvios.texto.LeerArchivos;
import modelo.manejodearchvios.texto.Escribir;
import java.io.IOException;
import java.io.File;

public class Medidor{

	private int consumoMaxHora = 0;
	private float total = 0;
	private String ruta;
	File energiaFile;

	public Medidor(){

	}

	public Medidor(int tipoMedidor){

		setMedidor(tipoMedidor);
	}

	private void setMedidor(int tipoMedidor){
		switch(tipoMedidor){
			case 1:
				consumoMaxHora=2;
				ruta ="modelo\\Archivos\\medidor\\Energia\\Domestica.txt";
				energiaFile = new File(ruta);
			break;
			case 2:
				consumoMaxHora=10;
				ruta ="modelo\\Archivos\\medidor\\Energia\\Negocio.txt";
				energiaFile = new File(ruta);
			break;
			case 3:
				consumoMaxHora=15;
				ruta ="modelo\\Archivos\\medidor\\Energia\\Empresa.txt";
				energiaFile = new File(ruta);
			break;
		}
	}

	private float calcular(){

		return (float)(Math.random()*consumoMaxHora+1);
	}

	public void watssAcumulados() throws IOException{
		if(energiaFile.exists()){
			total = Float.parseFloat(LeerArchivos.leer(ruta));
		}
		float calcular = 0;
		calcular = calcular();
		//System.out.println("watts : " + calcular+"\ntotal" + total+"\n"+consumoMaxHora);
		total += calcular;
		//System.out.println("wattsTotales : " + total);
		try{
			Escribir.escribir(total,ruta);
	    }catch(IOException e){
	    	throw new IOException();
	    }
	}

	public String getWattsTotales(){
		return String.valueOf(total);
	}
}