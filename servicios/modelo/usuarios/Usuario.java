package modelo.usuarios;

//import java.io.Serializable;
import  modelo.manejodearchvios.texto.LeerArchivos;

//public abstract class Usuario implements Serializable
public abstract class Usuario
{
	private String nombre;
	private int cuenta;
	private String direccion;
	private String fechaPago;
	private String numeroDeMedidor;

	public void setNombre(String nombre){
		if(!nombre.isEmpty())
			this.nombre = nombre;
		else
			nombre="NO NAME";
	}

	public String getNombre(){
		return nombre;
	}

	public void setCuenta(int cuenta){
		if(cuenta>9999 && cuenta<999999999)
			this.cuenta = cuenta;
		else
			cuenta = 10000;
	}

	public int getCuenta(){
		return cuenta;
	}

	public void setDireccion(String direccion){
		if(!direccion.isEmpty())
			this.direccion=direccion;
		else
			direccion="NO ADRESS";
		
	}
	public String getDireccion(){
		return direccion;
	}

	public void setFechaPago(String fechaPago){
		if(!fechaPago.isEmpty())
			this.fechaPago=fechaPago;
		else
			direccion="NO DATE";
		
	}
	
	public String getFechaPago(){
		return fechaPago;
	}

	public void setNumeroDeMedidor(String numeroDeMedidor){
		if(!numeroDeMedidor.isEmpty())
			this.numeroDeMedidor=numeroDeMedidor;
		else
			numeroDeMedidor="NO DATE";
		
	}
	public String getNumeroDeMedidor(){
		return numeroDeMedidor;
	}

	public abstract String checarConsumoActual(String ruta);
	
	
	public String checarHistorial(String ruta)
	{
		String historialAFecha="";
		String[] historial = LeerArchivos.leerHistorial(ruta);
		for(String periodo : historial)
			historialAFecha += "\n"+periodo;
		return historialAFecha;
	}
	
	
	public String promedioConsumo(String ruta)
	{	
		float suma=0;
		String[] historial = LeerArchivos.leerHistorial(ruta);
		for(int i=0;i<historial.length;i++){

			String [] valor=historial[i].split("\\$");
			suma+=Float.parseFloat(valor[1]);
			//System.out.println(valor[0]);
			//System.out.println(valor[1]);
		}
		return String.valueOf(suma/historial.length);
		//return 0;		
	}	
	
	
	public String toString(){
		return " Nombre: " + nombre + " Cuenta: " + cuenta + " \nDireccion: " + direccion + " Fecha pago:" + fechaPago + " Num Medidor: " + numeroDeMedidor + " ";
	}
}