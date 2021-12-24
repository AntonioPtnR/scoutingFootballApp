package Presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JList;
import java.awt.GridBagConstraints;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import Dominio.Jugador;
import Dominio.Usuario;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IF_Chollos extends JInternalFrame {
	
	private static IF_Chollos instancia;
	private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarra = null;
	private JButton btnMostrarDatos;
	private JPanel pnlSuperior;
	private JLabel lblNombreEntidad;
	private JLabel lblPresupuesto;
	private JLabel lblRentabilidad;
	private JTextField txtIR;
	private JScrollPane scrollPane;
	private JTable tablaChollosJugadores;
	private static String nombre_usuario;
	
	MiTablaChollos modeloTablaChollos = new MiTablaChollos();
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IF_Chollos frame = new IF_Chollos(nombre_usuario);
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
	
	 public static  IF_Chollos getInstancia() {
	       // Si la instancia no está creada o la ventana está cerrada se crea la instancia

	       if (instancia == null || instancia.isClosed) {
	          instancia = new IF_Chollos();
	      }
	       return instancia;
	   }
	public IF_Chollos() {};
	public IF_Chollos(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
		setFrameIcon(new ImageIcon(IF_Chollos.class.getResource("/Presentacion/logoApp.png")));
		setBorder(null);
		setBounds(new Rectangle(0, 0, 1150, 759));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1150, 0};
		gridBagLayout.rowHeights = new int[]{138, 539, 58, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		try {
			Usuario u = Usuario.readPresupuesto(nombre_usuario);
		
		pnlSuperior = new JPanel();
		GridBagConstraints gbc_pnlSuperior = new GridBagConstraints();
		gbc_pnlSuperior.insets = new Insets(0, 0, 5, 0);
		gbc_pnlSuperior.fill = GridBagConstraints.BOTH;
		gbc_pnlSuperior.gridx = 0;
		gbc_pnlSuperior.gridy = 0;
		getContentPane().add(pnlSuperior, gbc_pnlSuperior);
		GridBagLayout gbl_pnlSuperior = new GridBagLayout();
		gbl_pnlSuperior.columnWidths = new int[]{74, 282, 170, 148, 141, 117, 0, 0};
		gbl_pnlSuperior.rowHeights = new int[]{51, 36, 0};
		gbl_pnlSuperior.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSuperior.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlSuperior.setLayout(gbl_pnlSuperior);
		
		lblNombreEntidad = new JLabel("Nombre de la entidad: "+u.getmNombre_Entidad());
		GridBagConstraints gbc_lblNombreEntidad = new GridBagConstraints();
		gbc_lblNombreEntidad.fill = GridBagConstraints.BOTH;
		gbc_lblNombreEntidad.insets = new Insets(0, 0, 0, 5);
		gbc_lblNombreEntidad.gridx = 1;
		gbc_lblNombreEntidad.gridy = 1;
		pnlSuperior.add(lblNombreEntidad, gbc_lblNombreEntidad);
		
		lblPresupuesto = new JLabel("Presupuesto del club: "+u.getmPresupuesto()+" M");
		GridBagConstraints gbc_lblPresupuesto = new GridBagConstraints();
		gbc_lblPresupuesto.fill = GridBagConstraints.BOTH;
		gbc_lblPresupuesto.insets = new Insets(0, 0, 0, 5);
		gbc_lblPresupuesto.gridx = 2;
		gbc_lblPresupuesto.gridy = 1;
		pnlSuperior.add(lblPresupuesto, gbc_lblPresupuesto);
		
		lblRentabilidad = new JLabel("Índice de rentabilidad mínimo: ");
		GridBagConstraints gbc_lblRentabilidad = new GridBagConstraints();
		gbc_lblRentabilidad.anchor = GridBagConstraints.EAST;
		gbc_lblRentabilidad.fill = GridBagConstraints.VERTICAL;
		gbc_lblRentabilidad.insets = new Insets(0, 0, 0, 5);
		gbc_lblRentabilidad.gridx = 3;
		gbc_lblRentabilidad.gridy = 1;
		pnlSuperior.add(lblRentabilidad, gbc_lblRentabilidad);
		
		txtIR = new JTextField();
		GridBagConstraints gbc_txtIR = new GridBagConstraints();
		gbc_txtIR.insets = new Insets(0, 0, 0, 5);
		gbc_txtIR.anchor = GridBagConstraints.WEST;
		gbc_txtIR.gridx = 4;
		gbc_txtIR.gridy = 1;
		pnlSuperior.add(txtIR, gbc_txtIR);
		txtIR.setColumns(10);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(IF_Chollos.class.getResource("/Presentacion/icono_actualizar.png")));
		btnActualizar.setBackground(Color.LIGHT_GRAY);
		btnActualizar.addActionListener(new BtnActualizarActionListener());
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.insets = new Insets(0, 0, 0, 5);
		gbc_btnActualizar.gridx = 5;
		gbc_btnActualizar.gridy = 1;
		pnlSuperior.add(btnActualizar, gbc_btnActualizar);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		tablaChollosJugadores = new JTable();
		scrollPane.setViewportView(tablaChollosJugadores);
		tablaChollosJugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaChollosJugadores.setModel(modeloTablaChollos);
		
		btnMostrarDatos = new JButton("Mostrar datos");
		btnMostrarDatos.setBackground(Color.LIGHT_GRAY);
		btnMostrarDatos.addActionListener(new BtnMostrarDatosActionListener());
		GridBagConstraints gbc_btnMostrarDatos = new GridBagConstraints();
		gbc_btnMostrarDatos.fill = GridBagConstraints.BOTH;
		gbc_btnMostrarDatos.gridx = 0;
		gbc_btnMostrarDatos.gridy = 2;
		getContentPane().add(btnMostrarDatos, gbc_btnMostrarDatos);
		QuitarLaBarraTitulo();
		aniadirValoresTabla(u.getmPresupuesto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getNombre_usuario() {
		return nombre_usuario;
	}

	public static void setNombre_usuario(String nombre_usuario) {
		IF_Chollos.nombre_usuario = nombre_usuario;
	}

	public void QuitarLaBarraTitulo()
	{
	Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	DimensionBarra = Barra.getPreferredSize();
	Barra.setSize(0,0);
	Barra.setPreferredSize(new Dimension(0,0));
	repaint();
	}
	
	public void aniadirValoresTabla(int presupuesto) {
		Jugador j = new Jugador();
		try {
			Vector<Jugador> jugadores = j.readChollos(presupuesto);
			vaciarTabla();
			for(int i = jugadores.size() -1; i >= 0;i--) {
				Object[] vectorJugador = {jugadores.get(i).getNombre(), jugadores.get(i).getPosicion(), jugadores.get(i).getAtaque(), jugadores.get(i).getPase(), jugadores.get(i).getRegate(), jugadores.get(i).getDefensa(),  jugadores.get(i).getValor(), jugadores.get(i).getValoracion(jugadores.get(i)), jugadores.get(i).getIndice_rendimiento(jugadores.get(i))};
				String ir = jugadores.get(i).getIndice_rendimiento(jugadores.get(i));
				String indice_rendimiento = ir.replace(",", ".");
				if(txtIR.getText().equals("") || Double.parseDouble(indice_rendimiento)>=Double.parseDouble(txtIR.getText().replace(",", ".")) )
					modeloTablaChollos.anadirFila(vectorJugador);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void vaciarTabla() {
		while(modeloTablaChollos.getRowCount() > 0)
			modeloTablaChollos.eliminarFila(0);
		modeloTablaChollos.fireTableDataChanged();
	}
	private class BtnActualizarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			try {
				Usuario u = Usuario.readPresupuesto(getNombre_usuario());
				int presupuesto = u.getmPresupuesto();
				aniadirValoresTabla(presupuesto);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class BtnMostrarDatosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int n = tablaChollosJugadores.getSelectedRow();
			//int m = tablaJugadores.getSelectedColumn();
			VentanaAtributosJugador ventanaAtributosJ = new VentanaAtributosJugador(modeloTablaChollos.getValueAt(n, 0).toString());
			ventanaAtributosJ.setVisible(true);
			ventanaAtributosJ.setLocationRelativeTo(null);
		}
	}
}
