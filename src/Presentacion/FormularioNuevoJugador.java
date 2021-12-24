package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;

import Dominio.Jugador;
import Dominio.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.EtchedBorder;

public class FormularioNuevoJugador extends JFrame {

	private JPanel contentPane;
	private JPanel pnlNuevoJugador;
	private JButton btnLimpiarCampos;
	private JButton btnAniadirJugador;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblPosicion;
	private JTextField txtEdad;
	private JLabel lblEdad;
	private JComboBox cbPosicion;
	private JLabel lblFormaFisica;
	private JTextField txtFormaFisica;
	private JLabel lblEstado;
	private JComboBox cbEstado;
	private JLabel lblLesiones;
	private JTextField txtLesiones;
	private JLabel lblGoles;
	private JTextField txtGoles;
	private JLabel lblPunteria;
	private JTextField txtPunteria;
	private JLabel lblGolesLast;
	private JTextField txtGolesLast;
	private JLabel lblPenaltisLanzados;
	private JTextField txtPenaltisLanzados;
	private JLabel lblPenaltisMarcados;
	private JTextField txtPenaltisMarcados;
	private JLabel lblEfectividadPenaltis;
	private JTextField txtEfectividadPenaltis;
	private JLabel lblAsistencias;
	private JLabel lblToques;
	private JLabel lblOcasionesCreadas;
	private JTextField txtAsistencias;
	private JTextField txtToques;
	private JTextField txtOcasionesCreadas;
	private JLabel lblPasesClave;
	private JLabel lblPasesCompletados;
	private JLabel lblPasesCompletadosLast;
	private JTextField txtPasesClave;
	private JTextField txtPasesCompletados;
	private JTextField txtPasesCompletados_last;
	private JLabel lblEntradasExito;
	private JLabel lblDespejes;
	private JLabel lblTiros_bloqueados;
	private JTextField txtEntradasExito;
	private JTextField txtDespejes;
	private JTextField txtTiros_bloqueados;
	private JLabel lblIntercepciones;
	private JLabel lblParadasPorPartido;
	private JLabel lblGolesConcedidos;
	private JTextField txtIntercepciones;
	private JTextField txtParadasPartido;
	private JTextField txtGolesConcedidos;
	private JLabel lblAtaque;
	private JLabel lblPase;
	private JLabel lblDefensa;
	private JTextField txtAtaque;
	private JTextField txtPase;
	private JTextField txtDefensa;
	private JLabel lblComentarios;
	private JTextArea txtComentarios;
	private JButton btnCampos;
	private static String nombre_user_club;
	private static int[] vNumeros;
	private JLabel lblNota;
	static FormularioNuevoJugador frame = new FormularioNuevoJugador(nombre_user_club, vNumeros);
	private JPanel pnlAtaque;
	private JPanel pnlPase;
	private JPanel pnlDefensaPorteria;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//FormularioNuevoJugador frame = new FormularioNuevoJugador(nombre_user_club, vNumeros);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param numero 
	 */
	public FormularioNuevoJugador(String nombre_user_club, int[] vNumeros) {
		addWindowListener(new ThisWindowListener());
		FormularioNuevoJugador.nombre_user_club = nombre_user_club;
		FormularioNuevoJugador.vNumeros = vNumeros;
		setTitle("scoutingFootballApp - Añadir nuevo jugador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioNuevoJugador.class.getResource("/Presentacion/logoApp.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{635, 676, 0};
		gbl_contentPane.rowHeights = new int[]{36, 454, 36, 34, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		pnlNuevoJugador = new JPanel();
		pnlNuevoJugador.setBorder(new TitledBorder(null, "Formulario para a\u00F1adir nuevo jugador", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		GridBagConstraints gbc_pnlNuevoJugador = new GridBagConstraints();
		gbc_pnlNuevoJugador.gridheight = 2;
		gbc_pnlNuevoJugador.gridwidth = 2;
		gbc_pnlNuevoJugador.fill = GridBagConstraints.BOTH;
		gbc_pnlNuevoJugador.insets = new Insets(0, 0, 5, 0);
		gbc_pnlNuevoJugador.gridx = 0;
		gbc_pnlNuevoJugador.gridy = 0;
		contentPane.add(pnlNuevoJugador, gbc_pnlNuevoJugador);
		GridBagLayout gbl_pnlNuevoJugador = new GridBagLayout();
		gbl_pnlNuevoJugador.columnWidths = new int[]{30, 48, 91, 152, 0, 76, 132, 0, 95, 59, 0, 51, 0};
		gbl_pnlNuevoJugador.rowHeights = new int[]{21, 45, 38, 39, 40, 46, 42, 50, 45, 38, 54, 0};
		gbl_pnlNuevoJugador.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlNuevoJugador.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		pnlNuevoJugador.setLayout(gbl_pnlNuevoJugador);
		
		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.fill = GridBagConstraints.VERTICAL;
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 1;
		pnlNuevoJugador.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 1;
		pnlNuevoJugador.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblPosicion = new JLabel("Posición");
		GridBagConstraints gbc_lblPosicion = new GridBagConstraints();
		gbc_lblPosicion.anchor = GridBagConstraints.EAST;
		gbc_lblPosicion.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosicion.gridx = 5;
		gbc_lblPosicion.gridy = 1;
		pnlNuevoJugador.add(lblPosicion, gbc_lblPosicion);
		
		cbPosicion = new JComboBox();
		cbPosicion.setModel(new DefaultComboBoxModel(new String[] {"Portero", "Defensa", "Centrocampista", "Delantero"}));
		GridBagConstraints gbc_cbPosicion = new GridBagConstraints();
		gbc_cbPosicion.insets = new Insets(0, 0, 5, 5);
		gbc_cbPosicion.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbPosicion.gridx = 6;
		gbc_cbPosicion.gridy = 1;
		pnlNuevoJugador.add(cbPosicion, gbc_cbPosicion);
		
		lblEdad = new JLabel("Edad:");
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.EAST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 8;
		gbc_lblEdad.gridy = 1;
		pnlNuevoJugador.add(lblEdad, gbc_lblEdad);
		
		txtEdad = new JTextField();
		GridBagConstraints gbc_txtEdad = new GridBagConstraints();
		gbc_txtEdad.insets = new Insets(0, 0, 5, 5);
		gbc_txtEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEdad.gridx = 9;
		gbc_txtEdad.gridy = 1;
		pnlNuevoJugador.add(txtEdad, gbc_txtEdad);
		txtEdad.setColumns(10);
		
		lblFormaFisica = new JLabel("Forma Física:");
		GridBagConstraints gbc_lblFormaFisica = new GridBagConstraints();
		gbc_lblFormaFisica.anchor = GridBagConstraints.EAST;
		gbc_lblFormaFisica.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormaFisica.gridx = 2;
		gbc_lblFormaFisica.gridy = 2;
		pnlNuevoJugador.add(lblFormaFisica, gbc_lblFormaFisica);
		
		txtFormaFisica = new JTextField();
		GridBagConstraints gbc_txtFormaFisica = new GridBagConstraints();
		gbc_txtFormaFisica.insets = new Insets(0, 0, 5, 5);
		gbc_txtFormaFisica.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFormaFisica.gridx = 3;
		gbc_txtFormaFisica.gridy = 2;
		pnlNuevoJugador.add(txtFormaFisica, gbc_txtFormaFisica);
		txtFormaFisica.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 5;
		gbc_lblEstado.gridy = 2;
		pnlNuevoJugador.add(lblEstado, gbc_lblEstado);
		
		cbEstado = new JComboBox();
		cbEstado.setModel(new DefaultComboBoxModel(new String[] {"Muy descontento", "Descontento", "Contento", "Muy contento"}));
		GridBagConstraints gbc_cbEstado = new GridBagConstraints();
		gbc_cbEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cbEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEstado.gridx = 6;
		gbc_cbEstado.gridy = 2;
		pnlNuevoJugador.add(cbEstado, gbc_cbEstado);
		
		lblLesiones = new JLabel("Lesiones:");
		GridBagConstraints gbc_lblLesiones = new GridBagConstraints();
		gbc_lblLesiones.anchor = GridBagConstraints.EAST;
		gbc_lblLesiones.insets = new Insets(0, 0, 5, 5);
		gbc_lblLesiones.gridx = 8;
		gbc_lblLesiones.gridy = 2;
		pnlNuevoJugador.add(lblLesiones, gbc_lblLesiones);
		
		txtLesiones = new JTextField();
		GridBagConstraints gbc_txtLesiones = new GridBagConstraints();
		gbc_txtLesiones.insets = new Insets(0, 0, 5, 5);
		gbc_txtLesiones.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLesiones.gridx = 9;
		gbc_txtLesiones.gridy = 2;
		pnlNuevoJugador.add(txtLesiones, gbc_txtLesiones);
		txtLesiones.setColumns(10);
		
		pnlAtaque = new JPanel();
		pnlAtaque.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Atributos de ataque", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		GridBagConstraints gbc_pnlAtaque = new GridBagConstraints();
		gbc_pnlAtaque.gridheight = 2;
		gbc_pnlAtaque.gridwidth = 8;
		gbc_pnlAtaque.insets = new Insets(0, 0, 5, 5);
		gbc_pnlAtaque.fill = GridBagConstraints.BOTH;
		gbc_pnlAtaque.gridx = 2;
		gbc_pnlAtaque.gridy = 3;
		pnlNuevoJugador.add(pnlAtaque, gbc_pnlAtaque);
		GridBagLayout gbl_pnlAtaque = new GridBagLayout();
		gbl_pnlAtaque.columnWidths = new int[]{40, 108, 171, 87, 92, 110, 53, 125, 124, 23, 0};
		gbl_pnlAtaque.rowHeights = new int[]{43, 31, 0};
		gbl_pnlAtaque.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlAtaque.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		pnlAtaque.setLayout(gbl_pnlAtaque);
		
		lblGoles = new JLabel("Goles:");
		GridBagConstraints gbc_lblGoles = new GridBagConstraints();
		gbc_lblGoles.anchor = GridBagConstraints.EAST;
		gbc_lblGoles.insets = new Insets(0, 0, 5, 5);
		gbc_lblGoles.gridx = 1;
		gbc_lblGoles.gridy = 0;
		pnlAtaque.add(lblGoles, gbc_lblGoles);
		
		txtGoles = new JTextField();
		GridBagConstraints gbc_txtGoles = new GridBagConstraints();
		gbc_txtGoles.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGoles.insets = new Insets(0, 0, 5, 5);
		gbc_txtGoles.gridx = 2;
		gbc_txtGoles.gridy = 0;
		pnlAtaque.add(txtGoles, gbc_txtGoles);
		txtGoles.setColumns(10);
		
		lblPunteria = new JLabel("Puntería (%):");
		GridBagConstraints gbc_lblPunteria = new GridBagConstraints();
		gbc_lblPunteria.anchor = GridBagConstraints.EAST;
		gbc_lblPunteria.insets = new Insets(0, 0, 5, 5);
		gbc_lblPunteria.gridx = 4;
		gbc_lblPunteria.gridy = 0;
		pnlAtaque.add(lblPunteria, gbc_lblPunteria);
		
		txtPunteria = new JTextField();
		GridBagConstraints gbc_txtPunteria = new GridBagConstraints();
		gbc_txtPunteria.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPunteria.insets = new Insets(0, 0, 5, 5);
		gbc_txtPunteria.gridx = 5;
		gbc_txtPunteria.gridy = 0;
		pnlAtaque.add(txtPunteria, gbc_txtPunteria);
		txtPunteria.setColumns(10);
		
		lblGolesLast = new JLabel("Goles en los últimos 10 partidos:");
		GridBagConstraints gbc_lblGolesLast = new GridBagConstraints();
		gbc_lblGolesLast.anchor = GridBagConstraints.EAST;
		gbc_lblGolesLast.insets = new Insets(0, 0, 5, 5);
		gbc_lblGolesLast.gridx = 7;
		gbc_lblGolesLast.gridy = 0;
		pnlAtaque.add(lblGolesLast, gbc_lblGolesLast);
		
		txtGolesLast = new JTextField();
		GridBagConstraints gbc_txtGolesLast = new GridBagConstraints();
		gbc_txtGolesLast.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGolesLast.insets = new Insets(0, 0, 5, 5);
		gbc_txtGolesLast.gridx = 8;
		gbc_txtGolesLast.gridy = 0;
		pnlAtaque.add(txtGolesLast, gbc_txtGolesLast);
		txtGolesLast.setColumns(10);
		
		lblPenaltisLanzados = new JLabel("Penaltis lanzados:");
		GridBagConstraints gbc_lblPenaltisLanzados = new GridBagConstraints();
		gbc_lblPenaltisLanzados.anchor = GridBagConstraints.EAST;
		gbc_lblPenaltisLanzados.insets = new Insets(0, 0, 0, 5);
		gbc_lblPenaltisLanzados.gridx = 1;
		gbc_lblPenaltisLanzados.gridy = 1;
		pnlAtaque.add(lblPenaltisLanzados, gbc_lblPenaltisLanzados);
		
		txtPenaltisLanzados = new JTextField();
		GridBagConstraints gbc_txtPenaltisLanzados = new GridBagConstraints();
		gbc_txtPenaltisLanzados.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPenaltisLanzados.insets = new Insets(0, 0, 0, 5);
		gbc_txtPenaltisLanzados.gridx = 2;
		gbc_txtPenaltisLanzados.gridy = 1;
		pnlAtaque.add(txtPenaltisLanzados, gbc_txtPenaltisLanzados);
		txtPenaltisLanzados.setColumns(10);
		
		lblPenaltisMarcados = new JLabel("Penaltis Marcados:");
		GridBagConstraints gbc_lblPenaltisMarcados = new GridBagConstraints();
		gbc_lblPenaltisMarcados.anchor = GridBagConstraints.EAST;
		gbc_lblPenaltisMarcados.insets = new Insets(0, 0, 0, 5);
		gbc_lblPenaltisMarcados.gridx = 4;
		gbc_lblPenaltisMarcados.gridy = 1;
		pnlAtaque.add(lblPenaltisMarcados, gbc_lblPenaltisMarcados);
		
		txtPenaltisMarcados = new JTextField();
		GridBagConstraints gbc_txtPenaltisMarcados = new GridBagConstraints();
		gbc_txtPenaltisMarcados.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPenaltisMarcados.insets = new Insets(0, 0, 0, 5);
		gbc_txtPenaltisMarcados.gridx = 5;
		gbc_txtPenaltisMarcados.gridy = 1;
		pnlAtaque.add(txtPenaltisMarcados, gbc_txtPenaltisMarcados);
		txtPenaltisMarcados.setColumns(10);
		
		lblEfectividadPenaltis = new JLabel("Efectividad Penaltis (%):");
		GridBagConstraints gbc_lblEfectividadPenaltis = new GridBagConstraints();
		gbc_lblEfectividadPenaltis.anchor = GridBagConstraints.EAST;
		gbc_lblEfectividadPenaltis.insets = new Insets(0, 0, 0, 5);
		gbc_lblEfectividadPenaltis.gridx = 7;
		gbc_lblEfectividadPenaltis.gridy = 1;
		pnlAtaque.add(lblEfectividadPenaltis, gbc_lblEfectividadPenaltis);
		
		txtEfectividadPenaltis = new JTextField();
		GridBagConstraints gbc_txtEfectividadPenaltis = new GridBagConstraints();
		gbc_txtEfectividadPenaltis.insets = new Insets(0, 0, 0, 5);
		gbc_txtEfectividadPenaltis.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEfectividadPenaltis.gridx = 8;
		gbc_txtEfectividadPenaltis.gridy = 1;
		pnlAtaque.add(txtEfectividadPenaltis, gbc_txtEfectividadPenaltis);
		txtEfectividadPenaltis.setColumns(10);
		
		pnlPase = new JPanel();
		pnlPase.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Atributos de pase", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		GridBagConstraints gbc_pnlPase = new GridBagConstraints();
		gbc_pnlPase.gridheight = 2;
		gbc_pnlPase.gridwidth = 8;
		gbc_pnlPase.insets = new Insets(0, 0, 5, 5);
		gbc_pnlPase.fill = GridBagConstraints.BOTH;
		gbc_pnlPase.gridx = 2;
		gbc_pnlPase.gridy = 5;
		pnlNuevoJugador.add(pnlPase, gbc_pnlPase);
		GridBagLayout gbl_pnlPase = new GridBagLayout();
		gbl_pnlPase.columnWidths = new int[]{27, 114, 135, 35, 110, 121, 44, 180, 124, 21, 0};
		gbl_pnlPase.rowHeights = new int[]{41, 34, 0};
		gbl_pnlPase.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlPase.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlPase.setLayout(gbl_pnlPase);
		
		lblAsistencias = new JLabel("Asistencias:");
		GridBagConstraints gbc_lblAsistencias = new GridBagConstraints();
		gbc_lblAsistencias.anchor = GridBagConstraints.EAST;
		gbc_lblAsistencias.insets = new Insets(0, 0, 5, 5);
		gbc_lblAsistencias.gridx = 1;
		gbc_lblAsistencias.gridy = 0;
		pnlPase.add(lblAsistencias, gbc_lblAsistencias);
		
		txtAsistencias = new JTextField();
		GridBagConstraints gbc_txtAsistencias = new GridBagConstraints();
		gbc_txtAsistencias.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAsistencias.insets = new Insets(0, 0, 5, 5);
		gbc_txtAsistencias.gridx = 2;
		gbc_txtAsistencias.gridy = 0;
		pnlPase.add(txtAsistencias, gbc_txtAsistencias);
		txtAsistencias.setColumns(10);
		
		lblToques = new JLabel("Toques:");
		GridBagConstraints gbc_lblToques = new GridBagConstraints();
		gbc_lblToques.anchor = GridBagConstraints.EAST;
		gbc_lblToques.insets = new Insets(0, 0, 5, 5);
		gbc_lblToques.gridx = 4;
		gbc_lblToques.gridy = 0;
		pnlPase.add(lblToques, gbc_lblToques);
		
		txtToques = new JTextField();
		GridBagConstraints gbc_txtToques = new GridBagConstraints();
		gbc_txtToques.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtToques.insets = new Insets(0, 0, 5, 5);
		gbc_txtToques.gridx = 5;
		gbc_txtToques.gridy = 0;
		pnlPase.add(txtToques, gbc_txtToques);
		txtToques.setColumns(10);
		
		lblOcasionesCreadas = new JLabel("Ocasiones creadas:");
		GridBagConstraints gbc_lblOcasionesCreadas = new GridBagConstraints();
		gbc_lblOcasionesCreadas.anchor = GridBagConstraints.EAST;
		gbc_lblOcasionesCreadas.insets = new Insets(0, 0, 5, 5);
		gbc_lblOcasionesCreadas.gridx = 7;
		gbc_lblOcasionesCreadas.gridy = 0;
		pnlPase.add(lblOcasionesCreadas, gbc_lblOcasionesCreadas);
		
		txtOcasionesCreadas = new JTextField();
		GridBagConstraints gbc_txtOcasionesCreadas = new GridBagConstraints();
		gbc_txtOcasionesCreadas.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOcasionesCreadas.insets = new Insets(0, 0, 5, 5);
		gbc_txtOcasionesCreadas.gridx = 8;
		gbc_txtOcasionesCreadas.gridy = 0;
		pnlPase.add(txtOcasionesCreadas, gbc_txtOcasionesCreadas);
		txtOcasionesCreadas.setColumns(10);
		
		lblPasesClave = new JLabel("Pases Clave:");
		GridBagConstraints gbc_lblPasesClave = new GridBagConstraints();
		gbc_lblPasesClave.anchor = GridBagConstraints.EAST;
		gbc_lblPasesClave.insets = new Insets(0, 0, 0, 5);
		gbc_lblPasesClave.gridx = 1;
		gbc_lblPasesClave.gridy = 1;
		pnlPase.add(lblPasesClave, gbc_lblPasesClave);
		
		txtPasesClave = new JTextField();
		GridBagConstraints gbc_txtPasesClave = new GridBagConstraints();
		gbc_txtPasesClave.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPasesClave.insets = new Insets(0, 0, 0, 5);
		gbc_txtPasesClave.gridx = 2;
		gbc_txtPasesClave.gridy = 1;
		pnlPase.add(txtPasesClave, gbc_txtPasesClave);
		txtPasesClave.setColumns(10);
		
		lblPasesCompletados = new JLabel("Pases Completados(%):");
		GridBagConstraints gbc_lblPasesCompletados = new GridBagConstraints();
		gbc_lblPasesCompletados.anchor = GridBagConstraints.EAST;
		gbc_lblPasesCompletados.insets = new Insets(0, 0, 0, 5);
		gbc_lblPasesCompletados.gridx = 4;
		gbc_lblPasesCompletados.gridy = 1;
		pnlPase.add(lblPasesCompletados, gbc_lblPasesCompletados);
		
		txtPasesCompletados = new JTextField();
		GridBagConstraints gbc_txtPasesCompletados = new GridBagConstraints();
		gbc_txtPasesCompletados.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPasesCompletados.insets = new Insets(0, 0, 0, 5);
		gbc_txtPasesCompletados.gridx = 5;
		gbc_txtPasesCompletados.gridy = 1;
		pnlPase.add(txtPasesCompletados, gbc_txtPasesCompletados);
		txtPasesCompletados.setColumns(10);
		
		lblPasesCompletadosLast = new JLabel("Pases completados (ult 10 p.)(%):");
		GridBagConstraints gbc_lblPasesCompletadosLast = new GridBagConstraints();
		gbc_lblPasesCompletadosLast.anchor = GridBagConstraints.EAST;
		gbc_lblPasesCompletadosLast.insets = new Insets(0, 0, 0, 5);
		gbc_lblPasesCompletadosLast.gridx = 7;
		gbc_lblPasesCompletadosLast.gridy = 1;
		pnlPase.add(lblPasesCompletadosLast, gbc_lblPasesCompletadosLast);
		
		txtPasesCompletados_last = new JTextField();
		GridBagConstraints gbc_txtPasesCompletados_last = new GridBagConstraints();
		gbc_txtPasesCompletados_last.insets = new Insets(0, 0, 0, 5);
		gbc_txtPasesCompletados_last.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPasesCompletados_last.gridx = 8;
		gbc_txtPasesCompletados_last.gridy = 1;
		pnlPase.add(txtPasesCompletados_last, gbc_txtPasesCompletados_last);
		txtPasesCompletados_last.setColumns(10);
		
		pnlDefensaPorteria = new JPanel();
		pnlDefensaPorteria.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Atributos de defensa y porter\u00EDa", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		GridBagConstraints gbc_pnlDefensaPorteria = new GridBagConstraints();
		gbc_pnlDefensaPorteria.gridheight = 2;
		gbc_pnlDefensaPorteria.fill = GridBagConstraints.BOTH;
		gbc_pnlDefensaPorteria.gridwidth = 8;
		gbc_pnlDefensaPorteria.insets = new Insets(0, 0, 5, 5);
		gbc_pnlDefensaPorteria.gridx = 2;
		gbc_pnlDefensaPorteria.gridy = 7;
		pnlNuevoJugador.add(pnlDefensaPorteria, gbc_pnlDefensaPorteria);
		GridBagLayout gbl_pnlDefensaPorteria = new GridBagLayout();
		gbl_pnlDefensaPorteria.columnWidths = new int[]{0, 96, 124, 27, 99, 104, 0, 121, 116, 0, 0};
		gbl_pnlDefensaPorteria.rowHeights = new int[]{43, 34, 0};
		gbl_pnlDefensaPorteria.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDefensaPorteria.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlDefensaPorteria.setLayout(gbl_pnlDefensaPorteria);
		
		lblEntradasExito = new JLabel("Entradas con éxito:");
		GridBagConstraints gbc_lblEntradasExito = new GridBagConstraints();
		gbc_lblEntradasExito.anchor = GridBagConstraints.EAST;
		gbc_lblEntradasExito.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntradasExito.gridx = 1;
		gbc_lblEntradasExito.gridy = 0;
		pnlDefensaPorteria.add(lblEntradasExito, gbc_lblEntradasExito);
		
		txtEntradasExito = new JTextField();
		GridBagConstraints gbc_txtEntradasExito = new GridBagConstraints();
		gbc_txtEntradasExito.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEntradasExito.insets = new Insets(0, 0, 5, 5);
		gbc_txtEntradasExito.gridx = 2;
		gbc_txtEntradasExito.gridy = 0;
		pnlDefensaPorteria.add(txtEntradasExito, gbc_txtEntradasExito);
		txtEntradasExito.setColumns(10);
		
		lblDespejes = new JLabel("Despejes:");
		GridBagConstraints gbc_lblDespejes = new GridBagConstraints();
		gbc_lblDespejes.anchor = GridBagConstraints.EAST;
		gbc_lblDespejes.insets = new Insets(0, 0, 5, 5);
		gbc_lblDespejes.gridx = 4;
		gbc_lblDespejes.gridy = 0;
		pnlDefensaPorteria.add(lblDespejes, gbc_lblDespejes);
		
		txtDespejes = new JTextField();
		GridBagConstraints gbc_txtDespejes = new GridBagConstraints();
		gbc_txtDespejes.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDespejes.insets = new Insets(0, 0, 5, 5);
		gbc_txtDespejes.gridx = 5;
		gbc_txtDespejes.gridy = 0;
		pnlDefensaPorteria.add(txtDespejes, gbc_txtDespejes);
		txtDespejes.setColumns(10);
		
		lblTiros_bloqueados = new JLabel("Disparos bloqueados:");
		GridBagConstraints gbc_lblTiros_bloqueados = new GridBagConstraints();
		gbc_lblTiros_bloqueados.anchor = GridBagConstraints.EAST;
		gbc_lblTiros_bloqueados.insets = new Insets(0, 0, 5, 5);
		gbc_lblTiros_bloqueados.gridx = 7;
		gbc_lblTiros_bloqueados.gridy = 0;
		pnlDefensaPorteria.add(lblTiros_bloqueados, gbc_lblTiros_bloqueados);
		
		txtTiros_bloqueados = new JTextField();
		GridBagConstraints gbc_txtTiros_bloqueados = new GridBagConstraints();
		gbc_txtTiros_bloqueados.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTiros_bloqueados.insets = new Insets(0, 0, 5, 5);
		gbc_txtTiros_bloqueados.gridx = 8;
		gbc_txtTiros_bloqueados.gridy = 0;
		pnlDefensaPorteria.add(txtTiros_bloqueados, gbc_txtTiros_bloqueados);
		txtTiros_bloqueados.setColumns(10);
		
		lblIntercepciones = new JLabel("Intercepciones:");
		GridBagConstraints gbc_lblIntercepciones = new GridBagConstraints();
		gbc_lblIntercepciones.anchor = GridBagConstraints.EAST;
		gbc_lblIntercepciones.insets = new Insets(0, 0, 0, 5);
		gbc_lblIntercepciones.gridx = 1;
		gbc_lblIntercepciones.gridy = 1;
		pnlDefensaPorteria.add(lblIntercepciones, gbc_lblIntercepciones);
		
		txtIntercepciones = new JTextField();
		GridBagConstraints gbc_txtIntercepciones = new GridBagConstraints();
		gbc_txtIntercepciones.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIntercepciones.insets = new Insets(0, 0, 0, 5);
		gbc_txtIntercepciones.gridx = 2;
		gbc_txtIntercepciones.gridy = 1;
		pnlDefensaPorteria.add(txtIntercepciones, gbc_txtIntercepciones);
		txtIntercepciones.setColumns(10);
		
		lblParadasPorPartido = new JLabel("Paradas por partido:");
		GridBagConstraints gbc_lblParadasPorPartido = new GridBagConstraints();
		gbc_lblParadasPorPartido.anchor = GridBagConstraints.EAST;
		gbc_lblParadasPorPartido.insets = new Insets(0, 0, 0, 5);
		gbc_lblParadasPorPartido.gridx = 4;
		gbc_lblParadasPorPartido.gridy = 1;
		pnlDefensaPorteria.add(lblParadasPorPartido, gbc_lblParadasPorPartido);
		
		txtParadasPartido = new JTextField();
		GridBagConstraints gbc_txtParadasPartido = new GridBagConstraints();
		gbc_txtParadasPartido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtParadasPartido.insets = new Insets(0, 0, 0, 5);
		gbc_txtParadasPartido.gridx = 5;
		gbc_txtParadasPartido.gridy = 1;
		pnlDefensaPorteria.add(txtParadasPartido, gbc_txtParadasPartido);
		txtParadasPartido.setColumns(10);
		
		lblGolesConcedidos = new JLabel("Goles Concedidos:");
		GridBagConstraints gbc_lblGolesConcedidos = new GridBagConstraints();
		gbc_lblGolesConcedidos.anchor = GridBagConstraints.EAST;
		gbc_lblGolesConcedidos.insets = new Insets(0, 0, 0, 5);
		gbc_lblGolesConcedidos.gridx = 7;
		gbc_lblGolesConcedidos.gridy = 1;
		pnlDefensaPorteria.add(lblGolesConcedidos, gbc_lblGolesConcedidos);
		
		txtGolesConcedidos = new JTextField();
		GridBagConstraints gbc_txtGolesConcedidos = new GridBagConstraints();
		gbc_txtGolesConcedidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGolesConcedidos.insets = new Insets(0, 0, 0, 5);
		gbc_txtGolesConcedidos.gridx = 8;
		gbc_txtGolesConcedidos.gridy = 1;
		pnlDefensaPorteria.add(txtGolesConcedidos, gbc_txtGolesConcedidos);
		txtGolesConcedidos.setColumns(10);
		
		lblAtaque = new JLabel("Ataque:");
		GridBagConstraints gbc_lblAtaque = new GridBagConstraints();
		gbc_lblAtaque.anchor = GridBagConstraints.EAST;
		gbc_lblAtaque.insets = new Insets(0, 0, 5, 5);
		gbc_lblAtaque.gridx = 2;
		gbc_lblAtaque.gridy = 9;
		pnlNuevoJugador.add(lblAtaque, gbc_lblAtaque);
		
		txtAtaque = new JTextField();
		txtAtaque.setColumns(10);
		GridBagConstraints gbc_txtAtaque = new GridBagConstraints();
		gbc_txtAtaque.insets = new Insets(0, 0, 5, 5);
		gbc_txtAtaque.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAtaque.gridx = 3;
		gbc_txtAtaque.gridy = 9;
		pnlNuevoJugador.add(txtAtaque, gbc_txtAtaque);
		
		lblPase = new JLabel("Pase:");
		GridBagConstraints gbc_lblPase = new GridBagConstraints();
		gbc_lblPase.anchor = GridBagConstraints.EAST;
		gbc_lblPase.insets = new Insets(0, 0, 5, 5);
		gbc_lblPase.gridx = 5;
		gbc_lblPase.gridy = 9;
		pnlNuevoJugador.add(lblPase, gbc_lblPase);
		
		txtPase = new JTextField();
		txtPase.setColumns(10);
		GridBagConstraints gbc_txtPase = new GridBagConstraints();
		gbc_txtPase.insets = new Insets(0, 0, 5, 5);
		gbc_txtPase.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPase.gridx = 6;
		gbc_txtPase.gridy = 9;
		pnlNuevoJugador.add(txtPase, gbc_txtPase);
		
		lblDefensa = new JLabel("Defensa:");
		GridBagConstraints gbc_lblDefensa = new GridBagConstraints();
		gbc_lblDefensa.anchor = GridBagConstraints.EAST;
		gbc_lblDefensa.insets = new Insets(0, 0, 5, 5);
		gbc_lblDefensa.gridx = 8;
		gbc_lblDefensa.gridy = 9;
		pnlNuevoJugador.add(lblDefensa, gbc_lblDefensa);
		
		txtDefensa = new JTextField();
		txtDefensa.setColumns(10);
		GridBagConstraints gbc_txtDefensa = new GridBagConstraints();
		gbc_txtDefensa.insets = new Insets(0, 0, 5, 5);
		gbc_txtDefensa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDefensa.gridx = 9;
		gbc_txtDefensa.gridy = 9;
		pnlNuevoJugador.add(txtDefensa, gbc_txtDefensa);
		
		lblComentarios = new JLabel("Comentarios:");
		GridBagConstraints gbc_lblComentarios = new GridBagConstraints();
		gbc_lblComentarios.anchor = GridBagConstraints.EAST;
		gbc_lblComentarios.insets = new Insets(0, 0, 0, 5);
		gbc_lblComentarios.gridx = 2;
		gbc_lblComentarios.gridy = 10;
		pnlNuevoJugador.add(lblComentarios, gbc_lblComentarios);
		
		txtComentarios = new JTextArea();
		GridBagConstraints gbc_txtComentarios = new GridBagConstraints();
		gbc_txtComentarios.gridwidth = 4;
		gbc_txtComentarios.insets = new Insets(0, 0, 0, 5);
		gbc_txtComentarios.fill = GridBagConstraints.BOTH;
		gbc_txtComentarios.gridx = 3;
		gbc_txtComentarios.gridy = 10;
		pnlNuevoJugador.add(txtComentarios, gbc_txtComentarios);
		
		btnCampos = new JButton("Calcular campos");
		btnCampos.setBackground(Color.LIGHT_GRAY);
		btnCampos.addActionListener(new BtnCamposActionListener());
		GridBagConstraints gbc_btnCampos = new GridBagConstraints();
		gbc_btnCampos.fill = GridBagConstraints.BOTH;
		gbc_btnCampos.insets = new Insets(0, 0, 0, 5);
		gbc_btnCampos.gridx = 9;
		gbc_btnCampos.gridy = 10;
		pnlNuevoJugador.add(btnCampos, gbc_btnCampos);
		
		btnLimpiarCampos = new JButton("Limpiar Campos");
		btnLimpiarCampos.setBackground(Color.LIGHT_GRAY);
		btnLimpiarCampos.addActionListener(new BtnLimpiarCamposActionListener());
		
		lblNota = new JLabel("Los campos Ataque, Defensa, Pase y Efectividad Penalti se calculan de forma automática (al pulsar el botón).");
		GridBagConstraints gbc_lblNota = new GridBagConstraints();
		gbc_lblNota.gridwidth = 2;
		gbc_lblNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNota.gridx = 0;
		gbc_lblNota.gridy = 2;
		contentPane.add(lblNota, gbc_lblNota);
		GridBagConstraints gbc_btnLimpiarCampos = new GridBagConstraints();
		gbc_btnLimpiarCampos.fill = GridBagConstraints.VERTICAL;
		gbc_btnLimpiarCampos.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpiarCampos.gridx = 0;
		gbc_btnLimpiarCampos.gridy = 3;
		contentPane.add(btnLimpiarCampos, gbc_btnLimpiarCampos);
		
		btnAniadirJugador = new JButton("Añadir Jugador");
		btnAniadirJugador.setBackground(Color.LIGHT_GRAY);
		btnAniadirJugador.addActionListener(new BtnAniadirJugadorActionListener());
		GridBagConstraints gbc_btnAniadirJugador = new GridBagConstraints();
		gbc_btnAniadirJugador.fill = GridBagConstraints.VERTICAL;
		gbc_btnAniadirJugador.gridx = 1;
		gbc_btnAniadirJugador.gridy = 3;
		contentPane.add(btnAniadirJugador, gbc_btnAniadirJugador);
	}
	private class BtnAniadirJugadorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			try {
				FormularioNuevoJugador.vNumeros[0] = 0;
				Usuario u = new Usuario();
				u = Usuario.readPresupuesto(nombre_user_club);
				if (txtNombre.getText().equals("")) {
					ImageIcon error = new ImageIcon(VentanaLogin.class.getResource("/Presentacion/icono_error.png"));
					JLabel info = new JLabel("El campo nombre está vacío");
					JOptionPane.showMessageDialog(frame, info, "Campo nombre vacío", JOptionPane.INFORMATION_MESSAGE, error);
				}
				else {
					int edad = 0, forma_fisica = 0, lesiones = 0, ataque = 0, defensa = 0, pase = 0, paradas_partido = 0, goles_concedidos = 0;
					if(isNumeric(txtEdad.getText()))
						edad = Integer.parseInt(txtEdad.getText());
					if(isNumeric(txtFormaFisica.getText()))
						forma_fisica = Integer.parseInt(txtFormaFisica.getText());
					if(isNumeric(txtLesiones.getText()))
						lesiones = Integer.parseInt(txtLesiones.getText());
					if(isNumeric(txtAtaque.getText()))
						ataque = Integer.parseInt(txtAtaque.getText());
					if(isNumericDouble(txtDefensa.getText())) {
						double def = Double.parseDouble(txtDefensa.getText());
						defensa = (int)Math.round(def);
					}
					if(isNumericDouble(txtPase.getText())) {
						double pas = Double.parseDouble(txtPase.getText());
						pase = (int) Math.round(pas);
					}
					if(isNumeric(txtParadasPartido.getText()))
						paradas_partido = Integer.parseInt(txtParadasPartido.getText());
					if(isNumeric(txtGolesConcedidos.getText()))
						goles_concedidos = Integer.parseInt(txtGolesConcedidos.getText());
					

				Jugador j = new Jugador(txtNombre.getText(), u.getmNombre_Entidad(), (String) cbPosicion.getSelectedItem(), edad, forma_fisica, (String) cbEstado.getSelectedItem(),lesiones, ataque, defensa, pase, txtComentarios.getText(), paradas_partido, goles_concedidos);
				j.insert();
				ImageIcon ok = new ImageIcon(VentanaLogin.class.getResource("/Presentacion/ok_accion.png"));
				JLabel info = new JLabel("El jugador ha sido añadido de forma correcta");
				JOptionPane.showMessageDialog(frame, info, "Jugador añadido", JOptionPane.INFORMATION_MESSAGE, ok);
				dispose();
				//IF_Equipo if_equipo= new IF_Equipo(nombre_user_club);
				//if_equipo.show();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	private static boolean isNumericDouble(String cadena){
		try {
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			FormularioNuevoJugador.vNumeros[0] = 0;
			dispose();
			
		}
	}
	private class BtnCamposActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//int ataque = 0, defensa = 0, pase = 0;
			if(isNumeric(txtPenaltisMarcados.getText()) && isNumeric(txtPenaltisLanzados.getText()))
				txtEfectividadPenaltis.setText(""+Double.parseDouble(txtPenaltisMarcados.getText()) / Double.parseDouble(txtPenaltisLanzados.getText()) * 100);
			if(isNumeric(txtGoles.getText())&& isNumeric(txtPunteria.getText()))
					txtAtaque.setText(""+(Integer.parseInt(txtGoles.getText())+ Integer.parseInt(txtPunteria.getText())+10));
			if(isNumeric(txtEntradasExito.getText()) && isNumeric(txtDespejes.getText()) && isNumeric(txtTiros_bloqueados.getText()) && isNumeric(txtIntercepciones.getText()))
				txtDefensa.setText(""+(Integer.parseInt(txtEntradasExito.getText())+Integer.parseInt(txtDespejes.getText())+Integer.parseInt(txtTiros_bloqueados.getText())+Double.parseDouble(txtIntercepciones.getText()))/1.5);
			if(isNumeric(txtAsistencias.getText()) && isNumeric(txtToques.getText()) && isNumeric(txtOcasionesCreadas.getText()) && isNumeric(txtPasesClave.getText()) && isNumeric(txtPasesCompletados.getText()) && isNumeric(txtPasesCompletados_last.getText()))
				txtPase.setText(""+((Integer.parseInt(txtAsistencias.getText())*2)+(Double.parseDouble(txtToques.getText())/2)+Integer.parseInt(txtOcasionesCreadas.getText())+Integer.parseInt(txtPasesClave.getText())+(Integer.parseInt(txtPasesCompletados.getText())-60)+(Integer.parseInt(txtPasesCompletados_last.getText())-50)));
			if(!txtPase.getText().equals("")) {
				if(txtPase.getText().charAt(0) == '-')
					txtPase.setText("0");
				if(Double.parseDouble( txtPase.getText()) > 100)
					txtPase.setText("98");
			}
			if(!txtDefensa.getText().equals("")) {
				if(txtDefensa.getText().charAt(0) == '-')
					txtDefensa.setText("0");
				if(Double.parseDouble(txtDefensa.getText()) > 100)
					txtDefensa.setText("98");
			}
			if(!txtAtaque.getText().equals("")) {
				if(txtAtaque.getText().charAt(0) == '-')
					txtAtaque.setText("0");
				if(Integer.parseInt(txtAtaque.getText()) > 100)
					txtAtaque.setText("98");
			}
			
			if(txtAtaque.getText().equals("") || txtDefensa.getText().equals("") || txtPase.getText().equals("") || txtEfectividadPenaltis.getText().equals("")) {
				ImageIcon error = new ImageIcon(VentanaLogin.class.getResource("/Presentacion/icono_error.png"));
				JLabel info = new JLabel("Algunos campos necesarios para el cálculo de una estadística están vacíos");
				JOptionPane.showMessageDialog(frame, info, "Campos necesarios vacíos", JOptionPane.INFORMATION_MESSAGE, error);
			}
			
		}
	}
	private class BtnLimpiarCamposActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtAtaque.setText("");
			txtNombre.setText("");
			txtDefensa.setText("");
			txtPase.setText("");
			txtFormaFisica.setText("");
			txtGoles.setText("");
			txtLesiones.setText("");
			txtGolesLast.setText("");
			txtPenaltisLanzados.setText("");
			txtPenaltisMarcados.setText("");
			txtPunteria.setText("");
			txtEfectividadPenaltis.setText("");
			txtAsistencias.setText("");
			txtToques.setText("");
			txtOcasionesCreadas.setText("");
			txtPasesClave.setText("");
			txtPasesCompletados.setText("");
			txtPasesCompletados_last.setText("");
			txtEntradasExito.setText("");
			txtIntercepciones.setText("");
			txtDespejes.setText("");
			txtTiros_bloqueados.setText("");
			txtParadasPartido.setText("");
			txtGolesConcedidos.setText("");
			txtComentarios.setText("");
			
			
		}
	}
}
