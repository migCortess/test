package modelo.usuarios;

import modelo.manejodearchvios.texto.LeerArchivos;

public class UsuarioDomestico extends Usuario
{
	
	public UsuarioDomestico()
	{
		
	}
	public UsuarioDomestico(String nombre, int cuenta, String direccion, String fechaPago, String numeroMedidor){
		setNombre(nombre);
		setCuenta(cuenta);
		setDireccion(direccion);
		setFechaPago(fechaPago);
		setNumeroDeMedidor(numeroMedidor);
	}
	
	public String checarConsumoActual(String ruta)
	{
		float consumoActual =  0;
		
		System.out.println(Float.parseFloat(LeerArchivos.leer(ruta)) );
		if(Float.parseFloat(LeerArchivos.leer(ruta) ) > 0 && Float.parseFloat(LeerArchivos.leer(ruta) ) < 76)
		{
			consumoActual = Float.parseFloat(LeerArchivos.leer(ruta) )* (.793f);
			
		}
		if(Float.parseFloat(LeerArchivos.leer(ruta) ) > 75 && Float.parseFloat(LeerArchivos.leer(ruta) ) < 141)
		{
			consumoActual = ( (75) * (.793f) ) + (Float.parseFloat(LeerArchivos.leer(ruta))-75)  * (.956f);
			
		}
		if(Float.parseFloat(LeerArchivos.leer(ruta) )  > 140)
		{
			consumoActual = ((75* (.793f)) + ((65) * (.956f) ) + ((Float.parseFloat(LeerArchivos.leer(ruta) )-140) * (2.802f)) );
			//consumoActual = Float.parseFloat(LeerArchivos.leer(ruta) ) * (2.802f);
		}
		
		
		//String consumoActual =  LeerArchivos.leer(ruta);
		return String.valueOf(consumoActual);
		
		//System.out.println("Hola");
	}
	
}