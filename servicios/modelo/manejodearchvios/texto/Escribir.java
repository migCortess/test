package modelo.manejodearchvios.texto;

import java.io.IOException;
import java.io.FileWriter;

public class Escribir{

	public static void escribir(float valor, String ruta) throws IOException{
		String watts= Float.toString(valor);
		try{
			FileWriter fw = new FileWriter(ruta);
			fw.write(watts);
			fw.close();
		}catch(IOException e){
			throw new IOException("no se pudo escribir en el archivo reintentar nuevamente");
		}
	}
}