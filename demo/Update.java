package demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Update {

	private static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION="jdbc:mysql://localhost:3306/mahasiswa";
	private static final String DB_USER="root";
	private static final String DB_PASSWORD="";
	
	public static void main(String[]args) {
		try {
			updateRecord();
		
		}catch (SQLException e){
			e.printStackTrace();
		}
	}


	public static void updateRecord() throws SQLException{
		Connection connection=null;
		Statement statement=null;
		int recordCount=0;
	
		String updateTableQuery="UPDATE COBA " + "SET nama_mhs = 'Rino'"
								+"WHERE id = '1'";
		
		try {
			connection = getDatabaseConnection();
			statement = connection.createStatement();
			System.out.println(updateTableQuery);
			statement.execute(updateTableQuery);
			recordCount = statement.getUpdateCount();
			System.out.print(recordCount +" berhasil");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
	}
	
	private static Connection getDatabaseConnection() {
		Connection connection =null;
		try {
			Class.forName(DB_DRIVER);
		}catch(ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		try {
			connection=DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
			return connection;
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return connection;
		}
	}
	

