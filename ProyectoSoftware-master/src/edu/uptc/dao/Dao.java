package edu.uptc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.sql.SQLException;
import java.util.logging.Logger;

import edu.uptc.model.Cliente;
import edu.uptc.model.Domiciliario;
import edu.uptc.model.Domicilio;
import edu.uptc.model.Empleado;
import edu.uptc.model.Reserva;
import edu.uptc.model.TipoEmpleo;

import java.sql.Statement;

public class Dao {

	private String usuario = "gallina_elegante";
	private String clave = "a123";
	private int puerto = 3306;
	private String maquina = "localhost";

	public void registrarEmpleado(Empleado empleado) throws SQLException, ClassNotFoundException {
		Statement statement = null;
		// sentancias sql necesarias para agregar un nuevo empleado a la base de datos.
		String query = "insert into empleados (cedula, nombres, apellidos, telefono, correo, contraseña, cuenta, tipo_empleo, salario) values "
				+ "(" + empleado.getCedula() + ", " + empleado.getNombres() + ", " + empleado.getApellidos() + ", "
				+ empleado.getTelefono() + ", " + empleado.getCorreo() + ", " + empleado.getContraseña() + ", "
				+ empleado.getNumeroCuenta() + ", " + empleado.getTipoEmpleo() + ", " + empleado.getSalario() + ");";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://" + this.maquina + ":" + this.puerto + "/g_e_db?serverTimezone=UTC", this.usuario, this.clave);
			statement = connection.createStatement();
			statement.executeUpdate(query);
			connection.close();

		} catch (SQLException sqlex) {
			throw sqlex;
		}
	}

	public void registrarReserva(Reserva reserva) throws ClassNotFoundException, SQLException {
		Statement statement = null;
		String query = "insert into reservas (id_reserva, id_mesa, cedula, numero_personas) values " + "("
				+ reserva.getId() + ", " + reserva.getMesa() + "," + reserva.getCliente() + ", "
				+ reserva.getNumero_personas() + ");";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://" + this.maquina + ":" + this.puerto + "/g_e_db?serverTimezone=UTC", this.usuario, this.clave);
			statement = connection.createStatement();
			statement.executeUpdate(query);
			connection.close();
		} catch (SQLException sqlex) {
			throw sqlex;
			// TODO: handle exception
		}
	}

	public void registrarDomicilio(Domicilio domicilio) {

	}

	public void registrarCliente(Cliente cliente) {

	}

	public boolean isEmpleado(String correo, String contraseña) {
		boolean resultado = false;
		Statement statement = null;
		String query = "select * from empleados where correo = '" + correo + "' and contraseña = '" + contraseña + "';";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://" + this.maquina + ":" + this.puerto + "/g_e_db?serverTimezone=UTC", this.usuario,
					this.clave);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			if (resultSet.getRow() != 0) {
				resultado = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return resultado;
	}

	public boolean isCliente(String correo, String contraseña) {
		boolean resultado = false;
		Statement statement = null;
		String query = "select * from clientes where correo_clie = '" + correo + "' and contrasena_clie = '"
				+ contraseña + "';";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://" + this.maquina + ":" + this.puerto + "/g_e_db?serverTimezone=UTC", this.usuario,
					this.clave);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			if (resultSet.getRow() != 0) {
				resultado = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return resultado;
	}

	public Cliente obtenerCliente(String correo, String contraseña) throws ClassNotFoundException, SQLException {
		Statement statement = null;
		Cliente cliente = new Cliente();
		String query = "select * from clientes where correo_clie = '" + correo + "' and contrasena_clie = '"
				+ contraseña + "';";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://" + this.maquina + ":" + this.puerto + "/g_e_db?serverTimezone=UTC", this.usuario,
					this.clave);
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			rs.next();
			if (rs.getRow() == 0) {
				cliente = null;
			} else {
				cliente.setCedula(Long.parseLong(rs.getString("cedula")));
				cliente.setNombres(rs.getString("nombres_clie"));
				cliente.setApellidos(rs.getString("apellidos_clie"));
				cliente.setTelefono(Long.parseLong(rs.getString("telefono_clie")));
				cliente.setCorreo(rs.getString("correo_clie"));
				cliente.setContraseña(rs.getString("contrasena_clie"));
				cliente.setDireccion(rs.getString("direccion_clie"));
			}

			connection.close();

		} catch (SQLException ex) {
			Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return cliente;
	}

	public boolean isDomiciliario(String correo, String contraseña) {
		boolean resultado = false;
		Statement statement = null;
		String query = "select * from domiciliario where correo_dom = '" + correo + "' and contrasena_dom = '"
				+ contraseña + "';";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://" + this.maquina + ":" + this.puerto + "/g_e_db?serverTimezone=UTC", this.usuario,
					this.clave);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			if (resultSet.getRow() != 0) {
				resultado = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return resultado;
	}

	public Domiciliario obtenerDomiciliario(String correo, String contraseña)
			throws ClassNotFoundException, SQLException {
		Statement statement = null;
		Domiciliario domiciliario = new Domiciliario();
		String query = "select * from domiciliario where correo_dom = '" + correo + "' and contrasena_dom = '"
				+ contraseña + "';";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://" + this.maquina + ":" + this.puerto + "/g_e_db?serverTimezone=UTC", this.usuario,
					this.clave);
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			rs.next();
			if (rs.getRow() == 0) {
				domiciliario = null;
			} else {
				domiciliario.setCedula(Long.parseLong(rs.getString("cedula_domiciliario")));
				domiciliario.setNombres(rs.getString("nombres_dom"));
				domiciliario.setApellidos(rs.getString("apellidos_dom"));
				domiciliario.setTelefono(Long.parseLong(rs.getString("telefono_dom")));
				domiciliario.setCorreo(rs.getString("correo_dom"));
				domiciliario.setContraseña(rs.getString("contrasena_dom"));
				if (rs.getString("estado").equalsIgnoreCase("O")) {
					domiciliario.setEstado(true);
				} else {
					domiciliario.setEstado(false);
				}
			}

			connection.close();

		} catch (SQLException ex) {
			Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return domiciliario;
	}

	public Empleado obtenerEmpleado(String correo, String contraseña) throws ClassNotFoundException, SQLException {
		Statement statement = null;
		Empleado empleado = new Empleado();
		String query = "select * from empleados where correo = '" + correo + "' and contraseña = '" + contraseña + "';";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://" + this.maquina + ":" + this.puerto + "/g_e_db?serverTimezone=UTC", this.usuario,
					this.clave);
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			rs.next();
			if (rs.getRow() == 0) {
				empleado = null;
			} else {
				empleado.setCedula(Long.parseLong(rs.getString("cedula")));
				empleado.setNombres(rs.getString("nombres"));
				empleado.setApellidos(rs.getString("apellidos"));
				empleado.setTelefono(Long.parseLong(rs.getString("telefono")));
				empleado.setCorreo(rs.getString("correo"));
				empleado.setContraseña(rs.getString("contraseña"));
				empleado.setNumeroCuenta(Long.parseLong(rs.getString("cuenta")));
				empleado.setTipoEmpleo(TipoEmpleo.valueOf(rs.getString("tipo_Empleo")));
				empleado.setSalario(Float.parseFloat(rs.getString("salario")));
			}

			connection.close();

		} catch (SQLException ex) {
			Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return empleado;
	}
}
