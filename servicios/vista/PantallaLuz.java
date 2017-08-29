package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controller.Controller_Medidor;

public class PantallaLuz extends JFrame implements ActionListener{

	PantallaInfo ventanaDomestico;
	PantallaInfo ventanaNegocio;
	PantallaInfo ventanaEmpresa;
	//PantallaEmulador ventanaEDomestico,ventanaENegocio,ventanaEEmpresa;
	private JPanel base;
	private JLabel labelTitulo;
	private JButton botonDomestico,botonNegocio,botonEmpresa,botonSalir;
	private Controller_Medidor controller_Medidor;


	public PantallaLuz(){

		setTitle("Servicio Basicos");
		setResizable(false);
		controller_Medidor = new Controller_Medidor();                       
		Toolkit monitor=Toolkit.getDefaultToolkit();
		Dimension sizeMonitor=monitor.getScreenSize();
		int altura = sizeMonitor.height;
		int ancho = sizeMonitor.width;
		setSize(ancho/3,altura-200);  //pantalla principal y para pantalla de eleccion de usuario  video 66
		setLocation(ancho/8,altura/8);
		/*setSize(ancho/2,altura-200);   //tamaño para pantallas de opciones dentro de usuarios pss tambien se pone visible la pantalla de medidior
		setLocation(ancho/8,altura/8);
		setSize(ancho/3,altura/3);
		setLocation(ancho-500,altura/3);*/
		asignarComponentes();
		add(base);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private void asignarComponentes(){

		Font auxFont;

		base = new JPanel();
		base.setLayout(new GridLayout(6,3,-400,20));


		labelTitulo = new JLabel("Servicios de luz");
		auxFont=labelTitulo.getFont();
		labelTitulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 25));

		botonDomestico = new JButton("Servicio Domestico");
		botonNegocio = new JButton("Servicio Negocio");
		botonEmpresa = new JButton("Servicio Empresa");
		botonSalir = new JButton("salir");

		base.add(new JLabel(""));
		base.add(labelTitulo);
		base.add(new JLabel(""));
		base.add(new JLabel(""));
		base.add(botonDomestico);
		base.add(new JLabel(""));
		base.add(new JLabel(""));
		base.add(botonNegocio);
		base.add(new JLabel(""));
		base.add(new JLabel(""));
		base.add(botonEmpresa);
		base.add(new JLabel(""));
		base.add(new JLabel(""));
		base.add(botonSalir);
		base.add(new JLabel(""));
		base.add(new JLabel(""));
		base.add(new JLabel(""));
		base.add(new JLabel(""));

		botonSalir.addActionListener(this);
		botonDomestico.addActionListener(this);
		botonNegocio.addActionListener(this);
		botonEmpresa.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		Object botonPulsado=e.getSource();

            if(botonPulsado == botonSalir){
            	controller_Medidor.detenerEmulador();
               	System.exit(0);
            }
            else if(botonPulsado == botonDomestico){
            	//ventanaEDomestico = new PantallaEmulador(controller_Medidor,1);
            	//ventanaEDomestico.setVisible(true);
            	ventanaDomestico = new PantallaInfo(1);
            	setVisible(false);
            	ventanaDomestico.setVisible(true);
            	ventanaDomestico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }else if(botonPulsado == botonNegocio){
            	//ventanaENegocio = new PantallaEmulador(controller_Medidor,2);
            	//ventanaENegocio.setVisible(true);
            	ventanaNegocio = new PantallaInfo(2);
            	setVisible(false);
            	ventanaNegocio.setVisible(true);
            	ventanaNegocio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }else{
            	//ventanaEEmpresa = new PantallaEmulador(controller_Medidor,3);
            	//ventanaEEmpresa.setVisible(true);
            	ventanaEmpresa = new PantallaInfo(3);
            	setVisible(false);
            	ventanaEmpresa.setVisible(true);
            	ventanaEmpresa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
    }
}