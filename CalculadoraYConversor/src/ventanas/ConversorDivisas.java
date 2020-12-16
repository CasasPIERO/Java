package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class ConversorDivisas extends JFrame {

	private JPanel contentPane;
	private boolean punto = true;
	private String cantidad2 = "";
	private double dinero,cambio;
	private String divisa1 = "";
	private String divisa2 = "";
	private String cantidad = "";
	private JComboBox comboDivisas1;
	private JLabel etiquetaDivisa1;
	private JLabel etiquetaCambio1;
	private JComboBox comboDivisas2;
	private JLabel etiquetaDivisa2;
	private JLabel etiquetaCambio2;
	private JButton boton4;
	private JButton boton5;
	private JButton boton9;
	private JButton botonBorrar;
	private JButton botonPunto;
	private JButton boton3;
	private JButton boton8;
	private JButton botonClear;
	private JButton boton7;
	private JButton boton1;
	private JButton boton0;
	private JButton boton6;
	private JButton boton2;

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
					ConversorDivisas frame = new ConversorDivisas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void pasarAVentanaCalculadora(){
		Calculadora calc = new Calculadora();
		calc.setVisible(true);
		dispose();
	}
	
	
	/**
	 * Create the frame.
	 */
	public ConversorDivisas() {
		setResizable(false);
		setSize(new Dimension(230, 450));
		setTitle("Conversor de Divisas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		this.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsos = new JMenu("Usos");
		mnUsos.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mnUsos);
		
		JMenuItem mntmCalculadora = new JMenuItem("Calculadora Est\u00E1ndar");
		mntmCalculadora.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\CalculadoraYConversor\\calculadora.jpg"));
		mntmCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pasarAVentanaCalculadora();
			}
		});
		mntmCalculadora.setFont(new Font("Arial", Font.PLAIN, 14));
		mnUsos.add(mntmCalculadora);
		
		JMenuItem mntmConversorDeDivisas = new JMenuItem("Conversor de Divisas");
		mntmConversorDeDivisas.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\CalculadoraYConversor\\divisas.jpg"));
		mntmConversorDeDivisas.setFont(new Font("Arial", Font.PLAIN, 14));
		mnUsos.add(mntmConversorDeDivisas);
		
		JSeparator separator = new JSeparator();
		mnUsos.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(ConversorDivisas.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mntmSalir.setFont(new Font("Arial", Font.PLAIN, 14));
		mnUsos.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		comboDivisas1 = new JComboBox();
		comboDivisas1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				divisa1 = (String)comboDivisas1.getSelectedItem();
				if(divisa1.equals("Estados Unidos - Dólar")){
					etiquetaDivisa1.setText("$");
				}else if(divisa1.equals("Perú - Nuevo Sol")){
					etiquetaDivisa1.setText("S/.");
				}else if(divisa1.equals("Europa - Euro")){
					etiquetaDivisa1.setText("€");
				}
				obtenerDinero();
			}
		});
		comboDivisas1.setModel(new DefaultComboBoxModel(new String[] {"Estados Unidos - D\u00F3lar", "Per\u00FA - Nuevo Sol", "Europa - Euro"}));
		comboDivisas1.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_comboDivisas1 = new GridBagConstraints();
		gbc_comboDivisas1.weighty = 0.5;
		gbc_comboDivisas1.weightx = 0.5;
		gbc_comboDivisas1.gridwidth = 3;
		gbc_comboDivisas1.insets = new Insets(0, 10, 5, 10);
		gbc_comboDivisas1.fill = GridBagConstraints.BOTH;
		gbc_comboDivisas1.gridx = 0;
		gbc_comboDivisas1.gridy = 1;
		panel.add(comboDivisas1, gbc_comboDivisas1);
		
		etiquetaCambio1 = new JLabel("0");
		etiquetaCambio1.setFont(new Font("Arial", Font.PLAIN, 36));
		GridBagConstraints gbc_etiquetaCambio1 = new GridBagConstraints();
		gbc_etiquetaCambio1.weighty = 0.5;
		gbc_etiquetaCambio1.weightx = 0.5;
		gbc_etiquetaCambio1.fill = GridBagConstraints.BOTH;
		gbc_etiquetaCambio1.gridwidth = 2;
		gbc_etiquetaCambio1.insets = new Insets(15, 0, 5, 0);
		gbc_etiquetaCambio1.gridx = 1;
		gbc_etiquetaCambio1.gridy = 0;
		panel.add(etiquetaCambio1, gbc_etiquetaCambio1);
		
		etiquetaDivisa1 = new JLabel("$");
		etiquetaDivisa1.setHorizontalAlignment(SwingConstants.RIGHT);
		etiquetaDivisa1.setFont(new Font("Arial", Font.PLAIN, 36));
		GridBagConstraints gbc_etiquetaDivisa1 = new GridBagConstraints();
		gbc_etiquetaDivisa1.insets = new Insets(15, 15, 5, 10);
		gbc_etiquetaDivisa1.weighty = 0.5;
		gbc_etiquetaDivisa1.weightx = 0.5;
		gbc_etiquetaDivisa1.fill = GridBagConstraints.BOTH;
		gbc_etiquetaDivisa1.gridx = 0;
		gbc_etiquetaDivisa1.gridy = 0;
		panel.add(etiquetaDivisa1, gbc_etiquetaDivisa1);
		
		comboDivisas2 = new JComboBox();
		comboDivisas2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				divisa2 = (String)comboDivisas2.getSelectedItem();
				if(divisa2.equals("Estados Unidos - Dólar")){
					etiquetaDivisa2.setText("$");
				}else if(divisa2.equals("Perú - Nuevo Sol")){
					etiquetaDivisa2.setText("S/.");
				}else if(divisa2.equals("Europa - Euro")){
					etiquetaDivisa2.setText("€");
				}
				obtenerDinero();
			}
		});
		comboDivisas2.setModel(new DefaultComboBoxModel(new String[] {"Estados Unidos - D\u00F3lar", "Per\u00FA - Nuevo Sol", "Europa - Euro"}));
		comboDivisas2.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_comboDivisas2 = new GridBagConstraints();
		gbc_comboDivisas2.weighty = 0.5;
		gbc_comboDivisas2.weightx = 0.5;
		gbc_comboDivisas2.gridwidth = 3;
		gbc_comboDivisas2.insets = new Insets(0, 10, 5, 10);
		gbc_comboDivisas2.fill = GridBagConstraints.BOTH;
		gbc_comboDivisas2.gridx = 0;
		gbc_comboDivisas2.gridy = 3;
		panel.add(comboDivisas2, gbc_comboDivisas2);
		
		etiquetaDivisa2 = new JLabel("$");
		etiquetaDivisa2.setHorizontalAlignment(SwingConstants.RIGHT);
		etiquetaDivisa2.setFont(new Font("Arial", Font.PLAIN, 36));
		GridBagConstraints gbc_etiquetaDivisa2 = new GridBagConstraints();
		gbc_etiquetaDivisa2.insets = new Insets(15, 15, 5, 10);
		gbc_etiquetaDivisa2.weighty = 0.5;
		gbc_etiquetaDivisa2.weightx = 0.5;
		gbc_etiquetaDivisa2.fill = GridBagConstraints.BOTH;
		gbc_etiquetaDivisa2.gridx = 0;
		gbc_etiquetaDivisa2.gridy = 2;
		panel.add(etiquetaDivisa2, gbc_etiquetaDivisa2);
		
		etiquetaCambio2 = new JLabel("0");
		etiquetaCambio2.setFont(new Font("Arial", Font.PLAIN, 36));
		GridBagConstraints gbc_etiquetaCambio2 = new GridBagConstraints();
		gbc_etiquetaCambio2.gridwidth = 2;
		gbc_etiquetaCambio2.fill = GridBagConstraints.BOTH;
		gbc_etiquetaCambio2.weighty = 0.5;
		gbc_etiquetaCambio2.weightx = 0.5;
		gbc_etiquetaCambio2.insets = new Insets(15, 0, 5, 0);
		gbc_etiquetaCambio2.gridx = 1;
		gbc_etiquetaCambio2.gridy = 2;
		panel.add(etiquetaCambio2, gbc_etiquetaCambio2);
		
		botonClear = new JButton("C");
		botonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantidad = "";
				punto = true;
				etiquetaCambio1.setText("0");
				etiquetaCambio2.setText("0");
			}
		});
		botonClear.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_botonClear = new GridBagConstraints();
		gbc_botonClear.weighty = 0.5;
		gbc_botonClear.weightx = 0.5;
		gbc_botonClear.fill = GridBagConstraints.BOTH;
		gbc_botonClear.insets = new Insets(15, 0, 5, 5);
		gbc_botonClear.gridx = 1;
		gbc_botonClear.gridy = 4;
		panel.add(botonClear, gbc_botonClear);
		
		botonBorrar = new JButton("");
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int tamaño = cantidad.length();
				if(tamaño > 0){
					if(tamaño == 1){
						etiquetaCambio1.setText("0");
						cantidad = "";
					}else{
						cantidad = cantidad.substring(0, cantidad.length()-1);
						etiquetaCambio1.setText(cantidad);
					}
					obtenerDinero();
				}
			}
		});
		botonBorrar.setIcon(new ImageIcon(ConversorDivisas.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
		GridBagConstraints gbc_botonBorrar = new GridBagConstraints();
		gbc_botonBorrar.insets = new Insets(15, 0, 5, 0);
		gbc_botonBorrar.weighty = 0.5;
		gbc_botonBorrar.weightx = 0.5;
		gbc_botonBorrar.fill = GridBagConstraints.BOTH;
		gbc_botonBorrar.gridx = 2;
		gbc_botonBorrar.gridy = 4;
		panel.add(botonBorrar, gbc_botonBorrar);
		
		boton7 = new JButton("7");
		boton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantidad += "7";
				etiquetaCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		boton7.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_boton7 = new GridBagConstraints();
		gbc_boton7.fill = GridBagConstraints.BOTH;
		gbc_boton7.weighty = 0.5;
		gbc_boton7.weightx = 0.5;
		gbc_boton7.insets = new Insets(0, 0, 5, 5);
		gbc_boton7.gridx = 0;
		gbc_boton7.gridy = 5;
		panel.add(boton7, gbc_boton7);
		
		boton8 = new JButton("8");
		boton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantidad += "8";
				etiquetaCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		boton8.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_boton8 = new GridBagConstraints();
		gbc_boton8.weighty = 0.5;
		gbc_boton8.weightx = 0.5;
		gbc_boton8.fill = GridBagConstraints.BOTH;
		gbc_boton8.insets = new Insets(0, 0, 5, 5);
		gbc_boton8.gridx = 1;
		gbc_boton8.gridy = 5;
		panel.add(boton8, gbc_boton8);
		
		boton9 = new JButton("9");
		boton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantidad += "9";
				etiquetaCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		boton9.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_boton9 = new GridBagConstraints();
		gbc_boton9.insets = new Insets(0, 0, 5, 0);
		gbc_boton9.fill = GridBagConstraints.BOTH;
		gbc_boton9.weighty = 0.5;
		gbc_boton9.weightx = 0.5;
		gbc_boton9.gridx = 2;
		gbc_boton9.gridy = 5;
		panel.add(boton9, gbc_boton9);
		
		boton4 = new JButton("4");
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantidad += "4";
				etiquetaCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		boton4.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_boton4 = new GridBagConstraints();
		gbc_boton4.weighty = 0.5;
		gbc_boton4.weightx = 0.5;
		gbc_boton4.fill = GridBagConstraints.BOTH;
		gbc_boton4.insets = new Insets(0, 0, 5, 5);
		gbc_boton4.gridx = 0;
		gbc_boton4.gridy = 6;
		panel.add(boton4, gbc_boton4);
		
		boton5 = new JButton("5");
		boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantidad += "5";
				etiquetaCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		boton5.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_boton5 = new GridBagConstraints();
		gbc_boton5.weighty = 0.5;
		gbc_boton5.weightx = 0.5;
		gbc_boton5.fill = GridBagConstraints.BOTH;
		gbc_boton5.insets = new Insets(0, 0, 5, 5);
		gbc_boton5.gridx = 1;
		gbc_boton5.gridy = 6;
		panel.add(boton5, gbc_boton5);
		
		boton6 = new JButton("6");
		boton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantidad += "6";
				etiquetaCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		boton6.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_boton6 = new GridBagConstraints();
		gbc_boton6.insets = new Insets(0, 0, 5, 0);
		gbc_boton6.weighty = 0.5;
		gbc_boton6.weightx = 0.5;
		gbc_boton6.fill = GridBagConstraints.BOTH;
		gbc_boton6.gridx = 2;
		gbc_boton6.gridy = 6;
		panel.add(boton6, gbc_boton6);
		
		boton1 = new JButton("1");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantidad += "1";
				etiquetaCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		boton1.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_boton1 = new GridBagConstraints();
		gbc_boton1.weighty = 0.5;
		gbc_boton1.weightx = 0.5;
		gbc_boton1.fill = GridBagConstraints.BOTH;
		gbc_boton1.insets = new Insets(0, 0, 5, 5);
		gbc_boton1.gridx = 0;
		gbc_boton1.gridy = 7;
		panel.add(boton1, gbc_boton1);
		
		boton2 = new JButton("2");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantidad += "2";
				etiquetaCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		boton2.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_boton2 = new GridBagConstraints();
		gbc_boton2.weighty = 0.5;
		gbc_boton2.weightx = 0.5;
		gbc_boton2.fill = GridBagConstraints.BOTH;
		gbc_boton2.insets = new Insets(0, 0, 5, 5);
		gbc_boton2.gridx = 1;
		gbc_boton2.gridy = 7;
		panel.add(boton2, gbc_boton2);
		
		boton3 = new JButton("3");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantidad += "3";
				etiquetaCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		boton3.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_boton3 = new GridBagConstraints();
		gbc_boton3.insets = new Insets(0, 0, 5, 0);
		gbc_boton3.weighty = 0.5;
		gbc_boton3.weightx = 0.5;
		gbc_boton3.fill = GridBagConstraints.BOTH;
		gbc_boton3.gridx = 2;
		gbc_boton3.gridy = 7;
		panel.add(boton3, gbc_boton3);
		
		boton0 = new JButton("0");
		boton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cantidad != ""){
					cantidad += "0";	
					etiquetaCambio1.setText(cantidad);
					obtenerDinero();
				}		
			}
		});
		boton0.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_boton0 = new GridBagConstraints();
		gbc_boton0.weighty = 0.5;
		gbc_boton0.weightx = 0.5;
		gbc_boton0.fill = GridBagConstraints.BOTH;
		gbc_boton0.insets = new Insets(0, 0, 0, 5);
		gbc_boton0.gridx = 1;
		gbc_boton0.gridy = 8;
		panel.add(boton0, gbc_boton0);
		
		botonPunto = new JButton(".");
		botonPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(punto){
					if(cantidad == ""){
						cantidad = "0.";
					}else{
						cantidad += ".";
					}
					etiquetaCambio1.setText(cantidad);
					punto = false;
				}
			}
		});
		botonPunto.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_botonPunto = new GridBagConstraints();
		gbc_botonPunto.weighty = 0.5;
		gbc_botonPunto.weightx = 0.5;
		gbc_botonPunto.fill = GridBagConstraints.BOTH;
		gbc_botonPunto.gridx = 2;
		gbc_botonPunto.gridy = 8;
		panel.add(botonPunto, gbc_botonPunto);
	}
	
	private void obtenerDinero(){
		cantidad2 = etiquetaCambio1.getText();
		dinero = Double.parseDouble(cantidad2);
		cambioDivisas();
		dinero *= cambio;
		etiquetaCambio2.setText(String.format("%.2f",dinero));
	}
	
	private void cambioDivisas(){
		if(divisa1.equals(divisa2)){
			cambio = 1;
		}else if(divisa1.equals("Estados Unidos - Dólar") && divisa2.equals("Perú - Nuevo Sol")){
			cambio = 3.6;
		}else if(divisa1.equals("Estados Unidos - Dólar") && divisa2.equals("Europa - Euro")){
			cambio = 0.84;
		}else if(divisa1.equals("Perú - Nuevo Sol") && divisa2.equals("Estados Unidos - Dólar")){
			cambio = 0.28;
		}else if(divisa1.equals("Perú - Nuevo Sol") && divisa2.equals("Europa - Euro")){
			cambio = 0.23;
		}else if(divisa1.equals("Europa - Euro") && divisa2.equals("Estados Unidos - Dólar")){
			cambio = 1.19;
		}else if(divisa1.equals("Europa - Euro") && divisa2.equals("Perú - Nuevo Sol")){
			cambio = 4.27;
		}
	}

}
