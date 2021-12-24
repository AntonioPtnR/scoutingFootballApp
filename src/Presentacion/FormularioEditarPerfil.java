package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Dominio.GestorUsuario;
import Dominio.Usuario;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class FormularioEditarPerfil extends JFrame {

	private JPanel contentPane;
	private JPanel pnlFormulario;
	private JLabel lblNUsuario;
	private JTextField txtNUsuario;
	private JLabel lblContrasena;
	private JLabel lblNombreEntidad;
	private JTextField txtNEntidad;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JLabel lblDivision;
	private JComboBox cbDivision;
	private JLabel lblPresupuesto;
	private JTextField txtPresupuesto;
	private static String usuario;
	private static FormularioEditarPerfil frame = new FormularioEditarPerfil(usuario);
	private JButton btnConfirmar;
	private JButton btnLimpiar;
	private JPasswordField txtContrasena;
	private JPasswordField txtNuevaContrasena;
	private JLabel lblNuevaContraseña;
	private JLabel lblNombreDeUsuario;
	private JTextField txtNuevoUsuario;
	private JLabel lblNewLabel;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//FormularioRegistro frame = new FormularioRegistro();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioEditarPerfil(String usuario) {
		FormularioEditarPerfil.usuario = usuario;
		
		setTitle("scoutingFootballApp - Cambiar datos del usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioEditarPerfil.class.getResource("/Presentacion/logoApp.png")));
		addWindowListener(new ThisWindowListener());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnlFormulario = new JPanel();
		pnlFormulario.setBounds(10, 10, 866, 396);
		pnlFormulario.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Formulario de cambio de datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pnlFormulario);
		GridBagLayout gbl_pnlFormulario = new GridBagLayout();
		gbl_pnlFormulario.columnWidths = new int[]{45, 102, 158, 49, 179, 108, 121, 43, 0};
		gbl_pnlFormulario.rowHeights = new int[]{66, 19, 30, 21, 36, 33, 52, 19, 19, 19, 37, 0};
		gbl_pnlFormulario.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlFormulario.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlFormulario.setLayout(gbl_pnlFormulario);
		
		lblNUsuario = new JLabel("Nombre de usuario actual");
		GridBagConstraints gbc_lblNUsuario = new GridBagConstraints();
		gbc_lblNUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblNUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNUsuario.gridx = 1;
		gbc_lblNUsuario.gridy = 1;
		pnlFormulario.add(lblNUsuario, gbc_lblNUsuario);
		
		txtNUsuario = new JTextField();
		GridBagConstraints gbc_txtNUsuario = new GridBagConstraints();
		gbc_txtNUsuario.anchor = GridBagConstraints.NORTH;
		gbc_txtNUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtNUsuario.gridx = 2;
		gbc_txtNUsuario.gridy = 1;
		pnlFormulario.add(txtNUsuario, gbc_txtNUsuario);
		txtNUsuario.setColumns(10);
		
		txtNUsuario.setText(usuario);
		
		lblNombreDeUsuario = new JLabel("Nombre de usuario nuevo");
		GridBagConstraints gbc_lblNombreDeUsuario = new GridBagConstraints();
		gbc_lblNombreDeUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDeUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeUsuario.gridx = 1;
		gbc_lblNombreDeUsuario.gridy = 2;
		pnlFormulario.add(lblNombreDeUsuario, gbc_lblNombreDeUsuario);
		
		txtNuevoUsuario = new JTextField();
		GridBagConstraints gbc_txtNuevoUsuario = new GridBagConstraints();
		gbc_txtNuevoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtNuevoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNuevoUsuario.gridx = 2;
		gbc_txtNuevoUsuario.gridy = 2;
		pnlFormulario.add(txtNuevoUsuario, gbc_txtNuevoUsuario);
		txtNuevoUsuario.setColumns(10);
		
		lblDivision = new JLabel("Nueva división");
		GridBagConstraints gbc_lblDivision = new GridBagConstraints();
		gbc_lblDivision.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDivision.insets = new Insets(0, 0, 5, 5);
		gbc_lblDivision.gridx = 4;
		gbc_lblDivision.gridy = 3;
		pnlFormulario.add(lblDivision, gbc_lblDivision);
		
		cbDivision = new JComboBox();
		cbDivision.setModel(new DefaultComboBoxModel(new String[] {"Primera División", "Segunda División", "Segunda División B", "Tercera División"}));
		GridBagConstraints gbc_cbDivision = new GridBagConstraints();
		gbc_cbDivision.anchor = GridBagConstraints.NORTHWEST;
		gbc_cbDivision.insets = new Insets(0, 0, 5, 5);
		gbc_cbDivision.gridx = 5;
		gbc_cbDivision.gridy = 3;
		pnlFormulario.add(cbDivision, gbc_cbDivision);
		
		lblContrasena = new JLabel("Contraseña actual");
		GridBagConstraints gbc_lblContrasena = new GridBagConstraints();
		gbc_lblContrasena.anchor = GridBagConstraints.EAST;
		gbc_lblContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasena.gridx = 1;
		gbc_lblContrasena.gridy = 4;
		pnlFormulario.add(lblContrasena, gbc_lblContrasena);
		
		txtContrasena = new JPasswordField();
		GridBagConstraints gbc_txtContrasena = new GridBagConstraints();
		gbc_txtContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_txtContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtContrasena.gridx = 2;
		gbc_txtContrasena.gridy = 4;
		pnlFormulario.add(txtContrasena, gbc_txtContrasena);
		
		lblNuevaContraseña = new JLabel("Nueva Contraseña");
		GridBagConstraints gbc_lblNuevaContraseña = new GridBagConstraints();
		gbc_lblNuevaContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevaContraseña.anchor = GridBagConstraints.EAST;
		gbc_lblNuevaContraseña.gridx = 1;
		gbc_lblNuevaContraseña.gridy = 5;
		pnlFormulario.add(lblNuevaContraseña, gbc_lblNuevaContraseña);
		
		txtNuevaContrasena = new JPasswordField();
		GridBagConstraints gbc_txtNuevaContrasena = new GridBagConstraints();
		gbc_txtNuevaContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_txtNuevaContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNuevaContrasena.gridx = 2;
		gbc_txtNuevaContrasena.gridy = 5;
		pnlFormulario.add(txtNuevaContrasena, gbc_txtNuevaContrasena);
		
		lblNombreEntidad = new JLabel("Nuevo nombre de la entidad");
		GridBagConstraints gbc_lblNombreEntidad = new GridBagConstraints();
		gbc_lblNombreEntidad.anchor = GridBagConstraints.EAST;
		gbc_lblNombreEntidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreEntidad.gridx = 1;
		gbc_lblNombreEntidad.gridy = 7;
		pnlFormulario.add(lblNombreEntidad, gbc_lblNombreEntidad);
		
		txtNEntidad = new JTextField();
		GridBagConstraints gbc_txtNEntidad = new GridBagConstraints();
		gbc_txtNEntidad.anchor = GridBagConstraints.NORTH;
		gbc_txtNEntidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNEntidad.insets = new Insets(0, 0, 5, 5);
		gbc_txtNEntidad.gridx = 2;
		gbc_txtNEntidad.gridy = 7;
		pnlFormulario.add(txtNEntidad, gbc_txtNEntidad);
		txtNEntidad.setColumns(10);
		
		lblPresupuesto = new JLabel("Nuevo presupuesto");
		GridBagConstraints gbc_lblPresupuesto = new GridBagConstraints();
		gbc_lblPresupuesto.anchor = GridBagConstraints.EAST;
		gbc_lblPresupuesto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPresupuesto.gridx = 4;
		gbc_lblPresupuesto.gridy = 8;
		pnlFormulario.add(lblPresupuesto, gbc_lblPresupuesto);
		
		txtPresupuesto = new JTextField();
		GridBagConstraints gbc_txtPresupuesto = new GridBagConstraints();
		gbc_txtPresupuesto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPresupuesto.anchor = GridBagConstraints.NORTH;
		gbc_txtPresupuesto.insets = new Insets(0, 0, 5, 5);
		gbc_txtPresupuesto.gridx = 5;
		gbc_txtPresupuesto.gridy = 8;
		pnlFormulario.add(txtPresupuesto, gbc_txtPresupuesto);
		txtPresupuesto.setColumns(10);
		
		lblCorreo = new JLabel("Nuevo correo");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.EAST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 1;
		gbc_lblCorreo.gridy = 9;
		pnlFormulario.add(lblCorreo, gbc_lblCorreo);
		
		txtCorreo = new JTextField();
		GridBagConstraints gbc_txtCorreo = new GridBagConstraints();
		gbc_txtCorreo.anchor = GridBagConstraints.NORTH;
		gbc_txtCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreo.gridx = 2;
		gbc_txtCorreo.gridy = 9;
		pnlFormulario.add(txtCorreo, gbc_txtCorreo);
		txtCorreo.setColumns(10);
		
		btnConfirmar = new JButton("Cambiar datos");
		btnConfirmar.setBackground(Color.LIGHT_GRAY);
		btnConfirmar.addActionListener(new BtnConfirmarActionListener());
		btnConfirmar.setBounds(696, 465, 168, 35);
		contentPane.add(btnConfirmar);
		
		btnLimpiar = new JButton("Limpiar campos");
		btnLimpiar.setBackground(Color.LIGHT_GRAY);
		btnLimpiar.addActionListener(new BtnLimpiarActionListener());
		btnLimpiar.setBounds(21, 452, 156, 35);
		contentPane.add(btnLimpiar);
		
		lblNewLabel = new JLabel("(*) Los campos que dejes vacíos no se cambiarán");
		lblNewLabel.setBounds(313, 419, 312, 13);
		contentPane.add(lblNewLabel);
	}

	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			Menu menu = new Menu(usuario);
			menu.setVisible(true);
			menu.setLocationRelativeTo(null);
		}
		
	}
	private class BtnConfirmarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Usuario u = new Usuario();
			try {
				u = Usuario.readChangeUser(usuario);
				String nombre_usuario = "";
				String pass = u.getmPassword();
				String nombre_entidad = u.getmNombre_Entidad();
				String correo = u.getmCorreo();
				String division = (String) cbDivision.getSelectedItem();
				int presupuesto = u.getmPresupuesto();
				
				if(!txtContrasena.getText().equals(u.getmPassword()) && !txtContrasena.getText().equals("")) {
					ImageIcon error= new ImageIcon(VentanaLogin.class.getResource("/Presentacion/icono_error.png"));
					JLabel info = new JLabel("Las contraseñas no coinciden, introduce la contraseña correcta");
					JOptionPane.showMessageDialog(frame, info, "Contraseña actual errónea", JOptionPane.INFORMATION_MESSAGE, error);
					
				}
					
				else {
					if(!txtNuevaContrasena.getText().equals(""))
						pass = txtNuevaContrasena.getText();

				if(txtNuevoUsuario.getText().equals(""))
					nombre_usuario = txtNUsuario.getText();
				else
					nombre_usuario = txtNuevoUsuario.getText();
					
				
				
				if(!txtNEntidad.getText().equals(""))
					nombre_entidad = txtNEntidad.getText();
				if(!txtCorreo.getText().equals(""))
					correo = txtCorreo.getText();
				if(!txtPresupuesto.getText().equals(""))
					presupuesto = Integer.parseInt(txtPresupuesto.getText());
				u.updateUser(usuario, nombre_usuario, pass, nombre_entidad, correo, division, presupuesto);
				ImageIcon ok= new ImageIcon(VentanaLogin.class.getResource("/Presentacion/ok_accion.png"));
				JLabel info = new JLabel("Datos cambiados correctamente");
				JOptionPane.showMessageDialog(frame, info, "Los datos se han cambiado correctamente", JOptionPane.INFORMATION_MESSAGE, ok);
				dispose();
				Menu menu = new Menu(nombre_usuario);
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtNUsuario.setText("");
			txtContrasena.setText("");
			txtNEntidad.setText("");
			txtCorreo.setText("");
			txtPresupuesto.setText("");
			txtContrasena.setText("");
		}
	}
}
