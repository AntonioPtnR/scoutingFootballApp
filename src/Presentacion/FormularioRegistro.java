package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Dominio.GestorUsuario;

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
import java.awt.Color;

public class FormularioRegistro extends JFrame {

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
	private JLabel lblNewLabel;
	private static FormularioRegistro frame = new FormularioRegistro();
	private JButton btnConfirmar;
	private JButton btnLimpiar;
	private JPasswordField txtContrasena;
	

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
	public FormularioRegistro() {
		setTitle("scoutingFootballApp - Crear Usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioRegistro.class.getResource("/Presentacion/logoApp.png")));
		addWindowListener(new ThisWindowListener());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnlFormulario = new JPanel();
		pnlFormulario.setBounds(10, 10, 866, 396);
		pnlFormulario.setBorder(new TitledBorder(null, "Formulario de registro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pnlFormulario);
		GridBagLayout gbl_pnlFormulario = new GridBagLayout();
		gbl_pnlFormulario.columnWidths = new int[]{106, 102, 190, 86, 102, 108, 121, 43, 0};
		gbl_pnlFormulario.rowHeights = new int[]{66, 19, 33, 72, 19, 19, 19, 50, 55, 0};
		gbl_pnlFormulario.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlFormulario.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlFormulario.setLayout(gbl_pnlFormulario);
		
		lblNUsuario = new JLabel("Nombre de usuario(*)");
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
		
		lblContrasena = new JLabel("Contraseña(*)");
		GridBagConstraints gbc_lblContrasena = new GridBagConstraints();
		gbc_lblContrasena.anchor = GridBagConstraints.EAST;
		gbc_lblContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasena.gridx = 1;
		gbc_lblContrasena.gridy = 2;
		pnlFormulario.add(lblContrasena, gbc_lblContrasena);
		
		txtContrasena = new JPasswordField();
		GridBagConstraints gbc_txtContrasena = new GridBagConstraints();
		gbc_txtContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_txtContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtContrasena.gridx = 2;
		gbc_txtContrasena.gridy = 2;
		pnlFormulario.add(txtContrasena, gbc_txtContrasena);
		
		lblDivision = new JLabel("División del club");
		GridBagConstraints gbc_lblDivision = new GridBagConstraints();
		gbc_lblDivision.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDivision.insets = new Insets(0, 0, 5, 5);
		gbc_lblDivision.gridx = 4;
		gbc_lblDivision.gridy = 2;
		pnlFormulario.add(lblDivision, gbc_lblDivision);
		
		cbDivision = new JComboBox();
		cbDivision.setModel(new DefaultComboBoxModel(new String[] {"Primera División", "Segunda División", "Segunda División B", "Tercera División"}));
		GridBagConstraints gbc_cbDivision = new GridBagConstraints();
		gbc_cbDivision.anchor = GridBagConstraints.NORTHWEST;
		gbc_cbDivision.insets = new Insets(0, 0, 5, 5);
		gbc_cbDivision.gridx = 5;
		gbc_cbDivision.gridy = 2;
		pnlFormulario.add(cbDivision, gbc_cbDivision);
		
		lblNombreEntidad = new JLabel("Nombre de la entidad(*)");
		GridBagConstraints gbc_lblNombreEntidad = new GridBagConstraints();
		gbc_lblNombreEntidad.anchor = GridBagConstraints.EAST;
		gbc_lblNombreEntidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreEntidad.gridx = 1;
		gbc_lblNombreEntidad.gridy = 4;
		pnlFormulario.add(lblNombreEntidad, gbc_lblNombreEntidad);
		
		txtNEntidad = new JTextField();
		GridBagConstraints gbc_txtNEntidad = new GridBagConstraints();
		gbc_txtNEntidad.anchor = GridBagConstraints.NORTH;
		gbc_txtNEntidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNEntidad.insets = new Insets(0, 0, 5, 5);
		gbc_txtNEntidad.gridx = 2;
		gbc_txtNEntidad.gridy = 4;
		pnlFormulario.add(txtNEntidad, gbc_txtNEntidad);
		txtNEntidad.setColumns(10);
		
		lblPresupuesto = new JLabel("Presupuesto (€)(*)");
		GridBagConstraints gbc_lblPresupuesto = new GridBagConstraints();
		gbc_lblPresupuesto.anchor = GridBagConstraints.EAST;
		gbc_lblPresupuesto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPresupuesto.gridx = 4;
		gbc_lblPresupuesto.gridy = 5;
		pnlFormulario.add(lblPresupuesto, gbc_lblPresupuesto);
		
		txtPresupuesto = new JTextField();
		GridBagConstraints gbc_txtPresupuesto = new GridBagConstraints();
		gbc_txtPresupuesto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPresupuesto.anchor = GridBagConstraints.NORTH;
		gbc_txtPresupuesto.insets = new Insets(0, 0, 5, 5);
		gbc_txtPresupuesto.gridx = 5;
		gbc_txtPresupuesto.gridy = 5;
		pnlFormulario.add(txtPresupuesto, gbc_txtPresupuesto);
		txtPresupuesto.setColumns(10);
		
		lblCorreo = new JLabel("Correo electrónico(*)");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.EAST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 1;
		gbc_lblCorreo.gridy = 6;
		pnlFormulario.add(lblCorreo, gbc_lblCorreo);
		
		txtCorreo = new JTextField();
		GridBagConstraints gbc_txtCorreo = new GridBagConstraints();
		gbc_txtCorreo.anchor = GridBagConstraints.NORTH;
		gbc_txtCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreo.gridx = 2;
		gbc_txtCorreo.gridy = 6;
		pnlFormulario.add(txtCorreo, gbc_txtCorreo);
		txtCorreo.setColumns(10);
		
		lblNewLabel = new JLabel("Los campos con (*) son de obligatorio relleno.");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 8;
		pnlFormulario.add(lblNewLabel, gbc_lblNewLabel);
		
		btnConfirmar = new JButton("Crear Usuario");
		btnConfirmar.setBackground(Color.LIGHT_GRAY);
		btnConfirmar.addActionListener(new BtnConfirmarActionListener());
		btnConfirmar.setBounds(696, 465, 168, 35);
		contentPane.add(btnConfirmar);
		
		btnLimpiar = new JButton("Limpiar campos");
		btnLimpiar.setBackground(Color.LIGHT_GRAY);
		btnLimpiar.addActionListener(new BtnLimpiarActionListener());
		btnLimpiar.setBounds(21, 452, 156, 35);
		contentPane.add(btnLimpiar);
	}

	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			VentanaLogin v = new VentanaLogin();
			v.frmScoutingfutbolappLogin.setVisible(true);
		}
		
	}
	private class BtnConfirmarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(txtNUsuario.getText().isEmpty() || txtContrasena.getText().isEmpty() || txtPresupuesto.getText().isEmpty() || txtNEntidad.getText().isEmpty() || txtCorreo.getText().isEmpty()) {
				ImageIcon error = new ImageIcon(VentanaLogin.class.getResource("/Presentacion/autenticacion.png"));
				JLabel info = new JLabel("Alguno de los campos obligatorios están vacíos");
				JOptionPane.showMessageDialog(frame, info, "Campos obligatorios vacíos", JOptionPane.INFORMATION_MESSAGE, error);
			}
			
			else {
				String login = txtNUsuario.getText();
				String password = txtContrasena.getText();
				String nombre_entidad = txtNEntidad.getText();
				String correo = txtCorreo.getText();
				String division = (String)cbDivision.getSelectedItem();
				int presupuesto = Integer.parseInt(txtPresupuesto.getText());
				try {
					
					ImageIcon error = new ImageIcon(VentanaLogin.class.getResource("/Presentacion/autenticacion.png"));
					boolean existe[] = GestorUsuario.comprobarExistencia(login, nombre_entidad, correo);
					if(existe[0] && existe[1] && existe[2]) {
						GestorUsuario.nuevoUsuario(login, password, nombre_entidad, correo, division, presupuesto);
						ImageIcon ok = new ImageIcon(VentanaLogin.class.getResource("/Presentacion/autenticacion_tick.png"));
						JLabel info = new JLabel("El usuario ha sido creado de forma correcta");
						JOptionPane.showMessageDialog(frame, info, "Registro correcto", JOptionPane.INFORMATION_MESSAGE, ok);
						dispose();
						VentanaLogin vl = new VentanaLogin();
						vl.frmScoutingfutbolappLogin.setVisible(true);
					}
					
					else if(!existe[0]) {
						JLabel info = new JLabel("El nombre de usuario ya existe, elige otro");
						JOptionPane.showMessageDialog(frame, info, "Usuario repetido", JOptionPane.INFORMATION_MESSAGE, error);
					}
					else if(!existe[1]) {
						JLabel info = new JLabel("El nombre de esa entidad ya existe, elige otro");
						JOptionPane.showMessageDialog(frame, info, "Entidad registrada", JOptionPane.INFORMATION_MESSAGE, error);
					}
					else if(!existe[2]) {
						JLabel info = new JLabel("Ese correo ya está registrado, elige otro");
						JOptionPane.showMessageDialog(frame, info, "Correo registrado", JOptionPane.INFORMATION_MESSAGE, error);
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
