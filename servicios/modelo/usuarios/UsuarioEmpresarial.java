package modelo.usuarios;

import modelo.manejodearchvios.texto.LeerArchivos;

public class UsuarioEmpresarial extends Usuario
{
		public UsuarioEmpresarial()
		{
		}

		public UsuarioEmpresarial(String nombre, int cuenta, String direccion, String fechaPago, String numeroMedidor){
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
			if(Float.parseFloat(LeerArchivos.leer(ruta) ) > 0 && Float.parseFloat(LeerArchivos.leer(ruta) ) < 51)
			{
				consumoActual = Float.parseFloat(LeerArchivos.leer(ruta) )* (7.004f);
				
			}
			if(Float.parseFloat(LeerArchivos.leer(ruta) ) > 50 && Float.parseFloat(LeerArchivos.leer(ruta) ) < 101)
			{
				consumoActual = ( (50) * (7.004f) ) + (Float.parseFloat(LeerArchivos.leer(ruta))-50)  * (7.417f);
				
			}
			if(Float.parseFloat(LeerArchivos.leer(ruta) )  > 100)
			{
				consumoActual = ((50* (7.004f)) + ((50) * (7.417f) ) + ((Float.parseFloat(LeerArchivos.leer(ruta) )-100) * (7.664f)) );
				//consumoActual = Float.parseFloat(LeerArchivos.leer(ruta) ) * (7.802f);
			}
			
			
			//String consumoActual =  LeerArchivos.leer(ruta);
			return String.valueOf(consumoActual);
			
			//System.out.println("Hola");
		}
}