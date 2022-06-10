package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Place;
import models.TipoLugar;

public class Connect {

	private final static String USER = "xd123";
	private final static String PASSWORD = "a123";
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;

	public Connect() throws SQLException {
		tryConnect();
		statement = connection.createStatement();
	}

	public void tryConnect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
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

	public void insert(Place place) {
		try {
			String query = "INSERT INTO LUGARES VALUES (?,?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(query);
			insert.setInt(1, place.getIdLugar());
			if (place.getUbicacion() == -1) {
				insert.setString(2, null);
			} else {
				insert.setInt(2, place.getUbicacion());
			}
			insert.setString(3, place.getNombreLugar());
			insert.setString(4, place.getTipolugar().toString());
			insert.setString(5, place.getNacionalidad());
			insert.execute();
		} catch (SQLException e) {
		}
	}

	public ArrayList<Place> getPlaces() {
		ArrayList<Place> placesList = new ArrayList<>();
		try {
			resultSet = resultSet();
			while (resultSet.next()) {
				String nationality = resultSet.getString("NACIONALIDAD");
				String name = resultSet.getString("NOMBRE_LUGAR");
				int idPlace = Integer.parseInt(resultSet.getString("ID_LUGAR"));
				int location;
				if (resultSet.getString("UBICACION") != null) {
					location = Integer.parseInt(resultSet.getString("UBICACION"));
				} else {
					location = -1;
				}
				TipoLugar placeType = getTipoLugar(resultSet.getString("TIPO_LUGAR"));
				placesList.add(new Place(idPlace, location, name, nationality, placeType));
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

	public void deletePlace(int id_lugar) {
		try {
			resultSet = resultSet();
			while (resultSet.next()) {
				if (resultSet.getInt("ID_LUGAR") == id_lugar) {
					connection.prepareStatement("DELETE FROM LUGARES WHERE ID_LUGAR=" + id_lugar).execute();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void renameplace(int id_lugar, String nombre_lugar) {
		try {
			resultSet = resultSet();
			while (resultSet.next()) {
				if (resultSet.getInt("ID_LUGAR") == id_lugar) {
					String query = "UPDATE LUGARES SET NOMBRE_LUGAR=" + "'" + nombre_lugar + "'" + " WHERE ID_LUGAR="
							+ id_lugar;
					connection.prepareStatement(query).execute();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
