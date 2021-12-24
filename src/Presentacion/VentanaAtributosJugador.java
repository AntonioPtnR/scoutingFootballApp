package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import Dominio.Jugador;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Toolkit;

public class VentanaAtributosJugador extends JFrame {

	private JPanel contentPane;
	private static  String nombre_jugador;
	private JPanel pnlGrafica;
	private JPanel pnlFotoNombre;
	private JLabel lblFoto;
	private JLabel lblNombre;
	private JPanel pnlPase;
	private JLabel lblAsistencias;
	private JLabel lblToques;
	private JLabel lblOcasionesCreadas;
	private JLabel lblPasesClave;
	private JLabel lblPasesCompletados;
	private JLabel lblPasesCompletadosLast;
	private JLabel lblPases;
	private JPanel pnlAtaque;
	private JLabel lblGoles;
	private JLabel lblPunteria;
	private JLabel lblPenaltisLanzados;
	private JLabel lblPenaltisMarcados;
	private JLabel lblEfectividadPenaltis;
	private JLabel lblGolesLast;
	private JLabel lblAtaque;
	private JPanel pnlDefensa;
	private JLabel lblEntradas;
	private JLabel lblDespejes;
	private JLabel lblDisparosBloqueados;
	private JLabel lblIntercepciones;
	private JLabel lblDefensa;
	private JPanel pnlOtrosAtributos;
	private JLabel lblRegate;
	private JLabel lblEfectividadRegate;
	private JLabel lblParadasPartido;
	private JLabel lblGolesConcedidosPartido;
	private JLabel lblDuelosGanados;
	private JLabel lblFaltas;
	private JLabel lblEquipoSemana;
	private JPanel pnlAtributosGenerales;
	private JLabel lblEdad;
	private JLabel lblAltura;
	private JLabel lblPosicin;
	private JLabel lblValor;
	private JLabel lblValoracin;
	private JLabel lblndiceDeRentabilidad;
	private JLabel lblGrafica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAtributosJugador frame = new VentanaAtributosJugador(nombre_jugador);
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
	public VentanaAtributosJugador(String nombre_jugador) {
		setTitle("scoutingFootballApp - Atributos del jugador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAtributosJugador.class.getResource("/Presentacion/logoApp.png")));
		VentanaAtributosJugador.nombre_jugador = nombre_jugador;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 1150, 759));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{42, 97, 182, 206, 230, 197, 168, 0};
		gbl_contentPane.rowHeights = new int[]{91, 130, 125, 130, 145, 137, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		try {
			Jugador jugador = new Jugador();
			Vector<Jugador> atributos_jugador= jugador.readPase(nombre_jugador);
			jugador = atributos_jugador.elementAt(0);
		
		pnlFotoNombre = new JPanel();
		pnlFotoNombre.setLayout(null);
		GridBagConstraints gbc_pnlFotoNombre = new GridBagConstraints();
		gbc_pnlFotoNombre.gridwidth = 2;
		gbc_pnlFotoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_pnlFotoNombre.fill = GridBagConstraints.BOTH;
		gbc_pnlFotoNombre.gridx = 1;
		gbc_pnlFotoNombre.gridy = 0;
		contentPane.add(pnlFotoNombre, gbc_pnlFotoNombre);
		
		lblFoto = new JLabel("");
		lblFoto.setIcon(new ImageIcon(VentanaAtributosJugador.class.getResource("/Presentacion/usuario_perfil.png")));
		lblFoto.setBounds(10, 25, 61, 50);
		pnlFotoNombre.add(lblFoto);
		
		lblNombre = new JLabel(nombre_jugador);
		lblNombre.setBounds(81, 42, 195, 33);
		pnlFotoNombre.add(lblNombre);
		
		pnlAtributosGenerales = new JPanel();
		pnlAtributosGenerales.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Atributos generales", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlAtributosGenerales = new GridBagConstraints();
		gbc_pnlAtributosGenerales.gridwidth = 3;
		gbc_pnlAtributosGenerales.insets = new Insets(0, 0, 5, 5);
		gbc_pnlAtributosGenerales.fill = GridBagConstraints.BOTH;
		gbc_pnlAtributosGenerales.gridx = 1;
		gbc_pnlAtributosGenerales.gridy = 1;
		contentPane.add(pnlAtributosGenerales, gbc_pnlAtributosGenerales);
		GridBagLayout gbl_pnlAtributosGenerales = new GridBagLayout();
		gbl_pnlAtributosGenerales.columnWidths = new int[]{27, 111, 47, 97, 79, 61, 138, 0};
		gbl_pnlAtributosGenerales.rowHeights = new int[]{41, 31, 42, 0};
		gbl_pnlAtributosGenerales.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlAtributosGenerales.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlAtributosGenerales.setLayout(gbl_pnlAtributosGenerales);
		
		lblEdad = new JLabel("Edad: "+jugador.getEdad());
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.fill = GridBagConstraints.BOTH;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 1;
		gbc_lblEdad.gridy = 0;
		pnlAtributosGenerales.add(lblEdad, gbc_lblEdad);
		
		lblAltura = new JLabel("Altura: "+jugador.getAltura()+" cm");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblAltura = new GridBagConstraints();
		gbc_lblAltura.fill = GridBagConstraints.BOTH;
		gbc_lblAltura.insets = new Insets(0, 0, 5, 5);
		gbc_lblAltura.gridx = 3;
		gbc_lblAltura.gridy = 0;
		pnlAtributosGenerales.add(lblAltura, gbc_lblAltura);
		
		lblPosicin = new JLabel("Posición: "+jugador.getPosicion());
		lblPosicin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPosicin = new GridBagConstraints();
		gbc_lblPosicin.gridwidth = 2;
		gbc_lblPosicin.fill = GridBagConstraints.BOTH;
		gbc_lblPosicin.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosicin.gridx = 5;
		gbc_lblPosicin.gridy = 0;
		pnlAtributosGenerales.add(lblPosicin, gbc_lblPosicin);
		
		lblValor = new JLabel("Valor (M €): "+jugador.getValor());
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.fill = GridBagConstraints.BOTH;
		gbc_lblValor.insets = new Insets(0, 0, 0, 5);
		gbc_lblValor.gridx = 1;
		gbc_lblValor.gridy = 2;
		pnlAtributosGenerales.add(lblValor, gbc_lblValor);
		
		int valoracion = 0;
		if(jugador.getPosicion().equals("Delantero"))
			valoracion = (int) (0.70 * jugador.getAtaque() + 0.10 * jugador.getPase() +  0.02 * jugador.getDefensa_gen() + 0.18 * jugador.getRegate());
		if(jugador.getPosicion().equals("Defensa"))
			valoracion = (int) (0.80 * jugador.getDefensa_gen() + 0.15 * jugador.getPase() + 0.05 * jugador.getAtaque());
		if(jugador.getPosicion().equals("Centrocampista"))
			valoracion = (int) (0.70 * jugador.getPase() + 0.10 * jugador.getAtaque() + 0.10 * jugador.getDefensa_gen() + 0.10*jugador.getRegate());
		
		if(jugador.getEquipo_semana() > 0 && jugador.getEquipo_semana() <= 4) 
			valoracion += 1;
		else if(jugador.getEquipo_semana() > 4 && jugador.getEquipo_semana() <=9)
			valoracion += 2;
		else 
			valoracion += 3;
	
		lblValoracin = new JLabel("Valoración: "+valoracion);
		lblValoracin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblValoracin = new GridBagConstraints();
		gbc_lblValoracin.fill = GridBagConstraints.BOTH;
		gbc_lblValoracin.gridwidth = 2;
		gbc_lblValoracin.insets = new Insets(0, 0, 0, 5);
		gbc_lblValoracin.gridx = 3;
		gbc_lblValoracin.gridy = 2;
		pnlAtributosGenerales.add(lblValoracin, gbc_lblValoracin);
		float valorac = (float) valoracion;
		float valor_float = (float) jugador.getValor();
		
		
		double rentabilidad = valorac / valor_float;
	
		lblndiceDeRentabilidad = new JLabel("Índice de rentabilidad: "+String.format("%.2f", rentabilidad));
		lblndiceDeRentabilidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblndiceDeRentabilidad = new GridBagConstraints();
		gbc_lblndiceDeRentabilidad.gridwidth = 2;
		gbc_lblndiceDeRentabilidad.fill = GridBagConstraints.BOTH;
		gbc_lblndiceDeRentabilidad.gridx = 5;
		gbc_lblndiceDeRentabilidad.gridy = 2;
		pnlAtributosGenerales.add(lblndiceDeRentabilidad, gbc_lblndiceDeRentabilidad);
		
		pnlGrafica = new JPanel();
		pnlGrafica.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Gr\u00E1fica Valor - Ataque", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlGrafica = new GridBagConstraints();
		gbc_pnlGrafica.gridwidth = 3;
		gbc_pnlGrafica.gridheight = 5;
		gbc_pnlGrafica.fill = GridBagConstraints.BOTH;
		gbc_pnlGrafica.gridx = 4;
		gbc_pnlGrafica.gridy = 1;
		contentPane.add(pnlGrafica, gbc_pnlGrafica);
		pnlGrafica.setLayout(new BorderLayout(0, 0));
		
		lblGrafica = new JLabel("");
		lblGrafica.setIcon(new ImageIcon(VentanaAtributosJugador.class.getResource("/Presentacion/grafica.png")));
		pnlGrafica.add(lblGrafica);
		
		pnlAtaque = new JPanel();
		pnlAtaque.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Atributos de ataque", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlAtaque = new GridBagConstraints();
		gbc_pnlAtaque.gridwidth = 3;
		gbc_pnlAtaque.insets = new Insets(0, 0, 5, 5);
		gbc_pnlAtaque.fill = GridBagConstraints.BOTH;
		gbc_pnlAtaque.gridx = 1;
		gbc_pnlAtaque.gridy = 2;
		contentPane.add(pnlAtaque, gbc_pnlAtaque);
		GridBagLayout gbl_pnlAtaque = new GridBagLayout();
		gbl_pnlAtaque.columnWidths = new int[]{27, 111, 41, 65, 0, 81, 61, 65, 90, 0};
		gbl_pnlAtaque.rowHeights = new int[]{38, 34, 31, 0};
		gbl_pnlAtaque.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlAtaque.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlAtaque.setLayout(gbl_pnlAtaque);
		
		lblGoles = new JLabel("Goles: "+jugador.getGoles());
		lblGoles.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblGoles = new GridBagConstraints();
		gbc_lblGoles.fill = GridBagConstraints.BOTH;
		gbc_lblGoles.insets = new Insets(0, 0, 5, 5);
		gbc_lblGoles.gridx = 1;
		gbc_lblGoles.gridy = 0;
		pnlAtaque.add(lblGoles, gbc_lblGoles);
		
		lblPunteria = new JLabel("Puntería (%): "+jugador.getPunteria());
		lblPunteria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPunteria = new GridBagConstraints();
		gbc_lblPunteria.fill = GridBagConstraints.BOTH;
		gbc_lblPunteria.gridwidth = 3;
		gbc_lblPunteria.insets = new Insets(0, 0, 5, 0);
		gbc_lblPunteria.gridx = 6;
		gbc_lblPunteria.gridy = 0;
		pnlAtaque.add(lblPunteria, gbc_lblPunteria);
		
		lblPenaltisLanzados = new JLabel("Penaltis Lanzados: "+jugador.getPenaltis_lanzados());
		lblPenaltisLanzados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPenaltisLanzados = new GridBagConstraints();
		gbc_lblPenaltisLanzados.fill = GridBagConstraints.BOTH;
		gbc_lblPenaltisLanzados.gridwidth = 2;
		gbc_lblPenaltisLanzados.insets = new Insets(0, 0, 5, 5);
		gbc_lblPenaltisLanzados.gridx = 1;
		gbc_lblPenaltisLanzados.gridy = 1;
		pnlAtaque.add(lblPenaltisLanzados, gbc_lblPenaltisLanzados);
		
		lblPenaltisMarcados = new JLabel("Penaltis Marcados: "+jugador.getPenaltis_marcados());
		lblPenaltisMarcados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPenaltisMarcados = new GridBagConstraints();
		gbc_lblPenaltisMarcados.fill = GridBagConstraints.BOTH;
		gbc_lblPenaltisMarcados.gridwidth = 3;
		gbc_lblPenaltisMarcados.insets = new Insets(0, 0, 5, 5);
		gbc_lblPenaltisMarcados.gridx = 3;
		gbc_lblPenaltisMarcados.gridy = 1;
		pnlAtaque.add(lblPenaltisMarcados, gbc_lblPenaltisMarcados);
		
		lblEfectividadPenaltis = new JLabel("Efectividad (penaltis): "+jugador.getEfectividad_penaltis());
		lblEfectividadPenaltis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEfectividadPenaltis = new GridBagConstraints();
		gbc_lblEfectividadPenaltis.gridwidth = 3;
		gbc_lblEfectividadPenaltis.fill = GridBagConstraints.BOTH;
		gbc_lblEfectividadPenaltis.insets = new Insets(0, 0, 5, 5);
		gbc_lblEfectividadPenaltis.gridx = 6;
		gbc_lblEfectividadPenaltis.gridy = 1;
		pnlAtaque.add(lblEfectividadPenaltis, gbc_lblEfectividadPenaltis);
		
		lblGolesLast = new JLabel("Goles en los últimos 10 partidos: "+jugador.getGoles_last());
		lblGolesLast.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblGolesLast = new GridBagConstraints();
		gbc_lblGolesLast.gridwidth = 3;
		gbc_lblGolesLast.fill = GridBagConstraints.BOTH;
		gbc_lblGolesLast.insets = new Insets(0, 0, 0, 5);
		gbc_lblGolesLast.gridx = 1;
		gbc_lblGolesLast.gridy = 2;
		pnlAtaque.add(lblGolesLast, gbc_lblGolesLast);
		
		lblAtaque = new JLabel("Ataque: "+jugador.getAtaque());
		lblAtaque.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblAtaque = new GridBagConstraints();
		gbc_lblAtaque.gridwidth = 2;
		gbc_lblAtaque.insets = new Insets(0, 0, 0, 5);
		gbc_lblAtaque.fill = GridBagConstraints.BOTH;
		gbc_lblAtaque.gridx = 6;
		gbc_lblAtaque.gridy = 2;
		pnlAtaque.add(lblAtaque, gbc_lblAtaque);
		
		pnlPase = new JPanel();
		pnlPase.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Atributos de pase", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlPase = new GridBagConstraints();
		gbc_pnlPase.gridwidth = 3;
		gbc_pnlPase.insets = new Insets(0, 0, 5, 5);
		gbc_pnlPase.fill = GridBagConstraints.BOTH;
		gbc_pnlPase.gridx = 1;
		gbc_pnlPase.gridy = 3;
		contentPane.add(pnlPase, gbc_pnlPase);
		GridBagLayout gbl_pnlPase = new GridBagLayout();
		gbl_pnlPase.columnWidths = new int[]{27, 111, 47, 4, 65, 61, 138, 0};
		gbl_pnlPase.rowHeights = new int[]{34, 31, 29, 0};
		gbl_pnlPase.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlPase.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlPase.setLayout(gbl_pnlPase);
		
		lblAsistencias = new JLabel("Asistencias: "+jugador.getAsistencias());
		lblAsistencias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblAsistencias = new GridBagConstraints();
		gbc_lblAsistencias.fill = GridBagConstraints.BOTH;
		gbc_lblAsistencias.insets = new Insets(0, 0, 5, 5);
		gbc_lblAsistencias.gridx = 1;
		gbc_lblAsistencias.gridy = 0;
		pnlPase.add(lblAsistencias, gbc_lblAsistencias);
		
		lblOcasionesCreadas = new JLabel("Ocasiones creadas: "+jugador.getOcasiones_creadas());
		lblOcasionesCreadas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblOcasionesCreadas = new GridBagConstraints();
		gbc_lblOcasionesCreadas.fill = GridBagConstraints.BOTH;
		gbc_lblOcasionesCreadas.insets = new Insets(0, 0, 5, 0);
		gbc_lblOcasionesCreadas.gridwidth = 3;
		gbc_lblOcasionesCreadas.gridx = 4;
		gbc_lblOcasionesCreadas.gridy = 0;
		pnlPase.add(lblOcasionesCreadas, gbc_lblOcasionesCreadas);
		
		lblPasesCompletados = new JLabel("Pases completados (%): "+jugador.getPases_completados());
		lblPasesCompletados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPasesCompletados = new GridBagConstraints();
		gbc_lblPasesCompletados.fill = GridBagConstraints.BOTH;
		gbc_lblPasesCompletados.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasesCompletados.gridwidth = 3;
		gbc_lblPasesCompletados.gridx = 1;
		gbc_lblPasesCompletados.gridy = 1;
		pnlPase.add(lblPasesCompletados, gbc_lblPasesCompletados);
		
		lblPasesCompletadosLast = new JLabel("Pases completados (últimos 10 partidos) (%): "+jugador.getPases_completados_last());
		lblPasesCompletadosLast.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPasesCompletadosLast = new GridBagConstraints();
		gbc_lblPasesCompletadosLast.fill = GridBagConstraints.BOTH;
		gbc_lblPasesCompletadosLast.insets = new Insets(0, 0, 5, 0);
		gbc_lblPasesCompletadosLast.gridwidth = 3;
		gbc_lblPasesCompletadosLast.gridx = 4;
		gbc_lblPasesCompletadosLast.gridy = 1;
		pnlPase.add(lblPasesCompletadosLast, gbc_lblPasesCompletadosLast);
		
		lblPasesClave = new JLabel("Pases clave: "+jugador.getPases_clave());
		lblPasesClave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPasesClave = new GridBagConstraints();
		gbc_lblPasesClave.fill = GridBagConstraints.BOTH;
		gbc_lblPasesClave.insets = new Insets(0, 0, 0, 5);
		gbc_lblPasesClave.gridx = 1;
		gbc_lblPasesClave.gridy = 2;
		pnlPase.add(lblPasesClave, gbc_lblPasesClave);
		
		lblToques = new JLabel("Toques: "+jugador.getToques());
		lblToques.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblToques = new GridBagConstraints();
		gbc_lblToques.fill = GridBagConstraints.BOTH;
		gbc_lblToques.insets = new Insets(0, 0, 0, 5);
		gbc_lblToques.gridwidth = 2;
		gbc_lblToques.gridx = 3;
		gbc_lblToques.gridy = 2;
		pnlPase.add(lblToques, gbc_lblToques);
		
		lblPases = new JLabel("Pases: "+jugador.getPase());
		lblPases.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblPases = new GridBagConstraints();
		gbc_lblPases.fill = GridBagConstraints.BOTH;
		gbc_lblPases.gridx = 6;
		gbc_lblPases.gridy = 2;
		pnlPase.add(lblPases, gbc_lblPases);
		
		pnlDefensa = new JPanel();
		pnlDefensa.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Atributos de defensa", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlDefensa = new GridBagConstraints();
		gbc_pnlDefensa.gridwidth = 3;
		gbc_pnlDefensa.insets = new Insets(0, 0, 5, 5);
		gbc_pnlDefensa.fill = GridBagConstraints.BOTH;
		gbc_pnlDefensa.gridx = 1;
		gbc_pnlDefensa.gridy = 4;
		contentPane.add(pnlDefensa, gbc_pnlDefensa);
		GridBagLayout gbl_pnlDefensa = new GridBagLayout();
		gbl_pnlDefensa.columnWidths = new int[]{27, 111, 66, 4, 65, 38, 128, 46};
		gbl_pnlDefensa.rowHeights = new int[]{34, 22, 29, 0};
		gbl_pnlDefensa.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlDefensa.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDefensa.setLayout(gbl_pnlDefensa);
		
		lblEntradas = new JLabel("Entradas con éxito: "+jugador.getEntradas_exito());
		lblEntradas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEntradas = new GridBagConstraints();
		gbc_lblEntradas.fill = GridBagConstraints.BOTH;
		gbc_lblEntradas.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntradas.gridx = 1;
		gbc_lblEntradas.gridy = 0;
		pnlDefensa.add(lblEntradas, gbc_lblEntradas);
		
		lblDespejes = new JLabel("Despejes: "+jugador.getDespejes());
		lblDespejes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDespejes = new GridBagConstraints();
		gbc_lblDespejes.fill = GridBagConstraints.BOTH;
		gbc_lblDespejes.gridwidth = 2;
		gbc_lblDespejes.insets = new Insets(0, 0, 5, 5);
		gbc_lblDespejes.gridx = 3;
		gbc_lblDespejes.gridy = 0;
		pnlDefensa.add(lblDespejes, gbc_lblDespejes);
		
		lblDisparosBloqueados = new JLabel("Disparos bloqueados: "+jugador.getTiros_bloqueados());
		lblDisparosBloqueados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDisparosBloqueados = new GridBagConstraints();
		gbc_lblDisparosBloqueados.fill = GridBagConstraints.BOTH;
		gbc_lblDisparosBloqueados.gridwidth = 2;
		gbc_lblDisparosBloqueados.insets = new Insets(0, 0, 5, 0);
		gbc_lblDisparosBloqueados.gridx = 6;
		gbc_lblDisparosBloqueados.gridy = 0;
		pnlDefensa.add(lblDisparosBloqueados, gbc_lblDisparosBloqueados);
		
		lblIntercepciones = new JLabel("Intercepciones: "+jugador.getIntercepciones());
		lblIntercepciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblIntercepciones = new GridBagConstraints();
		gbc_lblIntercepciones.fill = GridBagConstraints.BOTH;
		gbc_lblIntercepciones.insets = new Insets(0, 0, 0, 5);
		gbc_lblIntercepciones.gridx = 1;
		gbc_lblIntercepciones.gridy = 2;
		pnlDefensa.add(lblIntercepciones, gbc_lblIntercepciones);
		
		lblDefensa = new JLabel("Defensa: "+jugador.getDefensa_gen());
		lblDefensa.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblDefensa = new GridBagConstraints();
		gbc_lblDefensa.insets = new Insets(0, 0, 0, 5);
		gbc_lblDefensa.fill = GridBagConstraints.BOTH;
		gbc_lblDefensa.gridx = 6;
		gbc_lblDefensa.gridy = 2;
		pnlDefensa.add(lblDefensa, gbc_lblDefensa);
		
		pnlOtrosAtributos = new JPanel();
		pnlOtrosAtributos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Otros atributos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlOtrosAtributos = new GridBagConstraints();
		gbc_pnlOtrosAtributos.gridwidth = 3;
		gbc_pnlOtrosAtributos.insets = new Insets(0, 0, 0, 5);
		gbc_pnlOtrosAtributos.fill = GridBagConstraints.BOTH;
		gbc_pnlOtrosAtributos.gridx = 1;
		gbc_pnlOtrosAtributos.gridy = 5;
		contentPane.add(pnlOtrosAtributos, gbc_pnlOtrosAtributos);
		GridBagLayout gbl_pnlOtrosAtributos = new GridBagLayout();
		gbl_pnlOtrosAtributos.columnWidths = new int[]{27, 111, 47, 4, 65, 61, 138, 0};
		gbl_pnlOtrosAtributos.rowHeights = new int[]{34, 31, 29, 0};
		gbl_pnlOtrosAtributos.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlOtrosAtributos.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlOtrosAtributos.setLayout(gbl_pnlOtrosAtributos);
		
		lblRegate = new JLabel("Regate: "+jugador.getRegate());
		lblRegate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblRegate = new GridBagConstraints();
		gbc_lblRegate.fill = GridBagConstraints.BOTH;
		gbc_lblRegate.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegate.gridx = 1;
		gbc_lblRegate.gridy = 0;
		pnlOtrosAtributos.add(lblRegate, gbc_lblRegate);
		
		lblEfectividadRegate = new JLabel("Efectividad en el regate (%): "+jugador.getEfectividad_regate());
		lblEfectividadRegate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEfectividadRegate = new GridBagConstraints();
		gbc_lblEfectividadRegate.fill = GridBagConstraints.BOTH;
		gbc_lblEfectividadRegate.gridwidth = 3;
		gbc_lblEfectividadRegate.insets = new Insets(0, 0, 5, 0);
		gbc_lblEfectividadRegate.gridx = 4;
		gbc_lblEfectividadRegate.gridy = 0;
		pnlOtrosAtributos.add(lblEfectividadRegate, gbc_lblEfectividadRegate);
		
		lblParadasPartido = new JLabel("Paradas por partido (%): "+jugador.getParadas_partido());
		lblParadasPartido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblParadasPartido = new GridBagConstraints();
		gbc_lblParadasPartido.fill = GridBagConstraints.BOTH;
		gbc_lblParadasPartido.gridwidth = 3;
		gbc_lblParadasPartido.insets = new Insets(0, 0, 5, 5);
		gbc_lblParadasPartido.gridx = 1;
		gbc_lblParadasPartido.gridy = 1;
		pnlOtrosAtributos.add(lblParadasPartido, gbc_lblParadasPartido);
		
		lblGolesConcedidosPartido = new JLabel("Goles concedidos por partido: "+jugador.getGoles_concedidos_partido());
		lblGolesConcedidosPartido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblGolesConcedidosPartido = new GridBagConstraints();
		gbc_lblGolesConcedidosPartido.fill = GridBagConstraints.BOTH;
		gbc_lblGolesConcedidosPartido.gridwidth = 3;
		gbc_lblGolesConcedidosPartido.insets = new Insets(0, 0, 5, 0);
		gbc_lblGolesConcedidosPartido.gridx = 4;
		gbc_lblGolesConcedidosPartido.gridy = 1;
		pnlOtrosAtributos.add(lblGolesConcedidosPartido, gbc_lblGolesConcedidosPartido);
		
		lblDuelosGanados = new JLabel("Duelos ganados (%): "+jugador.getDuelos_ganados());
		lblDuelosGanados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDuelosGanados = new GridBagConstraints();
		gbc_lblDuelosGanados.fill = GridBagConstraints.BOTH;
		gbc_lblDuelosGanados.insets = new Insets(0, 0, 0, 5);
		gbc_lblDuelosGanados.gridx = 1;
		gbc_lblDuelosGanados.gridy = 2;
		pnlOtrosAtributos.add(lblDuelosGanados, gbc_lblDuelosGanados);
		
		lblFaltas = new JLabel("Faltas: "+jugador.getFaltas());
		lblFaltas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblFaltas = new GridBagConstraints();
		gbc_lblFaltas.fill = GridBagConstraints.BOTH;
		gbc_lblFaltas.gridwidth = 2;
		gbc_lblFaltas.insets = new Insets(0, 0, 0, 5);
		gbc_lblFaltas.gridx = 3;
		gbc_lblFaltas.gridy = 2;
		pnlOtrosAtributos.add(lblFaltas, gbc_lblFaltas);
		
		lblEquipoSemana = new JLabel("Equipo de la semana: "+jugador.getEquipo_semana());
		lblEquipoSemana.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEquipoSemana = new GridBagConstraints();
		gbc_lblEquipoSemana.gridwidth = 2;
		gbc_lblEquipoSemana.fill = GridBagConstraints.BOTH;
		gbc_lblEquipoSemana.gridx = 5;
		gbc_lblEquipoSemana.gridy = 2;
		pnlOtrosAtributos.add(lblEquipoSemana, gbc_lblEquipoSemana);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
