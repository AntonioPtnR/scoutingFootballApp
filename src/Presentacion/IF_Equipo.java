package Presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;

import Dominio.Jugador;
import Dominio.Usuario;

import javax.swing.event.ListSelectionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class IF_Equipo extends JInternalFrame {
	private static IF_Equipo instancia;
	private static IF_Equipo frame;
	private static String nombre_entidad;
	private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarra = null;  
	private JScrollPane scrollPane;
	private JPanel pnlInfo;
	private JButton btnAniadirJugador;
	private JLabel lblJugadorSeleccionado;
	private JLabel lblPantillaActual;
	private JList listJugadores;
	private JLabel lblNombre;
	private JLabel lblNombreEquipo;
	private JLabel lblPosicion;
	private JLabel lblEdad;
	private JLabel lblFormaFisica;
	private JLabel lblEstado;
	private JProgressBar pbFormaFisica;
	private JLabel lblLesiones;
	private JLabel lblAtaque;
	private JLabel lblDefensa;
	private JLabel lblPase;
	private JLabel lblParadasPartido;
	private JLabel lbNumParadas;
	private JLabel lblGolesConcedidos;
	private JLabel lblComentarios;
	private JTextPane txtPaneComentarios;
	private static int [] vNumeros = {0};
	DefaultListModel modeloLista = new DefaultListModel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new IF_Equipo();
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
	
	
	public static IF_Equipo getInstancia() {
	       // Si la instancia no está creada o la ventana está cerrada se crea la instancia

	       if (instancia == null || instancia.isClosed) {
	          instancia = new IF_Equipo();
	      }
	       return instancia;
	   }
	public IF_Equipo() {};
	public IF_Equipo(String nombre_entidad) {
		this.nombre_entidad = nombre_entidad;
		setBorder(null);
		setBounds(new Rectangle(0, 0, 1050, 750));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{227, 762, 72, 0, 0};
		gridBagLayout.rowHeights = new int[]{45, 638, 41, 24, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		try {
			Usuario u = Usuario.readPresupuesto(nombre_entidad);
			Jugador j = new Jugador();
			Vector<Jugador> jugadores = j.readJugadorEquipo(u.getmNombre_Entidad());
		
		lblPantillaActual = new JLabel("Plantilla Actual de Jugadores del Equipo");
		lblPantillaActual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblPantillaActual = new GridBagConstraints();
		gbc_lblPantillaActual.gridwidth = 2;
		gbc_lblPantillaActual.insets = new Insets(0, 0, 5, 5);
		gbc_lblPantillaActual.gridx = 0;
		gbc_lblPantillaActual.gridy = 0;
		getContentPane().add(lblPantillaActual, gbc_lblPantillaActual);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(Color.LIGHT_GRAY);
		btnActualizar.addActionListener(new BtnActualizarActionListener());
		btnActualizar.setIcon(new ImageIcon(IF_Equipo.class.getResource("/Presentacion/icono_actualizar.png")));
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnActualizar.gridx = 2;
		gbc_btnActualizar.gridy = 0;
		getContentPane().add(btnActualizar, gbc_btnActualizar);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		listJugadores = new JList();
		
		listJugadores.setModel(modeloLista);
		for(int i= 0; i < jugadores.size(); i++ )
			modeloLista.addElement(jugadores.get(i).getNombre());
		//modeloLista.addElement("Javier");
		//Añadimos dos elementos de prueba
		listJugadores.addListSelectionListener(new ListJugadoresListSelectionListener());
		listJugadores.setCellRenderer(new ListCellRender());
		listJugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listJugadores);
		
		pnlInfo = new JPanel();
		pnlInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informaci\u00F3n del jugador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlInfo = new GridBagConstraints();
		gbc_pnlInfo.gridwidth = 3;
		gbc_pnlInfo.insets = new Insets(0, 0, 5, 0);
		gbc_pnlInfo.fill = GridBagConstraints.BOTH;
		gbc_pnlInfo.gridx = 1;
		gbc_pnlInfo.gridy = 1;
		getContentPane().add(pnlInfo, gbc_pnlInfo);
		GridBagLayout gbl_pnlInfo = new GridBagLayout();
		gbl_pnlInfo.columnWidths = new int[]{44, 127, 150, 260, 233, 0, 0};
		gbl_pnlInfo.rowHeights = new int[]{0, 86, 0, 106, 0, 84, 0, 77, 26, 89, 0};
		gbl_pnlInfo.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlInfo.setLayout(gbl_pnlInfo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setVisible(false);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		pnlInfo.add(lblNombre, gbc_lblNombre);
		
		lblPosicion = new JLabel("Posición:  <posicion>");
		lblPosicion.setVisible(false);
		
		lbNombre = new JLabel("");
		GridBagConstraints gbc_lbNombre = new GridBagConstraints();
		gbc_lbNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lbNombre.gridx = 2;
		gbc_lbNombre.gridy = 1;
		pnlInfo.add(lbNombre, gbc_lbNombre);
		GridBagConstraints gbc_lblPosicion = new GridBagConstraints();
		gbc_lblPosicion.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosicion.gridx = 3;
		gbc_lblPosicion.gridy = 1;
		pnlInfo.add(lblPosicion, gbc_lblPosicion);
		
		lblEdad = new JLabel("Edad: <edad>");
		lblEdad.setVisible(false);
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 4;
		gbc_lblEdad.gridy = 1;
		pnlInfo.add(lblEdad, gbc_lblEdad);
		
		lblFormaFisica = new JLabel("Forma Física:");
		lblFormaFisica.setVisible(false);
		GridBagConstraints gbc_lblFormaFisica = new GridBagConstraints();
		gbc_lblFormaFisica.anchor = GridBagConstraints.EAST;
		gbc_lblFormaFisica.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormaFisica.gridx = 1;
		gbc_lblFormaFisica.gridy = 3;
		pnlInfo.add(lblFormaFisica, gbc_lblFormaFisica);
		
		pbFormaFisica = new JProgressBar();
		pbFormaFisica.setBackground(Color.RED);
		pbFormaFisica.setVisible(false);
		pbFormaFisica.setForeground(Color.GREEN);
		pbFormaFisica.setValue(90);
		GridBagConstraints gbc_pbFormaFisica = new GridBagConstraints();
		gbc_pbFormaFisica.fill = GridBagConstraints.HORIZONTAL;
		gbc_pbFormaFisica.insets = new Insets(0, 0, 5, 5);
		gbc_pbFormaFisica.gridx = 2;
		gbc_pbFormaFisica.gridy = 3;
		pnlInfo.add(pbFormaFisica, gbc_pbFormaFisica);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setVisible(false);
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 3;
		gbc_lblEstado.gridy = 3;
		pnlInfo.add(lblEstado, gbc_lblEstado);
		
		lblLesiones = new JLabel("Lesiones:");
		lblLesiones.setVisible(false);
		GridBagConstraints gbc_lblLesiones = new GridBagConstraints();
		gbc_lblLesiones.insets = new Insets(0, 0, 5, 5);
		gbc_lblLesiones.gridx = 4;
		gbc_lblLesiones.gridy = 3;
		pnlInfo.add(lblLesiones, gbc_lblLesiones);
		
		lblAtaque = new JLabel("Ataque:");
		lblAtaque.setVisible(false);
		GridBagConstraints gbc_lblAtaque = new GridBagConstraints();
		gbc_lblAtaque.anchor = GridBagConstraints.EAST;
		gbc_lblAtaque.insets = new Insets(0, 0, 5, 5);
		gbc_lblAtaque.gridx = 1;
		gbc_lblAtaque.gridy = 5;
		pnlInfo.add(lblAtaque, gbc_lblAtaque);
		
		lblDefensa = new JLabel("Defensa:");
		lblDefensa.setVisible(false);
		
		lbAtaque = new JLabel("");
		GridBagConstraints gbc_lbAtaque = new GridBagConstraints();
		gbc_lbAtaque.anchor = GridBagConstraints.WEST;
		gbc_lbAtaque.insets = new Insets(0, 0, 5, 5);
		gbc_lbAtaque.gridx = 2;
		gbc_lbAtaque.gridy = 5;
		pnlInfo.add(lbAtaque, gbc_lbAtaque);
		GridBagConstraints gbc_lblDefensa = new GridBagConstraints();
		gbc_lblDefensa.insets = new Insets(0, 0, 5, 5);
		gbc_lblDefensa.gridx = 3;
		gbc_lblDefensa.gridy = 5;
		pnlInfo.add(lblDefensa, gbc_lblDefensa);
		
		lblPase = new JLabel("Pase:");
		lblPase.setVisible(false);
		GridBagConstraints gbc_lblPase = new GridBagConstraints();
		gbc_lblPase.insets = new Insets(0, 0, 5, 5);
		gbc_lblPase.gridx = 4;
		gbc_lblPase.gridy = 5;
		pnlInfo.add(lblPase, gbc_lblPase);
		
		lblParadasPartido = new JLabel("Paradas/partido:");
		lblParadasPartido.setVisible(false);
		GridBagConstraints gbc_lblParadasPartido = new GridBagConstraints();
		gbc_lblParadasPartido.anchor = GridBagConstraints.EAST;
		gbc_lblParadasPartido.insets = new Insets(0, 0, 5, 5);
		gbc_lblParadasPartido.gridx = 1;
		gbc_lblParadasPartido.gridy = 7;
		pnlInfo.add(lblParadasPartido, gbc_lblParadasPartido);
		
		lbNumParadas = new JLabel("<num_par>");
		lbNumParadas.setVisible(false);
		GridBagConstraints gbc_lbNumParadas = new GridBagConstraints();
		gbc_lbNumParadas.anchor = GridBagConstraints.WEST;
		gbc_lbNumParadas.insets = new Insets(0, 0, 5, 5);
		gbc_lbNumParadas.gridx = 2;
		gbc_lbNumParadas.gridy = 7;
		pnlInfo.add(lbNumParadas, gbc_lbNumParadas);
		
		lblGolesConcedidos = new JLabel("Goles concedidos/partido: <num_goles>");
		lblGolesConcedidos.setVisible(false);
		GridBagConstraints gbc_lblGolesConcedidos = new GridBagConstraints();
		gbc_lblGolesConcedidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblGolesConcedidos.gridx = 4;
		gbc_lblGolesConcedidos.gridy = 7;
		pnlInfo.add(lblGolesConcedidos, gbc_lblGolesConcedidos);
		
		lblComentarios = new JLabel("Comentarios:");
		lblComentarios.setVisible(false);
		GridBagConstraints gbc_lblComentarios = new GridBagConstraints();
		gbc_lblComentarios.gridwidth = 2;
		gbc_lblComentarios.insets = new Insets(0, 0, 0, 5);
		gbc_lblComentarios.gridx = 1;
		gbc_lblComentarios.gridy = 9;
		pnlInfo.add(lblComentarios, gbc_lblComentarios);
		
		txtPaneComentarios = new JTextPane();
		txtPaneComentarios.setVisible(false);
		GridBagConstraints gbc_txtPaneComentarios = new GridBagConstraints();
		gbc_txtPaneComentarios.gridwidth = 2;
		gbc_txtPaneComentarios.insets = new Insets(0, 0, 0, 5);
		gbc_txtPaneComentarios.fill = GridBagConstraints.BOTH;
		gbc_txtPaneComentarios.gridx = 3;
		gbc_txtPaneComentarios.gridy = 9;
		pnlInfo.add(txtPaneComentarios, gbc_txtPaneComentarios);
		
		btnAniadirJugador = new JButton("Añadir Jugador");
		btnAniadirJugador.setBackground(Color.LIGHT_GRAY);
		btnAniadirJugador.addActionListener(new BtnAniadirJugadorActionListener());
		GridBagConstraints gbc_btnAniadirJugador = new GridBagConstraints();
		gbc_btnAniadirJugador.fill = GridBagConstraints.BOTH;
		gbc_btnAniadirJugador.insets = new Insets(0, 0, 5, 5);
		gbc_btnAniadirJugador.gridx = 0;
		gbc_btnAniadirJugador.gridy = 2;
		getContentPane().add(btnAniadirJugador, gbc_btnAniadirJugador);
		btnAniadirJugador.setEnabled(true);
		
		lblNombreEquipo = new JLabel(u.getmNombre_Entidad());
		lblNombreEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNombreEquipo = new GridBagConstraints();
		gbc_lblNombreEquipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreEquipo.gridx = 1;
		gbc_lblNombreEquipo.gridy = 2;
		getContentPane().add(lblNombreEquipo, gbc_lblNombreEquipo);
		
		lblJugadorSeleccionado = new JLabel("");
		GridBagConstraints gbc_lblJugadorSeleccionado = new GridBagConstraints();
		gbc_lblJugadorSeleccionado.insets = new Insets(0, 0, 0, 5);
		gbc_lblJugadorSeleccionado.anchor = GridBagConstraints.WEST;
		gbc_lblJugadorSeleccionado.gridwidth = 2;
		gbc_lblJugadorSeleccionado.gridx = 0;
		gbc_lblJugadorSeleccionado.gridy = 3;
		getContentPane().add(lblJugadorSeleccionado, gbc_lblJugadorSeleccionado);
		QuitarLaBarraTitulo();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void setVector(int[] vector, int valor) {
		vector[0] = valor;
	}
	
	public void QuitarLaBarraTitulo()
	{
	Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	DimensionBarra = Barra.getPreferredSize();
	Barra.setSize(0,0);
	Barra.setPreferredSize(new Dimension(0,0));
	repaint();
	}

	private class ListJugadoresListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			lblJugadorSeleccionado.setText("Jugador seleccionado: "+(String) listJugadores.getSelectedValue());
			Jugador j = new Jugador();
			try {
				Vector<Jugador> jugador = j.readJugadorEquipoLista((String)listJugadores.getSelectedValue());
				j = jugador.get(0);
				lblNombre.setVisible(true);
				lblPosicion.setVisible(true);
				lblEdad.setVisible(true);
				lblFormaFisica.setVisible(true);
				lblAtaque.setVisible(true);
				lblDefensa.setVisible(true);
				lblPase.setVisible(true);
				lblEstado.setVisible(true);
				lblLesiones.setVisible(true);
				lbNumParadas.setVisible(true);
				lblGolesConcedidos.setVisible(true);
				lblParadasPartido.setVisible(true);
				lblFormaFisica.setVisible(true);
				pbFormaFisica.setVisible(true);
				txtPaneComentarios.setVisible(true);
				
				lbNombre.setText(j.getNombre());
				lblPosicion.setText("Posición "+j.getPosicion());
				lblEdad.setText("Edad: "+j.getEdad());
				pbFormaFisica.setValue(j.getForma_fisica());
				lblEstado.setText("Estado: "+j.getEstado());
				lblLesiones.setText("Lesiones: "+j.getLesiones());
				lbAtaque.setText(""+j.getAtaque());
				lblDefensa.setText("Defensa: "+j.getDefensa());
				lblPase.setText("Pase: " +j.getPase());
				txtPaneComentarios.setText(j.getComentarios());
				lbNumParadas.setText(""+j.getParadas_partido());
				lblGolesConcedidos.setText("Goles concedidos/partido "+j.getGoles_concedidos_partido());
				lblComentarios.setVisible(true);
			
			}catch (ArrayIndexOutOfBoundsException es) {
				System.out.println("Excepcion, ninguna fila seleccionada");
					
				}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
	}
	
	int numero = 0;
	private JButton btnActualizar;
	private JLabel lbNombre;
	private JLabel lbAtaque;
	private class BtnAniadirJugadorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(vNumeros[0] == 0) {
				FormularioNuevoJugador nuevoJugador = new FormularioNuevoJugador(nombre_entidad,vNumeros);
				nuevoJugador.setVisible(true);
				vNumeros[0] =1;
			}
			
		}
	}
	private class BtnActualizarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Usuario u;
			try {
				u = Usuario.readPresupuesto(nombre_entidad);
				Jugador j = new Jugador();
				Vector<Jugador> jugadores = j.readJugadorEquipo(u.getmNombre_Entidad());
				modeloLista.removeAllElements();
				for(int i= 0; i < jugadores.size(); i++ )
					modeloLista.addElement(jugadores.get(i).getNombre());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
	}
}
