package Dominio;
import java.util.Vector;

import Persistencia.ConectorBD;

public class Usuario {

	private String mLogin;
	private String mPassword;
	private String mNombre_Entidad;
	private String mCorreo;
	private String mDivision;
	private int mPresupuesto;

	//Constructor para la creación de un objeto Usuario vacio
	public Usuario(){
	}
	//Constructor de usuario para el select (a la hora de hacer el ingreso)
	public Usuario(String login, String password){
		this.mLogin = login;
		this.mPassword = password;
	}	
	
	public Usuario(String nombre_entidad, int presupuesto) {
		this.mNombre_Entidad = nombre_entidad;
		this.mPresupuesto = presupuesto;
	}
	
	//Constructor para la creación de un Usuario al insertarlo
	public Usuario(String login, String password, String nombre_entidad, String correo, String division, int presupuesto){
		this.mLogin = login;
		this.mPassword = password;
		this.mNombre_Entidad = nombre_entidad;
		this.mCorreo = correo;
		this.mDivision = division;
		this.mPresupuesto = presupuesto;
	}

	//Selección de un usuario de la base de datos a partir del login y el password
	public static Usuario read(String login, String password) throws Exception{
		String l,g;
		Usuario u = null;
		Vector<Object> aux = null;

		String SQL_Consulta = "SELECT login, pass FROM usuario WHERE login = '"+login+"' AND pass = '"+password+"'";

		ConectorBD a = ConectorBD.getAgente();
		Vector<Object> res = a.selectUser(SQL_Consulta);

		if (res.size() == 1){
			aux = (Vector<Object>) res.elementAt(0);
			u = new Usuario((String) aux.elementAt(0), (String) aux.elementAt(1));
		}
		return u;
	}
	
	public static Usuario readPresupuesto(String login) throws Exception{
		String l,g;
		Usuario u = null;
		Vector<Object> aux = null;

		String SQL_Consulta = "SELECT nombre_entidad, presupuesto FROM usuario WHERE login = '"+login+"'";

		ConectorBD a = ConectorBD.getAgente();
		Vector<Object> res = a.selectUser(SQL_Consulta);

		if (res.size() == 1){
			aux = (Vector<Object>) res.elementAt(0);
			u = new Usuario((String) aux.elementAt(0), Integer.parseInt((String) aux.elementAt(1)));
		}
		return u;
	}
	
	public static Usuario readChangeUser(String login) throws Exception{
		String l,g;
		Usuario u = null;
		Vector<Object> aux = null;

		String SQL_Consulta = "SELECT login, pass, nombre_entidad, correo, division, presupuesto FROM usuario WHERE login = '"+login+"'";

		ConectorBD a = ConectorBD.getAgente();
		Vector<Object> res = a.selectChangeUser(SQL_Consulta);
			aux =  res;
			u = new Usuario((String) res.elementAt(0), (String) res.elementAt(1), (String) res.elementAt(2), (String) res.elementAt(3), (String) res.elementAt(4), (Integer) res.elementAt(5));
		
		return u;
	}
	
	public static  String devolverContraseña(String login) throws Exception {
		String contraseña = "";
		
		String SQL_Consulta = "SELECT pass FROM usuario WHERE login = '"+login+"'";
		ConectorBD a = ConectorBD.getAgente();
		contraseña = a.selectPass(SQL_Consulta);
		
		return contraseña;
	}
	
	public static boolean[] comprobarUnique(String login, String n_entidad, String correo) throws Exception {
		boolean valor[] = new boolean[3];
		String SQL_Consulta_log = "SELECT login FROM usuario WHERE login = '"+login+"'";
		String SQL_Consulta_ne = "SELECT login FROM usuario WHERE nombre_entidad = '"+n_entidad+"'";
		String SQL_Consulta_correo = "SELECT login FROM usuario WHERE correo = '"+correo+"'";
		ConectorBD a = ConectorBD.getAgente();
		String log_nuevo = a.selectPass(SQL_Consulta_log);
		String ne_nuevo = a.selectPass(SQL_Consulta_ne);
		String correo_nuevo = a.selectPass(SQL_Consulta_correo);
		if(log_nuevo.isEmpty())
			valor[0] = true;
		else
			valor[0] = false;
		
		if(ne_nuevo.isEmpty())
			valor[1] = true;
		else
			valor[1] = false;
		
		if(correo_nuevo.isEmpty())
			valor[2] = true;
		else
			valor[2] = false;
		return valor;
	}

	public String getmLogin() {
		return mLogin;
	}

	public void setmLogin(String mLogin) {
		this.mLogin = mLogin;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	
	

	public String getmNombre_Entidad() {
		return mNombre_Entidad;
	}
	public void setmNombre_Entidad(String mNombre_Entidad) {
		this.mNombre_Entidad = mNombre_Entidad;
	}
	public String getmCorreo() {
		return mCorreo;
	}
	public void setmCorreo(String mCorreo) {
		this.mCorreo = mCorreo;
	}
	public String getmDivision() {
		return mDivision;
	}
	public void setmDivision(String mDivision) {
		this.mDivision = mDivision;
	}
	public int getmPresupuesto() {
		return mPresupuesto;
	}
	public void setmPresupuesto(int mPresupuesto) {
		this.mPresupuesto = mPresupuesto;
	}
	//Inserción de un nuevo usuario en la base de datos
	public int insert() throws Exception{
		// 0=false
		// 1=true
		int insertado = 0;
		String SQL_Consulta = "INSERT INTO usuario VALUES('"+this.mLogin+"','"+this.mPassword+"','"+this.mNombre_Entidad+"','"+this.mCorreo+"','"+this.mDivision+"','"+this.mPresupuesto+"')";
		ConectorBD a = ConectorBD.getAgente();
		a.insert(SQL_Consulta);
		insertado = 1;
		return insertado;

	}
	
	//Actualizar base de datos
	
	public boolean updateUser(String nombre_user_actual, String nombre_usuario, String pass, String nombre_entidad, String correo, String division, int presupuesto ) throws Exception {
		boolean tablaActualizada = false;
		String SQL_Consulta = "UPDATE usuario SET login = '"+nombre_usuario+"', pass = '"+pass+"', nombre_entidad = '"+nombre_entidad+"', correo = '"+correo+"', division = '"+division+"', presupuesto = '"+presupuesto+"'  WHERE login = '"+nombre_user_actual+"'";
		ConectorBD a = ConectorBD.getAgente();
		a.update(SQL_Consulta);
		this.mLogin = nombre_usuario;
		this.mPassword = pass;
		this.mNombre_Entidad = nombre_entidad;
		this.mCorreo = correo;
		this.mDivision = division;
		this.mPresupuesto = presupuesto;
		return tablaActualizada;
	}
}