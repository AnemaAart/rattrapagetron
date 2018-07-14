package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// TODO: Auto-generated Javadoc
/**
 * <h1>The Class BoulderDashBDDConnector.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
final class BDDConnector {

	/** The instance. */
	private static BDDConnector instance;

	/** The login. */
	private static String user = "root";

	/** The password. */
	private static String password = "";

	/** The url. */
	private static String url = "jdbc:mysql://localhost/score?useSSL=false&serverTimezone=UTC";

	/**
	 * Gets the single instance of BoulderDashBDDConnector.
	 *
	 * @return single instance of BoulderDashBDDConnector
	 */
	public static BDDConnector getInstance() {
		if (instance == null) {
			setInstance(new BDDConnector());
		}
		return instance;
	}

	/**
	 * Sets the instance.
	 *
	 * @param instance
	 *            the new instance
	 */
	private static void setInstance(final BDDConnector instance) {
		BDDConnector.instance = instance;
	}

	/** The connection. */
	private Connection connection;

	/** The statement. */
	private Statement statement;

	/**
	 * Instantiates a new boulder dash BDD connector.
	 */
	private BDDConnector() {
		this.open();
	}

	/**
	 * Execute query.
	 *
	 * @param query
	 *            the query
	 * @return the result set
	 */
	public ResultSet executeQuery(final String query) {
		try {
			return this.getStatement().executeQuery(query);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Execute update.
	 *
	 * @param query
	 *            the query
	 * @return the int
	 */
	public int executeUpdate(final String query) {
		try {
			return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}

	/**
	 * Gets the statement.
	 *
	 * @return the statement
	 */
	public Statement getStatement() {
		return this.statement;
	}

	/**
	 * Open.
	 *
	 * @return true, if successful
	 */
	private boolean open() {
		try {
			this.connection = DriverManager.getConnection(BDDConnector.url, BDDConnector.user, BDDConnector.password);
			this.statement = this.connection.createStatement();
			return true;
		} catch (final SQLException exception) {
			exception.printStackTrace();
		}
		return false;
	}

	/**
	 * Prepare call.
	 *
	 * @param query
	 *            the query
	 * @return the java.sql. callable statement
	 */
	public java.sql.CallableStatement prepareCall(final String query) {
		try {
			return this.getConnection().prepareCall(query);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Sets the connection.
	 *
	 * @param connection
	 *            the new connection
	 */
	public void setConnection(final Connection connection) {
		this.connection = connection;
	}

	/**
	 * Sets the statement.
	 *
	 * @param statement
	 *            the new statement
	 */
	public void setStatement(final Statement statement) {
		this.statement = statement;
	}

}
