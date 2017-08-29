package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PantallaPrincipal extends JFrame implements ActionListener{

	PantallaLuz ventanaLuz;
	private JPanel base;
	private JLabel labelTitulo;
	private JButton botonLuz,botonAgua,botonGas,botonSalir;


	public PantallaPrincipal(){

		setTitle("Servicios Basicos");
		setResizable(false);
		                       
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
		
	}

	private void asignarComponentes(){

		Font auxFont;

		base = new JPanel();
		base.setLayout(new GridLayout(6,3,-400,20));


		labelTitulo = new JLabel("Servicios Basicos");
		auxFont=labelTitulo.getFont();
		labelTitulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 25));

		botonLuz = new JButton("Luz");
		botonAgua = new JButton("agua");
		botonGas = new JButton("gas");
		botonSalir = new JButton("salir");

		botonAgua.setEnabled(false);
		botonGas.setEnabled(false);

		base.add(new JLabel(""));
		base.add(labelTitulo);
		base.add(new JLabel(""));
		base.add(new JLabel(""));
		base.add(botonLuz);
		base.add(new JLabel(""));
		base.add(new JLabel(""));
		base.add(botonAgua);
		base.add(new JLabel(""));
		base.add(new JLabel(""));
		base.add(botonGas);
		base.add(new JLabel(""));
		base.add(new JLabel(""));
		base.add(botonSalir);
		base.add(new JLabel(""));
		base.add(new JLabel(""));
		base.add(new JLabel(""));
		base.add(new JLabel(""));

		botonSalir.addActionListener(this);
		botonLuz.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		Object botonPulsado=e.getSource();

            if(botonPulsado == botonSalir)
               	System.exit(0);
            else if(botonPulsado == botonLuz){
            	//controller_Medidor = new Controller_Medidor();
            	ventanaLuz = new PantallaLuz();
            	setVisible(false);
            	ventanaLuz.setVisible(true);
            	ventanaLuz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
    }
}