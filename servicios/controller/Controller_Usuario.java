package controller;

import modelo.usuarios.Usuario;
import modelo.usuarios.UsuarioDomestico;
import modelo.usuarios.UsuarioNegocio;
import modelo.usuarios.UsuarioEmpresarial;

public class Controller_Usuario{

	private String rutaDomestico="modelo\\Archivos\\GuardarObjetos\\domestico.obj";
	private String rutaNegocio="modelo\\Archivos\\GuardarObjetos\\negocio.obj";
	private String rutaEmpresa="modelo\\Archivos\\GuardarObjetos\\empresa.obj";
	private String rutaWattsDomestico = "modelo\\Archivos\\medidor\\Energia\\Domestica.txt";
	private String rutaWattsNegocio = "modelo\\Archivos\\medidor\\Energia\\Negocio.txt";
	private String rutaWattsEmpresa = "modelo\\Archivos\\medidor\\Energia\\Empresa.txt";
	private String rutaHistorialDomestico= "modelo\\Archivos\\Historial\\historialDomestico.txt";
	private String rutaHistorialNegocio="modelo\\Archivos\\Historial\\historialNegocio.txt";
	private String rutaHistorialEmpresa="modelo\\Archivos\\Historial\\historialEmpresa.txt";
	Usuario usuario[] = new Usuario[3];
	

	public Controller_Usuario(){
		usuario[0] = new UsuarioDomestico("miguel",1435,"las","28/05/16","9H294C");
		usuario[1] = new UsuarioNegocio("Alexis",1233233,"los cedros #230 San Nicolas de los Gzz NL","01/06/16","8J275B");
		usuario[2] = new UsuarioEmpresarial("Mario",1255553,"dsswwwefaffdfdfdf","12/06/16","8G275A");
	}

	public String datosDomestico(){
		return usuario[0].toString();
	}

	public String datosNegocio(){
		return usuario[1].toString();
	}

	public String datosEmpresa(){
		return usuario[2].toString();
	}

	public String historialDomestico(){
		return usuario[0].checarHistorial(rutaHistorialDomestico);
	}

	public String historialNegocio(){
		 return usuario[1].checarHistorial(rutaHistorialNegocio);
	}

	public String historialEmpresa(){
		return usuario[2].checarHistorial(rutaHistorialEmpresa);
	}

	public String promedioDomestico(){
		return usuario[0].promedioConsumo(rutaHistorialDomestico);
	}

	public String promedioNegocio(){
		return usuario[1].promedioConsumo(rutaHistorialNegocio);
	}
	
	public String promedioEmpresa(){
		return usuario[2].promedioConsumo(rutaHistorialEmpresa);
	}

	public String consumoActualDomestico(){
		return usuario[0].checarConsumoActual(rutaWattsDomestico);
	}

	public String consumoActualNegocio(){
		return usuario[1].checarConsumoActual(rutaWattsNegocio);
	}

	public String consumoActualEmpresa(){
		return usuario[2].checarConsumoActual(rutaWattsEmpresa);
	}

	public String getNumMed(int tipo){
		if(tipo==1){
			return usuario[0].getNumeroDeMedidor();
		}else if(tipo==2){
			return usuario[1].getNumeroDeMedidor();
		}else{
			return usuario[2].getNumeroDeMedidor();
		}
	}
}