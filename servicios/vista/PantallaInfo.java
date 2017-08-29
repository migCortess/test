package vista;

import controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class  PantallaInfo extends JFrame implements ActionListener{
	private int tipo;
	private JPanel base,parteSuperior,parteCentral,izquierdaCentral,derechaCentral,pieDePagina;
	private JLabel labelTitulo,labelInfo,labelPie;
	private JButton botonHistorial,botonPromedio,botonConsumoALaFecha,botonCambiarUsuario;
	private JTextArea datos;
	private PantallaLuz ventanaLuz;
	private JScrollPane datosLargos;
	private Controller_Usuario controller_Usuario = new Controller_Usuario();
	private static Font FUENTE_TEXT_AREA = new Font("Verdana", Font.BOLD, 12);

	public PantallaInfo(int tipo){
		this.tipo=tipo;
		setTitle("Servicio Basicos");
		setResizable(false);
		                       
		Toolkit monitor=Toolkit.getDefaultToolkit();
		Dimension sizeMonitor=monitor.getScreenSize();
		int altura = sizeMonitor.height;
		int ancho = sizeMonitor.width;
		/*setSize(ancho/3,altura-200);  //pantalla principal y para pantalla de eleccion de usuario  video 66
		setLocation(ancho/8,altura/8);*/
		setSize(ancho/2,altura-200);   //tamaño para pantallas de opciones dentro de usuarios pss tambien se pone visible la pantalla de medidior
		setLocation(ancho/8,altura/8);
		/*setSize(ancho/3,altura/3);
		setLocation(ancho-500,altura/3);*/
		asignarComponentes(tipo);
		add(base);	

	}

	private void asignarComponentes(int tipo){
		if(tipo ==1)
			crearDomestico();
		else if(tipo ==2)
			crearNegocio();
		else
			crearEmpresa();
	}

	private void crearDomestico(){
		Font auxFont;
		

		base = new JPanel();
		base.setLayout(new BorderLayout());
		parteSuperior = new JPanel();
		parteSuperior.setLayout(new GridLayout(1,2,20,0));
		pieDePagina = new JPanel();
		pieDePagina.setLayout(new GridLayout(1,2,300,50));
		parteCentral= new JPanel();
		parteCentral.setLayout(new GridLayout(0,2,20,0));
		izquierdaCentral = new JPanel();
		izquierdaCentral.setLayout(new GridLayout(5,3,-300,20));
		derechaCentral = new JPanel();
		derechaCentral.setLayout(new GridLayout(3,3,-300,-500));

		labelTitulo = new JLabel("Usuario Domestico ");
		
		labelInfo = new JLabel(controller_Usuario.datosDomestico());
		labelPie = new JLabel("Cortes corp");
		auxFont=labelTitulo.getFont();
		labelTitulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 25));

		botonHistorial = new JButton("Historial");
		botonPromedio = new JButton("Promedio");
		botonConsumoALaFecha = new JButton("Consumo actual");
		botonCambiarUsuario = new JButton("Seleccionar Otro Usuario");

		datos = new JTextArea();
		datos.setLineWrap(true);
		datos.setEditable(false);
		datos.setFont(FUENTE_TEXT_AREA);

		datosLargos = new JScrollPane(datos);

		base.add(parteSuperior,BorderLayout.PAGE_START);
		base.add(parteCentral,BorderLayout.CENTER);
		base.add(pieDePagina,BorderLayout.PAGE_END);

		parteSuperior.add(labelTitulo);
		parteSuperior.add(labelInfo);

		parteCentral.add(izquierdaCentral);

		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(botonHistorial);
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(botonPromedio);
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(botonConsumoALaFecha);
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(botonCambiarUsuario);
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));

		parteCentral.add(derechaCentral);

		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(datosLargos);
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));

		
		pieDePagina.add(new JLabel(""));
		pieDePagina.add(labelPie);

		botonCambiarUsuario.addActionListener(this);
		botonHistorial.addActionListener(this);
		botonPromedio.addActionListener(this);
		botonConsumoALaFecha.addActionListener(this);	

	}
	private void crearNegocio(){

		Font auxFont;

		base = new JPanel();
		base.setLayout(new BorderLayout());
		parteSuperior = new JPanel();
		parteSuperior.setLayout(new GridLayout(1,2,20,0));
		pieDePagina = new JPanel();
		pieDePagina.setLayout(new GridLayout(1,2,300,50));
		parteCentral= new JPanel();
		parteCentral.setLayout(new GridLayout(0,2,20,0));
		izquierdaCentral = new JPanel();
		izquierdaCentral.setLayout(new GridLayout(5,3,-300,20));
		derechaCentral = new JPanel();
		derechaCentral.setLayout(new GridLayout(3,3,-300,-500));

		labelTitulo = new JLabel("Usuario Negocio ");

		labelInfo = new JLabel(controller_Usuario.datosNegocio());
		labelPie = new JLabel("Cortes corp");
		auxFont=labelTitulo.getFont();
		labelTitulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 25));

		botonHistorial = new JButton("Historial");
		botonPromedio = new JButton("Promedio");
		botonConsumoALaFecha = new JButton("Consumo actual");
		botonCambiarUsuario = new JButton("Seleccionar Otro Usuario");

		datos = new JTextArea();
		datos.setLineWrap(true);
		datos.setEditable(false);
		datos.setFont(FUENTE_TEXT_AREA);

		datosLargos = new JScrollPane(datos);

		base.add(parteSuperior,BorderLayout.PAGE_START);
		base.add(parteCentral,BorderLayout.CENTER);
		base.add(pieDePagina,BorderLayout.PAGE_END);

		parteSuperior.add(labelTitulo);
		parteSuperior.add(labelInfo);

		parteCentral.add(izquierdaCentral);

		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(botonHistorial);
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(botonPromedio);
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(botonConsumoALaFecha);
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(botonCambiarUsuario);
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));

		parteCentral.add(derechaCentral);

		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(datosLargos);
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));

		
		pieDePagina.add(new JLabel(""));
		pieDePagina.add(labelPie);

		botonCambiarUsuario.addActionListener(this);
		botonHistorial.addActionListener(this);
		botonPromedio.addActionListener(this);
		botonConsumoALaFecha.addActionListener(this);

	}
	private void crearEmpresa(){

		Font auxFont;

		base = new JPanel();
		base.setLayout(new BorderLayout());
		parteSuperior = new JPanel();
		parteSuperior.setLayout(new GridLayout(1,2,20,0));
		pieDePagina = new JPanel();
		pieDePagina.setLayout(new GridLayout(1,2,300,50));
		parteCentral= new JPanel();
		parteCentral.setLayout(new GridLayout(0,2,20,0));
		izquierdaCentral = new JPanel();
		izquierdaCentral.setLayout(new GridLayout(5,3,-300,20));
		derechaCentral = new JPanel();
		derechaCentral.setLayout(new GridLayout(3,3,-300,-500));

		labelTitulo = new JLabel("Usuario Empresa ");

		labelInfo = new JLabel(controller_Usuario.datosEmpresa());
		labelPie = new JLabel("Cortes corp");
		auxFont=labelTitulo.getFont();
		labelTitulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 25));

		botonHistorial = new JButton("Historial");
		botonPromedio = new JButton("Promedio");
		botonConsumoALaFecha = new JButton("Consumo actual");
		botonCambiarUsuario = new JButton("Seleccionar Otro Usuario");

		datos = new JTextArea();
		datos.setLineWrap(true);
		datos.setEditable(false);
		datos.setFont(FUENTE_TEXT_AREA);

		datosLargos = new JScrollPane(datos);

		base.add(parteSuperior,BorderLayout.PAGE_START);
		base.add(parteCentral,BorderLayout.CENTER);
		base.add(pieDePagina,BorderLayout.PAGE_END);

		parteSuperior.add(labelTitulo);
		parteSuperior.add(labelInfo);

		parteCentral.add(izquierdaCentral);

		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(botonHistorial);
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(botonPromedio);
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(botonConsumoALaFecha);
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(botonCambiarUsuario);
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));
		izquierdaCentral.add(new JLabel(""));

		parteCentral.add(derechaCentral);

		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(datosLargos);
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));
		derechaCentral.add(new JLabel(""));

		
		pieDePagina.add(new JLabel(""));
		pieDePagina.add(labelPie);

		botonCambiarUsuario.addActionListener(this);
		botonHistorial.addActionListener(this);
		botonPromedio.addActionListener(this);
		botonConsumoALaFecha.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		Object botonPulsado=e.getSource();

            if(botonPulsado == botonCambiarUsuario){
               	ventanaLuz = new PantallaLuz();
               	setVisible(false);
               	ventanaLuz.setVisible(true);
               	ventanaLuz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            else if(botonPulsado == botonHistorial){
            	if(tipo==1){
            		datos.setText("Su historial de consumo es: \n");
            		datos.append(controller_Usuario.historialDomestico());
            	}
            	else if(tipo==2){
            		datos.setText("Su historial de consumo es: \n");
            		datos.append(controller_Usuario.historialNegocio());
            	}
            	else{
            		datos.setText("Su historial de consumo es: \n");
            		datos.append(controller_Usuario.historialEmpresa()); 
     	
            	}
            }else if(botonPulsado == botonPromedio){
            	if(tipo==1){
            		datos.setText("El promedio de consumo de su historial es: \n$");
            		datos.append(controller_Usuario.promedioDomestico());
            	}
            	else if(tipo==2){
            		datos.setText("El promedio de consumo de su historial es: \n$");
            		datos.append(controller_Usuario.promedioNegocio());
            	}
            	else{
            		datos.setText("El promedio de consumo de su historial es: \n$");
            		datos.append(controller_Usuario.promedioEmpresa()); 
            	}
            }else{
            	if(tipo==1){
            		datos.setText("El consumo actual es: \n$");
            		datos.append(controller_Usuario.consumoActualDomestico());
            	}
            	else if(tipo==2){
            		datos.setText("El consumo actual es: \n$");
            		datos.append(controller_Usuario.consumoActualNegocio());
            	}
            	else{
            		datos.setText("El consumo actual es: \n$");
            		datos.append(controller_Usuario.consumoActualEmpresa());
            	}
            }
    }
}