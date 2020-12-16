package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.ImageIcon;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JButton boton8;
	private JButton boton2;
	private JButton botonDividir;
	private JButton botonPunto;
	private JButton boton9;
	private JButton boton5;
	private JButton boton6;
	private JButton boton3;
	private JButton botonBorrar;
	private JButton boton7;
	private JButton boton0;
	private JButton botonResta;
	private JButton boton1;
	private JButton botonSuma;
	private JButton botonClear;
	private JButton boton4;
	private JButton botonRaiz;
	private JButton botonMasMenos;
	private JButton botonIgual;
	private JButton botonMultiplicacion;
	private JLabel etiquetaArriba;
	private JLabel etiquetaAbajo;
	private String cadena = "";
	private double num1;
	private String operacion = "nula";
	private double resultado;
	private boolean activado = true;
	private boolean punto = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void cambiarAVentanaConversor(){
		ConversorDivisas conversor = new ConversorDivisas();
		conversor.setVisible(true);
		dispose();
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		setResizable(false);
		setTitle("Calculadora Est\u00E1ndar");
		setSize(new Dimension(300, 484));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		this.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuUsos = new JMenu("Usos");
		menuUsos.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(menuUsos);
		
		JMenuItem mntmCalculadora = new JMenuItem("Calculadora Est\u00E1ndar");
		mntmCalculadora.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\CalculadoraYConversor\\calculadora.jpg"));
		mntmCalculadora.setFont(new Font("Arial", Font.PLAIN, 14));
		menuUsos.add(mntmCalculadora);
		
		JMenuItem mntmConversorDeDivisas = new JMenuItem("Conversor de Divisas");
		mntmConversorDeDivisas.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\CalculadoraYConversor\\divisas.jpg"));
		mntmConversorDeDivisas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiarAVentanaConversor();
			}
		});
		mntmConversorDeDivisas.setFont(new Font("Arial", Font.PLAIN, 14));
		menuUsos.add(mntmConversorDeDivisas);
		
		JSeparator separator = new JSeparator();
		menuUsos.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(Calculadora.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mntmSalir.setFont(new Font("Arial", Font.PLAIN, 14));
		menuUsos.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{62, 49, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		etiquetaArriba = new JLabel("");
		etiquetaArriba.setHorizontalAlignment(SwingConstants.RIGHT);
		etiquetaArriba.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_etiquetaArriba = new GridBagConstraints();
		gbc_etiquetaArriba.gridwidth = 4;
		gbc_etiquetaArriba.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaArriba.weightx = 0.5;
		gbc_etiquetaArriba.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaArriba.gridx = 0;
		gbc_etiquetaArriba.gridy = 0;
		panel.add(etiquetaArriba, gbc_etiquetaArriba);
		
		botonIgual = new JButton("=\r\n");
		botonIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double num2;
				if(operacion.equals("nula")){
					etiquetaAbajo.setText(cadena);
				}else if(operacion.equals("suma")){
					num2 = Double.parseDouble(cadena);
					resultado = num1 + num2;
					etiquetaAbajo.setText(String.format("%.2f",resultado));
					cadena = String.valueOf(resultado);
					operacion = "nula";
				}else if(operacion.equals("resta")){
					num2 = Double.parseDouble(cadena);
					resultado = num1 - num2;
					etiquetaAbajo.setText(String.format("%.2f",resultado));
					cadena = String.valueOf(resultado);
					operacion = "nula";
				}else if(operacion.equals("multiplicar")){
					num2 = Double.parseDouble(cadena);
					resultado = num1 * num2;
					etiquetaAbajo.setText(String.format("%.2f",resultado));
					cadena = String.valueOf(resultado);
					operacion = "nula";
				}else if(operacion.equals("division")){
					num2 = Double.parseDouble(cadena);
					resultado = num1 / num2;
					etiquetaAbajo.setText(String.format("%.2f",resultado));
					cadena = String.valueOf(resultado);
					operacion = "nula";
				}
				
				etiquetaArriba.setText("");
				activado = true;
			}
		});
		botonIgual.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_botonIgual = new GridBagConstraints();
		gbc_botonIgual.ipady = 30;
		gbc_botonIgual.weightx = 0.5;
		gbc_botonIgual.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonIgual.insets = new Insets(0, 0, 5, 0);
		gbc_botonIgual.gridx = 3;
		gbc_botonIgual.gridy = 6;
		panel.add(botonIgual, gbc_botonIgual);
		
		botonPunto = new JButton(".");
		botonPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(punto == true){
					if(cadena == ""){
						cadena += "0.";
					}else{
						cadena += ".";
					}
					etiquetaAbajo.setText(cadena);
					punto = false;
				}
				
			}
		});
		botonPunto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_botonPunto = new GridBagConstraints();
		gbc_botonPunto.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonPunto.ipady = 30;
		gbc_botonPunto.weightx = 0.5;
		gbc_botonPunto.insets = new Insets(0, 0, 0, 5);
		gbc_botonPunto.gridx = 2;
		gbc_botonPunto.gridy = 6;
		panel.add(botonPunto, gbc_botonPunto);
		
		boton0 = new JButton("0");
		boton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cadena != ""){
					if(etiquetaAbajo.getText() == "0"){
						cadena = "0";
					}else{
						cadena += "0";
					}
					etiquetaAbajo.setText(cadena);
					activado = true;
				}
			}
		});
		boton0.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_boton0 = new GridBagConstraints();
		gbc_boton0.weightx = 0.5;
		gbc_boton0.ipady = 30;
		gbc_boton0.fill = GridBagConstraints.HORIZONTAL;
		gbc_boton0.insets = new Insets(0, 0, 0, 5);
		gbc_boton0.gridx = 1;
		gbc_boton0.gridy = 6;
		panel.add(boton0, gbc_boton0);
		
		botonMasMenos = new JButton("\u00B1");
		botonMasMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double numero;
				if(cadena.charAt(0) != '-'){
					cadena = "-" + cadena;
				}else{
					cadena = cadena.substring(1, cadena.length());
				}
				etiquetaAbajo.setText(cadena);
			}
		});
		botonMasMenos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_botonMasMenos = new GridBagConstraints();
		gbc_botonMasMenos.ipady = 30;
		gbc_botonMasMenos.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonMasMenos.weightx = 0.5;
		gbc_botonMasMenos.insets = new Insets(0, 0, 0, 5);
		gbc_botonMasMenos.gridx = 0;
		gbc_botonMasMenos.gridy = 6;
		panel.add(botonMasMenos, gbc_botonMasMenos);
		
		botonSuma = new JButton("+");
		botonSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(activado == true){
					num1 = Double.parseDouble(cadena);
					etiquetaArriba.setText(cadena + " + ");
					cadena = "";
					operacion = "suma";
					activado = false;
					punto = true;
				}
			}
		});
		botonSuma.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_botonSuma = new GridBagConstraints();
		gbc_botonSuma.insets = new Insets(0, 0, 5, 0);
		gbc_botonSuma.weightx = 0.5;
		gbc_botonSuma.ipady = 30;
		gbc_botonSuma.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonSuma.gridx = 3;
		gbc_botonSuma.gridy = 5;
		panel.add(botonSuma, gbc_botonSuma);
		
		boton3 = new JButton("3");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(etiquetaAbajo.getText() == "0"){
					cadena = "3";
				}else{
					cadena += "3";
				}
				etiquetaAbajo.setText(cadena);
				activado = true;
			}
		});
		boton3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_boton3 = new GridBagConstraints();
		gbc_boton3.fill = GridBagConstraints.HORIZONTAL;
		gbc_boton3.ipady = 30;
		gbc_boton3.weightx = 0.5;
		gbc_boton3.insets = new Insets(0, 0, 5, 5);
		gbc_boton3.gridx = 2;
		gbc_boton3.gridy = 5;
		panel.add(boton3, gbc_boton3);
		
		boton2 = new JButton("2");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(etiquetaAbajo.getText() == "0"){
					cadena = "2";
				}else{
					cadena += "2";
				}
				etiquetaAbajo.setText(cadena);
				activado = true;
			}
		});
		boton2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_boton2 = new GridBagConstraints();
		gbc_boton2.ipady = 30;
		gbc_boton2.weightx = 0.5;
		gbc_boton2.fill = GridBagConstraints.HORIZONTAL;
		gbc_boton2.insets = new Insets(0, 0, 5, 5);
		gbc_boton2.gridx = 1;
		gbc_boton2.gridy = 5;
		panel.add(boton2, gbc_boton2);
		
		boton1 = new JButton("1");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(etiquetaAbajo.getText() == "0"){
					cadena = "1";
				}else{
					cadena += "1";
				}
				etiquetaAbajo.setText(cadena);
				activado = true;
			}
		});
		boton1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_boton1 = new GridBagConstraints();
		gbc_boton1.ipady = 30;
		gbc_boton1.fill = GridBagConstraints.HORIZONTAL;
		gbc_boton1.weightx = 0.5;
		gbc_boton1.insets = new Insets(0, 0, 5, 5);
		gbc_boton1.gridx = 0;
		gbc_boton1.gridy = 5;
		panel.add(boton1, gbc_boton1);
		
		botonResta = new JButton("-");
		botonResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(activado == true){
					num1 = Double.parseDouble(cadena);
					etiquetaArriba.setText(cadena + " - ");
					cadena = "";
					operacion = "resta";
					activado = false;
					punto = true;
				}
			}
		});
		botonResta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_botonResta = new GridBagConstraints();
		gbc_botonResta.insets = new Insets(0, 0, 5, 0);
		gbc_botonResta.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonResta.ipady = 30;
		gbc_botonResta.weightx = 0.5;
		gbc_botonResta.gridx = 3;
		gbc_botonResta.gridy = 4;
		panel.add(botonResta, gbc_botonResta);
		
		boton6 = new JButton("6");
		boton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(etiquetaAbajo.getText() == "0"){
					cadena = "6";
				}else{
					cadena += "6";
				}
				etiquetaAbajo.setText(cadena);
				activado = true;
			}
		});
		boton6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_boton6 = new GridBagConstraints();
		gbc_boton6.ipady = 30;
		gbc_boton6.weightx = 0.5;
		gbc_boton6.fill = GridBagConstraints.HORIZONTAL;
		gbc_boton6.insets = new Insets(0, 0, 5, 5);
		gbc_boton6.gridx = 2;
		gbc_boton6.gridy = 4;
		panel.add(boton6, gbc_boton6);
		
		boton5 = new JButton("5");
		boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(etiquetaAbajo.getText() == "0"){
					cadena = "5";
				}else{
					cadena += "5";
				}
				etiquetaAbajo.setText(cadena);
				activado = true;
			}
		});
		boton5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_boton5 = new GridBagConstraints();
		gbc_boton5.fill = GridBagConstraints.HORIZONTAL;
		gbc_boton5.weightx = 0.5;
		gbc_boton5.ipady = 30;
		gbc_boton5.insets = new Insets(0, 0, 5, 5);
		gbc_boton5.gridx = 1;
		gbc_boton5.gridy = 4;
		panel.add(boton5, gbc_boton5);
		
		boton4 = new JButton("4");
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(etiquetaAbajo.getText() == "0"){
					cadena = "4";
				}else{
					cadena += "4";
				}
				etiquetaAbajo.setText(cadena);
				activado = true;
			}
		});
		boton4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_boton4 = new GridBagConstraints();
		gbc_boton4.weightx = 0.5;
		gbc_boton4.ipady = 30;
		gbc_boton4.fill = GridBagConstraints.HORIZONTAL;
		gbc_boton4.insets = new Insets(0, 0, 5, 5);
		gbc_boton4.gridx = 0;
		gbc_boton4.gridy = 4;
		panel.add(boton4, gbc_boton4);
		
		botonMultiplicacion = new JButton("*");
		botonMultiplicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(activado == true){
					num1 = Double.parseDouble(cadena);
					etiquetaArriba.setText(cadena + " * ");
					cadena = "";
					operacion = "multiplicar";
					activado = false;
					punto = true;
				}
			}
		});
		botonMultiplicacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_botonMultiplicacion = new GridBagConstraints();
		gbc_botonMultiplicacion.insets = new Insets(0, 0, 5, 0);
		gbc_botonMultiplicacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonMultiplicacion.weightx = 0.5;
		gbc_botonMultiplicacion.ipady = 30;
		gbc_botonMultiplicacion.gridx = 3;
		gbc_botonMultiplicacion.gridy = 3;
		panel.add(botonMultiplicacion, gbc_botonMultiplicacion);
		
		boton9 = new JButton("9");
		boton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(etiquetaAbajo.getText() == "0"){
					cadena = "9";
				}else{
					cadena += "9";
				}
				etiquetaAbajo.setText(cadena);
				activado = true;
			}
		});
		boton9.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_boton9 = new GridBagConstraints();
		gbc_boton9.fill = GridBagConstraints.HORIZONTAL;
		gbc_boton9.weightx = 0.5;
		gbc_boton9.ipady = 30;
		gbc_boton9.insets = new Insets(0, 0, 5, 5);
		gbc_boton9.gridx = 2;
		gbc_boton9.gridy = 3;
		panel.add(boton9, gbc_boton9);
		
		boton8 = new JButton("8");
		boton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(etiquetaAbajo.getText() == "0"){
					cadena = "8";
				}else{
					cadena += "8";
				}
				etiquetaAbajo.setText(cadena);
				activado = true;
			}
		});
		boton8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_boton8 = new GridBagConstraints();
		gbc_boton8.ipady = 30;
		gbc_boton8.fill = GridBagConstraints.HORIZONTAL;
		gbc_boton8.insets = new Insets(0, 0, 5, 5);
		gbc_boton8.gridx = 1;
		gbc_boton8.gridy = 3;
		panel.add(boton8, gbc_boton8);
		
		boton7 = new JButton("7");
		boton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(etiquetaAbajo.getText() == "0"){
					cadena = "7";
				}else{
					cadena += "7";
				}
				etiquetaAbajo.setText(cadena);
				activado = true;
			}
		});
		boton7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_boton7 = new GridBagConstraints();
		gbc_boton7.fill = GridBagConstraints.HORIZONTAL;
		gbc_boton7.weightx = 0.5;
		gbc_boton7.ipady = 30;
		gbc_boton7.insets = new Insets(0, 0, 5, 5);
		gbc_boton7.gridx = 0;
		gbc_boton7.gridy = 3;
		panel.add(boton7, gbc_boton7);
		
		botonBorrar = new JButton("");
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int tamaño = cadena.length();
				if(tamaño > 0){
					if(tamaño == 1){
						cadena = "0";
					}else{
						cadena = cadena.substring(0, cadena.length()-1);
					}
					etiquetaAbajo.setText(cadena);
				}
				
			}
		});
		botonBorrar.setIcon(new ImageIcon(Calculadora.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		botonBorrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_botonBorrar = new GridBagConstraints();
		gbc_botonBorrar.ipady = 30;
		gbc_botonBorrar.weightx = 0.5;
		gbc_botonBorrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonBorrar.insets = new Insets(0, 0, 5, 0);
		gbc_botonBorrar.gridx = 3;
		gbc_botonBorrar.gridy = 2;
		panel.add(botonBorrar, gbc_botonBorrar);
		
		botonDividir = new JButton("/");
		botonDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(activado == true){
					num1 = Double.parseDouble(cadena);
					etiquetaArriba.setText(cadena + " / ");
					cadena = "";
					operacion = "division";
					activado = false;
					punto = true;
				}
			}
		});
		botonDividir.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_botonDividir = new GridBagConstraints();
		gbc_botonDividir.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonDividir.ipady = 30;
		gbc_botonDividir.weightx = 0.5;
		gbc_botonDividir.insets = new Insets(0, 0, 5, 5);
		gbc_botonDividir.gridx = 2;
		gbc_botonDividir.gridy = 2;
		panel.add(botonDividir, gbc_botonDividir);
		
		etiquetaAbajo = new JLabel("0");
		etiquetaAbajo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
		etiquetaAbajo.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_etiquetaAbajo = new GridBagConstraints();
		gbc_etiquetaAbajo.gridwidth = 4;
		gbc_etiquetaAbajo.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaAbajo.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaAbajo.weightx = 0.5;
		gbc_etiquetaAbajo.gridx = 0;
		gbc_etiquetaAbajo.gridy = 1;
		panel.add(etiquetaAbajo, gbc_etiquetaAbajo);
		
		botonClear = new JButton("C");
		botonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				etiquetaArriba.setText("");
				etiquetaAbajo.setText("0");
				cadena = "";
				activado = true;
				punto = true;
			}
		});
		botonClear.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_botonClear = new GridBagConstraints();
		gbc_botonClear.ipady = 30;
		gbc_botonClear.insets = new Insets(0, 0, 5, 5);
		gbc_botonClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonClear.weightx = 0.5;
		gbc_botonClear.gridx = 0;
		gbc_botonClear.gridy = 2;
		panel.add(botonClear, gbc_botonClear);
		
		botonRaiz = new JButton("");
		botonRaiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				num1 = Double.parseDouble(cadena);
				etiquetaArriba.setText("sqrt(" + cadena + ")");
				resultado = Math.sqrt(num1);
				etiquetaAbajo.setText(String.format("%.2f",resultado));
				cadena = String.valueOf(resultado);
				punto = true;
			}
		});
		botonRaiz.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\CalculadoraYConversor\\raizCuadrada.jpg"));
		botonRaiz.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_botonRaiz = new GridBagConstraints();
		gbc_botonRaiz.insets = new Insets(0, 0, 5, 5);
		gbc_botonRaiz.ipady = 30;
		gbc_botonRaiz.weightx = 0.5;
		gbc_botonRaiz.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonRaiz.gridx = 1;
		gbc_botonRaiz.gridy = 2;
		panel.add(botonRaiz, gbc_botonRaiz);
	}

}
