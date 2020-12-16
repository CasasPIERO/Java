package ventanas;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private boolean matriz[][] = new boolean[3][3];
	private int matriz2[][] = new int [3][3];
	private String turno = "usuario1";
	private JButton botonArribaIzquierda;
	private JButton botonArribaCentro;
	private JButton botonCentroDerecha;
	private JButton botonCentral;
	private JButton botonAbajoCentro;
	private JButton botonArribaDerecha;
	private JButton botonCentroIzquierda;
	private JButton botonAbajoIzquierda;
	private JButton botonAbajoDerecha;
	private String usuario1,usuario2;
	private int gano1 = 0;
	private int gano2 = 0;
	private int empate = 0;
	private JMenuItem mostrar;
	
	/**
	 * Launch the application.
	 */
	
	private void quienJuegaPrimero(){
		VentanaTurno t = new VentanaTurno(usuario1,usuario2);
		t.setVisible(true);
		turno = t.getTurno();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void dibujarX(JButton boton){
		boton.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\TresEnRaya\\X.png"));
	}
	
	private void dibujarO(JButton boton){
		boton.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\TresEnRaya\\O.png"));
	}
	
	private void llenarCasillas(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				matriz[i][j] = true;
			}
		}
	}
	
	private void llenarMatriz(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				matriz2[i][j] = 0;
			}
		}
	}
	
	private void reiniciarJuego(){
		llenarCasillas();
		llenarMatriz();
		botonArribaIzquierda.setIcon(null);
		botonArribaCentro.setIcon(null);
		botonArribaDerecha.setIcon(null);
		botonCentroIzquierda.setIcon(null);
		botonCentral.setIcon(null);
		botonCentroDerecha.setIcon(null);
		botonAbajoIzquierda.setIcon(null);
		botonAbajoCentro.setIcon(null);
		botonAbajoDerecha.setIcon(null);
		
		quienJuegaPrimero();
	}
	
	private void comprobarGanador(){
		boolean ganador1 = false;
		boolean ganador2 = false;
		int casillasEmpate = 0;
		
		ganador1 = ganador(1);
		ganador2 = ganador(2);
		
		if(ganador1){
			++gano1;
			VentanaGanador g = new VentanaGanador(usuario1);
			g.setVisible(true);
			reiniciarJuego();
		}else if(ganador2){
			++gano2;
			VentanaGanador g = new VentanaGanador(usuario2);
			g.setVisible(true);
			reiniciarJuego();
		}else{
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(matriz2[i][j]!=0){
						++casillasEmpate;
					}
				}
			}
			
			if(casillasEmpate == 9){
				++empate;
				VentanaEmpate e = new VentanaEmpate();
				e.setVisible(true);
				reiniciarJuego();
			}else{
				casillasEmpate = 0;
			}
		}
	}
	
	private boolean ganador(int num){
		boolean ganador = false;
		
		if(matriz2[0][0]==num && matriz2[0][1]==num && matriz2[0][2]==num){
			ganador = true;
		}else if(matriz2[1][0]==num && matriz2[1][1]==num && matriz2[1][2]==num){
			ganador = true;
		}else if(matriz2[2][0]==num && matriz2[2][1]==num && matriz2[2][2]==num){
			ganador = true;
		}else if(matriz2[0][0]==num && matriz2[1][0]==num && matriz2[2][0]==num){
			ganador = true;
		}else if(matriz2[0][1]==num && matriz2[1][1]==num && matriz2[2][1]==num){
			ganador = true;
		}else if(matriz2[0][2]==num && matriz2[1][2]==num && matriz2[2][2]==num){
			ganador = true;
		}else if(matriz2[0][0]==num && matriz2[1][1]==num && matriz2[2][2]==num){
			ganador = true;
		}else if(matriz2[0][2]==num && matriz2[1][1]==num && matriz2[2][0]==num){
			ganador = true;
		}
		
		return ganador;
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(String usuarios, String usuario) {
		setSize(new Dimension(600, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		this.setLocationRelativeTo(null);
		llenarCasillas();
		llenarMatriz();
		
		this.usuario1 = usuarios;
		this.usuario2 = usuario;
		
		JMenuBar barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		JMenu menuJuego = new JMenu("Juego");
		menuJuego.setFont(new Font("Arial", Font.PLAIN, 16));
		barraMenu.add(menuJuego);
		
		JMenuItem comenzar = new JMenuItem("Comenzar de nuevo");
		comenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gano1 = 0;
				gano2 = 0;
				empate = 0;
				reiniciarJuego();
			}
		});
		comenzar.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\TresEnRaya\\comenzar.png"));
		comenzar.setFont(new Font("Arial", Font.PLAIN, 14));
		menuJuego.add(comenzar);
		
		mostrar = new JMenuItem("Mostrar tabla de resultados");
		mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaResultados ventanita = new VentanaResultados(usuario1,usuario2,gano1,gano2,empate);
				ventanita.setVisible(true);
			}
		});
		mostrar.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\TresEnRaya\\tabla.png"));
		mostrar.setFont(new Font("Arial", Font.PLAIN, 14));
		menuJuego.add(mostrar);
		
		JSeparator separator = new JSeparator();
		menuJuego.add(separator);
		
		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		salir.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\TresEnRaya\\salir.png"));
		salir.setFont(new Font("Arial", Font.PLAIN, 14));
		menuJuego.add(salir);
		
		JMenu menuAyuda = new JMenu("Ayuda");
		menuAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URI("https://ocio.uncomo.com/articulo/como-jugar-al-tres-en-raya-2442.html"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		});
		menuAyuda.setFont(new Font("Arial", Font.PLAIN, 16));
		barraMenu.add(menuAyuda);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		botonArribaIzquierda = new JButton("");
		botonArribaIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(matriz[0][0]){
					if(turno.equals("usuario1")){
						dibujarX(botonArribaIzquierda);
						matriz2[0][0] = 1;
						turno = "usuario2";
					}else{
						dibujarO(botonArribaIzquierda);
						matriz2[0][0] = 2;
						turno = "usuario1";
					}
					matriz[0][0] = false;
					comprobarGanador();
				}
			}
		});
		botonArribaIzquierda.setIcon(null);
		panel.add(botonArribaIzquierda);
		
		botonArribaCentro = new JButton("");
		botonArribaCentro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(matriz[0][1]){
					if(turno.equals("usuario1")){
						dibujarX(botonArribaCentro);
						matriz2[0][1] = 1;
						turno = "usuario2";
					}else{
						dibujarO(botonArribaCentro);
						matriz2[0][1] = 2;
						turno = "usuario1";
					}
					matriz[0][1] = false;
					comprobarGanador();
				}
			}
		});
		botonArribaCentro.setIcon(null);
		panel.add(botonArribaCentro);
		
		botonArribaDerecha = new JButton("");
		botonArribaDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(matriz[0][2]){
					if(turno.equals("usuario1")){
						dibujarX(botonArribaDerecha);
						matriz2[0][2] = 1;
						turno = "usuario2";
					}else{
						dibujarO(botonArribaDerecha);
						matriz2[0][2] = 2;
						turno = "usuario1";
					}
					matriz[0][2] = false;
					comprobarGanador();
				}
			}
		});
		panel.add(botonArribaDerecha);
		
		botonCentroIzquierda = new JButton("");
		botonCentroIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(matriz[1][0]){
					if(turno.equals("usuario1")){
						dibujarX(botonCentroIzquierda);
						matriz2[1][0] = 1;
						turno = "usuario2";
					}else{
						dibujarO(botonCentroIzquierda);
						matriz2[1][0] = 2;
						turno = "usuario1";
					}
					matriz[1][0] = false;
					comprobarGanador();
				}
			}
		});
		panel.add(botonCentroIzquierda);
		
		botonCentral = new JButton("");
		botonCentral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(matriz[1][1]){
					if(turno.equals("usuario1")){
						dibujarX(botonCentral);
						matriz2[1][1] = 1;
						turno = "usuario2";
					}else{
						dibujarO(botonCentral);
						matriz2[1][1] = 2;
						turno = "usuario1";
					}
					matriz[1][1] = false;
					comprobarGanador();
				}
			}
		});
		panel.add(botonCentral);
		
		botonCentroDerecha = new JButton("");
		botonCentroDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(matriz[1][2]){
					if(turno.equals("usuario1")){
						dibujarX(botonCentroDerecha);
						matriz2[1][2] = 1;
						turno = "usuario2";
					}else{
						dibujarO(botonCentroDerecha);
						matriz2[1][2] = 2;
						turno = "usuario1";
					}
					matriz[1][2] = false;
					comprobarGanador();
				}
			}
		});
		panel.add(botonCentroDerecha);
		
		botonAbajoIzquierda = new JButton("");
		botonAbajoIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(matriz[2][0]){
					if(turno.equals("usuario1")){
						dibujarX(botonAbajoIzquierda);
						matriz2[2][0] = 1;
						turno = "usuario2";
					}else{
						dibujarO(botonAbajoIzquierda);
						matriz2[2][0] = 2;
						turno = "usuario1";
					}
					matriz[2][0] = false;
					comprobarGanador();
				}
			}
		});
		panel.add(botonAbajoIzquierda);
		
		botonAbajoCentro = new JButton("");
		botonAbajoCentro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(matriz[2][1]){
					if(turno.equals("usuario1")){
						dibujarX(botonAbajoCentro);
						matriz2[2][1] = 1;
						turno = "usuario2";
					}else{
						dibujarO(botonAbajoCentro);
						matriz2[2][1] = 2;
						turno = "usuario1";
					}
					matriz[2][1] = false;
					comprobarGanador();
				}
			}
		});
		panel.add(botonAbajoCentro);
		
		botonAbajoDerecha = new JButton("");
		botonAbajoDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(matriz[2][2]){
					if(turno.equals("usuario1")){
						dibujarX(botonAbajoDerecha);
						matriz2[2][2] = 1;
						turno = "usuario2";
					}else{
						dibujarO(botonAbajoDerecha);
						matriz2[2][2] = 2;
						turno = "usuario1";
					}
					matriz[2][2] = false;
					comprobarGanador();
				}
			}
		});
		panel.add(botonAbajoDerecha);
		
	}

}
