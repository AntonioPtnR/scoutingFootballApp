package Persistencia;

import java.awt.List;
import java.sql.*;
import java.util.LinkedList;
import java.util.Vector;

import Dominio.Jugador;
import Dominio.Usuario;

public class ConectorBD {
	// instancia del agente
	protected static ConectorBD mInstancia = null;
	// Conexion con la base de datos
	protected static Connection mBD;
	// Identificador ODBC de la base de datos
	private static String url = "jdbc:mysql://localhost:3306/gsi";
	// Driver para conectar con bases de datos MySQL
	private static String driver = "com.mysql.cj.jdbc.Driver";

	private static final String USUARIO = "gsi_admin";
	private static final String CLAVE = "gsi";

	// Constructor
	private ConectorBD() throws Exception {
		conectar();

	}

	
	public static ConectorBD getAgente() throws Exception {
		if (mInstancia == null) {
			mInstancia = new ConectorBD();
		}
		return mInstancia;
	}

	// Metodo para realizar la conexion a la base de datos
	private void conectar() throws Exception {
		Class.forName(driver);
		mBD = DriverManager.getConnection(url, USUARIO, CLAVE);
		
	}

	// Metodo para desconectar de la base de datos
	public void desconectar() throws Exception {
		mBD.close();
	}

	// Metodo para realizar una insercion en la base de datos
	public int insert(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	// Metodo para realizar una eliminacion en la base de datos
	public int delete(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	// Metodo para realizar una eliminacion en la base de datos
	public int update(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	public Vector<Object> selectUser(String SQL) throws SQLException, Exception {
		/*
		 * Metodo para realizar una busqueda o seleccion de informacion enla base de
		 * datos El m�todo select develve un vector de vectores, donde cada uno de los
		 * vectores que contiene el vector principal representa los registros que se
		 * recuperan de la base de datos.
		 */
		conectar();
		Vector<Object> vectores = new Vector<Object>();
		Vector<Object> datos = new Vector<Object>();
		// Vector<Object> datos = null;
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		ResultSet resultado = stmt.executeQuery(SQL);
		while (resultado.next()) {
			String login = resultado.getString(1);
			String pass = resultado.getString(2);
			if (!login.equals("") || !pass.equals("")) {
				datos.add(login);
				datos.add(pass);
				vectores.add(datos);
			}
		}
		desconectar();
		return vectores;
	}
	
	public String selectPass(String SQL) throws SQLException, Exception {
		/*
		 * Metodo para realizar una busqueda o seleccion de informacion enla base de
		 * datos El m�todo select develve un vector de vectores, donde cada uno de los
		 * vectores que contiene el vector principal representa los registros que se
		 * recuperan de la base de datos.
		 */
		conectar();
		String pass = "";
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		ResultSet resultado = stmt.executeQuery(SQL);
		while (resultado.next()) {
			pass = resultado.getString(1);
			
		}
		desconectar();
		return pass;
	}
	
	public Vector<Object> selectPresupuesto(String SQL) throws SQLException, Exception {
		/*
		 * Metodo para realizar una busqueda o seleccion de informacion enla base de
		 * datos El m�todo select develve un vector de vectores, donde cada uno de los
		 * vectores que contiene el vector principal representa los registros que se
		 * recuperan de la base de datos.
		 */
		conectar();
		Vector<Object> datos = new Vector<Object>();
		String nombre_entidad = "";
		int presupuesto = 0;
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		ResultSet resultado = stmt.executeQuery(SQL);
		while (resultado.next()) {
			nombre_entidad = resultado.getString(1);
			presupuesto = resultado.getInt(2);
			datos.add(nombre_entidad);
			datos.add(presupuesto);
		}
		desconectar();
		return datos;
	}
	
	public Vector<Object> selectChangeUser(String SQL) throws SQLException, Exception {
		/*
		 * Metodo para realizar una busqueda o seleccion de informacion enla base de
		 * datos El m�todo select develve un vector de vectores, donde cada uno de los
		 * vectores que contiene el vector principal representa los registros que se
		 * recuperan de la base de datos.
		 */
		conectar();
		Vector<Object> datos = new Vector<Object>();
		String nombre_entidad = "";
		String login = "";
		String pass = "";
		String correo = "";
		String division = "";
		int presupuesto = 0;
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		ResultSet resultado = stmt.executeQuery(SQL);
		while (resultado.next()) {
			login = resultado.getString(1);
			pass = resultado.getString(2);
			nombre_entidad = resultado.getString(3);
			correo = resultado.getString(4);
			division = resultado.getString(5);
			presupuesto = resultado.getInt(6);
			datos.add(login);
			datos.add(pass);
			datos.add(nombre_entidad);
			datos.add(correo);
			datos.add(division);
			datos.add(presupuesto);
		}
		desconectar();
		return datos;
	}
	
	public Vector<Jugador> selectJugador(String SQL) throws SQLException, Exception {
		/*
		 * Metodo para realizar una busqueda o seleccion de informacion enla base de
		 * datos El m�todo select develve un vector de vectores, donde cada uno de los
		 * vectores que contiene el vector principal representa los registros que se
		 * recuperan de la base de datos.
		 */
		conectar();
		Vector<Jugador> vectores = new Vector<Jugador>();
		Vector<Object> datos = new Vector<Object>();
		// Vector<Object> datos = null;
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		ResultSet resultado = stmt.executeQuery(SQL);
		int i=0;
		while (resultado.next()) {
			String nombre = resultado.getString(1);
			String posicion = resultado.getString(2);
			int disparo = resultado.getInt(3);
			int pase = resultado.getInt(4);
			int regate = resultado.getInt(5);
			int defensa = resultado.getInt(6);
			int goles_encajados = resultado.getInt(7);
			int velocidad = resultado.getInt(8);
			int valor = resultado.getInt(9);
				
				Jugador j = new Jugador(nombre, posicion, disparo, pase, regate, defensa, goles_encajados, velocidad, valor);
				vectores.add(i, j);
				
			
		}
		desconectar();
		return vectores;
	}
	
	public String comprobarUnique(String SQL) throws Exception {
		conectar();
		String atr = "";
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		ResultSet resultado = stmt.executeQuery(SQL);
		while (resultado.next()) {
			atr = resultado.getString(1);
			
		}
		desconectar();
		return atr;
	}
	
	public Vector<Jugador> selectJugadorPase(String SQL) throws SQLException, Exception {
		/*
		 * Metodo para realizar una busqueda o seleccion de informacion enla base de
		 * datos El m�todo select develve un vector de vectores, donde cada uno de los
		 * vectores que contiene el vector principal representa los registros que se
		 * recuperan de la base de datos.
		 */
		conectar();
		Vector<Jugador> vectores = new Vector<Jugador>();
		Vector<Object> datos = new Vector<Object>();
		// Vector<Object> datos = null;
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		ResultSet resultado = stmt.executeQuery(SQL);
		while (resultado.next()) {
			String nombre = resultado.getString(1);
			int asistencias = resultado.getInt(2);
			int toques = resultado.getInt(3);
			int ocasiones_creadas = resultado.getInt(4);
			int pases_clave = resultado.getInt(5);
			int pases_completados = resultado.getInt(6);
			int pases_completados_last = resultado.getInt(7);
			int pases = resultado.getInt(8);
			int goles = resultado.getInt(9);
			int punteria = resultado.getInt(10);
			int penaltis_lanzados = resultado.getInt(11);
			int penaltis_marcados = resultado.getInt(12);
			int efectividad_penaltis = resultado.getInt(13);
			int goles_last = resultado.getInt(14);
			int ataque = resultado.getInt(15);
			int entradas_exito = resultado.getInt(16);
			int despejes = resultado.getInt(17);
			int tiros_bloqueados = resultado.getInt(18);
			int intercepciones = resultado.getInt(19);
			int defensa = resultado.getInt(20);
			String posicion = resultado.getString(21);
			int valor = resultado.getInt(22);
 			int edad = resultado.getInt(23);
			int altura = resultado.getInt(24);
			int regate = resultado.getInt(25);
			int efectividad_regate = resultado.getInt(26);
			int paradas_partido = resultado.getInt(27);
			int goles_concedidos_partido = resultado.getInt(28);
			int duelos_ganados = resultado.getInt(29);
			int faltas = resultado.getInt(30);
			int equipo_semana = resultado.getInt(31);
				
				Jugador j = new Jugador(nombre, asistencias, toques, ocasiones_creadas, pases_clave, pases_completados, pases_completados_last, pases, goles, punteria, penaltis_lanzados, penaltis_marcados, efectividad_penaltis, goles_last, ataque, entradas_exito, despejes, tiros_bloqueados, intercepciones, defensa, valor, posicion, edad, altura, regate, efectividad_regate, paradas_partido, goles_concedidos_partido, duelos_ganados, faltas, equipo_semana);
				vectores.add(j);
				
			
		}
		desconectar();
		return vectores;
	}
	
	public Vector<Jugador> selectJugadorChollos(String SQL) throws SQLException, Exception {
		/*
		 * Metodo para realizar una busqueda o seleccion de informacion enla base de
		 * datos El m�todo select develve un vector de vectores, donde cada uno de los
		 * vectores que contiene el vector principal representa los registros que se
		 * recuperan de la base de datos.
		 */
		conectar();
		Vector<Jugador> vectores = new Vector<Jugador>();
		// Vector<Object> datos = null;
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		ResultSet resultado = stmt.executeQuery(SQL);
		int i=0;
		while (resultado.next()) {
			String nombre = resultado.getString(1);
			String posicion = resultado.getString(2);
			int ataque = resultado.getInt(3);
			int pase = resultado.getInt(4);
			int regate = resultado.getInt(5);
			int defensa = resultado.getInt(6);
			int valor = resultado.getInt(7);
				
				Jugador j = new Jugador(nombre, posicion, ataque, pase, regate, defensa, valor);
				vectores.add(j);
				
			
		}
		return vectores;
	}
	
	public Vector<Jugador> selectJugadorEquipo(String SQL) throws SQLException, Exception {
		/*
		 * Metodo para realizar una busqueda o seleccion de informacion enla base de
		 * datos El m�todo select develve un vector de vectores, donde cada uno de los
		 * vectores que contiene el vector principal representa los registros que se
		 * recuperan de la base de datos.
		 */
		conectar();
		Vector<Jugador> vectores = new Vector<Jugador>();
		// Vector<Object> datos = null;
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		ResultSet resultado = stmt.executeQuery(SQL);
		int i=0;
		while (resultado.next()) {
			String nombre = resultado.getString(1);
			String equipo = resultado.getString(2);
			String posicion = resultado.getString(3);
			int edad = resultado.getInt(4);
			int forma_fisica = resultado.getInt(5);
			String estado = resultado.getString(6);
			int lesiones = resultado.getInt(7);
			int ataque = resultado.getInt(8);
			int defensa = resultado.getInt(9);
			int pase = resultado.getInt(10);
			String comentarios = resultado.getString(11);
			int paradas_partido = resultado.getInt(12);
			int goles_concedidos = resultado.getInt(13);
				
			Jugador j = new Jugador(nombre, equipo, posicion, edad, forma_fisica, estado, lesiones, ataque, defensa, pase, comentarios, paradas_partido, goles_concedidos);
			vectores.add(j);		
		}
		return vectores;
	}
}