
/*
 * Testing Code for the Database Connection
 * By Jan Willem 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class Database {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private String host;
	private String user;
	private String passwd;

	public Database(String host, String user, String passwd) {
		this.host = host;
		this.user = user;
		this.passwd = passwd;
	}

	public void connect() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://" + this.host + "user=" + this.user + "&password=" + this.passwd);
		} catch (Exception e) {
			throw e;
		}
	}

	public void select() throws Exception {
		connect(); //Don't know if the connection has to be established everytime when a Query is executed??
		preparedStatement = connect.prepareStatement("SQL_QUERY");
		resultSet = preparedStatement.executeQuery(); // read this variable to
														// determine the
														// location of
														// products(X, Y POS)
	}

	public void insert() throws Exception {
		connect(); //Don't know if the connection has to be established everytime when a Query is executed??
		preparedStatement = connect.prepareStatement("insert into DBNAME values (default, ?, ?, ?, ? , ?, ?)");

		/*
		 * Example Statements
		 */
		preparedStatement.setString(1, "Test");
		preparedStatement.setString(2, "TestEmail");
		preparedStatement.setString(3, "TestWebpage");
		preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
		preparedStatement.setString(5, "TestSummary");
		preparedStatement.setString(6, "TestComment");
		preparedStatement.executeUpdate();
	}

	public void update() throws Exception {

	}

	public void delete() throws Exception {

	}
}
