package Dominio;

public class GestorUsuario {

	public static boolean autenticar(String login, String password) throws Exception {
		boolean autenticado = false;

		if (Usuario.read(login, password) != null)
			autenticado = true;
		return autenticado;
	}
	public static String passwordOlvidada(String login) throws Exception{
		return Usuario.devolverContraseña(login);
	}
	
	public static boolean[] comprobarExistencia(String login, String n_entidad, String correo) throws Exception {
		boolean[] existe = Usuario.comprobarUnique(login, n_entidad, correo);
		return existe;
		
	}
	public static boolean nuevoUsuario(String login, String password, String nombre_entidad, String correo, String division, int presupuesto) throws Exception {
		boolean insertado = false;

		Usuario u = new Usuario(login, password,nombre_entidad, correo, division, presupuesto);
		if (u.insert() == 1)
			insertado = true;
		return insertado;
	}
	

}