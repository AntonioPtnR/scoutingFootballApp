package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import Dominio.GestorUsuario;


import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

public class VentanaLogin extends JFrame{

	JFrame frmScoutingfutbolappLogin;
	private JPanel pnlBarraEstado;
	private JPanel pnlLogin;
	private JLabel lblBienvenido;
	private JLabel lblLogo;
	private JLabel lblNUsuario;
	private JLabel lblPassword;
	private JButton btnEntrar;
	private JButton btnCrearCuenta;
	private JLabel lblEstado;
	private JTextField txtNUsuario;
	private JPasswordField password;
	private JPanel pnlInformacion;
	private JLabel lblInfo;
	private JButton btnContraseñaOlvidada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
					window.frmScoutingfutbolappLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScoutingfutbolappLogin = new JFrame();
		frmScoutingfutbolappLogin.setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaLogin.class.getResource("/Presentacion/logoApp.png")));
		frmScoutingfutbolappLogin.setTitle("scoutingFutbolApp - Login");
		frmScoutingfutbolappLogin.setBounds(new Rectangle(460, 100, 700, 600));
		frmScoutingfutbolappLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScoutingfutbolappLogin.getContentPane().setLayout(new BorderLayout(0, 0));
		pnlBarraEstado = new JPanel();
		pnlBarraEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmScoutingfutbolappLogin.getContentPane().add(pnlBarraEstado, BorderLayout.SOUTH);
		pnlBarraEstado.setLayout(new BorderLayout(0, 0));

		lblEstado = new JLabel("No logeado");
		pnlBarraEstado.add(lblEstado);
		frmScoutingfutbolappLogin.setResizable(false);

		pnlLogin = new JPanel();
		frmScoutingfutbolappLogin.getContentPane().add(pnlLogin, BorderLayout.NORTH);
		GridBagLayout gbl_pnlLogin = new GridBagLayout();
		gbl_pnlLogin.columnWidths = new int[] { 133, 101, 113, 96, 96, 83, 73, 63, 118, 126, 0 };
		gbl_pnlLogin.rowHeights = new int[] { 153, 53, 15, 50, 68, 57, 98, 46, 0 };
		gbl_pnlLogin.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_pnlLogin.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlLogin.setLayout(gbl_pnlLogin);

		lblBienvenido = new JLabel("scoutingFutbolApp");
		lblBienvenido.setFont(new Font("Kristen ITC", Font.PLAIN, 30));
		GridBagConstraints gbc_lblBienvenido = new GridBagConstraints();
		gbc_lblBienvenido.anchor = GridBagConstraints.EAST;
		gbc_lblBienvenido.gridwidth = 6;
		gbc_lblBienvenido.insets = new Insets(0, 0, 5, 5);
		gbc_lblBienvenido.gridx = 0;
		gbc_lblBienvenido.gridy = 0;
		pnlLogin.add(lblBienvenido, gbc_lblBienvenido);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(VentanaLogin.class.getResource("/Presentacion/logoApp.png")));
		GridBagConstraints gbc_lblLogo = new GridBagConstraints();
		gbc_lblLogo.gridwidth = 2;
		gbc_lblLogo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLogo.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogo.gridx = 6;
		gbc_lblLogo.gridy = 0;
		pnlLogin.add(lblLogo, gbc_lblLogo);

		lblNUsuario = new JLabel("Nombre de usuario");
		lblNUsuario.setFont(new Font("Georgia", Font.PLAIN, 19));
		GridBagConstraints gbc_lblNUsuario = new GridBagConstraints();
		gbc_lblNUsuario.gridwidth = 2;
		gbc_lblNUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblNUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNUsuario.gridx = 2;
		gbc_lblNUsuario.gridy = 1;
		pnlLogin.add(lblNUsuario, gbc_lblNUsuario);

		txtNUsuario = new JTextField();
		txtNUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNUsuario.setColumns(10);
		GridBagConstraints gbc_txtNUsuario = new GridBagConstraints();
		gbc_txtNUsuario.gridwidth = 4;
		gbc_txtNUsuario.fill = GridBagConstraints.BOTH;
		gbc_txtNUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtNUsuario.gridx = 4;
		gbc_txtNUsuario.gridy = 1;
		pnlLogin.add(txtNUsuario, gbc_txtNUsuario);

		lblPassword = new JLabel("Contraseña");
		lblPassword.setFont(new Font("Georgia", Font.PLAIN, 19));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.gridwidth = 2;
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 3;
		pnlLogin.add(lblPassword, gbc_lblPassword);

		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.gridwidth = 4;
		gbc_password.insets = new Insets(0, 0, 5, 5);
		gbc_password.fill = GridBagConstraints.BOTH;
		gbc_password.gridx = 4;
		gbc_password.gridy = 3;
		pnlLogin.add(password, gbc_password);
		
				btnCrearCuenta = new JButton("Crear Cuenta");
				btnCrearCuenta.setBackground(Color.LIGHT_GRAY);
				btnCrearCuenta.addActionListener(new BtnCrearCuentaActionListener());
				btnCrearCuenta.setFont(new Font("Georgia", Font.PLAIN, 16));
				GridBagConstraints gbc_btnCrearCuenta = new GridBagConstraints();
				gbc_btnCrearCuenta.gridheight = 2;
				gbc_btnCrearCuenta.gridwidth = 3;
				gbc_btnCrearCuenta.insets = new Insets(0, 0, 5, 5);
				gbc_btnCrearCuenta.gridx = 3;
				gbc_btnCrearCuenta.gridy = 4;
				pnlLogin.add(btnCrearCuenta, gbc_btnCrearCuenta);
				
						btnEntrar = new JButton("Entrar");
						btnEntrar.setBackground(Color.LIGHT_GRAY);
						btnEntrar.setFont(new Font("Georgia", Font.PLAIN, 16));
						btnEntrar.addActionListener(new BtnEntrarActionListener());
						GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
						gbc_btnEntrar.gridwidth = 2;
						gbc_btnEntrar.gridheight = 2;
						gbc_btnEntrar.anchor = GridBagConstraints.EAST;
						gbc_btnEntrar.insets = new Insets(0, 0, 5, 5);
						gbc_btnEntrar.gridx = 6;
						gbc_btnEntrar.gridy = 4;
						pnlLogin.add(btnEntrar, gbc_btnEntrar);
						
						pnlInformacion = new JPanel();
						GridBagConstraints gbc_pnlInformacion = new GridBagConstraints();
						gbc_pnlInformacion.gridheight = 2;
						gbc_pnlInformacion.gridwidth = 7;
						gbc_pnlInformacion.insets = new Insets(0, 0, 5, 5);
						gbc_pnlInformacion.fill = GridBagConstraints.VERTICAL;
						gbc_pnlInformacion.gridx = 2;
						gbc_pnlInformacion.gridy = 6;
						pnlLogin.add(pnlInformacion, gbc_pnlInformacion);
						GridBagLayout gbl_pnlInformacion = new GridBagLayout();
						gbl_pnlInformacion.columnWidths = new int[]{540, 0};
						gbl_pnlInformacion.rowHeights = new int[]{108, 33, 0};
						gbl_pnlInformacion.columnWeights = new double[]{0.0, Double.MIN_VALUE};
						gbl_pnlInformacion.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
						pnlInformacion.setLayout(gbl_pnlInformacion);
						
						lblInfo = new JLabel("Introduce tus datos de autenticación");
						lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
						lblInfo.setFont(new Font("Verdana", Font.PLAIN, 12));
						GridBagConstraints gbc_lblInfo = new GridBagConstraints();
						gbc_lblInfo.fill = GridBagConstraints.BOTH;
						gbc_lblInfo.insets = new Insets(0, 0, 5, 0);
						gbc_lblInfo.gridx = 0;
						gbc_lblInfo.gridy = 0;
						pnlInformacion.add(lblInfo, gbc_lblInfo);
						
						btnContraseñaOlvidada = new JButton("¿Has olvidado la contraseña?");
						btnContraseñaOlvidada.setBackground(Color.LIGHT_GRAY);
						btnContraseñaOlvidada.addActionListener(new BtnContraseñaOlvidadaActionListener());
						btnContraseñaOlvidada.setVisible(false);
						btnContraseñaOlvidada.setFont(new Font("Georgia", Font.PLAIN, 14));
						GridBagConstraints gbc_btnContraseñaOlvidada = new GridBagConstraints();
						gbc_btnContraseñaOlvidada.gridx = 0;
						gbc_btnContraseñaOlvidada.gridy = 1;
						pnlInformacion.add(btnContraseñaOlvidada, gbc_btnContraseñaOlvidada);

	}

	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String log = txtNUsuario.getText();
			String pass = String.valueOf(password.getPassword());
			btnContraseñaOlvidada.setEnabled(true);
			try {
				boolean autenticado = GestorUsuario.autenticar(log, pass);
				if (autenticado == true) {
					lblEstado.setText("El usuario se ha autenticado correctamente");
					lblInfo.setIcon(new ImageIcon(VentanaLogin.class.getResource("/Presentacion/autenticacion_tick.png")));
					lblInfo.setText("Usuario y contraseña correctas. Autenticación completada");
					btnContraseñaOlvidada.setEnabled(false);
					frmScoutingfutbolappLogin.dispose();
					Menu menu = new Menu(log);
					menu.setVisible(true);
					menu.setLocationRelativeTo(null);
				} else {
					lblEstado.setText("Usuario o contraseña erróneas");
					lblInfo.setIcon(new ImageIcon(VentanaLogin.class.getResource("/Presentacion/autenticacion.png")));
					lblInfo.setText("Error al introducir el usuario o la contraseña. Comprueba los datos");
					btnContraseñaOlvidada.setVisible(true);
				}

			} catch (Exception ex) {
				lblEstado.setText("Se ha producido un error");
				ex.printStackTrace();
			}
		}
	}
	private class BtnContraseñaOlvidadaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String login = txtNUsuario.getText();
			try {
				if(GestorUsuario.passwordOlvidada(login)!= "") {
					lblInfo.setText("La contraseña es "+GestorUsuario.passwordOlvidada(login));
					lblEstado.setText("Contraseña: "+GestorUsuario.passwordOlvidada(login));
				}
				else {
					lblInfo.setText("Ese usuario no existe, por favor, regístrese");
					lblEstado.setText("Usuario no registrado");
					btnContraseñaOlvidada.setEnabled(false);
				}
			} catch (Exception e1) {
				System.out.println("Error");
				e1.printStackTrace();
			}
		}
	}
	
	private class BtnCrearCuentaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			btnContraseñaOlvidada.setEnabled(false);
			btnEntrar.setEnabled(false);
			btnCrearCuenta.setEnabled(false);
			FormularioRegistro ventanaRegistro = new FormularioRegistro();
			ventanaRegistro.setVisible(true);
			ventanaRegistro.setResizable(false);
			frmScoutingfutbolappLogin.dispose();
		}
	}
}
