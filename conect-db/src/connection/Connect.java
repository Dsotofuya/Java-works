package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Lugar;
import models.TipoLugar;

public class Connect {

	private final static String USER = "gu";
	private final static String PASSWORD = "a123";
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;

	public Connect() throws SQLException {
		linker();
		statement = connection.createStatement();
	}

	public void linker() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("CONECTO");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet resultSet() throws SQLException {
		resultSet = statement.executeQuery("SELECT * FROM LUGARES");
		return resultSet;
	}

	public static void main(String[] args) throws SQLException {
		Connect connect = new Connect();
//		connect.insert(new Lugar(13, 11, "Tunja", "Tunjano", TipoLugar.CI));
		
	}
	
	public void insert(Lugar lugar) throws SQLException { 
		String consulta = "INSERT INTO LUGARES VALUES (?,?,?,?,?)";
		PreparedStatement insercion = connection.prepareStatement(consulta);
		insercion.setInt(1, lugar.getIdLugar());
		insercion.setInt(2, lugar.getUbicacion());
		insercion.setString(3, lugar.getNombreLugar());
		insercion.setString(4, lugar.getTipolugar().toString());	
		insercion.setString(5, lugar.getGentilisio());
		insercion.execute();
	}

	public ArrayList<Lugar> test() {
		ArrayList<Lugar> placesList = new ArrayList<Lugar>();
		try {
			resultSet = resultSet();
			while (resultSet.next()) {
				String nacionalidad = resultSet.getString("NACIONALIDAD");
				String nombre = resultSet.getString("NOMBRE_LUGAR");
				int idLugar = Integer.parseInt(resultSet.getString("ID_LUGAR"));
				int ubicado;
				if (resultSet.getString("UBICACION") != null) {
					ubicado = Integer.parseInt(resultSet.getString("UBICACION"));
				}else { 
					ubicado = -1;
				}
				TipoLugar tipoLugar = getTipoLugar(resultSet.getString("TIPO_LUGAR"));
				placesList.add(new Lugar(idLugar,ubicado, nombre, nacionalidad, tipoLugar));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return placesList;
	}

	public static TipoLugar getTipoLugar(String tipo) {
		switch (tipo) {
		case "PA":
			return TipoLugar.PA;
		case "CI":
			return TipoLugar.CI;
		case "DE":
			return TipoLugar.DE;
		default:
			break;
		}
		return null;
	}
}
