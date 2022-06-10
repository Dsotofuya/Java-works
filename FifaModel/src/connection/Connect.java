package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	
	private final static String USER = "test";
	private final static String PASSWORD = "Test";
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	
	public Connect() throws SQLException {
		test();
	}
	
    public static Connection linker(Connection conn) {
    	try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return conn;
    }
    
    public static Statement statement(Statement statement) throws SQLException {
    	connection = linker(connection);
    	statement = connection.createStatement();
        return statement;
    }

    public static ResultSet resultSet(ResultSet resultSet) throws SQLException {
    	statement = statement(statement);
    	resultSet = statement.executeQuery("SELECT  * FROM POSICIONES");
        return resultSet;
    }
    public static void main(String[] args) {
		try {
			new Connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public void test() {
    	try {
			resultSet = resultSet(resultSet);
			while(resultSet.next()) {
	    		System.out.println(resultSet.getString("id_posicion")+ ", "+ resultSet.getString("nombre_posicion"));
	    	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
