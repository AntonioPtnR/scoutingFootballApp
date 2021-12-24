package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;



import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Menu extends JFrame {
	private JPanel contentPane;
	IF_Futbolistas if_futbolistas = IF_Futbolistas.getInstancia();
	IF_Equipo if_equipo = IF_Equipo.getInstancia();
	IF_Chollos if_chollos = IF_Chollos.getInstancia();
	
	private static String nombre_usuario;
	
	//private Menu frame;
	
	private javax.swing.JDesktopPane desktopPane;
	private JDesktopPane jDeskPane;
	
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu jmbFutbolistas;
    private javax.swing.JMenuItem jmibFutbolistas;
    private JButton btnSalir;
    private JButton btnEditarUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(nombre_usuario);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu(String nombre_usuario) {
		addWindowListener(new ThisWindowListener());
		this.nombre_usuario = nombre_usuario;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/Presentacion/logoApp.png")));
		setTitle("scoutingFootbalApp - Menú");
		setBounds(new Rectangle(0, 0, 1150, 759));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		 jDeskPane = new JDesktopPane();
		 jDeskPane.setBackground(SystemColor.textHighlight);
		contentPane.add(jDeskPane, BorderLayout.CENTER);
		jDeskPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlInicio = new JPanel();
		pnlInicio.setBackground(SystemColor.menu);
		jDeskPane.add(pnlInicio, BorderLayout.NORTH);
		GridBagLayout gbl_pnlInicio = new GridBagLayout();
		gbl_pnlInicio.columnWidths = new int[]{235, 116, 120, 96, 164, 142, 110, 26, 113, 26, 0};
		gbl_pnlInicio.rowHeights = new int[]{43, 96, 14, 94, 168, 116, 99, 189, 0};
		gbl_pnlInicio.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlInicio.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		pnlInicio.setLayout(gbl_pnlInicio);
		
		JLabel lblMensaje = new JLabel("¿Qué quieres hacer?");
		lblMensaje.setFont(new Font("Georgia", Font.PLAIN, 27));
		GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
		gbc_lblMensaje.gridheight = 2;
		gbc_lblMensaje.gridwidth = 3;
		gbc_lblMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblMensaje.gridx = 2;
		gbc_lblMensaje.gridy = 1;
		pnlInicio.add(lblMensaje, gbc_lblMensaje);
		
		btnEditarUser = new JButton("");
		btnEditarUser.addMouseListener(new BtnEditarUserMouseListener());
		btnEditarUser.addActionListener(new BtnEditarUserActionListener());
		btnEditarUser.setContentAreaFilled(false);
		btnEditarUser.setToolTipText("Editar Perfil");
		btnEditarUser.setBackground(new Color(245, 245, 245));
		btnEditarUser.setIcon(new ImageIcon(Menu.class.getResource("/Presentacion/editar_perfil.png")));
		btnEditarUser.setBorder(null);
		GridBagConstraints gbc_btnEditarUser = new GridBagConstraints();
		gbc_btnEditarUser.anchor = GridBagConstraints.EAST;
		gbc_btnEditarUser.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditarUser.gridx = 6;
		gbc_btnEditarUser.gridy = 1;
		pnlInicio.add(btnEditarUser, gbc_btnEditarUser);
		
		btnSalir = new JButton("");
		btnSalir.setToolTipText("Volver a la pantalla de login");
		btnSalir.setContentAreaFilled(false);
		btnSalir.addMouseListener(new BtnSalirMouseListener());
		btnSalir.addActionListener(new BtnSalirActionListener());
		btnSalir.setIcon(new ImageIcon(Menu.class.getResource("/Presentacion/salir_icono.png")));
		btnSalir.setBorder(null);
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.anchor = GridBagConstraints.WEST;
		gbc_btnSalir.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalir.gridx = 8;
		gbc_btnSalir.gridy = 1;
		pnlInicio.add(btnSalir, gbc_btnSalir);
		
		JButton btnJugadores = new JButton("Cargar base de datos de jugadores");
		btnJugadores.setBackground(Color.LIGHT_GRAY);
		btnJugadores.addActionListener(new BtnJugadoresActionListener());
		GridBagConstraints gbc_btnJugadores = new GridBagConstraints();
		gbc_btnJugadores.gridwidth = 3;
		gbc_btnJugadores.insets = new Insets(0, 0, 5, 5);
		gbc_btnJugadores.gridx = 2;
		gbc_btnJugadores.gridy = 3;
		pnlInicio.add(btnJugadores, gbc_btnJugadores);
		
		JLabel lblimagenIzqda = new JLabel("");
		lblimagenIzqda.setIcon(new ImageIcon(Menu.class.getResource("/Presentacion/scouting-company.png")));
		GridBagConstraints gbc_lblimagenIzqda = new GridBagConstraints();
		gbc_lblimagenIzqda.anchor = GridBagConstraints.EAST;
		gbc_lblimagenIzqda.gridwidth = 2;
		gbc_lblimagenIzqda.insets = new Insets(0, 0, 5, 5);
		gbc_lblimagenIzqda.gridx = 1;
		gbc_lblimagenIzqda.gridy = 4;
		pnlInicio.add(lblimagenIzqda, gbc_lblimagenIzqda);
		
		JLabel lblImagenDcha = new JLabel("");
		lblImagenDcha.setIcon(new ImageIcon(Menu.class.getResource("/Presentacion/Football-Vector-Man-298x300.png")));
		GridBagConstraints gbc_lblImagenDcha = new GridBagConstraints();
		gbc_lblImagenDcha.anchor = GridBagConstraints.WEST;
		gbc_lblImagenDcha.gridwidth = 2;
		gbc_lblImagenDcha.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagenDcha.gridx = 4;
		gbc_lblImagenDcha.gridy = 4;
		pnlInicio.add(lblImagenDcha, gbc_lblImagenDcha);
		
		JButton btnChollos = new JButton("Chollos");
		btnChollos.setBackground(Color.LIGHT_GRAY);
		btnChollos.addActionListener(new BtnChollosActionListener());
		GridBagConstraints gbc_btnChollos = new GridBagConstraints();
		gbc_btnChollos.anchor = GridBagConstraints.EAST;
		gbc_btnChollos.gridwidth = 2;
		gbc_btnChollos.insets = new Insets(0, 0, 5, 5);
		gbc_btnChollos.gridx = 1;
		gbc_btnChollos.gridy = 5;
		pnlInicio.add(btnChollos, gbc_btnChollos);
		
		JButton btnAdministrarEquipo = new JButton("Administrar Equipo");
		btnAdministrarEquipo.setBackground(Color.LIGHT_GRAY);
		btnAdministrarEquipo.addActionListener(new BtnAdministrarEquipoActionListener());
		GridBagConstraints gbc_btnAdministrarEquipo = new GridBagConstraints();
		gbc_btnAdministrarEquipo.anchor = GridBagConstraints.WEST;
		gbc_btnAdministrarEquipo.gridwidth = 2;
		gbc_btnAdministrarEquipo.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdministrarEquipo.gridx = 4;
		gbc_btnAdministrarEquipo.gridy = 5;
		pnlInicio.add(btnAdministrarEquipo, gbc_btnAdministrarEquipo);
		
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBackground(SystemColor.menu);
		contentPane.add(menuBar_1, BorderLayout.NORTH);
		
		JMenu aplicacionMenu = new JMenu("Aplicación");
		menuBar_1.add(aplicacionMenu);
		
		JMenuItem mntmInicio = new JMenuItem("Inicio");
		mntmInicio.addActionListener(new MntmInicioActionListener());
		aplicacionMenu.add(mntmInicio);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new MntmSalirActionListener());
		aplicacionMenu.add(mntmSalir);
		
		
		JMenu jmbFutbolistas_1 = new JMenu("Futbolistas");
		menuBar_1.add(jmbFutbolistas_1);
		
		JMenuItem mntmFutbolistas = new JMenuItem("Base de datos de futbolistas");
		mntmFutbolistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jDeskPane.removeAll();
				int height =jDeskPane.getHeight();
				int width = jDeskPane.getWidth();
		        jDeskPane.add(if_futbolistas);
		        if_futbolistas.setSize(width,height);
		        jDeskPane.updateUI();
		        if_futbolistas.show();
		        setTitle("scoutingFootballApp - Base de datos de jugadores");
			}
		});
		
		jmbFutbolistas_1.add(mntmFutbolistas);
		
		JMenu jmbOnce = new JMenu("Tu equipo");
		menuBar_1.add(jmbOnce);
		
		JMenuItem mntmOnce = new JMenuItem("Administrar equipo");
		mntmOnce.addActionListener(new MntmOnceActionListener());
		jmbOnce.add(mntmOnce);
		
		JMenu jmbChollos = new JMenu("Chollos");
		menuBar_1.add(jmbChollos);
		
		JMenuItem mntmChollos = new JMenuItem("Chollos de mercado");
		mntmChollos.addActionListener(new MntmChollosActionListener());
		jmbChollos.add(mntmChollos);
	}
	
	
	private class MntmSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
	}
	private class MntmInicioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(if_futbolistas.isEnabled())
				if_futbolistas.dispose();
			if(if_equipo.isEnabled())
				if_equipo.dispose();
			if(if_chollos.isEnabled())
				if_chollos.dispose();
			else
				setTitle("scoutingFootballApp - Inicio");
				dispose();
				Menu menu = new Menu(Menu.nombre_usuario);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
		}
	}
	private class MntmOnceActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jDeskPane.removeAll();
			if_equipo = new IF_Equipo(nombre_usuario);
			int height =jDeskPane.getHeight();
			int width = jDeskPane.getWidth();
	        jDeskPane.add(if_equipo);
	        if_equipo.setSize(width,height);
	        jDeskPane.updateUI();
	        if_equipo.show();
	        setTitle("scoutingFootballApp - Administrador del equipo");
		}
	}
	private class MntmChollosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jDeskPane.removeAll();
			if_chollos = new IF_Chollos(nombre_usuario);
			int height =jDeskPane.getHeight();
			int width = jDeskPane.getWidth();
	        jDeskPane.add(if_chollos);
	        if_chollos.setSize(width,height);
	        jDeskPane.updateUI();
	        if_chollos.show();
	        setTitle("scoutingFootballApp - Chollos");
			
		}
	}
	private class BtnJugadoresActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jDeskPane.removeAll();
			int height =jDeskPane.getHeight();
			int width = jDeskPane.getWidth();
	        jDeskPane.add(if_futbolistas);
	        if_futbolistas.setSize(width,height);
	        jDeskPane.updateUI();
	        if_futbolistas.show();
	        setTitle("scoutingFootballApp - Base de datos de jugadores");
			
		}
	}
	private class BtnChollosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jDeskPane.removeAll();
			if_chollos = new IF_Chollos(nombre_usuario);
			int height =jDeskPane.getHeight();
			int width = jDeskPane.getWidth();
	        jDeskPane.add(if_chollos);
	        if_chollos.setSize(width,height);
	        jDeskPane.updateUI();
	        if_chollos.show();
	        setTitle("scoutingFootballApp - Chollos");
		}
	}
	private class BtnAdministrarEquipoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			jDeskPane.removeAll();
			if_equipo = new IF_Equipo(nombre_usuario);
			int height =jDeskPane.getHeight();
			int width = jDeskPane.getWidth();
	        jDeskPane.add(if_equipo);
	        if_equipo.setSize(width,height);
	        jDeskPane.updateUI();
	        if_equipo.show();
	        setTitle("scoutingFootballApp - Administrador del equipo");
		}
	}
	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			VentanaLogin vLogin = new VentanaLogin();
			vLogin.frmScoutingfutbolappLogin.setVisible(true);
		}
	}
	private class BtnSalirMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSalir.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnSalir.setBorder(null);
		}
	}
	private class BtnEditarUserActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			FormularioEditarPerfil formularioEdPerfil = new FormularioEditarPerfil(nombre_usuario);
			formularioEdPerfil.setVisible(true);
			
		}
	}
	private class BtnEditarUserMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnEditarUser.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnEditarUser.setBorder(null);
		}
	}
	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			dispose();
			VentanaLogin vlogin = new VentanaLogin();
			vlogin.frmScoutingfutbolappLogin.setVisible(true);
			vlogin.setLocationRelativeTo(null);
		}
	}
	
	class FondoPanel extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/Presentacion/terreno_juego_1.jpg")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
}
