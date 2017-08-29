package modelo.manejodearchvios.texto;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;//importamos la clase SimpleDateFormat para dar formato legible a la salida en milisegundos
//a la ultima modificacion del archivo o directorio proporcionado por el metodo lastModified() de la clase File

public class LeerArchivos{
	
	

	public static void verificarRuta(String ruta) throws IOException,FileNotFoundException{

		//declaramos las variables y objetos a utilizar
		String[] directorio = null;
		String informacionTexto=null;
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		SimpleDateFormat modificacion = null;
		//instanciamos objeto SimpleDateFormat y objeto File
		modificacion = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
		file = new File(ruta);

		if (file.exists()){//verificamos que exista el archivo con el metodo exists()

			if(file.isFile())//varificamos que sea un archivo con el metodo isFile()
				System.out.println("\nes un archivo");
			else
				System.out.println("\nno es un archivo");
			if(file.isDirectory())//verificamos que sea un directorio con el metodo isDirectory()
				System.out.println("\nes un directorio");
			else
				System.out.println("\nno es un directorio");
			if(file.isAbsolute())//verificamos si la ruta proporcionada es absoluta con el metodo isAbsolute()
				System.out.println("\nes una ruta absoluta: " + file.getPath());
			else
				System.out.println("\nno es ruta absoluta: " + file.getPath());
			//en mostramos la salida de el metodo lastModified que es en milisegundos y le damos formato con el objeto modificacion y su metodo
			//format() el cual le da la salida que uno le especifique en este caso dia/mes/anio  hora/minutos/segundos
			System.out.println("\nUltima modificacion:  " + modificacion.format(file.lastModified()) + "Hrs.");
			System.out.println("\nLa ruta absoluta es: " + file.getAbsolutePath());	//muestra la ruta absoluta del archivo o directorio		
			if(file.isFile()){

				System.out.println("\nEl contenido del archivo:  " + file.getPath()+" Es: ");
				try{
					fr = new FileReader (ruta);
					br = new BufferedReader (fr);
					while((informacionTexto = br.readLine()) != null){

						System.out.println(informacionTexto);		
					}		

				}catch(IOException e){
					throw new IOException("error al leer archivo favor de intentar nuevamente");//proporciona al metodo main el error por no poder leer el archivo
				}finally{
					br.close();//cerramos el documento
				}	
			}
	 		if(file.isDirectory()){

	 			directorio = file.list();//pasamos la lista que contiene el directorio a un arreglo de Srtring llamada directorio
	 			System.out.println("\nContenido del directorio es:\n");

				for ( String nombreDirectorio : directorio )//usamos un for simplificado para la lectura del arreglo
	 				System.out.println( "\t-"+nombreDirectorio);//mostramos el contenido del arreglo en pantalla
	 		}
	   	}else{
	   		throw new FileNotFoundException("La ruta no existe favor de intentarlo nuevamente");//proporcionamos el error que ocurreo al no encontrar el archivoo o directorio
	   	}
		
	}
	
	public static String leer(String ruta)
	{
		
			File file = null;
			FileReader fr = null;
			BufferedReader br = null;
			String [] wats =  null;
						
			int x = 0;
		try
		{
			file = new File(ruta);
			String informacionTexto = null;
			
			fr = new FileReader (ruta);
			br = new BufferedReader (fr);

			
			while((informacionTexto = br.readLine()) != null)
			{
				x++;
			}		
			wats = new String[x];
			br.close();
			
			
			int i = 0;
			fr = new FileReader (ruta);
			br = new BufferedReader (fr);
			while((informacionTexto = br.readLine()) != null)
			{
				
				wats [i] = informacionTexto;
				i++;
				
			}
			
			br.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return wats[wats.length-1];
		
		
		
	}
	
	public static String [] leerHistorial(String ruta)
	{
		
			File file = null;
			FileReader fr = null;
			BufferedReader br = null;
			String [] wats =  null;
						
			int x = 0;
		try
		{
			file = new File(ruta);
			String informacionTexto = null;
			
			fr = new FileReader (ruta);
			br = new BufferedReader (fr);

			
			while((informacionTexto = br.readLine()) != null)
			{
				x++;
			}		
			wats = new String[x];
			br.close();
			
			
			int i = 0;
			fr = new FileReader (ruta);
			br = new BufferedReader (fr);
			while((informacionTexto = br.readLine()) != null)
			{
				
				wats [i] = informacionTexto;
				i++;
				
			}
			
			br.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return wats;
		
		
		
	}
}