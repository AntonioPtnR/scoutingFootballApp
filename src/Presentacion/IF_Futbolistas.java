package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;



import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import Dominio.Jugador;

import java.awt.SystemColor;
import java.util.Vector;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IF_Futbolistas extends JInternalFrame {
	
	private static IF_Futbolistas instancia;
	private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarra = null;   
	private JPanel pnlBusqueda;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblPrecio;
	private JComboBox cbPrecio;
	private JScrollPane scrollPane;
	private JTable tablaJugadores;
	
	MiTablaJugadores tablaModeloJugadores = new MiTablaJugadores();
	private JLabel lblPosicion;
	private JComboBox cbPosicion;
	private JButton btnInformacion;
	private JButton btnFiltrar;
    

	   public static IF_Futbolistas getInstancia() {
	       // Si la instancia no está creada o la ventana está cerrada se crea la instancia

	       if (instancia == null || instancia.isClosed) {
	          instancia = new IF_Futbolistas();
	      }
	       return instancia;
	   }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IF_Futbolistas frame = new IF_Futbolistas();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IF_Futbolistas() {
		getContentPane().setBackground(SystemColor.window);
		setBackground(UIManager.getColor("textHighlight"));
		setBorder(null);
		setFrameIcon(new ImageIcon(IF_Futbolistas.class.getResource("/Presentacion/logoApp.png")));
		setTitle("Base de datos de jugadores");
		setBounds(new Rectangle(0, 0, 1150, 759));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{122, 135, 177, 89, 32, 180, 179, 0};
		gridBagLayout.rowHeights = new int[]{131, 106, 97, 68, 123, 149, 49, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		pnlBusqueda = new JPanel();
		pnlBusqueda.setBackground(SystemColor.window);
		GridBagConstraints gbc_pnlBusqueda = new GridBagConstraints();
		gbc_pnlBusqueda.gridwidth = 7;
		gbc_pnlBusqueda.insets = new Insets(0, 0, 5, 0);
		gbc_pnlBusqueda.fill = GridBagConstraints.BOTH;
		gbc_pnlBusqueda.gridx = 0;
		gbc_pnlBusqueda.gridy = 0;
		getContentPane().add(pnlBusqueda, gbc_pnlBusqueda);
		GridBagLayout gbl_pnlBusqueda = new GridBagLayout();
		gbl_pnlBusqueda.columnWidths = new int[]{44, 62, 122, 87, 101, 136, 97, 96, 135, 186, 52, 18, 0};
		gbl_pnlBusqueda.rowHeights = new int[]{47, 52, 30, 0};
		gbl_pnlBusqueda.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBusqueda.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlBusqueda.setLayout(gbl_pnlBusqueda);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Georgia", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		pnlBusqueda.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 1;
		pnlBusqueda.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblPosicion = new JLabel("Posición");
		lblPosicion.setFont(new Font("Georgia", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPosicion = new GridBagConstraints();
		gbc_lblPosicion.anchor = GridBagConstraints.EAST;
		gbc_lblPosicion.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosicion.gridx = 4;
		gbc_lblPosicion.gridy = 1;
		pnlBusqueda.add(lblPosicion, gbc_lblPosicion);
		
		cbPosicion = new JComboBox();
		cbPosicion.setModel(new DefaultComboBoxModel(new String[] {"", "Portero", "Defensa", "Centrocampista", "Delantero"}));
		GridBagConstraints gbc_cbPosicion = new GridBagConstraints();
		gbc_cbPosicion.insets = new Insets(0, 0, 5, 5);
		gbc_cbPosicion.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbPosicion.gridx = 5;
		gbc_cbPosicion.gridy = 1;
		pnlBusqueda.add(cbPosicion, gbc_cbPosicion);
		
		lblPrecio = new JLabel("Precio (M)");
		lblPrecio.setFont(new Font("Georgia", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.fill = GridBagConstraints.VERTICAL;
		gbc_lblPrecio.gridx = 7;
		gbc_lblPrecio.gridy = 1;
		pnlBusqueda.add(lblPrecio, gbc_lblPrecio);
		
		cbPrecio = new JComboBox();
		cbPrecio.setModel(new DefaultComboBoxModel(new String[] {"", "< 200", "< 150", "< 100", "< 50", "< 1", "< 0.5", "< 0.2", "< 0.1", "0"}));
		GridBagConstraints gbc_cbPrecio = new GridBagConstraints();
		gbc_cbPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_cbPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbPrecio.gridx = 8;
		gbc_cbPrecio.gridy = 1;
		pnlBusqueda.add(cbPrecio, gbc_cbPrecio);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new BtnFiltrarActionListener());
		btnFiltrar.setBorderPainted(false);
		btnFiltrar.setBorder(null);
		btnFiltrar.setForeground(SystemColor.desktop);
		btnFiltrar.setBackground(SystemColor.window);
		btnFiltrar.setIcon(new ImageIcon(IF_Futbolistas.class.getResource("/Presentacion/filtrar_icono.png")));
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnFiltrar.gridx = 9;
		gbc_btnFiltrar.gridy = 1;
		pnlBusqueda.add(btnFiltrar, gbc_btnFiltrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setForeground(SystemColor.textHighlight);
		scrollPane.setBackground(SystemColor.window);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		tablaJugadores = new JTable();
		scrollPane.setViewportView(tablaJugadores);
		tablaJugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaJugadores.setBackground(Color.WHITE);
		tablaJugadores.setModel(tablaModeloJugadores);
		
		btnInformacion = new JButton("Mostrar datos");
		btnInformacion.setBackground(Color.LIGHT_GRAY);
		btnInformacion.addActionListener(new BtnInformacionActionListener());
		GridBagConstraints gbc_btnInformacion = new GridBagConstraints();
		gbc_btnInformacion.fill = GridBagConstraints.BOTH;
		gbc_btnInformacion.gridwidth = 7;
		gbc_btnInformacion.gridx = 0;
		gbc_btnInformacion.gridy = 6;
		getContentPane().add(btnInformacion, gbc_btnInformacion);
		aniadirValoresTabla();
		QuitarLaBarraTitulo();
		

	}
	
	public void QuitarLaBarraTitulo()
	{
	Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	DimensionBarra = Barra.getPreferredSize();
	Barra.setSize(0,0);
	Barra.setPreferredSize(new Dimension(0,0));
	repaint();
	}
	public void vaciarTabla() {
		while(tablaModeloJugadores.getRowCount() > 0)
			tablaModeloJugadores.eliminarFila(0);
		tablaModeloJugadores.fireTableDataChanged();
	}
	public void aniadirValoresTabla() {
		
		try {
			Vector<Jugador> jugadores = aniadirValoresPrecio();
			jugadores = aniadirJugadoresPosicion(jugadores);
			jugadores = aniadirJugadoresNombre(jugadores);
			vaciarTabla();
			for(int i = jugadores.size() -1; i >= 0;i--) {
				Object[] vectorJugador = {jugadores.get(i).getNombre(), jugadores.get(i).getPosicion(), jugadores.get(i).getDisparo(), jugadores.get(i).getPase(), jugadores.get(i).getRegate(), jugadores.get(i).getDefensa(), jugadores.get(i).getGoles_encajados(), jugadores.get(i).getVelocidad(), jugadores.get(i).getValor()};
				tablaModeloJugadores.anadirFila(vectorJugador);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	public Vector<Jugador> aniadirValoresPrecio(){
		Jugador j = new Jugador();
		Vector<Jugador> jugadores = null;
		try {
			if(!cbPrecio.getSelectedItem().toString().isEmpty())
			jugadores = j.readValor(Double.parseDouble(cbPrecio.getSelectedItem().toString().substring(2)));
			else 
				jugadores = j.read();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jugadores;
	}
	
	public Vector<Jugador> aniadirJugadoresPosicion(Vector<Jugador> j){
		Vector<Jugador> jugadores = aniadirValoresPrecio();
		jugadores.clear();
		
		for(int i = 0; i< j.size();i++) {
			
			if(j.elementAt(i).getPosicion().equals(cbPosicion.getSelectedItem().toString()) || cbPosicion.getSelectedItem().equals(""))
				jugadores.add(j.elementAt(i));
		}
		
		
		return jugadores;
		
	}
	
	public Vector<Jugador> aniadirJugadoresNombre(Vector<Jugador> j){
		Vector<Jugador> jugadores = aniadirValoresPrecio();
		jugadores.clear();
		
		for(int i = 0; i< j.size();i++) {
			
			if(j.elementAt(i).getNombre().equals(txtNombre.getText()) || txtNombre.getText().equals(""))
				jugadores.add(j.elementAt(i));
		}
		
		
		return jugadores;
		
	}
	
	
	private class BtnFiltrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
					aniadirValoresTabla();
					
		}
	}
	private class BtnInformacionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int n = tablaJugadores.getSelectedRow();
			//int m = tablaJugadores.getSelectedColumn();
			VentanaAtributosJugador ventanaAtributosJ = new VentanaAtributosJugador(tablaModeloJugadores.getValueAt(n, 0).toString());
			ventanaAtributosJ.setVisible(true);
			ventanaAtributosJ.setLocationRelativeTo(null);
			
			
		}
	}
}
