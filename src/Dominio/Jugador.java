package Dominio;

import java.util.Vector;

import javax.swing.JLabel;

import Persistencia.ConectorBD;

public class Jugador {
	private String nombre;
	private String posicion;
	private int disparo;
	private int pase;
	private int regate;
	private int defensa;
	private int goles_encajados;
	private int velocidad;
	private int valor;
	private int asistencias;
	private int toques;
	private int ocasiones_creadas;
	private int pases_clave;
	private int pases_completados;
	private int pases_completados_last;
	private int goles;
	private int punteria;
	private int penaltis_lanzados;
	private int penaltis_marcados;
	private int efectividad_penaltis;
	private int goles_last;
	private int ataque;
	private int entradas_exito;
	private int despejes;
	private int tiros_bloqueados;
	private int intercepciones;
	private int defensa_gen;
	private int edad;
	private int altura;
	private int efectividad_regate;
	private int paradas_partido;
	private int goles_concedidos_partido;
	private int duelos_ganados;
	private int faltas;
	private int equipo_semana;
	private int valoracion;
	private String indice_rendimiento;
	private String equipo;
	private int forma_fisica;
	private String estado;
	private int lesiones;
	private String comentarios;
	
	public int getValoracion(Jugador jugador) {
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
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public String getIndice_rendimiento(Jugador jugador) {
		float valorac = (float) jugador.getValoracion(jugador);
		float valor_float = (float) jugador.getValor();
		double rentabilidad = valorac / valor_float;
		indice_rendimiento = String.format("%.2f", rentabilidad);
		return indice_rendimiento;
	}

	public void setIndice_rendimiento(String indice_rendimiento) {
		this.indice_rendimiento = indice_rendimiento;
	}

	public Jugador() {};
	
	public Jugador(String atr) {
		if(atr.equals("Delantero") || atr.equals("Defensa") || atr.equals("Centrocampista"))
			posicion = atr;
		else
			nombre = atr;
	};
	
	public Jugador(int valor ) {
		this.valor = valor;
		
	}
	public Jugador(String nombre, String posicion, int disparo, int pase, int regate, int defensa, int goles_encajados,
			int velocidad, int valor) {
		
		this.nombre = nombre;
		this.posicion = posicion;
		this.disparo = disparo;
		this.pase = pase;
		this.regate = regate;
		this.defensa = defensa;
		this.goles_encajados = goles_encajados;
		this.velocidad = velocidad;
		this.valor = valor;
		
	}
	
	public Jugador(String nombre, int asistencias, int toques, int pases_clave,int ocasiones_creadas, int pases_completados, int pases_completados_last, int pase, int goles, int punteria, int penaltis_lanzados, int penaltis_marcados, int efectividad_penaltis, int goles_last, int ataque, int entradas_exito, int despejes, int tiros_bloqueados, int intercepciones, int defensa_gen, int valor, String posicion, int edad, int altura, int regate, int efectividad_regate, int paradas_partido, int goles_concedidos_partido, int duelos_ganados, int faltas, int equipo_semana) {
		this.nombre = nombre;
		this.asistencias = asistencias;
		this.toques = toques;
		this.ocasiones_creadas = ocasiones_creadas;
		this.pases_clave = pases_clave;
		this.pases_completados = pases_completados;
		this.pases_completados_last = pases_completados_last;
		this.pase = pase;
		this.goles = goles;
		this.punteria = punteria;
		this.penaltis_lanzados = penaltis_lanzados;
		this.penaltis_marcados = penaltis_marcados;
		this.efectividad_penaltis = efectividad_penaltis;
		this.goles_last = goles_last;
		this.ataque = ataque;
		this.entradas_exito = entradas_exito;
		this.despejes = despejes;
		this.tiros_bloqueados = tiros_bloqueados;
		this.intercepciones = intercepciones;
		this.defensa_gen = defensa_gen;
		this.posicion = posicion;
		this.edad = edad;
		this.valor = valor;
		this.altura = altura;
		this.regate = regate;
		this.efectividad_regate = efectividad_regate;
		this.paradas_partido = paradas_partido;
		this.goles_concedidos_partido = goles_concedidos_partido;
		this.duelos_ganados = duelos_ganados;
		this.faltas = faltas;
		this.equipo_semana = equipo_semana;
	}
	public Jugador(String nombre, String posicion, int ataque, int pase, int regate, int defensa, int valor) {
		this.nombre = nombre;
		this.posicion = posicion;
		this.ataque = ataque;
		this.pase = pase;
		this.regate = regate;
		this.defensa = defensa;
		this.valor = valor;
	}
	
	public Jugador(String nombre, String equipo, String posicion, int edad, int forma_fisica, String estado, int lesiones, int ataque, int defensa, int pase, String comentarios, int paradas_partido, int goles_concedidos) {
		this.nombre = nombre;
		this.equipo = equipo;
		this.posicion = posicion;
		this.edad = edad;
		this.forma_fisica = forma_fisica;
		this.estado = estado;
		this.lesiones = lesiones;
		this.ataque = ataque;
		this.defensa = defensa;
		this.pase = pase;
		this.comentarios = comentarios;
		this.paradas_partido = paradas_partido;
		this.goles_concedidos_partido = goles_concedidos;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public int getDisparo() {
		return disparo;
	}
	public void setDisparo(int disparo) {
		this.disparo = disparo;
	}
	public int getPase() {
		return pase;
	}
	public void setPase(int pase) {
		this.pase = pase;
	}
	public int getRegate() {
		return regate;
	}
	public void setRegate(int regate) {
		this.regate = regate;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public int getGoles_encajados() {
		return goles_encajados;
	}
	public void setGoles_encajados(int goles_encajados) {
		this.goles_encajados = goles_encajados;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getToques() {
		return toques;
	}

	public void setToques(int toques) {
		this.toques = toques;
	}

	public int getOcasiones_creadas() {
		return ocasiones_creadas;
	}

	public void setOcasiones_creadas(int ocasiones_creadas) {
		this.ocasiones_creadas = ocasiones_creadas;
	}

	public int getPases_clave() {
		return pases_clave;
	}

	public void setPases_clave(int pases_clave) {
		this.pases_clave = pases_clave;
	}

	public int getPases_completados() {
		return pases_completados;
	}

	public void setPases_completados(int pases_completados) {
		this.pases_completados = pases_completados;
	}

	public int getPases_completados_last() {
		return pases_completados_last;
	}

	public void setPases_completados_last(int pases_completados_last) {
		this.pases_completados_last = pases_completados_last;
	}
	
	

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getPunteria() {
		return punteria;
	}

	public void setPunteria(int punteria) {
		this.punteria = punteria;
	}

	public int getPenaltis_lanzados() {
		return penaltis_lanzados;
	}

	public void setPenaltis_lanzados(int penaltis_lanzados) {
		this.penaltis_lanzados = penaltis_lanzados;
	}

	public int getPenaltis_marcados() {
		return penaltis_marcados;
	}

	public void setPenaltis_marcados(int penaltis_marcados) {
		this.penaltis_marcados = penaltis_marcados;
	}

	public int getEfectividad_penaltis() {
		return efectividad_penaltis;
	}

	public void setEfectividad_penaltis(int efectividad_penaltis) {
		this.efectividad_penaltis = efectividad_penaltis;
	}

	public int getGoles_last() {
		return goles_last;
	}

	public void setGoles_last(int goles_last) {
		this.goles_last = goles_last;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	public int getEntradas_exito() {
		return entradas_exito;
	}

	public void setEntradas_exito(int entradas_exito) {
		this.entradas_exito = entradas_exito;
	}

	public int getDespejes() {
		return despejes;
	}

	public void setDespejes(int despejes) {
		this.despejes = despejes;
	}

	public int getTiros_bloqueados() {
		return tiros_bloqueados;
	}

	public void setTiros_bloqueados(int tiros_bloqueados) {
		this.tiros_bloqueados = tiros_bloqueados;
	}

	public int getIntercepciones() {
		return intercepciones;
	}

	public void setIntercepciones(int intercepciones) {
		this.intercepciones = intercepciones;
	}

	public int getDefensa_gen() {
		return defensa_gen;
	}

	public void setDefensa_gen(int defensa_gen) {
		this.defensa_gen = defensa_gen;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	

	public int getEfectividad_regate() {
		return efectividad_regate;
	}

	public void setEfectividad_regate(int efectividad_regate) {
		this.efectividad_regate = efectividad_regate;
	}

	public int getParadas_partido() {
		return paradas_partido;
	}

	public void setParadas_partido(int paradas_partido) {
		this.paradas_partido = paradas_partido;
	}

	public int getGoles_concedidos_partido() {
		return goles_concedidos_partido;
	}

	public void setGoles_concedidos_partido(int goles_concedidos_partido) {
		this.goles_concedidos_partido = goles_concedidos_partido;
	}

	public int getDuelos_ganados() {
		return duelos_ganados;
	}

	public void setDuelos_ganados(int duelos_ganados) {
		this.duelos_ganados = duelos_ganados;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public int getEquipo_semana() {
		return equipo_semana;
	}

	public void setEquipo_semana(int equipo_semana) {
		this.equipo_semana = equipo_semana;
	}
	
	public int getForma_fisica() {
		return forma_fisica;
	}

	public void setForma_fisica(int forma_fisica) {
		this.forma_fisica = forma_fisica;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getLesiones() {
		return lesiones;
	}

	public void setLesiones(int lesiones) {
		this.lesiones = lesiones;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Vector<Jugador> read() throws Exception{
		Vector<Object> aux = null;
		String SQL_Consulta = "SELECT atributo_pase.nombre, posicion, atributo_ataque.ataque, atributo_pase.pases, atributo_regate.regate, atributo_defensa.defensa, goles_encajados, velocidad, valor FROM atributos_jugadores JOIN atributo_pase JOIN atributo_defensa JOIN atributo_ataque JOIN atributo_regate WHERE atributo_pase.nombre = atributos_jugadores.nombre AND atributo_pase.nombre = atributo_ataque.nombre AND atributo_pase.nombre = atributo_defensa.nombre  AND atributo_pase.nombre = atributo_regate.nombre ORDER BY valor DESC ";
		ConectorBD a = ConectorBD.getAgente();
		Vector<Jugador> res = a.selectJugador(SQL_Consulta);//vector en el que se muestra cada fila.
		return res;
		
	}
	
	public Vector<Jugador> readNombre(String nombre) throws Exception{
		Vector<Object> aux = null;
		String SQL_Consulta = "SELECT * FROM atributos_jugadores WHERE nombre = '"+nombre+"'";
		ConectorBD a = ConectorBD.getAgente();
		Vector<Jugador> res = a.selectJugador(SQL_Consulta);//vector en el que se muestra cada fila.
		return res;
		
	}
	
	public Vector<Jugador> readPosicion(String posicion) throws Exception{
		Vector<Object> aux = null;
		String SQL_Consulta = "SELECT * FROM atributos_jugadores WHERE posicion = '"+posicion+"'";
		ConectorBD a = ConectorBD.getAgente();
		Vector<Jugador> res = a.selectJugador(SQL_Consulta);//vector en el que se muestra cada fila.
		return res;
		
	}
	
	public Vector<Jugador> readValor(double valor) throws Exception{
		Vector<Object> aux = null;
		String SQL_Consulta = "SELECT atributo_pase.nombre, posicion, atributo_ataque.ataque, atributo_pase.pases, atributo_regate.regate, atributo_defensa.defensa, goles_encajados, velocidad, valor FROM atributos_jugadores JOIN atributo_pase JOIN atributo_defensa JOIN atributo_ataque JOIN atributo_regate WHERE valor <= '"+valor+"' AND atributo_pase.nombre = atributos_jugadores.nombre AND atributo_pase.nombre = atributo_ataque.nombre AND atributo_pase.nombre = atributo_defensa.nombre  AND atributo_pase.nombre = atributo_regate.nombre ORDER BY valor DESC ";
		ConectorBD a = ConectorBD.getAgente();
		Vector<Jugador> res = a.selectJugador(SQL_Consulta);//vector en el que se muestra cada fila.
		return res;
		
	}
	
	public Vector<Jugador> readPase(String nombre) throws Exception{
		Vector<Object> aux = null;
		String SQL_Consulta = "SELECT atributo_pase.nombre, asistencias, toques, ocasiones_creadas, pases_clave, pases_completados, pases_completados_last, atributo_pase.pases, goles, punteria, penaltis_lanzados, penaltis_marcados, efectividad_penaltis, goles_last, atributo_ataque.ataque, entradas_exito, despejes, tiros_bloqueados, intercepciones, atributo_defensa.defensa, posicion, valor, edad, altura, atributo_regate.regate, efectividad_regate, paradas_partido, goles_concedidos_partido, duelos_ganados, faltas, equipo_semana   FROM atributo_pase NATURAL JOIN atributo_ataque NATURAL JOIN atributo_defensa JOIN atributos_jugadores JOIN atributo_regate JOIN otros_atributos WHERE atributo_pase.nombre = '"+nombre+"' AND atributo_pase.nombre = atributo_ataque.nombre AND atributo_pase.nombre = atributo_defensa.nombre AND atributo_pase.nombre = atributos_jugadores.nombre AND atributo_pase.nombre = otros_atributos.nombre AND atributo_pase.nombre = atributo_regate.nombre";
		ConectorBD a = ConectorBD.getAgente();
		Vector<Jugador> res = a.selectJugadorPase(SQL_Consulta);//vector en el que se muestra cada fila
		return res;
		
	}
	
	public Vector<Jugador> readChollos(int presupuesto) throws Exception{
		Vector<Object> aux = null;
		String SQL_Consulta = "SELECT atributo_pase.nombre, posicion, ataque, atributo_pase.pases, atributo_regate.regate, atributo_defensa.defensa, valor FROM atributos_jugadores JOIN atributo_pase JOIN atributo_ataque JOIN atributo_regate JOIN atributo_defensa WHERE  valor <= '"+presupuesto+"' AND atributo_pase.nombre = atributos_jugadores.nombre AND atributo_pase.nombre = atributo_ataque.nombre AND atributo_pase.nombre = atributo_regate.nombre AND atributo_pase.nombre = atributo_defensa.nombre  ORDER BY valor";
		ConectorBD a = ConectorBD.getAgente();
		Vector<Jugador> res = a.selectJugadorChollos(SQL_Consulta);//vector en el que se muestra cada fila.
		System.out.println(res.get(0).getAtaque());
		return res;
		
	}
	
	public Vector<Jugador> readJugadorEquipo(String nombre_entidad) throws Exception{
		Vector<Object> aux = null;
		String SQL_Consulta = "SELECT * FROM jugadores_equipo WHERE equipo = '"+nombre_entidad+"'";
		ConectorBD a = ConectorBD.getAgente();
		Vector<Jugador> res = a.selectJugadorEquipo(SQL_Consulta);//vector en el que se muestra cada fila.
		return res;
		
	}
	
	public Vector<Jugador> readJugadorEquipoLista(String nombre) throws Exception{
		Vector<Object> aux = null;
		String SQL_Consulta = "SELECT * FROM jugadores_equipo WHERE nombre = '"+nombre+"'";
		ConectorBD a = ConectorBD.getAgente();
		Vector<Jugador> res = a.selectJugadorEquipo(SQL_Consulta);//vector en el que se muestra cada fila.
		return res;
		
	}
	
	public int insert() throws Exception{
		// 0=false
		// 1=true
		int insertado = 0;
		String SQL_Consulta = "INSERT INTO jugadores_equipo VALUES('"+this.nombre+"','"+this.equipo+"','"+this.posicion+"','"+this.edad+"','"+this.forma_fisica+"','"+this.estado+"','"+this.lesiones+"','"+this.ataque+"','"+this.defensa+"','"+this.pase+"','"+this.comentarios+"','"+this.paradas_partido+"','"+this.goles_concedidos_partido+"')";
		System.out.println("Nombre "+this.nombre);
		System.out.println("holaaaaaaaaaaa");
		ConectorBD a = ConectorBD.getAgente();
		a.insert(SQL_Consulta);
		insertado = 1;
		return insertado;

	}
}
	

